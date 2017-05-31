FROM websphere-liberty

ENV WLP_USR_DIR=/opt/ibm/wlp/usr

RUN installUtility install  --acceptLicense logstashCollector-1.0 sessionDatabase-1.0 servlet-3.1

COPY src/main/liberty/config/server.xml $WLP_USR_DIR/servers/defaultServer/
COPY build/libs/* $WLP_USR_DIR/servers/defaultServer/dropins/
COPY build/lib/mariadb-java-client-2.0.1.jar $WLP_USR_DIR/shared/resources/mariadb/client/
COPY jvm.options /config/jvm.options
RUN chmod g+rw -R /opt/ibm/wlp/ /logs

