#!/bin/bash
orbd -ORBInitialHost 0.0.0.0 -ORBInitialPort 900 &
sleep 10
echo "ORBD started on localhost and 900"
java  -jar /usr/local/tomcat/webapps/graphcore-Server.jar -ORBInitialPort 900 &
catalina.sh run 
echo "started the server"


