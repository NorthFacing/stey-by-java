//: enumerated/Burrito.java
package enumerated;

import static enumerated.Spiciness.HOT;
import static enumerated.Spiciness.MEDIUM;
import static enumerated.Spiciness.NOT;

public class Burrito {
  Spiciness degree;

  public Burrito(Spiciness degree) {
    this.degree = degree;
  }

  public static void main(String[] args) {
    System.out.println(new Burrito(NOT));
    System.out.println(new Burrito(MEDIUM));
    System.out.println(new Burrito(HOT));
  }

  public String toString() {
    return "Burrito is " + degree;
  }
} /* Output:
Burrito is NOT
Burrito is MEDIUM
Burrito is HOT
*///:~
