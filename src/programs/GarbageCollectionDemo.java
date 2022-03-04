package programs;

public class GarbageCollectionDemo {
    public static void main(String[] args) {

        Value v1 = new Value();
        Value v2 = new Value();

        v1.i = v2;
        v2.i = v1;

        v1 = null;
        v2 = null;

        System.gc();

    }

    public void finalize() throws Throwable {
        System.out.println("Finalize method called");
    }
}
class Value {
    Value i;
}