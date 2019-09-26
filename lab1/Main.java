// Extrauppgift
// Kör javac Main.java && java Main 3 Stop Go Mamma Mia John Jack

import framebuttons.*;

public class Main {
  public static void main(String[] args) {

    // CMD-line input has following form: "2 on off john jack"
    // So, multiply numButtons (2) by 2 to get 4 (num strings)

    int numButtons = Integer.parseInt(args[0]);
    String[] data = new String[numButtons*2];
    for (int i=1; i<(args.length); i++) {
      data[i-1] = args[i];
    }

    Window f = new Window(numButtons, data);

  }
}
