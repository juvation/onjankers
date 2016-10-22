#!/bin/bash

scp -i ~/ec2/Redfish.pem neutrino-application.war ec2-user@23.21.164.70:tomcat/webapps/onjankers.war

