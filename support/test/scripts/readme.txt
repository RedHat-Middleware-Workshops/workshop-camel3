This folder contains scripts to test the environment.

 - config.conf -> contains testing configuration
 - clean.sh 
 	Cleans the envioronment. Allows users to start from scratch
 	-> deletes integrations
 	-> deletes kamelets
 	-> deletes config-maps
 	-> deletes secrets
 	-> deletes kafka-topics

 - setup.sh 
 	Cleans and configures the environment.
 	-> undeploys integrations
 	-> resets configmaps
 	-> resets secrets
 	-> resets kafka topics
 	-> resets kamelets

 - deploy.sh 
 	Deploys the integrations.
 	-> deploys Camel K kamelet bindings
 	-> deploys Camel K routes


How to run the test
-------------------

1) The test covers lab 3/4/5
   > Lab 3 and 4 integrate the platforms Matrix / RocketChat / Discord
   > Lab 5 enables data archiving.

2) You need to login in your terminal as 'admin'
   > the test scripts needs to test all user namespaces

3) You can simulate as many users as desired (as per configuration)
   > configure below the number of users to simulate
     (attention: your cluster requires all users to be pre-provisioned)

4) The test uses modified code ('lab' folders under 'test' folder)
   > a special Kamelet 'test-action' is involved in this testing
   > these modifications capture the running namespace as a variable in Camel
   > allows the tester to see from which namespace a message (in the Chat platforms) comes from

5) Configure the property files under
    ../../config
   
   > You'll need to obtain the Matrix / RocketChat / Discord tokens and configure the properties.
   > You'll need to obtain the S3 access/secret keys (from Rocket.Chat #general channel).
