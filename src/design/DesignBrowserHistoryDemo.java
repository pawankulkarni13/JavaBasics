package design;

public class DesignBrowserHistoryDemo {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        System.out.println("back to " + browserHistory.back(1));   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println("back to " + browserHistory.back(1));   // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println("forward to " + browserHistory.forward(1));  // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        System.out.println("forward to " + browserHistory.forward(2)); // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println("back to " + browserHistory.back(2));    // You are in "linkedin.com", move back two steps to "facebook.com"
        System.out.println("back to " + browserHistory.back(7));    // Back to root
    }
}

class BrowserHistory {

    //Can be easily achieved by Stack
    String [] browserHistoryArr;
    int indexCounter = 0;
    int insertionCounter = 0;
    public BrowserHistory(String homepage) {
        browserHistoryArr = new String[5000];
        browserHistoryArr[0] = homepage;
    }

    public void visit(String url) {
        ++insertionCounter;
        indexCounter = insertionCounter;
        browserHistoryArr[insertionCounter]=url;
        System.out.println("Visiting - "+ url);
    }

    public String back(int steps) {

        if(indexCounter - steps <0){
            indexCounter=0;
            return browserHistoryArr[indexCounter];
        }

        if(steps == -1)
            return browserHistoryArr[0];

        if(steps > browserHistoryArr.length) {
            return "";
        }else{
            if(indexCounter> 0 && indexCounter - steps > 0) {
                indexCounter = (indexCounter - steps) ;
                return browserHistoryArr[indexCounter];
            }
        }

        return null;
    }

    public String forward(int steps) {
        if(steps > browserHistoryArr.length || indexCounter+steps > browserHistoryArr.length || indexCounter+steps > insertionCounter)
            return null;

        if(indexCounter < browserHistoryArr.length){
            indexCounter = (indexCounter + steps);
            return browserHistoryArr[indexCounter];
        }

        return null;
    }
}
