# poc_appdynamics_openshift
Extraido de fis-java-appdynamics, haciendo una poc para monitorizar contenedores de Openshift con Appdynamics

* base build for any FIS application requiring appdynamics agents


oc new-build https://github.com/juantimonescalona/poc_appdynamics_openshift

Si hiciera falta:
oc import-image my-jboss-eap-7/eap70-openshift:1.5 --from=registry.access.redhat.com/jboss-eap-7/eap70-openshift:1.5 --confirm

oc new-app pocappdynamicsopenshift
