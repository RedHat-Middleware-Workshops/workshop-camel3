# Load Configuration
source config.conf

# loop users
for i in $(eval echo "{$START..$END}")
do

	USER=user$i
	echo ""
	echo "Working on namespace $USER"
	oc login -u $USER -p openshift


	oc delete kl test-action
	oc apply -f ../kamelets/test-action.kamelet.yaml

	# Deploy GITTER/SLACK
	cd ../lab3
	oc apply -f flows/m2k.yaml
	oc apply -f flows/k2r.yaml
	oc apply -f flows/r2k.yaml
	oc apply -f flows/k2m.yaml

	# Deploy DISCORD
	cd ../lab4-k2d
	oc apply -f k2d.yaml

	cd ../lab4-d2k
	kamel run --name d2k \
	d2k.xml \
	wsConfig.java \
	-p file:$CONFIG_PATH/stage4.properties \
	--resource file:d2k.jslt \
	-d camel-jslt \
	-d camel-ahc-ws

	cd ../scripts

done