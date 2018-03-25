package com.home.hackerearth.athena;

import java.util.*;

public class q3 {

    public static void main (String[] args) {

        System.out.println("test");
        Map<String, Set<String>> taskDependencyMap = new HashMap<>();
        Set<String> taskSet = new HashSet<>(Arrays.asList("1","2","3","4","5"));
        taskDependencyMap.put("3", new HashSet<>(Arrays.asList("1","5")));
        taskDependencyMap.put("2", new HashSet<>(Arrays.asList("5","3")));
        taskDependencyMap.put("4", new HashSet<>(Arrays.asList("3")));
        taskDependencyMap.put("5", new HashSet<>(Arrays.asList("1")));
        taskDependencyMap.put("1",new HashSet<>());
        printDependencyOrder(taskDependencyMap);


    }

    /**
     * How would you resolve task's inter dependency, just as in maven/ant.
     * e.g - 3 -> 1,5
     *       2 -> 5,3
     *       4 -> 3
     *       5 -> 1
     */
    static void printDependencyOrder(Map<String, Set<String>> taskDependencyMap){
        Set<String> orderedSet = new LinkedHashSet<>();

        while (!taskDependencyMap.isEmpty()) {
            if (taskDependencyMap.containsValue(new HashSet<>())) {
                for (Iterator<Map.Entry<String, Set<String>>> it = taskDependencyMap.entrySet().iterator();it.hasNext();) {
                    Map.Entry<String, Set<String>> item = it.next();
                    if (item.getValue().size()==0) {
                        orderedSet.add(item.getKey());
                        it.remove();
                        rearangeDependencyMap(taskDependencyMap, item);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(orderedSet.toArray()));
    }

    private static void rearangeDependencyMap(Map<String, Set<String>> taskDependencyMap, Map.Entry<String, Set<String>> item) {
        for (Iterator<Map.Entry<String, Set<String>>> it = taskDependencyMap.entrySet().iterator(); it.hasNext();)  {
            Map.Entry<String, Set<String>> currentItem = it.next();
            Set<String> currentValue = currentItem.getValue();
            currentValue.remove(item.getKey());
            taskDependencyMap.put(currentItem.getKey(),currentValue);
        }
    }
}
