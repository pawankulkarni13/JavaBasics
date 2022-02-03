package programs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonCustomerReviewDemo {
    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {

        List<List<String>> res = new ArrayList<>();

        for(int i = 1; i < customerQuery.length(); i++){

            String s = customerQuery.substring(0, i+1).toLowerCase();
            List<String> keywordsList = repository.stream()
                    .map(String::toLowerCase)
                    .filter(word -> word.startsWith(s))
                    .sorted()
                    .limit(3)
                    .collect(Collectors.toList());
            res.add(keywordsList);
        }

        return res;

    }

}
