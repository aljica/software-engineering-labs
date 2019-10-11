public interface Boardgame {

  public void select(int i, int j);
  public void drop(int i, int j);
  public Piece getStatus(int i, int j);
  public String getMessage();

}
