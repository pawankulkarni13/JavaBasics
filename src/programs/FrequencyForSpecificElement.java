package programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrequencyForSpecificElement {

    public static void main(String[] args) {

        List<String> mylist = new ArrayList<String>();
        mylist.add("IBM");
        mylist.add("pawan");
        mylist.add("code");
        mylist.add("quiz");
        mylist.add("code");

        int freq = Collections.frequency(mylist, "code");

        //if its array of integers then
        //int freq = Collections.frequency(Arrays.asList(array), "code");

        System.out.println(freq);

    }
}
