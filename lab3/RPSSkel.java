import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

import javax.sound.sampled.*;

class RPSSkel extends JFrame implements ActionListener {
    Gameboard myboard, computersboard;
    int counter = 0; // To count ONE ... TWO  and on THREE you play
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    JButton closebutton;

    String playerChoice; // Player chooses STEN, SAX or PASE
    String computerChoice; // Same as above but for computer

    JToggleButton sound; // private? REMOVEEEE
    boolean soundOn; // private? REMOVEEEEE

    //Clip clip; REMOVE!!!!!!!!!!

    void setState(String state, String computersResult, boolean setChoices) {
      myboard.setLower(state);
      computersboard.setLower(computersResult);
      if (setChoices) {
        myboard.setUpper(playerChoice);
        computersboard.setUpper(computerChoice);
      }
    }

    public void actionPerformed(ActionEvent e) {

      if (counter == 0) {
        setState("ETT...", "ETT...", false);
        myboard.resetColor();
        myboard.setUpper("RPS"); // Reset result
        computersboard.resetColor();
        computersboard.setUpper("RPS");
      } else if (counter == 1) {
        setState("TVA...", "TVA...", false);
      } else if (counter == 2) {

        // Compare and declare winner.
        playerChoice = e.getActionCommand(); // Fetch string representative of the pushed button (STEN, SAX or PASE)
        playGame(); // Send playerChoice to server and retrieve computerChoice from server
        myboard.markPlayed(playerChoice); // parameter e references the button being pushed
        computersboard.markPlayed(computerChoice);

        // Detect win/loss. Change state & computersResult.
        if (playerChoice.equals(computerChoice)) {
          setState("DRAW", "DRAW", true);
        } else if (playerChoice.equals("STEN") && computerChoice.equals("SAX") ||
          playerChoice.equals("PASE") && computerChoice.equals("STEN") ||
          playerChoice.equals("SAX") && computerChoice.equals("PASE")){
            setState("WINS", "LOSES", true);
            myboard.wins();
        } else {
          setState("LOSES", "WINS", true);
          computersboard.wins();
        }

        counter = 0;
        return;
      } else {
        System.exit(0); // Something went wrong, if somehow counter>2.
      }
      counter++;
    }

    RPSSkel () {

      setDefaultCloseOperation(EXIT_ON_CLOSE);

      closebutton = new JButton("Close");
      // Listener on closebutton as anonymous inner class.
      // See https://www.geeksforgeeks.org/anonymous-inner-class-java/
      ActionListener closeBtnListener = (new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.exit(0);
        }
      });
      closebutton.addActionListener(closeBtnListener);

      // Setting up the board
      myboard = new Gameboard("You", this); /* Has been changed.
      Second parameter requires passing an instance of this object.
      See step 2: https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html */
      computersboard = new Gameboard("Computer");

      // Setting up the rest of the board. Basic.
    	JPanel boards = new JPanel();
    	boards.setLayout(new GridLayout(1,2));
    	boards.add(myboard);
    	boards.add(computersboard);
    	add(boards, BorderLayout.CENTER);
    	add(closebutton, BorderLayout.SOUTH);
    	setSize(500, 750);
    	setVisible(true);

      // Connect to server and introduce player
      try {
        socket = new Socket("localhost", 4713);
        in = new BufferedReader
          (new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());

        // Introduction
        out.println("Player 1"); out.flush();
        System.out.println(in.readLine());

      } catch (IOException e) {
        System.out.println(e);
      }
    }

    void playGame() {
        try {
        out.println(playerChoice); out.flush();
        computerChoice = in.readLine();
      } catch (IOException e) {
        System.out.println(e);
      }
    }

    public static void main (String[] u) {
    	new RPSSkel();
    }
}
