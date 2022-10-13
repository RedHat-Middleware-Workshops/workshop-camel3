// camel-k: language=java

import org.apache.camel.builder.RouteBuilder;

public class download extends RouteBuilder {

    @Override
    public void configure() throws Exception {

/*
        // Write your routes here, for example:
        from("timer:test?repeatCount=1")
            .setBody(simple("dummy data"))
            .convertBodyTo(byte[].class)

        .setHeader("file", simple("temp.txt"))

        // Does not work using KAMELET (via HTTP)
        .to("kamelet:aws-s3-sink?"+

        "accessKey=rPDtueiEaUuVu1OyR5MH"+
        "&secretKey=RAW(N3XCG0F9BDtY60e0FvzikZK9hvopkQ0JDzt9G1Wu)"+

        "&region=us-east-1"+

        "&uriEndpointOverride=https://s3-openshift-storage.apps.cluster-cc7p5.cc7p5.sandbox754.opentlc.com/"+
        // "&uriEndpointOverride=http://s3.openshift-storage.svc:80"+
            // "&uriEndpointOverride=http://localhost:8080"+
        "&overrideEndpoint=true"+
        "&keyName=temp.txt"+
        "&bucketNameOrArn=first.bucket"+
        "&useDefaultCredentialsProvider=false"
        // +"&autoCreateBucket=true"
        );
*/



            from("aws2-s3:chatrooms.bucket?{{camel.uri.s3.parameters.local}}")
            // .to("log:deb?showAll=true")
            .setHeader("CamelFileName", simple("${header.CamelAwsS3Key}"))
            .log("data: ${body}")
            .to("file:bucket")
            .log("done.");



/*
        from("timer:list?repeatCount=1")

            .to("aws2-s3:first.bucket?"+
            // .to("kamelet:aws-s3-sink?"+

                // "accessKey=05OGvxRRl6WwgEMVpfXg"+
                // "&secretKey=RAW(Jgu7HAYpDeJv1RSQnZu1S9/jSiIjaRuXPEoChaE4)"+

        "accessKey=rPDtueiEaUuVu1OyR5MH"+
        "&secretKey=RAW(N3XCG0F9BDtY60e0FvzikZK9hvopkQ0JDzt9G1Wu)"+

                "&region=us-east-1"+
                "&uriEndpointOverride=https://s3-openshift-storage.apps.cluster-cc7p5.cc7p5.sandbox754.opentlc.com/"+
                // "&uriEndpointOverride=http://s3.openshift-storage.svc:80"+
                // "&uriEndpointOverride=http://localhost:8080"+
                "&overrideEndpoint=true"+
                "&useDefaultCredentialsProvider=false"+
                // "&autoCreateBucket=true"
                // "&operation=listObjects"
                "&operation=createDownloadLink"+
                "&keyName=17-31-36.csv"

        // +"&bucketNameOrArn=first.bucket"

                )

            // .to("log:deb?showAll=true")

            // .setHeader("CamelFileName", simple("${header.CamelAwsS3Key}"))

            .log("data: ${body}")
            // .to("file:s3files")
            .log("done.");
*/

/*
        // Write your routes here, for example:
        from("timer:test?repeatCount=1")
            .setBody(simple("dummy data"))
            .convertBodyTo(byte[].class)

        .setHeader("file", simple("temp.txt"))

        // Does not work using KAMELET (via HTTP)
           .to("aws2-s3:chatroomstest3.bucket?"+
            // .to("kamelet:aws-s3-sink?"+

                // "accessKey=05OGvxRRl6WwgEMVpfXg"+
                // "&secretKey=RAW(Jgu7HAYpDeJv1RSQnZu1S9/jSiIjaRuXPEoChaE4)"+


        "accessKey=rPDtueiEaUuVu1OyR5MH"+
        "&secretKey=RAW(N3XCG0F9BDtY60e0FvzikZK9hvopkQ0JDzt9G1Wu)"+

        // "&bucketNameOrArn=kamelet.bucket"+
        "&keyName=room1/temp.txt"+
                "&region=us-east-1"+
                // "&uriEndpointOverride=https://s3-openshift-storage.apps.cluster-cc7p5.cc7p5.sandbox754.opentlc.com/"+
                "&uriEndpointOverride=http://s3.openshift-storage.svc:80"+
                // "&uriEndpointOverride=http://localhost:8080"+
                "&overrideEndpoint=true"+
                "&useDefaultCredentialsProvider=false"+
                "&autoCreateBucket=true"
                // "&operation=listObjects"
                );
*/



    }
}

