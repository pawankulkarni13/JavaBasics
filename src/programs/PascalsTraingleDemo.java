package programs;

import java.util.ArrayList;
import java.util.List;

public class PascalsTraingleDemo {
    public static void main(String[] args) {

        System.out.println("Pascal's Traingle - "+ generate(5));

    }
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> response = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for(int i=0;i<numRows;i++) {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            response.add(new ArrayList<>(row));
        }
        return response;
    }
}
