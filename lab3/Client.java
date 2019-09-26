import java.net.*;
import java.io.*;
import java.util.*;

public class Client {

  public static void main(String[] u) {
    try {
      Socket socket=new Socket("localhost",4713);
      BufferedReader in=new BufferedReader
          (new InputStreamReader(socket.getInputStream()));
      PrintWriter ut=new PrintWriter(socket.getOutputStream());
      ut.println("Charlotta"); ut.flush();
      System.out.println(in.readLine());

      // Maintaining connection and continuously prompting user for input. Or blank input, closes connection
      // (althought that part of the code is NOT included here, the SERVER terminates the connection).
      Scanner sc = new Scanner(System.in);
      while (true) {
        String userInput = sc.nextLine();
        System.out.println("Please enter STEN/SAX/PASE: ");
        ut.println(userInput); ut.flush();
        System.out.println(in.readLine());
      }

    } catch (IOException e) {
      System.out.println(e);
    }
  }

}
