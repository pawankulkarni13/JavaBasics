package datastructures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {
    public static void main(String[] args) {
        int capacityOfQueue = 4;

        PriorityBlockingQueue<String> names = new PriorityBlockingQueue<String>(
                capacityOfQueue, Comparator.reverseOrder());

        names.add("Naveen");
        names.add("Guru");
        names.add("Pawan");
        names.add("Purvi");
        names.add("Swara");

        System.out.println(names);
        Iterator iteratorVals = names.iterator();

        System.out.println("The Names are:");

        //an Iterator from a PriorityBlockingQueue, the Iterator does not guarantee to iterate the elements in priority order.
        while (iteratorVals.hasNext()) {
            System.out.println(iteratorVals.next());
        }
    }
}
