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