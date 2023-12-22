FROM tomcat:8.5.47-jdk8-openjdk
LABEL maintainer="adeelarifbhatti@gmail.com"
COPY graphcore-Server.jar /usr/local/tomcat/webapps/
COPY start.sh /usr/local/bin/start.sh
EXPOSE 8080 900
RUN chmod +x /usr/local/bin/start.sh
ENTRYPOINT ["/usr/local/bin/start.sh"]
