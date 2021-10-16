A API server which makes use of this server as ORB (Server) and perform get/post method. It is for another repository i.e. TinyCorba.

TinyCorba makes use of Corba middleware, its a key-value memory server and client. 
We should start the service orbd -ORBInitialHost 0.0.0.0 -ORBInitialPort 900 &.
Jar file should be started as java  -jar /usr/local/tomcat/webapps/graphcore-Server.jar -ORBInitialPort 900 &

The Docker folder has the docker-compose.yml and Dockerfile. The jar files should be saved in the Docker folder before running the docker-compose up


