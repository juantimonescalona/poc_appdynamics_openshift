FROM registry.access.redhat.com/jboss-eap-7/eap70-openshift:1.5

USER root

ADD appdynamics/ /opt/appdynamics/

RUN chgrp -R 0 /opt/appdynamics/
RUN chmod -R g+rw /opt/appdynamics/
RUN find /opt/appdynamics/ -type d -exec chmod g+x {} +

ADD webapp-code /tmp/webapp-code
RUN %M2_HOME/mvn clean build -f /tmp/webapp-code/pom.xml

COPY target/helloworld-eap-mvn.war $JBOSS_HOME/standalone/deployments/

#jboss from FIS
USER 185
