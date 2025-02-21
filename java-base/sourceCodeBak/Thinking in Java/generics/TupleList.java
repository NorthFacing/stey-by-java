//: generics/TupleList.java
// Combining generic types to make complex generic types.

import com.books.book03.net.mindview.util.*;

import java.util.ArrayList;

public class TupleList<A, B, C, D>
    extends ArrayList<FourTuple<A, B, C, D>> {
  public static void main(String[] args) {
    TupleList<Vehicle, Amphibian, String, Integer> tl =
        new TupleList<Vehicle, Amphibian, String, Integer>();
    tl.add(TupleTest.h());
    tl.add(TupleTest.h());
    for (FourTuple<Vehicle, Amphibian, String, Integer> i : tl)
      System.out.println(i);
  }
} /* Output: (75% match)
(Vehicle@11b86e7, Amphibian@35ce36, hi, 47)
(Vehicle@757aef, Amphibian@d9f9c3, hi, 47)
*///:~
