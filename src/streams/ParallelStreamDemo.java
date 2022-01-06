package streams;

import java.util.Arrays;

public class ParallelStreamDemo {

    public static void main(String[] args) {

        basicExample();

    }

    private static void basicExample() {
        System.out.println("Stream");
        Arrays.asList(1,2,3,4,5,6,7,8,9).stream().forEach(rec-> System.out.print(rec));
        System.out.println("\n Parallel");
        Arrays.asList(1,2,3,4,5,6,7,8,9).stream().parallel().forEach(rec-> System.out.print(rec));

        System.out.println("\n ParallelStream ? Any Difference ?");
        Arrays.asList(1,2,3,4,5,6,7,8,9).parallelStream().forEach(rec-> System.out.print(rec));

        System.out.println("\n Parallel Stream with Sequential ? why ?");
        Arrays.asList(1,2,3,4,5,6,7,8,9).parallelStream().sequential().forEach(rec-> System.out.print(rec));
    }
}
