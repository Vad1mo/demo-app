FROM websphere-liberty
RUN installUtility install  --acceptLicense logstashCollector-1.0
COPY src/main/liberty/config/server.xml /opt/ibm/wlp/usr/servers/defaultServer/
COPY build/libs/* /opt/ibm/wlp/usr/servers/defaultServer/dropins/
COPY jvm.options /config/jvm.options
RUN chmod g+rw -R /opt/ibm/wlp/ /logs
#COPY ./build/wlp/usr/ /opt/ibm/wlp/usr/
