package com.sap.broker.budgie.configuration;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class Environment {

    private Gson gson;

    @Inject
    public Environment(Gson gson) {
        this.gson = gson;
    }

    public String getVariable(String name) {
        return System.getenv(name);
    }

    public <T> T getJsonVariable(String name, Class<T> classOfT) {
        String json = getVariable(name);
        return json == null ? null : gson.fromJson(json, classOfT);
    }

}
