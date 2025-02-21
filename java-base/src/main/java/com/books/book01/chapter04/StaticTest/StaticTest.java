package com.books.book01.chapter04.StaticTest;

/**
 * This program demonstrates static methods.
 *
 * @author Cay Horstmann
 * @version 1.01 2004-02-19
 * @chapter 4.4.1 静态域（类域：变量值在这个类的所有实例中共享）
 * @chapter 4.4.5 Main方法
 */
public class StaticTest {
  public static void main(String[] args) {
    // fill the staff array with three Employee objects
    Employee[] staff = new Employee[3];

    staff[0] = new Employee("Tom", 40000);
    staff[1] = new Employee("Dick", 60000);
    staff[2] = new Employee("Harry", 65000);

    // print out information about all Employee objects
    for (Employee e : staff) {
      e.setId();
      System.out.println("name=" + e.getName() + ",id=" + e.getId()
          + ",salary=" + e.getSalary());
    }

    int n = Employee.getNextId(); // calls static method
    System.out.println("Next available id=" + n);
  }
}

class Employee {
  private String name;
  private double salary;
  private int id;
  private static int nextId = 1;

  public Employee(String n, double s) {
    name = n;
    salary = s;
    id = 0;
  }

  public String getName() {
    return name;
  }

  public double getSalary() {
    return salary;
  }

  public int getId() {
    return id;
  }

  // HZ: 为了防止线程竞争，是不是应该加上synchronized关键字？
  public void setId() {
    id = nextId; // set id to next available id
    nextId++;
  }

  public static int getNextId() {
    return nextId; // returns static field
  }

  public static void main(String[] args) // unit test
  {
    Employee e = new Employee("Harry", 50000);
    System.out.println(e.getName() + " " + e.getSalary());
  }

}
