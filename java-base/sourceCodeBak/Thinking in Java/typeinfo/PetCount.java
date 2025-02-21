package com.books.book03.typeinfo;
//: typeinfo/PetCount.java
// Using instanceof.

import com.books.book03.typeinfo.pets.Cat;
import com.books.book03.typeinfo.pets.Dog;
import com.books.book03.typeinfo.pets.ForNameCreator;
import com.books.book03.typeinfo.pets.Hamster;
import com.books.book03.typeinfo.pets.Manx;
import com.books.book03.typeinfo.pets.Mouse;
import com.books.book03.typeinfo.pets.Mutt;
import com.books.book03.typeinfo.pets.Pet;
import com.books.book03.typeinfo.pets.PetCreator;
import com.books.book03.typeinfo.pets.Pug;
import com.books.book03.typeinfo.pets.Rat;
import com.books.book03.typeinfo.pets.Rodent;

import java.util.HashMap;

import static com.books.book03.net.mindview.util.Print.print;
import static com.books.book03.net.mindview.util.Print.printnb;

public class PetCount {
  public static void
  countPets(PetCreator creator) {
    PetCounter counter = new PetCounter();
    for (Pet pet : creator.createArray(20)) {
      // List each individual pet:
      printnb(pet.getClass().getSimpleName() + " ");
      if (pet instanceof Pet)
        counter.count("Pet");
      if (pet instanceof Dog)
        counter.count("Dog");
      if (pet instanceof Mutt)
        counter.count("Mutt");
      if (pet instanceof Pug)
        counter.count("Pug");
      if (pet instanceof Cat)
        counter.count("Cat");
      if (pet instanceof Manx)
        counter.count("EgyptianMau");
      if (pet instanceof Manx)
        counter.count("Manx");
      if (pet instanceof Manx)
        counter.count("Cymric");
      if (pet instanceof Rodent)
        counter.count("Rodent");
      if (pet instanceof Rat)
        counter.count("Rat");
      if (pet instanceof Mouse)
        counter.count("Mouse");
      if (pet instanceof Hamster)
        counter.count("Hamster");
    }
    // Show the counts:
    print();
    print(counter);
  }

  public static void main(String[] args) {
    countPets(new ForNameCreator());
  }

  static class PetCounter extends HashMap<String, Integer> {
    public void count(String type) {
      Integer quantity = get(type);
      if (quantity == null)
        put(type, 1);
      else
        put(type, quantity + 1);
    }
  }
} /* Output:
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Pug=3, Cat=9, Hamster=1, Cymric=7, Mouse=2, Mutt=3, Rodent=5, Pet=20, Manx=7, EgyptianMau=7, Dog=6, Rat=2}
*///:~
