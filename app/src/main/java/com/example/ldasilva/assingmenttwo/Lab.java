package com.example.ldasilva.assingmenttwo;

/**
 * Created by ldasilva on 4/9/18.
 */

public class Lab {
    public static void main(String[] args) {
        // Create a student
        Student stu1 = new Student("Lucas", "9988776655");
        stu1.enroll("MATH103");
        stu1.enroll("ENG100");
        stu1.enroll("POR101");
        System.out.println(stu1.getUserId());
        System.out.println(stu1.toString());
        stu1.showCourses();
        stu1.checkBalance();
        stu1.payTuition(500);
    }
}

class Student {
    // Properties
    private static int iD = 1000;
    private String userId;
    private String name;
    private String ssn;
    private String email;
    private String courses = "";
    private int balance =0;
    private static final int costOfCourse = 800;
    private String phone;
    private String state;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String city;

    // Student constructor
    public Student(String name, String ssn) {
        iD++;
        this.name = name;
        this.ssn = ssn;
        setUserId();
        System.out.println("\n");
        setEmail();
    }

    //- Generate a user ID that is combination of Static ID, random 4-digit number between 1000 and 9000, and last 4 of SSN
    private void setUserId() {
        int min = 1000;
        int max = 9000;
        int randNumber = (int)(Math.random() * ((max - min)));
        randNumber = randNumber + min;
        userId = iD + "" + randNumber + ssn.substring(6);
        System.out.println(userId);
    }

    public String getUserId() {
        return userId;
    }

    private void setEmail() {
        email = name.toLowerCase() + "@udemy.com";
        System.out.println("Your email is: " + email);
    }

    public void enroll(String course) {
        this.courses = this.courses + "\n" + course;
        balance = balance + costOfCourse;
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    public void showCourses() {
        System.out.println(courses);
    }

    public void payTuition(int amount) {
        balance = balance - amount;
        System.out.println("You have paid $" + amount + " off your balance");
        checkBalance();
    }

    @Override
    public String toString() {
        return "[Your email is: " + email + "]" + "\n"+ "[Your userId is: " + userId + "]";
    }
}
