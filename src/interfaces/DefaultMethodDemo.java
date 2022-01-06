package interfaces;


public class DefaultMethodDemo {
    public static void main(String[] args) {
        Person pawan = new Pawan();
        pawan.name();
    }

}
interface Person {
    default void name () {
        System.out.println(" default name ()");
    }
}
class Pawan implements Person{
    public  void name() {
        Person.super.name();
        System.out.println(" child name ()");
    }
}
