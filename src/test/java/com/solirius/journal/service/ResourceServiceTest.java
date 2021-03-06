package com.solirius.journal.service;

import com.solirius.journal.Service.ResourceService;
import com.solirius.journal.domain.Resource;
import com.solirius.journal.repository.ResourceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
public class ResourceServiceTest {

    @Mock
    private ResourceRepository resourceRepository;

    private ResourceService resourceService;

    @Before
    public void setup() {
        Resource testResource = new Resource();
        testResource.setName("testResource");
        testResource.setUrl("http://testResource.com");
        testResource.setResourceId(1);
        List<Resource> testResources = Arrays.asList(testResource);
        
        given(resourceRepository.findAll()).willReturn(testResources);
        resourceService = new ResourceService(resourceRepository);

    }

    @Test
    public void resourceService() {
        List<Resource> testResources = resourceService.getAllResources();

        assertNotNull(testResources);
        assertEquals(1, testResources.size());
    }
}
