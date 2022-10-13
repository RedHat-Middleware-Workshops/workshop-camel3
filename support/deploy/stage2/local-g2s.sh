# Define the path to your personal configuration
CONFIG_PATH=../../chapters_config

camel run \
flows/g2s.yaml \
maps/g2s.jslt \
--local-kamelet-dir=$PWD/../kamelets \
--properties=$CONFIG_PATH/stage2.properties \
--property=transform.path=maps/g2s.jslt