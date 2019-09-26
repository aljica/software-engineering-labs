class NewGame implements Boardgame {

  private String currentMessage = "Just joking";
  private String[][] board = new String[8][8];

  public boolean move(int i, int j) {
    return true;
  }

  public String getStatus(int i, int j) {
    return "00";
  }

  public String getMessage() {
    return currentMessage;
  }

}
