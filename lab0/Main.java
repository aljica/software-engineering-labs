import java.util.*;

public class Main {

  public static void main(String[] args) {

    // Del 2
    System.out.println("Del 2");
    Person kabool = new Person("kabool", 6);
    System.out.println(kabool.getName());
    System.out.println(kabool.getAge());
    System.out.println(kabool); // Then automatically calls the toString()-method.
    System.out.println("Del 2 END");

    // Del 3
    System.out.println("\nDel 3");
    Person[] listOfRandomPeople = new Person[15];
    for (Person p : listOfRandomPeople) {
      p = new Person();
      System.out.println(p);
    }
    System.out.println("Del 3 END");

    // Del 4
    System.out.println("\nDel 4");
    Student[] randomStudents = new Student[15];
    for (Student s : randomStudents) {
      s = new Student();
      System.out.println(s);
    }
    System.out.println("Del 4.5 END");

    System.out.println("\nDel 4.6");
    Person[] randomPeople = new Person[10];
    for (int i=0; i<randomPeople.length; i++) {
      if (i%2==0) randomPeople[i] = new Person();
      else randomPeople[i] = new Student();
      System.out.println(randomPeople[i]);
    }
  }
}
