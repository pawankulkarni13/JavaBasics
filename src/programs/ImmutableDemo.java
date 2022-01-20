package programs;

public class ImmutableDemo {

    public static void main(String args[])
    {
        Age age = new Age();
        age.setDay(1);
        age.setMonth(1);
        age.setYear(1990);
        Student student = new Student(1, "Pawan", age);
        System.out.println("Pawan age year before modification = " + student.getAge().getYear());
        age.setYear(1993);
        System.out.println("Pawan age year after modification = " + student.getAge().getYear());
        student.getAge().setYear(2020);
        System.out.println("Pawan age year after modification again= " + student.getAge().getYear());

    }
}

final class Student
{
    final int id;
    final String name;
    final Age age;

    public Student(int id,String name,Age age)
    {
        this.name = name;
        this.id = id;
        Age cloneAge = new Age();
        cloneAge.setDay(age.getDay());
        cloneAge.setMonth(age.getMonth());
        cloneAge.setYear(age.getYear());
        this.age = cloneAge;
    }
    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }
    public Age getAge(){
        Age cloneAge = new Age();
        cloneAge.setDay(this.age.getDay());
        cloneAge.setMonth(this.age.getMonth());
        cloneAge.setYear(this.age.getYear());
        return cloneAge;
    }
}

class Age {
    private int day;
    private int month;
    private int year;
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}