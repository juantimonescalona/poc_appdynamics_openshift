FROM registry.access.redhat.com/jboss-eap-7/eap70-openshift:1.5

USER root

ADD appdynamics/ /opt/appdynamics/

RUN chgrp -R 0 /opt/appdynamics/
RUN chmod -R g+rw /opt/appdynamics/
RUN find /opt/appdynamics/ -type d -exec chmod g+x {} +

#ADD webapp-code /tmp/webapp-code
#RUN /opt/rh/rh-maven33/root/bin/mvn clean package -f /tmp/webapp-code/pom.xml
#RUN mv /tmp/webapp-code/target/helloworld-eap-mvn.war /standalone/deployments
#ADD binaries/helloworld-eap-mvn.war /standalone/deployments/helloworld-eap-mvn.war
RUN curl https://github.com/kborup-redhat/openshift-test/blob/master/ticket-monster.war -o /deployments/ticket-monster.war

#jboss from FIS
USER 185
