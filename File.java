
//imoprting the filewriter classes
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.BufferedReader;
import java.io.FileReader;
/*import java.io.IOException;

import java.io.*;
import java.util.*;*/

//will not be an object, static methods to write files from anywhere
class File {

  // the writing method
  public static void write(String message, String pathway) {

    // creating the variable of where to write and what to write
    String s = pathway;
    String m = message;

    // making it in a try catch for any errors
    try {
      // Connect to the file; create it if necessary
      FileWriter fw = new FileWriter(s);
      // Attach a buffer to the file
      BufferedWriter bw = new BufferedWriter(fw);

      // write the message and close the writer
      bw.write(m);
      bw.close();
    } catch (Exception e) {
      // if there's an error, print this message
      System.out.println("Error in writing.");
    }
  }

  public static String read(String pathway) {
    // creating where to read, a returning string, and the reading string
    String st = pathway;
    String thing = "";
    String s;

    try {
      // Connect to the file; create it if necessary
      FileReader fr = new FileReader(st);
      // Attach a buffer to the file
      BufferedReader br = new BufferedReader(fr);
      while ((s = br.readLine()) != null) {
        // expand returning string
        thing += s + "\n";

      }
      br.close();
    } catch (Exception e) {
      // if there's an error, print this message
      System.out.println("Error in reading.");
    }

    // return the string
    return thing;
  }

}