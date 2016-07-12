/**
 *
 */
package com.redhat.lightblue.springdata.repository.support;

import java.io.Serializable;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/**
 * @author bvulaj
 *
 */
public class LightblueRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable> extends RepositoryFactoryBeanSupport<T, S, ID> {

    @Override
    protected RepositoryFactorySupport createRepositoryFactory() {
        // TODO Auto-generated method stub
        return null;
    }

}
