# Load Configuration
source config.conf

# loop users
for i in $(eval echo "{$START..$END}")
do

	USER=user$i
	echo ""
	echo "Working on namespace $USER"
	oc login -u $USER -p openshift


	# Delete test kamelet if exists
	oc delete kl test-action

	# clear GITTER/SLACK integrations
	oc delete klb g2k
	oc delete klb k2s
	oc delete klb s2k
	oc delete klb k2g

	oc delete cm stage3-transform
	oc delete secret stage3

	# clear DISCORD
	kamel delete d2k
	oc delete klb k2d

	oc delete kl discord-sink

	oc delete cm stage4-transform
	oc delete secret stage4

	# clear storage integration
	kamel delete store

	# clear kafka topic
	# Needs to happen after all instances are down
	oc delete kt roomx

done