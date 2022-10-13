# Define the path to your personal configuration
CONFIG_PATH=../../../chapters_config

camel run download.java \
--dep mvn:software.amazon.awssdk:utils:2.17.256 \
--property file:$CONFIG_PATH/stage5.properties
