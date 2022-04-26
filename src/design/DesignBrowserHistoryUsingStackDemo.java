package design;

import org.w3c.dom.ls.LSOutput;

import java.util.Stack;

public class DesignBrowserHistoryUsingStackDemo {
    public static void main(String[] args) {
        BrowserHistoryStack browserHistory = new BrowserHistoryStack("leetcode.com");
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

class BrowserHistoryStack {

    private final Stack<String> stack ;
    private int indexCounter = 0;
    public BrowserHistoryStack(String homepage) {
        stack = new Stack<>();
        stack.add(homepage);
    }

    public void visit(String url) {
        stack.add(url);
        indexCounter = stack.size()-1;
        System.out.println("Visiting - "+ url);
    }

    public String back(int steps) {

        if(indexCounter - steps < 0){
            indexCounter=0;
            return stack.get(0);
        }
        indexCounter = indexCounter-steps;
        return stack.get(indexCounter);
    }

    public String forward(int steps) {
        if(steps > stack.size() || indexCounter+steps >= stack.size())
            return null;

        indexCounter = indexCounter+steps;
        return stack.get(indexCounter);
    }
}
