public class Student extends Person {

  private int year;

  public Student(String nameIn, int ageIn, int yearIn) {
    super(nameIn, ageIn); // Calls superclass's two-parameter constructor.
    year = yearIn;
  }

  public Student() {
    super(); // Calls superclass's parameter-less constructor.
    year = (int) (Math.random() * 85 + 1934); // 1934 - 2019
  }

  public String toString() {
    return super.toString() + ", började på CINEK " + year;
  }

  public int getYear() {
    return year;
  }

}
