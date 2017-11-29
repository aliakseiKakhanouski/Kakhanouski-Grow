package com.epam.grow;

import com.epam.grow.util.MapUtils;
import com.epam.grow.util.FileUtils;
import com.epam.grow.util.Order;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    private static final String PATH = "path";
    private static final String ORDER = "order";

    private static Path path;
    private static Order order;

    public static void main(String[] args) {
        readParam(args);
        if (path == null) {
            return;
        }
        Map<String, Long> map = Collections.emptyMap();
        try {
            map = MapUtils.convertListToMap(FileUtils.readFromFile(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (order.equals(Order.NONE)) {
            System.out.println(map);
        } else {
            System.out.println(MapUtils.sortedMapWithLambda(map, order));
        }
    }

    private static void readParam(String args[]) {
        for (String arg : args) {
            String param[] = arg.split("=");
            if (param[0].equals(PATH)) {
                path = Paths.get(param[1]);
            } else if (param[0].equals(ORDER)) {
                if (param[1].equals("asc")) {
                    order = Order.ASCENDING;
                } else if (param[1].equals("des")) {
                    order = Order.DESCENDING;
                } else {
                    order = Order.NONE;
                }
            }
        }
    }
}
