import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

import javax.sound.sampled.*;

class RPSSkel extends JFrame implements ActionListener {
    JFrame f = new JFrame();

    Gameboard myboard, computersboard;
    int counter = 0; // To count ONE ... TWO  and on THREE you play
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    JButton closebutton;

    String playerChoice; // Player chooses STEN, SAX or PASE
    String computerChoice; // Same as above but for computer

    boolean connected = false;

    void setState(String state, String computersResult, boolean setChoices) {
      myboard.setLower(state);
      computersboard.setLower(computersResult);
      if (setChoices) {
        myboard.setUpper(playerChoice);
        computersboard.setUpper(computerChoice);
      }
    }

    void whoWon() {
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
    }

    public void actionPerformed(ActionEvent e) {

      if (counter == 0) {
        setState("ETT...", "ETT...", false);
        myboard.resetColor();
        myboard.setUpper("RPS"); // Reset result
        computersboard.resetColor();
        computersboard.setUpper("RPS");
      }
      else if (counter == 1) {
        setState("TVA...", "TVA...", false);
      }
      else if (counter == 2) {
        // Compare and declare winner.
        playerChoice = e.getActionCommand(); // Fetch string representative of the pushed button (STEN, SAX or PASE)
        playGame(); // Send playerChoice to server and retrieve computerChoice from server
        myboard.markPlayed(playerChoice); // parameter e references the button being pushed
        computersboard.markPlayed(computerChoice);

        // Detect win/loss. Change state & computersResult.
        whoWon();

        counter = 0;
        return;
      }
      else {
        System.exit(0); // Something went wrong, if somehow counter>2.
      }
      counter++;
    }

    void createCloseBtn() {
      closebutton = new JButton("Close");
      // Listener on closebutton as anonymous inner class.
      // See https://www.geeksforgeeks.org/anonymous-inner-class-java/
      ActionListener closeBtnListener = (new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.exit(0);
        }
      });
      closebutton.addActionListener(closeBtnListener);
    }

    void boardSetup() {
      JPanel boards = new JPanel();
    	boards.setLayout(new GridLayout(1,2));
    	boards.add(myboard);
    	boards.add(computersboard);
    	f.add(boards, BorderLayout.CENTER);
    	f.add(closebutton, BorderLayout.SOUTH);
    	f.setSize(500, 750);
    	f.setVisible(true);
    }

    RPSSkel () {

      f.setDefaultCloseOperation(EXIT_ON_CLOSE);

      createCloseBtn();

      // Setting up the board
      myboard = new Gameboard("You", this); /* Has been changed.
      Second parameter requires passing an instance of this object.
      See step 2: https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html */
      computersboard = new Gameboard("Computer");

      // Setting up the rest of the board. Basic.
    	boardSetup();

      // Connect to server and introduce player
      // Two different options for connection to server:
      JButton localhost = new JButton("localhost:4713");
      ActionListener chooseLocal = (new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (!connected) {
            connectToServer("localhost", "Player 1");
          }
        }
      });
      localhost.addActionListener(chooseLocal);

      JButton kthost = new JButton("u3.csc.kth.se:4713");
      ActionListener chooseKTH = (new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (!connected) {
            connectToServer("KTH", "Player 1");
          }
        }
      });
      kthost.addActionListener(chooseKTH);

      // Adding connection buttons to frame.
      JPanel c = new JPanel();
      c.setLayout(new GridLayout(1, 2));
      c.add(localhost);
      c.add(kthost);
      f.add(c, BorderLayout.NORTH);

    }

    void connectToServer(String hostname, String playerName) {

      try {
        if (hostname.equals("localhost")) {
          socket = new Socket("localhost", 4713);
        }
        else if (hostname.equals("KTH")) {
          socket = new Socket("u3.csc.kth.se", 4713);
        }
        else {
          System.out.println("FATAL ERROR, EXITING"); // Just in case.
          System.exit(0);
        }

        in = new BufferedReader
          (new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());

        // Introduction
        out.println(playerName); out.flush(); // Connecting with playerName
        System.out.println(in.readLine());
        connected=true; // Connected true if we reach this stage.
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Something went wrong, try again");
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
