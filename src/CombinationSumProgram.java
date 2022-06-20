import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Given candidate set 10,1,2,7,6,1,5 and target 8,
 *
 * A solution set is:
 *
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */
public class CombinationSumProgram {
    public static void main(String[] args) {


        ArrayList<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(1);
        a.add(2);
        a.add(7);
        a.add(6);
        a.add(1);
        a.add(5);

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        Collections.sort(a);
        combinationSum(a, 8, 8,comb, results,0);

        System.out.println(results);

    }
    public static void combinationSum(ArrayList<Integer> ints, int target, int rem, LinkedList<Integer> comb, ArrayList<ArrayList<Integer>> results, int currNumber ) {

        if(rem <0)
            return;
        else if(rem ==0) {
            results.add(new ArrayList<>(comb));
            return;
        }else{
            for(int i=currNumber;i<ints.size();i++){
                if(i > currNumber && ints.get(i) == ints.get(i-1)){
                    continue;
                }
                Integer no = ints.get(i);
                comb.add(no);
                combinationSum(ints, target, rem-no, comb, results, i+1);
                comb.remove(comb.size()-1);
            }
        }
    }


}

