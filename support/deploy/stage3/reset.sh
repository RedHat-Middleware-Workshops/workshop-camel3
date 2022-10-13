# Define the path to your personal configuration
CONFIG_PATH=../../chapters_config

oc delete klb g2k
oc delete klb k2s
oc delete klb s2k
oc delete klb k2g

oc delete kt room1
oc apply -f kafka/room1.yaml

oc delete cm stage3-transform
oc delete secret stage3

oc create cm stage3-transform --from-file=maps
oc create secret generic stage3 --from-env-file=$CONFIG_PATH/stage3.properties
