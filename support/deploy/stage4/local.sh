# Define the path to your personal configuration
CONFIG_PATH=../../chapters_config

camel run flows/d2k.xml \
flows/java/wsConfig.java \
maps/d2k.jslt \
--properties=$CONFIG_PATH/stage4.properties
