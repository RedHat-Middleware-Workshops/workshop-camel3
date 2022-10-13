# Define the path to your personal configuration
CONFIG_PATH=../../chapters_config

oc apply -f flows/k2d.yaml

kamel run --name d2k \
flows/d2k.xml \
flows/java/wsConfig.java \
-p file:$CONFIG_PATH/stage4.properties \
--resource file:maps/d2k.jslt