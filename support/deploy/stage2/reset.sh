# Define the path to your personal configuration
CONFIG_PATH=../../chapters_config

oc delete klb g2s
oc delete klb s2g

oc delete cm stage2-transform
oc delete secret stage2

oc create cm stage2-transform --from-file=maps
oc create secret generic stage2 --from-env-file=$CONFIG_PATH/stage2.properties
