package com.epam.grow.service;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileServiceTest {

    private FileService fileService = new FileService();
    private File file = new File(getClass().getClassLoader().getResource("com/epam/grow/service/text.txt").getFile());

    @Test
    public void testReadFromFile() {
        List<String> expected, actual;
        try {
            actual = fileService.readFromFile(file.toPath());
            expected = Arrays.asList("qwewqe", "qwe", "qwe");
            Assert.assertTrue(expected.equals(actual));
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}
