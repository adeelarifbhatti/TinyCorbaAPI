#!/bin/bash
#orbd -ORBInitialPort 900 -ORBInitialHost 0.0.0.0 &
#echo "ORBD started on localhost and 900"
java  -jar /usr/local/tomcat/webapps/graphcore-Server.jar -ORBInitialPort 900 -ORBInitialHost graphcore-api
echo "started the server"


