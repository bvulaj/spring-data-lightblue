package com.redhat.lightblue.springdata.repository;

import static com.redhat.lightblue.util.test.AbstractJsonNodeTest.loadJsonNode;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fasterxml.jackson.databind.JsonNode;
import com.redhat.lightblue.client.integration.test.LightblueExternalResource;
import com.redhat.lightblue.client.integration.test.LightblueExternalResource.LightblueTestMethods;
import com.redhat.lightblue.springdata.test.SimpleApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SimpleApplication.class)
@WebAppConfiguration
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

    @Before
    public void before() throws Exception {
        lightblue.cleanupMongoCollections("simple");
    }

    @Test
    public void test() {

    }

}
