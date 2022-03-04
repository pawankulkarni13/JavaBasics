package datastructures;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVSLinkedListDemo {

    private static final int MAX = 500000;
    String[] strings = maxArray();

    ////////////// ADD ALL ////////////////////////////////////////
    @Test
    public void arrayListAddAll() {
        Watch watch = new Watch();
        List<String> stringList = Arrays.asList(strings);
        List<String> arrayList = new ArrayList<String>(MAX);

        watch.start();
        arrayList.addAll(stringList);
        watch.totalTime("Array List addAll() = ");// Nanoseconds
    }

    @Test
    public void linkedListAddAll() throws Exception {
        Watch watch = new Watch();
        List<String> stringList = Arrays.asList(strings);

        watch.start();
        List<String> linkedList = new LinkedList<String>();
        linkedList.addAll(stringList);
        watch.totalTime("Linked List addAll() = ");  // Nanoseconds
    }

    //Note: ArrayList is __ time faster here than LinkedList for addAll()

    ///////////////// INSERT /////////////////////////////////////////////
    @Test
    public void arrayListAdd() {
        Watch watch = new Watch();
        List<String> arrayList = new ArrayList<String>(MAX);

        watch.start();
        for (String string : strings)
            arrayList.add(string);
        watch.totalTime("Array List add() = ");// Nanoseconds
    }

    @Test
    public void linkedListAdd() {
        Watch watch = new Watch();

        List<String> linkedList = new LinkedList<String>();
        watch.start();
        for (String string : strings)
            linkedList.add(string);
        watch.totalTime("Linked List add() = ");  // Nanoseconds
    }

    //Note: ArrayList is __ times faster than LinkedList for add sequentially

    /////////////////// INSERT IN BETWEEN ///////////////////////////////////////

    @Test
    public void arrayListInsertOne() {
        Watch watch = new Watch();
        List<String> stringList = Arrays.asList(strings);
        List<String> arrayList = new ArrayList<String>(MAX + MAX / 10);
        arrayList.addAll(stringList);

        String insertString0 = getString(true, MAX / 2 + 10);
        String insertString1 = getString(true, MAX / 2 + 20);
        String insertString2 = getString(true, MAX / 2 + 30);
        String insertString3 = getString(true, MAX / 2 + 40);

        watch.start();

        arrayList.add(insertString0);
        arrayList.add(insertString1);
        arrayList.add(insertString2);
        arrayList.add(insertString3);

        watch.totalTime("Array List add() = ");//
    }

    @Test
    public void linkedListInsertOne() {
        Watch watch = new Watch();
        List<String> stringList = Arrays.asList(strings);
        List<String> linkedList = new LinkedList<String>();
        linkedList.addAll(stringList);

        String insertString0 = getString(true, MAX / 2 + 10);
        String insertString1 = getString(true, MAX / 2 + 20);
        String insertString2 = getString(true, MAX / 2 + 30);
        String insertString3 = getString(true, MAX / 2 + 40);

        watch.start();

        linkedList.add(insertString0);
        linkedList.add(insertString1);
        linkedList.add(insertString2);
        linkedList.add(insertString3);

        watch.totalTime("Linked List add = ");//
    }


    //Note: LinkedList is ____ nanosecond faster than ArrayList for insert randomly.

    ////////////////// DELETE //////////////////////////////////////////////////////
    @Test
    public void arrayListRemove() throws Exception {
        Watch watch = new Watch();
        List<String> stringList = Arrays.asList(strings);
        List<String> arrayList = new ArrayList<String>(MAX);

        arrayList.addAll(stringList);
        String searchString0 = getString(true, MAX / 2 + 10);
        String searchString1 = getString(true, MAX / 2 + 20);

        watch.start();
        arrayList.remove(searchString0);
        arrayList.remove(searchString1);
        watch.totalTime("Array List remove() = ");// Nanoseconds
    }

    @Test
    public void linkedListRemove() throws Exception {
        Watch watch = new Watch();
        List<String> linkedList = new LinkedList<String>();
        linkedList.addAll(Arrays.asList(strings));

        String searchString0 = getString(true, MAX / 2 + 10);
        String searchString1 = getString(true, MAX / 2 + 20);

        watch.start();
        linkedList.remove(searchString0);
        linkedList.remove(searchString1);
        watch.totalTime("Linked List remove = ");// Nanoseconds
    }

    //Note: LinkedList is __ millisecond faster than ArrayList while removing item.

    ///////////////////// SEARCH ///////////////////////////////////////////
    @Test
    public void arrayListSearch() throws Exception {
        Watch watch = new Watch();
        List<String> stringList = Arrays.asList(strings);
        List<String> arrayList = new ArrayList<String>(MAX);

        arrayList.addAll(stringList);
        String searchString0 = getString(true, MAX / 2 + 10);
        String searchString1 = getString(true, MAX / 2 + 20);

        watch.start();
        arrayList.contains(searchString0);
        arrayList.contains(searchString1);
        watch.totalTime("Array List addAll() time = ");
    }

    @Test
    public void linkedListSearch() throws Exception {
        Watch watch = new Watch();
        List<String> linkedList = new LinkedList<String>();
        linkedList.addAll(Arrays.asList(strings));

        String searchString0 = getString(true, MAX / 2 + 10);
        String searchString1 = getString(true, MAX / 2 + 20);

        watch.start();
        linkedList.contains(searchString0);
        linkedList.contains(searchString1);
        watch.totalTime("Linked List addAll() time = ");
    }

    //Note: Linked List is ___ Milliseconds faster than ArrayList

    class Watch {
        private long startTime;
        private long endTime;

        public void start() {
            startTime = System.nanoTime();
        }

        private void stop() {
            endTime = System.nanoTime();
        }

        public void totalTime(String s) {
            stop();
            System.out.println(s + (endTime - startTime));
        }
    }


    private String[] maxArray() {
        String[] strings = new String[MAX];
        Boolean result = Boolean.TRUE;
        for (int i = 0; i < MAX; i++) {
            strings[i] = getString(result, i);
            result = !result;
        }
        return strings;
    }

    private String getString(Boolean result, int i) {
        return String.valueOf(result) + i + String.valueOf(!result);
    }

}
