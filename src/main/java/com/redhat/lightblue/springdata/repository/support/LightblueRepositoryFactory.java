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

import com.redhat.lightblue.client.LightblueClient;
import com.redhat.lightblue.springdata.repository.LightblueRepository;
import com.redhat.lightblue.springdata.repository.mapping.LightbluePersistentEntity;
import com.redhat.lightblue.springdata.repository.mapping.LightbluePersistentProperty;
import com.redhat.lightblue.springdata.repository.support.entity.LightbluePersistentEntityInformation;

/**
 * @author bvulaj
 *
 */
public class LightblueRepositoryFactory extends RepositoryFactorySupport {

    private final LightblueClient lightblueClient;

    public LightblueClient getLightblueClient() {
        return lightblueClient;
    }

    public LightblueRepositoryFactory(LightblueClient lightblueClient) {
        this.lightblueClient = lightblueClient;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.repository.core.support.RepositoryFactorySupport#getEntityInformation(java.lang.Class)
     */
    @Override
    public <T, ID extends Serializable> EntityInformation<T, ID> getEntityInformation(Class<T> domainClass) {
        PersistentEntity<T, LightbluePersistentProperty> pe = new LightbluePersistentEntity<>(domainClass);
        PersistentEntityInformation<T, ID> ei = new LightbluePersistentEntityInformation<>(pe);
        return ei;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.repository.core.support.RepositoryFactorySupport#getTargetRepository(org.springframework.data.repository.core.RepositoryInformation)
     */
    @Override
    protected Object getTargetRepository(RepositoryInformation metadata) {
        return getTargetRepository(metadata.getDomainType());
    }

    public <T, ID extends Serializable> LightblueRepository<T, ID> getTargetRepository(Class<T> domainClass) {
        return getTargetRepository(getEntityInformation(domainClass));
    }

    public <T, ID extends Serializable> LightblueRepository<T, ID> getTargetRepository(EntityInformation<T, ID> entityInformation) {
        return new LightblueRepositoryImpl<>(entityInformation, getLightblueClient());
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
