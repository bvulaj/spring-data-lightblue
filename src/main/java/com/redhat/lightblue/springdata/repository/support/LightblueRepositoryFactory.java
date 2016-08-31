/**
 *
 */
package com.redhat.lightblue.springdata.repository.support;

import java.io.Serializable;

import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.repository.core.EntityInformation;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.PersistentEntityInformation;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import com.redhat.lightblue.springdata.repository.mapping.LightbluePersistentEntity;
import com.redhat.lightblue.springdata.repository.mapping.LightbluePersistentProperty;
import com.redhat.lightblue.springdata.repository.support.entity.LightbluePersistentEntityInformation;

/**
 * @author bvulaj
 *
 */
public class LightblueRepositoryFactory extends RepositoryFactorySupport {

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.repository.core.support.RepositoryFactorySupport#getEntityInformation(java.lang.Class)
     */
    @Override
    public <T, ID extends Serializable> EntityInformation<T, ID> getEntityInformation(Class<T> domainClass) {
        PersistentEntity<T, LightbluePersistentProperty> pe = new LightbluePersistentEntity<>(domainClass);
        PersistentEntityInformation<T, ID> ei = new LightbluePersistentEntityInformation<T, ID>(pe);
        return ei;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.repository.core.support.RepositoryFactorySupport#getTargetRepository(org.springframework.data.repository.core.RepositoryInformation)
     */
    @Override
    protected Object getTargetRepository(RepositoryInformation metadata) {
        EntityInformation<?, Serializable> entityInformation = getEntityInformation(metadata.getDomainType());
        // TODO: lb client injection
        LightblueRepositoryImpl<?, Serializable> lbRepo = new LightblueRepositoryImpl<>(entityInformation, null);
        return lbRepo;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.repository.core.support.RepositoryFactorySupport#getRepositoryBaseClass(org.springframework.data.repository.core.RepositoryMetadata)
     */
    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return LightblueRepositoryImpl.class;
    }

}
