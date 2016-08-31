/**
 *
 */
package com.redhat.lightblue.springdata.repository.mapping;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

import org.springframework.data.mapping.Association;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.mapping.model.AnnotationBasedPersistentProperty;
import org.springframework.data.mapping.model.SimpleTypeHolder;

/**
 * @author bvulaj
 *
 */
public class LightbluePersistentProperty extends AnnotationBasedPersistentProperty<LightbluePersistentProperty>{

    public LightbluePersistentProperty(Field field, PropertyDescriptor propertyDescriptor, PersistentEntity<?, LightbluePersistentProperty> owner,
            SimpleTypeHolder simpleTypeHolder) {
        super(field, propertyDescriptor, owner, simpleTypeHolder);
    }

    @Override
    protected Association<LightbluePersistentProperty> createAssociation() {
        return new Association<LightbluePersistentProperty>(this, null);
    }

}
