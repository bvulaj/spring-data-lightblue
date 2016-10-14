package com.redhat.lightblue.springdata.repository.support;

import java.lang.reflect.InvocationTargetException;

import com.redhat.lightblue.client.request.CRUDRequest;
import com.redhat.lightblue.springdata.annotation.LBEntity;

public class LightblueRequestFactory {

    private final String entityName;
    private final String entityVersion;

    public String getEntityName() {
        return entityName;
    }

    public String getEntityVersion() {
        return entityVersion;
    }

    public LightblueRequestFactory(LBEntity entity) {
        this(entity.entity(), entity.version());
    }

    public LightblueRequestFactory(String entityName, String entityVersion) {
        if (entityName == null) {
            throw new IllegalArgumentException("entityName cannot be null");
        }

        this.entityName = entityName;

        if (entityVersion == null || entityVersion.length() == 0) {
            this.entityVersion = null;
        } else {
            this.entityVersion = entityVersion;
        }
    }

    public LightblueRequestFactory(String entityName) {
        this(entityName, null);
    }

    public <R extends CRUDRequest> R createInstance(Class<R> type){
        try {
            return type.getConstructor(String.class, String.class).newInstance(entityName, entityVersion);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            throw new RuntimeException("Unable to instantiate: " + type.getName(), e);
        }
    }

}
