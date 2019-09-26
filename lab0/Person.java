public class Person{

  private String name;
  private int age;
  // Static för att inte skapa flera instanser av names[] vid skapandet av varje nytt Person-objekt.
  private static String[] names = {"John", "Jack", "Sylvia", "Mahamoud", "Catch", "Lars", "Si", "Sa", "Su", "Da"};

  public Person() {
    this(names[(int) (Math.random() * names.length)], (int) (Math.random() * 85 + 15));
  }

  public Person(String nameIn, int ageIn) {
    name = nameIn; age = ageIn;
  }

  public String toString() {
    return "Name: " + name + ", age: " + age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

}
