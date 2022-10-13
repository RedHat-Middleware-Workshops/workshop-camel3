# Define the path to your personal configuration
CONFIG_PATH=../../chapters_config

oc delete klb g2s

oc delete cm stage1-transform
oc delete secret stage1

oc create cm stage1-transform --from-file=maps
oc create secret generic stage1 --from-file=$CONFIG_PATH/stage1.properties
