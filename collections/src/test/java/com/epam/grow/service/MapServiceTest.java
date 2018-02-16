package com.epam.grow.service;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class MapServiceTest {

    private Path path = Paths.get("text.txt");

    @Mock
    private FileService mock;

    @InjectMocks
    private MapService mapService = new MapService();

    private Map<String, Long> map;

    @Before
    public void before() {
        map = new LinkedHashMap<>();
        map.put("qwe", 3L);
        map.put("asd", 1L);
        map.put("zxc", 2L);
    }

    @Test
    public void testCalculateWords() {
        try {
            when(mock.readFromFile(path)).thenReturn(Arrays.asList("qwe", "qwe", "asd", "zxc"));
            Map<String, Long> map = mapService.calculateWords(path);
            Assert.assertEquals(3, map.size());
            Assert.assertEquals(new Long(2), map.get("qwe"));
            Assert.assertEquals(new Long(1), map.get("asd"));
            Assert.assertEquals(new Long(1), map.get("zxc"));
            verify(mock).readFromFile(path);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testSortMapNone() {
        Map<String, Long> actualMap = mapService.sortMap(map, Order.NONE);

        Assert.assertTrue(actualMap.equals(map));
    }

    @Test
    public void testSortMapAsc() {
        Map<String, Long> expectedMap = new LinkedHashMap<>();
        expectedMap.put("asd", 1L);
        expectedMap.put("zxc", 2L);
        expectedMap.put("qwe", 3L);
        Map<String, Long> actualMap = mapService.sortMap(map, Order.ASCENDING);

        Assert.assertTrue(actualMap.equals(expectedMap));
    }

    @Test
    public void testSortMapDesc() {
        Map<String, Long> expectedMap = new LinkedHashMap<>();
        expectedMap.put("zxc", 2L);
        expectedMap.put("qwe", 3L);
        expectedMap.put("asd", 1L);
        Map<String, Long> actualMap = mapService.sortMap(map, Order.DESCENDING);

        Assert.assertTrue(actualMap.equals(expectedMap));
    }
}
