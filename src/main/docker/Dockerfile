FROM registry.access.redhat.com/jboss-eap-7/eap70-openshift:1.5

USER root

ADD appdynamics/ /opt/appdynamics/

RUN chgrp -R 0 /opt/appdynamics/
RUN chmod -R g+rw /opt/appdynamics/
RUN find /opt/appdynamics/ -type d -exec chmod g+x {} +

RUN mkdir /deployments/logs
RUN chgrp -R 0 /deployments/logs/
RUN chmod -R g+rw /deployments/logs/
ENV JAVA_OPTS="-javaagent:/opt/appdynamics/javaagent.jar -Dappdynamics.agent.logs.dir=/deployments/logs $JAVA_OPTS"
#FOR FIX JBOX LOGIN --> https://docs.appdynamics.com/display/PRO42/JBoss+and+Wildfly+Startup+Settings
ENV JAVA_OPTS="$JAVA_OPTS -Djava.util.logging.manager=org.jboss.logmanager.LogManager -Djboss.modules.system.pkgs=org.jboss.byteman,com.appdynamics.,com.appdynamics.,org.jboss.logmanager,com.singularity,com.singularity."

RUN curl https://github.com/kborup-redhat/openshift-test/blob/master/ticket-monster.war -o /deployments/ticket-monster.war

#jboss from FIS
USER 185
