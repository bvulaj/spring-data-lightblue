/**
 *
 */
package com.redhat.lightblue.springdata.repository.support;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import com.redhat.lightblue.client.LightblueClient;
import com.redhat.lightblue.springdata.repository.LightblueRepository;

/**
 * @author bvulaj
 *
 */
public class LightblueRepositoryFactoryBean<T extends LightblueRepository<S, ID>, S, ID extends Serializable> extends RepositoryFactoryBeanSupport<T, S, ID> {

    private final LightblueClient lightblueClient;

    public LightblueClient getLightblueClient() {
        return lightblueClient;
    }

    @Autowired
    public LightblueRepositoryFactoryBean(LightblueClient lightblueClient) {
        this.lightblueClient = lightblueClient;
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory() {
        return new LightblueRepositoryFactory(lightblueClient);
    }

}
