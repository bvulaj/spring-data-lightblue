/**
 *
 */
package com.redhat.lightblue.springdata.repository.support.entity;

import java.io.Serializable;

import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.repository.core.support.PersistentEntityInformation;

/**
 * @author bvulaj
 *
 */
public class LightbluePersistentEntityInformation<T, ID extends Serializable> extends PersistentEntityInformation<T, ID> {

    public LightbluePersistentEntityInformation(PersistentEntity<T, ?> entity) {
        super(entity);
        // TODO Auto-generated constructor stub
    }

}
