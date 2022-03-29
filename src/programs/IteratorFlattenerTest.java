package programs;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * "Flattens" nested sub-iterators into an iterator in a depth-first manner.
 *
 * Requirements:
 *  - Limit the amount of additional consumed memory to O(1).
 *
 * Example: an iterator {{1,2},{3},{4,5}} which has three sub-iterators with
 * 2, 1 and 2 elements correspondingly, presents values in this order:
 * {1, 2, 3, 4, 5}
 */

/**
 * Approach :
 *
 * @param <E>
 */
public class IteratorFlattenerTest {

    @org.junit.Test
    public void given_Strings_When_Itr_Flattener_Invoked_Then_Return_Flat_List() {
        List<String> stringsOne = Arrays.asList("StringOne", "StringTwo", "StringThree");
        List<String> stringsTwo = Arrays.asList("StringFour");
        List<String> stringsThree = Arrays.asList("StringFive", "StringSix", "StringSeven");
        List<String> expectedList = Arrays.asList("StringOne", "StringTwo", "StringThree", "StringFour", "StringFive", "StringSix", "StringSeven");
        List<Iterator<String>> response = Arrays.asList(stringsOne.iterator(), stringsTwo.iterator(), stringsThree.iterator());

        IteratorFlattener<String> flattener = new IteratorFlattener<>(response.iterator());

        List<String> flatList = new ArrayList<>();
        while (flattener.hasNext()) {
            flatList.add(flattener.next());
        }
        Assert.assertEquals(expectedList, flatList);
    }

    @org.junit.Test
    public void given_Integers_When_Itr_Flattener_Invoked_Then_Return_Flat_List() {
        List<Integer> numListOne = Arrays.asList(1,2,3);
        List<Integer> numListTwo = Arrays.asList(5,6,7,8);
        List<Integer> numListThree = Arrays.asList(4);
        List<Integer> numListFour = Arrays.asList(10,20);

        List<Integer> expectedList = Arrays.asList(1,2,3,5,6,7,8,4,10,20);
        List<Iterator<Integer>> numListItr = Arrays.asList(numListOne.iterator(),numListTwo.iterator(),numListThree.iterator(),numListFour.iterator());
        IteratorFlattener<Integer> flat = new IteratorFlattener<>(numListItr.iterator());
        List<Integer> flatList = new ArrayList<Integer>();
        while (flat.hasNext()) {
            flatList.add(flat.next());
        }
        Assert.assertEquals(expectedList, flatList);
    }

    @Test
    public void given_Two_Integers_List_When_Itr_Flattener_Invoked_Then_Return_Flat_List(){
        List<Integer> numListOne = new ArrayList<>();
        List<Integer> numListTwo = Arrays.asList(5,6,7,8);
        List<Integer> expectedList = Arrays.asList(5,6,7,8);
        List<Iterator<Integer>> numListItr = Arrays.asList(numListOne.iterator(),numListTwo.iterator());
        IteratorFlattener<Integer> flat = new IteratorFlattener<>(numListItr.iterator());
        List<Integer> flatList = new ArrayList<Integer>();
        while (flat.hasNext()) {
            flatList.add(flat.next());
        }
        Assert.assertEquals(expectedList, flatList);
    }

    @Test
    public void given_Empty_List_Integers_When_Itr_Flattener_Invoked_Then_Return_Empty_List(){
        List<Integer> numListOne = new ArrayList<>();
        List<Integer> numListTwo = new ArrayList<>();
        List<Integer> expectedList = new ArrayList<>();
        List<Iterator<Integer>> numListItr = Arrays.asList(numListOne.iterator(),numListTwo.iterator());
        IteratorFlattener<Integer> flat = new IteratorFlattener<>(numListItr.iterator());
        List<Integer> flatList = new ArrayList<Integer>();
        while (flat.hasNext()) {
            flatList.add(flat.next());
        }
        Assert.assertEquals(expectedList, flatList);
    }

    @Test
    public void given_Two_Integers_List_When_Elements_Even_Remove_Then_Return_Flat_List(){
        List<Integer> numList = Arrays.asList(5,6,7,8,9);
        List<Integer> expectedList = Arrays.asList(5,7,9);
        List<Iterator<Integer>> numListItr = Collections.singletonList(numList.iterator());
        IteratorFlattener<Integer> flat = new IteratorFlattener<>(numListItr.iterator());
        List<Integer> flatList = new ArrayList<Integer>();
        while (flat.hasNext()) {
            int element = flat.next();
            if(element % 2 ==0)
                flat.remove();
            else
                flatList.add(element);
        }
        Assert.assertEquals(expectedList, flatList);
    }

}

