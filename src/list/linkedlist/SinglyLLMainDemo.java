package list.linkedlist;

public class SinglyLLMainDemo {
    public static void main(String[] args) {
        SinglyLL singlyLL = new SinglyLL();
//        singlyLL.addNodeInBeginning(6);
        singlyLL.addNodeInBeginning(5);
        singlyLL.addNodeInBeginning(4);
        singlyLL.addNodeInBeginning(3);
        singlyLL.addNodeInBeginning(2);
        singlyLL.addNodeInBeginning(1);
//        singlyLL.printNodes(1);

        displayNodes(singlyLL);
        System.out.println("** Middle Node of LinkedList is = " + singlyLL.getMiddle());

        displayNodes(singlyLL);

        System.out.println("singlyLL is empty ? " + singlyLL.isEmpty());

        basicDemo(singlyLL);

        System.out.println("Reversing LinkedList now - ");
        reverseNodes(singlyLL);
        displayNodes(singlyLL);

        SinglyLL singlyLL2 = new SinglyLL();
        mergeLL(singlyLL,singlyLL2);

    }

    private static void mergeLL(SinglyLL singlyLL, SinglyLL singlyLL2) {
        System.out.println("singlyLL2 is empty ? " + singlyLL2.isEmpty());
        addNodes(singlyLL2);
        System.out.println("Elements of singlyLL2 == ");
        displayNodes(singlyLL2);

        singlyLL.merge(singlyLL2); //merge

        System.out.println("Elements of singlyLL1 == ");
        displayNodes(singlyLL);

        System.out.println("Elements of singlyLL2 == ");
        displayNodes(singlyLL2);

    }

    private static void basicDemo(SinglyLL singlyLL) {
        addNodes(singlyLL);
        displayNodes(singlyLL);

        System.out.println("--------------------------------------------------------");
        System.out.println("Deleting nth node from end - 6");
        singlyLL.deleteNthNode(6);
        displayNodes(singlyLL);
        System.out.println("--------------------------------------------------------");


        System.out.println("--------------------------------------------------------");
        System.out.println("Deleting nth node from end - 3");
        singlyLL.deleteNthNode(3);
        displayNodes(singlyLL);
        System.out.println("--------------------------------------------------------");

        deleteNodes(singlyLL);
        displayNodes(singlyLL);


        System.out.println("Deleting Nodes at Beginning");
        singlyLL.deleteNodeInBeginning();
        singlyLL.display();

        System.out.println("Deleting Nodes at End");
        singlyLL.deleteNodeAtEnd();
        singlyLL.display();

        System.out.println("--------------------------------------------------------");
        System.out.println("Deleting nth node from end - 1 and 2");
        singlyLL.deleteNthNode(2);
        singlyLL.deleteNthNode(1);
        displayNodes(singlyLL);
        System.out.println("--------------------------------------------------------");

        singlyLL.empty();
        displayNodes(singlyLL); //Should Print Null !!

        addNodes(singlyLL);
        displayNodes(singlyLL);

    }

    private static void reverseNodes(SinglyLL singlyLL) {
        singlyLL.reverse();
    }

    private static void displayNodes(SinglyLL singlyLL) {
        singlyLL.display();
    }

    private static void deleteNodes(SinglyLL singlyLL) {
        System.out.println("Deleting Nodes at End and Beginning");
        singlyLL.deleteNodeAtEnd();
        singlyLL.deleteNodeInBeginning();
    }

    private static void addNodes(SinglyLL singlyLL) {
        singlyLL.addNodeInBeginning(80);
        singlyLL.addNodeAtEnd(90);
        singlyLL.addNodeInBeginning(60);
        singlyLL.addNodeAtPosition(0,100);
        singlyLL.addNodeInBeginning(50);
        singlyLL.addNodeAtEnd(40);
        singlyLL.addNodeInBeginning(30);
        singlyLL.addNodeAtEnd(20);
        singlyLL.addNodeAtPosition(9, 120);
    }
}
