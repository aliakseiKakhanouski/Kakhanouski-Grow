package com.epam.grow.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileService {

    public List<String> readFromFile(Path path) throws IOException {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(path);
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        return list;
    }
}
