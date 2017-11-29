package com.epam.grow.util;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapUtils {

    public static Map<String, Long> convertListToMap(List<String> list) {
        return list
                .stream()
                .map(line -> line.replace(".", "").toLowerCase())
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                        )
                );
    }

    public static Map<String, Long> sortedMapWithLambda(Map<String, Long> map, Order order) {
        Map<String, Long> finalMap = new LinkedHashMap<>();
        if (order.equals(Order.DESCENDING)) {
            map.entrySet().stream()
                    .sorted(MapUtils::compare)
                    .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        } else if (order.equals(Order.ASCENDING)) {
            map.entrySet().stream()
                    .sorted((o1, o2)-> compare(o2, o1))
                    .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        }
        return finalMap;
    }

    private static int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2){
        if (o1.getValue().equals(o2.getValue())) {
            return o2.getKey().compareTo(o1.getKey());
        } else {
            return o2.getValue().compareTo(o1.getValue());
        }
    }
}
