package com.redhat.lightblue.springdata.test;

import com.redhat.lightblue.springdata.repository.LightblueRepository;
import com.redhat.lightblue.springdata.test.model.Simple;

public interface SimpleLightblueRepository extends LightblueRepository<Simple, String> {

    //List<Simple> findByValue(String value);

}
