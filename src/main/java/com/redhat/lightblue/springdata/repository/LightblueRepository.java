/**
 *
 */
package com.redhat.lightblue.springdata.repository;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author bvulaj
 * @param <T>
 * @param <ID>
 *
 */
public interface LightblueRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

}
