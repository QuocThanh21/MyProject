package com.demoqa.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private final Map<String, Object> scenarioContext;

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public void setContext(String key, Object value) {
        scenarioContext.put(key, value);
    }

    public <T> T getContext(String key, Class<T> kclass) {
        return kclass.cast(scenarioContext.get(key));
    }
}
