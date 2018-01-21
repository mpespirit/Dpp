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
  static void add(ArrayList<String> tokenList, int lineNum, int tokenInd){
    for(int i = 0; i < tokenList.size(); i++)
      textArr.get(lineNum).add(tokenInd + i, tokenList.get(i));
  }

  static void delete(int lineNum, int startInd, int endInd) {
    if(startInd == endInd)
      textArr.get(lineNum).remove(startInd);
    else 
      textArr.get(lineNum).subList(startInd, endInd).clear();
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
      //tokenList.add(2, "SpenserSucks");
      textArr.add(tokenList);
    }

    //Ok so we need to create an array of random transformation sequences
    //Add-Delete
    //key - token - line # - word index 
    ArrayList<String> seq = new ArrayList<String>();
    seq.add("a"); seq.add("2"); seq.add("3"); seq.add("frog"); 
    seq.add("turkey"); seq.add("firetruck");
    seq.add("d"); seq.add("0"); seq.add("0"); seq.add("2");

    //Code to execute transformation sequences
    for(int i = 0; i < seq.size(); i++){
      if(seq.get(i).equals("a")){
        int lineNum  = Integer.parseInt(seq.get(i+1));
        int tokenInd = Integer.parseInt(seq.get(i+2));
        int count = i+3; 

        ArrayList<String> tokenList = new ArrayList<String>();
        while(!seq.get(count).equals("d") && !seq.get(count).equals("t")){
          tokenList.add(seq.get(count));
          count++;
        }
        add(tokenList, lineNum, tokenInd);
        i += (count-1);
      } else if (seq.get(i).equals("d")) {
        int lineNum  = Integer.parseInt(seq.get(i+1));
        int startInd = Integer.parseInt(seq.get(i+2));
        int endInd   = Integer.parseInt(seq.get(i+3));
        delete(lineNum, startInd, endInd);
        i += 3;
      } else if (seq.get(i).equals("t")) {
        //transpose code
      }
    }

    printArr(out);   

    // Close files
    in.close();
    out.close();
  }

  // Print array list values for debugging
  static void printArr(PrintWriter out){
    for(int i = 0; i < textArr.size(); i++){
      for(int j = 0; j < textArr.get(i).size(); j++){
        out.print(textArr.get(i).get(j)+" ");
      }
      out.println("");
    }
  }
}
