package streams;

public class Employee {
    Integer grade;
    String name;
    Integer age;

    public Employee(int grade, String name, int age) {
        this.grade = grade;
        this.name = name;
        this.age = age;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "grade=" + grade +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
