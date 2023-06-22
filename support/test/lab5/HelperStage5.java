// package org.demo;

//Camel API
import org.apache.camel.AggregationStrategy;
import org.apache.camel.BindToRegistry;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.PropertyInject;
import org.apache.camel.builder.RouteBuilder;

// import org.apache.camel.component.kafka.KafkaConstants;
// import org.apache.camel.component.kafka.KafkaManualCommit;

import java.util.concurrent.CountDownLatch;

public class HelperStage5 extends RouteBuilder {
    
    @PropertyInject("messege.controller.cutoff.time")
    private static long cutoffTime;

    //dummy
    @Override
    public void configure() throws Exception {}


    //Controller declaration
    public static class Controller {};


    @BindToRegistry
    public static Controller controller(){

        //Controller implementation
        return new Controller(){

            // Helper variables
            boolean expiredTimeWindow = false;
            CountDownLatch latch      = null;
            long lastMessageTime      = 0;


            public synchronized void newMessage(CamelContext context) {

                //initialise when first message comes in
                if(latch == null){
                    lastMessageTime = System.currentTimeMillis();
                    latch = new CountDownLatch(1);
                    context.createProducerTemplate().asyncSendBody("direct:wait-until-aggregation-done", null);
                }

                //calculate time split between last 2 messages
                long now = System.currentTimeMillis();
                long elapsed = now - lastMessageTime;

                //if message not in the time window, we stop processing messages.
                if(elapsed > cutoffTime){
                    expiredTimeWindow = true;
                }

                //reset time
                lastMessageTime = now;
            }

            public void waitUntilAggregationDone() throws Exception {
                if(latch != null){
                    latch.await();
                }
            }

            public void aggregationDone() throws Exception{
                latch.countDown();
            }

            public boolean isTimeWindowExpired() {
                return expiredTimeWindow;
            }

        };
    }


    @BindToRegistry
    public static AggregationStrategy msgStrategy(){

        return new AggregationStrategy() {

            public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

                // Manual Kafka commit
                // Messages not commited will be retried and subsequent Cron runs
                // newExchange
                //     .getIn()
                //     .getHeader(KafkaConstants.MANUAL_COMMIT, KafkaManualCommit.class)
                //     .commitSync();

                if (oldExchange == null) {
                    return newExchange;
                }

                String oldBody = oldExchange.getIn().getBody(String.class);
                String newBody = newExchange.getIn().getBody(String.class);

                oldExchange.getIn().setBody(oldBody + newBody);
                return oldExchange;
            }

        };
    }
}