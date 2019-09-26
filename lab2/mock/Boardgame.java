public interface Boardgame {

  public boolean move(int i, int j); // true om draget gick bra, false annars.
  public String getStatus(int i, int j); // returnera innehåll på ruta (i, j)
  public String getMessage(); // OK eller felmeddelande avseende föregående drag

}
