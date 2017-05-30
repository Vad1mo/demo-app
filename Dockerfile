FROM websphere-liberty

ENV WLP_USR_DIR=/opt/ibm/wlp/usr

RUN installUtility install  --acceptLicense logstashCollector-1.0 sessionDatabase-1.0 servlet-3.1

COPY src/main/liberty/config/server.xml $LIBERTY_HOME/servers/defaultServer/
COPY build/libs/* $LIBERTY_HOME/servers/defaultServer/dropins/
COPY build/lib/mariadb-java-client-2.0.1.jar $LIBERTY_HOME/shared/resources/mariadb/client
COPY jvm.options /config/jvm.options
RUN chmod g+rw -R /opt/ibm/wlp/ /logs

