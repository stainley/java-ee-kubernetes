FROM payara/micro:5.21.0

# Download the database connector
#RUN wget -O $PAYARA_PATH/database-connector.jar https://repo1.maven.org/maven2/org/postgresql/postgresql/42.2.22/postgresql-42.2.22.jar

# Adds an application to be loaded
#ADD target/java-ee-kubernetes-1.0-SNAPSHOT.war $PAYARA_PATH/ROOT.war
COPY target/java-ee-kubernetes-1.0-SNAPSHOT.war $DEPLOY_DIR/ROOT.war
#ENTRYPOINT java -jar $PAYARA_PATH/payara-micro.jar --addJars $PAYARA_PATH/database-connector.jar --deploy $PAYARA_PATH/ROOT.war
