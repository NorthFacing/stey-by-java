package com.books.book03.operators;
//: operators/Assignment.java
// Assignment with objects is a bit tricky.

import static com.books.book03.net.mindview.util.Print.print;

class Tank {
  int level;
}

public class Assignment {
  public static void main(String[] args) {
    Tank t1 = new Tank();
    Tank t2 = new Tank();
    t1.level = 9;
    t2.level = 47;
    print("1: t1.level: " + t1.level +
        ", t2.level: " + t2.level);
    t1 = t2;
    print("2: t1.level: " + t1.level +
        ", t2.level: " + t2.level);
    t1.level = 27;
    print("3: t1.level: " + t1.level +
        ", t2.level: " + t2.level);
  }
} /* Output:
1: t1.level: 9, t2.level: 47
2: t1.level: 47, t2.level: 47
3: t1.level: 27, t2.level: 27
*///:~
