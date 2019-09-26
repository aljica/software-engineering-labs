import java.util.Random;

class FifteenModel implements Boardgame {

  private String currentMessage = "No message yet";
  private String[][] board = new String[4][4];
  private int iemp, jemp; // Index of empty square (good to keep track of.)

  public FifteenModel() {

    // Private constructor: "singleton class". Making sure only ONE
    // object of this class can be created at any one time.
    // Read some more about this, because I have to use public now...

    // Constructor. Let's fill the board up upon object creation.
    int squareNum = 0;
    for (int i=0; i<4; i++) {
      for (int j=0; j<4; j++) {
        squareNum += 1;

        if (squareNum == 16) {
          break;
        }

        board[i][j] = Integer.toString(squareNum);
      }
    }

    iemp = 3;
    jemp = 3;

    // Create random starting square

    int iChange;
    int jChange;
    int whichToMove;
    Random rand = new Random();
    for (int i=0; i<20; i++) {
      iChange = rand.nextInt(2); // iChange is 0 or 1
      jChange = rand.nextInt(2);

      if (iChange == 0) {
        iChange = -1;
      } else {
        iChange = 1;
      }
      if (jChange == 0) {
        jChange=-1;
      } else {
        jChange=1;
      }


      whichToMove = rand.nextInt(2); // if 0, move up/down (i)
      // if 1, move left/right (j)
      if (whichToMove == 0) {
        if (iemp+iChange<0 || iemp+iChange>3) {
          move(iemp-iChange, jemp);
        } else {
          move(iemp+iChange, jemp);
        }
      } else {
        if (jemp+jChange<0 || jemp+jChange>3) {
          move(iemp, jemp-jChange);
        } else {
          move(iemp, jemp+jChange);
        }
      }

    }

    /*for (int i=0; i<20; i++) {
      if (i%2 == 0) {
        if (0<jemp) {
          move(iemp, jemp-1);
        } else {
          move(iemp, jemp+1);
        }
      }
        else {
          if (0<iemp) {
            move(iemp-1, jemp);
          } else {
            move(iemp+1, jemp);
          }
      }
    }*/

  }

  public boolean move(int i, int j) {
    if (i-1==iemp && j == jemp || i+1==iemp && j == jemp ||
      j-1 == jemp && i == iemp || j+1 == jemp && i == iemp) {
        board[iemp][jemp] = board[i][j];
        board[i][j] = null;
        iemp = i;
        jemp = j;
        currentMessage = "Move has been made!";
        return true;
      } else {
          currentMessage = "Error, please select a filled square next to the empty square";
          return false;
      }
  }

  public String getStatus(int i, int j) {
    return board[i][j];
  }

  public String getMessage() {
    return currentMessage;
  }

}
