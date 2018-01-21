// dpp - a better diff tool
// This program takes in an input file and scrambles it based on a 
// provided sequence transformations. Possible transformations include
// add, delete, and transpose. 

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/*
 * Format:
 * textArray [ singleList ]    singleList [ token ]
 *           [ singleList ]               [ token ]
 *           [ .......... ]               [ ..... ]
 *           [ singleList ]               [ token ]
 *
 * So we want to modify textArray contents to add stuff
 * textArray.get(index) and iterate through until you reach desired location
 * add(textArray location, placement location or word?)
 *    iterate through until you reach desired index or word
 *    add at that location -> command?
 *
 */

class dpp{
  public static List<List<String>> textArr = new ArrayList<List<String>>();

  // void add(token, lineNum, tokenInd)
  // Inserts token at (line number, token index)
  static void add(String token, int lineNum, int tokenInd){
    textArr.get(lineNum).add(tokenInd, token);
  }

  static void delete(int lineNum, int tokenInd) {
    textArr.get(lineNum).remove(tokenInd);
  }

  //swap method
  static void transpose(){

  }

  public static void main(String[] args) throws IOException {
    if(args.length != 1){
      System.err.println("Usage: dpp text1 text2");
      System.exit(1);
    }

    Scanner in = new Scanner(new File(args[0]));
    PrintWriter out = new PrintWriter(new FileWriter("out"));

    //List<List<String>> textArr = new ArrayList<List<String>>();
        
    // Scan text file and insert into dynamic array list
    for(String line = in.nextLine(); in.hasNextLine(); line = in.nextLine()){
      ArrayList<String> tokenList = new ArrayList<String>();
      String[] tokens = line.split(" ");
      for(int i =0; i < tokens.length; i++){
        tokenList.add(tokens[i]);
      }
      tokenList.add(2, "SpenserSucks");
      textArr.add(tokenList);
    }

    //Ok so we need to create an array of random transformation sequences
    //Add-Delete
    //key - token - line # - word index 
    ArrayList<String> seq = new ArrayList<String>();
    seq.add("a"); seq.add("frog"); seq.add("2"); seq.add("3");
    seq.add("d"); seq.add("0"); seq.add("2"); 

    //Code to execute transformation sequence
    for(int i = 0; i < seq.size(); i++){
      if(seq.get(i).equals("a")){
        System.out.println("Add");
        //add(word, lineNum, tokenInd)
        int lineNum = Integer.parseInt(seq.get(i+2));
        int tokenInd = Integer.parseInt(seq.get(i+3));
        add(seq.get(i+1), lineNum, tokenInd);
        i+=3;
      } else if (seq.get(i).equals("d")) {
        System.out.println("Delete");
        //delete(word, lineNum)
        int lineNum = Integer.parseInt(seq.get(i+1));
        int tokenInd = Integer.parseInt(seq.get(i+2));
        delete(lineNum, tokenInd);
        i+=2;
      }
    }

    // Print array list values for debugging
    for(int i = 0; i < textArr.size(); i++){
      for(int j = 0; j < textArr.get(i).size(); j++){
        out.print(textArr.get(i).get(j)+" ");
      }
      out.println("");
    }   

    // Close files
    in.close();
    out.close();
  }
}
