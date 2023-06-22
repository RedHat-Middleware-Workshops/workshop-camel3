# Load configuration
source config.conf

# loop users
for i in $(eval echo "{$START..$END}")
do

	USER=user$i
	echo ""
	echo "Working on namespace $USER"
	# oc login -u $USER -p openshift
    oc project $USER


	# Delete test kamelet if exists
	oc delete kl test-action

	# clear storage integration
	kamel delete store

	# Reset DISCORD
	cd ../lab4-k2d

	kamel delete d2k
	oc delete klb k2d

	oc delete kl discord-sink
	oc apply -f discord-sink.kamelet.yaml

	oc delete cm stage4-transform
	oc delete secret stage4

	oc create secret generic stage4 --from-file=$CONFIG_PATH/stage4.properties
	oc create cm stage4-transform --from-file=k2d.jslt


	# Reset GITTER/SLACK integrations
	# Needs to happen after DISCORD as it contains the KT to reset
	cd ../lab3

	oc delete klb m2k
	oc delete klb k2r
	oc delete klb r2k
	oc delete klb k2m

	oc delete kt roomx
	oc apply -f kafka/room_x.yaml

	oc delete cm stage3-transform
	oc delete secret stage3

	oc create cm stage3-transform --from-file=maps
	oc create secret generic stage3 --from-file=$CONFIG_PATH/stage3.properties


	cd ../scripts

done