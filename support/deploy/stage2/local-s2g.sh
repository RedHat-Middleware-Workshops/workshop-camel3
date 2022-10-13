# Define the path to your personal configuration
CONFIG_PATH=../../chapters_config

camel run \
flows/s2g.yaml \
maps/s2g.jslt \
--local-kamelet-dir=$PWD/../kamelets \
--properties=$CONFIG_PATH/stage2.properties \
--property=transform.path=maps/s2g.jslt \
--dep=net.minidev:json-smart:2.4.8