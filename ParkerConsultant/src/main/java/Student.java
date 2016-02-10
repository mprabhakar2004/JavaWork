/**
 * Created by manish_kumar9 on 10/02/16.
 */

/*
Write a program that reads details about students in a class from a file. The values provided for each student will be their name, age and
height in cms. The challenge is to print a list of students that fit certain criteria.
The format will be given as parameter:operation:<value><|value>


possible parameter values: name, age, height

possible operation values: lessThan, between, average, max, sortAsc,sortDesc

possible value: positive number (optional)

 */
public class Student {
    private String name;
    private int age;

    public Student(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private int height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
