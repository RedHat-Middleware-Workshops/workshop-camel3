# Define the path to your personal configuration
CONFIG_PATH=../../chapters_config

kamel run --name store \
flows/store.xml \
flows/java/HelperStage5.java \
--property file:$CONFIG_PATH/stage5.properties \
--trait cron.enabled=true \
--trait cron.schedule="0/1 * * * ?"
