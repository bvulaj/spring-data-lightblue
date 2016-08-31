/**
 *
 */
package com.redhat.lightblue.springdata.repository.mapping;

import java.lang.annotation.Annotation;

import org.springframework.data.mapping.AssociationHandler;
import org.springframework.data.mapping.IdentifierAccessor;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.mapping.PersistentProperty;
import org.springframework.data.mapping.PersistentPropertyAccessor;
import org.springframework.data.mapping.PreferredConstructor;
import org.springframework.data.mapping.PropertyHandler;
import org.springframework.data.mapping.SimpleAssociationHandler;
import org.springframework.data.mapping.SimplePropertyHandler;
import org.springframework.data.util.TypeInformation;

/**
 * @author bvulaj
 *
 */
public class LightbluePersistentEntity<T> implements PersistentEntity<T, LightbluePersistentProperty> {

    Class<T> domainClass;

    /**
     * @param domainClass
     */
    public LightbluePersistentEntity(Class<T> domainClass) {
        this.domainClass = domainClass;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PreferredConstructor<T, LightbluePersistentProperty> getPersistenceConstructor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isConstructorArgument(PersistentProperty<?> property) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isIdProperty(PersistentProperty<?> property) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isVersionProperty(PersistentProperty<?> property) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public LightbluePersistentProperty getIdProperty() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LightbluePersistentProperty getVersionProperty() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LightbluePersistentProperty getPersistentProperty(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LightbluePersistentProperty getPersistentProperty(Class<? extends Annotation> annotationType) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasIdProperty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasVersionProperty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Class<T> getType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getTypeAlias() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TypeInformation<T> getTypeInformation() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void doWithProperties(PropertyHandler<LightbluePersistentProperty> handler) {
        // TODO Auto-generated method stub

    }

    @Override
    public void doWithProperties(SimplePropertyHandler handler) {
        // TODO Auto-generated method stub

    }

    @Override
    public void doWithAssociations(AssociationHandler<LightbluePersistentProperty> handler) {
        // TODO Auto-generated method stub

    }

    @Override
    public void doWithAssociations(SimpleAssociationHandler handler) {
        // TODO Auto-generated method stub

    }

    @Override
    public <A extends Annotation> A findAnnotation(Class<A> annotationType) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PersistentPropertyAccessor getPropertyAccessor(Object bean) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IdentifierAccessor getIdentifierAccessor(Object bean) {
        // TODO Auto-generated method stub
        return null;
    }
}
