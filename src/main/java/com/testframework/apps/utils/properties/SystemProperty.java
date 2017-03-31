package com.testframework.apps.utils.properties;

import com.testframework.apps.utils.YamlReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum SystemProperty {

    BASE_URL("baseUrl");

    private static final Logger logger = LogManager.getLogger(SystemProperty.class);

    private String value;

    SystemProperty(final String key) {
        this.value = retrieveValue(key);
    }

    public String getValue() {
        return this.value;
    }

    public boolean isSpecified() {
        return null != this.value && !this.value.isEmpty();
    }

    private String retrieveValue(final String key) {

        YamlReader yamlReader = new YamlReader("src/test/resources/", "config.yml");
        yamlReader.getConfigMap();

        if (yamlReader.getConfigMap() != null) {
            Object configValue = yamlReader.getConfigMap().environment.get("prod").get(key);
            if (configValue != null) {
                return configValue.toString();
            }
        }
        return null;
    }



}
