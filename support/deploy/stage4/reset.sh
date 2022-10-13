# Define the path to your personal configuration
CONFIG_PATH=../../chapters_config

kamel delete d2k
oc delete klb k2d

oc delete kl discord-sink
oc apply -f kamelets/discord-sink.kamelet.yaml

oc delete cm stage4-transform
oc delete secret stage4

oc create cm stage4-transform --from-file=maps
oc create secret generic stage4 --from-env-file=$CONFIG_PATH/stage4.properties
