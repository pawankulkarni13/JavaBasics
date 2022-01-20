package programs;

import java.util.Stack;

public class ParanthesisCheckerDemo {

    public static void main(String[] args) {

        //Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
        //For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”
        //
        //Input:
        //The first line of input contains an integer T denoting the number of test cases.  Each test case consists of a string of expression, in a separate line.
        //
        //Output:
        //Print 'balanced' without quotes if the pair of parenthesis is balanced else print 'not balanced' in a separate line.
        //
        //Constraints:
        //1 ≤ T ≤ 100
        //1 ≤ |s| ≤ 105
        //
        //Example:
        //Input:
        //3
        //{([])}
        //()
        //([]
        //
        //Output:
        //balanced
        //balanced
        //not balanced

        String s = "";

        boolean isBalanced = bracketsBalanced(s);
        System.out.println(isBalanced);

        s ="()]";
        isBalanced = bracketsBalanced(s);
        System.out.println(isBalanced);


    }

    private static boolean bracketsBalanced(String s) {

        Stack<Character> stack = new Stack();
        char [] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {

            if(!stack.empty() && ch[i] == stack.peek()){
                stack.pop();
            }else{
                stack.push(ch[i]);
            }

        }

        if(stack.empty()){
            return true;
        }
        return false;

    }
}
