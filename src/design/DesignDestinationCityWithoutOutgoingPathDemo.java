package design;

import java.util.*;

public class DesignDestinationCityWithoutOutgoingPathDemo {

    public static void main(String[] args) {

        List<List<String>> paths = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add("London");
        path.add("New York");
        paths.add(path);

        path = new ArrayList<>();
        path.add("New York");
        path.add("Lima");
        paths.add(path);

        path = new ArrayList<>();
        path.add("Lima");
        path.add("Sao Paulo");
        paths.add(path);

        System.out.println("destination city, that is, the city without any path outgoing to another city. - " + destCity(paths));

        paths = new ArrayList<>();
        path = new ArrayList<>();
        path.add("B");
        path.add("Z");
        paths.add(path);

        System.out.println("destination city, that is, the city without any path outgoing to another city. - " + destCity(paths));

        paths = new ArrayList<>();
        path = new ArrayList<>();
        path.add("B");
        path.add("C");
        paths.add(path);

        path = new ArrayList<>();
        path.add("D");
        path.add("B");
        paths.add(path);

        path = new ArrayList<>();
        path.add("C");
        path.add("A");
        paths.add(path);

        System.out.println("destination city, that is, the city without any path outgoing to another city. - " + destCity(paths));

    }

    private static String destCity(List<List<String>> paths) {
        Set<String> startPoints = new HashSet<>();
        for (List<String> each: paths)
            startPoints.add(each.get(0));

        for (List<String> each: paths) {
            String destination = each.get(1);
            if (!startPoints.contains(destination))
                return destination;
        }
        return null;
    }

    /*public static String destAltCity(List<List<String>> paths) {

        Map<String, Integer> cityMap = new LinkedHashMap<>();
        paths.forEach(rec->{
            rec.forEach(key->{

                if(cityMap.containsKey(key)){
                    cityMap.put(key, cityMap.get(key)+1);
                }else{
                    cityMap.put(key, 1);
                }
            });
        });

        int lastElement = cityMap.keySet().size()-1;

        int i = 0;
        for(String key: cityMap.keySet()){
            if(i == lastElement)
                return key;
            i++;
        }
        return null;
    }*/
}
