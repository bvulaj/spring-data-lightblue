/**
 *
 */
package com.redhat.lightblue.springdata.repository.support;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.core.EntityInformation;
import org.springframework.util.Assert;

import com.redhat.lightblue.client.LightblueClient;
import com.redhat.lightblue.client.LightblueException;
import com.redhat.lightblue.client.request.data.DataSaveRequest;
import com.redhat.lightblue.springdata.annotation.LBEntity;
import com.redhat.lightblue.springdata.repository.LightblueRepository;

/**
 * @author bvulaj
 *
 */
public class LightblueRepositoryImpl<T, ID extends Serializable> implements LightblueRepository<T, ID> {

    private final LightblueClient lbClient;
    private final EntityInformation<T, ID> entityInfo;

    public LightblueRepositoryImpl(EntityInformation<T, ID> entityInfo, LightblueClient lbClient) {
        Assert.notNull(entityInfo, "EntityInformation must not be null!");
        Assert.notNull(lbClient, "LightblueClient must not be null!");

        this.entityInfo = entityInfo;
        this.lbClient = lbClient;
    }

    @Override
    public Iterable<T> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends T> S save(S entity) {
        DataSaveRequest saveRequest = new LightblueRequestFactory(
                getLBEntityAnnotation(entity.getClass())).createInstance(DataSaveRequest.class);

        saveRequest.create(entity);
        //TODO: upsert? maybe entityInfo.isNew(entity);
        saveRequest.setUpsert(true);

        //TODO: Projection?

        try {
            return lbClient.data(saveRequest, ((Class<S>) entity.getClass()));
        } catch (LightblueException e) {
            throw new RuntimeException("Unable to save entity: " + entity, e);
        }
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T findOne(ID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean exists(ID id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterable<T> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<T> findAll(Iterable<ID> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(ID id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(T entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Iterable<? extends T> entities) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

    protected LBEntity getLBEntityAnnotation(Class<?> class1) {
        LBEntity details = class1.getAnnotation(LBEntity.class);
        if (details == null) {
            throw new IllegalArgumentException("Entity must be annotated with LBEntity: " + class1.getName());
        }

        return details;
    }

}
