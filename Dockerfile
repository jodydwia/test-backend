FROM tomcat:9.0-jre17-temurin-focal
ADD compiled/backend-service.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]