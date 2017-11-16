package com.redhat.bh.appdynamics.buildconfig;

import java.util.HashMap;
import java.util.Map;

import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.openshift.api.model.BuildTriggerPolicy;
import io.fabric8.openshift.api.model.DeploymentTriggerImageChangeParams;
import io.fabric8.openshift.api.model.ImageChangeTrigger;
import io.fabric8.openshift.api.model.TemplateBuilder;

public class BuildConfigKubernetesModelProcessor {

    public void on(TemplateBuilder builder) {
        builder.addNewBuildConfigObject()
                .withNewMetadata()
                    .withName("poc_appdynamics_openshift")
                    .withLabels(getLabels())
                .endMetadata()
                .withNewSpec()
                    .withTriggers(getTriggers())
                    .withNewSource()
                        .withNewGit()
                            .withUri("https://github.com/juantimonescalona/poc_appdynamics_openshift")
                        .endGit()
                        .withContextDir("src/main/docker")
                        .withType("Git")
                    .endSource()
                    .withNewStrategy()
                        .withNewDockerStrategy()
                            .withNewFrom()
                                .withKind("ImageStreamTag")
                                .withName("webapp-appdynamics-openshift:latest")
                                .withNamespace("openshift")
                            .endFrom()
                        .endDockerStrategy()
                        .withType("Docker")
                    .endStrategy()
                    .withNewOutput()
                        .withNewTo()
                            .withKind("ImageStreamTag")
                            .withName("webapp-appdynamics-openshift:latest")
                        .endTo()
                    .endOutput()
                .endSpec()
            .endBuildConfigObject()
            .build();
    }

    private BuildTriggerPolicy getTriggers() {
        ObjectReference from = new ObjectReference();
		from.setName("webapp-appdynamics-openshift:latest");
        from.setKind("ImageStreamTag");
        from.setNamespace("openshift");

        ImageChangeTrigger imageChangeTrigger = new ImageChangeTrigger();
        imageChangeTrigger.setFrom(from);

        BuildTriggerPolicy policy = new BuildTriggerPolicy();
        policy.setType("ImageChange");
        policy.setImageChange(imageChangeTrigger);

        return policy;
    }

    private Map<String, String> getLabels() {
        Map<String, String> labels = new HashMap<>();
        labels.put("app", "poc_appdynamics_openshift");
        labels.put("project", "poc_appdynamics_openshift");
        labels.put("version", "1.0.0-SNAPSHOT");
        labels.put("group", "openshift");

        return labels;
    }
}
