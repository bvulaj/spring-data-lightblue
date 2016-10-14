package com.redhat.lightblue.springdata.repository;

import static com.redhat.lightblue.util.test.AbstractJsonNodeTest.loadJsonNode;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.core.support.ReflectionEntityInformation;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.fasterxml.jackson.databind.JsonNode;
import com.redhat.lightblue.client.LightblueClient;
import com.redhat.lightblue.client.integration.test.LightblueExternalResource;
import com.redhat.lightblue.client.integration.test.LightblueExternalResource.LightblueTestMethods;
import com.redhat.lightblue.springdata.repository.support.LightblueRepositoryFactory;
import com.redhat.lightblue.springdata.test.model.Simple;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class LightblueRepositoryTest {

    @ClassRule
    public static LightblueExternalResource lightblue = new LightblueExternalResource(new LightblueTestMethods() {

        @Override
        public JsonNode[] getMetadataJsonNodes() throws Exception {
            return new JsonNode[]{
                    loadJsonNode("metadata/simple.json")
                };
        }
    });

    @Configuration
    static class ContextConfiguration {

        @Bean
        public LightblueClient lightblueClient() {
            return lightblue.getLightblueClient();
        }

        @Bean
        public LightblueRepositoryFactory lightblueRepositoryFactory(LightblueClient lightblueClient) {
            return new LightblueRepositoryFactory(lightblueClient);
        }

        @Bean(name = "SimpleLightblueRepository")
        public LightblueRepository<Simple, String> simpleLightblueRepository(LightblueRepositoryFactory factory) {
            return factory.getTargetRepository(new ReflectionEntityInformation<>(Simple.class));
        }

    }

    @Autowired
    public LightblueRepository<Simple, String> simpleLightblueRepository;

    @Before
    public void before() throws Exception {
        lightblue.cleanupMongoCollections("simple");
    }

    @Test
    public void testSave() {
        Simple entity = new Simple();
        entity.set_id("fakekey");
        entity.setValue("fakevalue");

        Simple createdEntity = simpleLightblueRepository.save(entity);
        assertNotNull(createdEntity);
    }

}
