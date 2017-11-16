package com.redhat.bh.appdynamics.buildconfig;

import java.util.HashMap;
import java.util.Map;

import io.fabric8.openshift.api.model.TemplateBuilder;

public class ImageStreamKubernetesModelProcessor {

    public void on(TemplateBuilder builder) {
        builder.addNewImageStreamObject()
                .withNewMetadata()
                    .withName("poc_appdynamics_openshift")
                    .withLabels(getLabels())
                .endMetadata()
                .withNewSpec()
                    .withDockerImageRepository("")
                .endSpec()
            .endImageStreamObject()
            .build();
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
