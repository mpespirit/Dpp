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
  static void transpose(int lineNum1, int tokenInd1, int length1, int lineNum2,
                        int tokenInd2, int length2){
    ArrayList<String> tmp1 = new ArrayList<String>();
    ArrayList<String> tmp2 = new ArrayList<String>();

    //System.out.println("(" + lineNum1 + ", " + tokenInd1 + ", " + length1 + ")"); 
    //System.out.println("(" + lineNum2 + ", " + tokenInd2 + ", " + length2 + ")"); 
 
    // Insert the sequence of words into temp arrays
    for (int i = 0; i < length1; i++) {
      tmp1.add(textArr.get(lineNum1).get(tokenInd1 + i));
    }
    for (int i = 0; i < length2; i++) {
      tmp2.add(textArr.get(lineNum2).get(tokenInd2 + i));
    }
    
    // Swap both word sequences by first removing and then adding
    textArr.get(lineNum1).subList(tokenInd1, tokenInd1 + length1).clear();
    textArr.get(lineNum1).addAll(tokenInd1, tmp2);
    textArr.get(lineNum2).subList(tokenInd2, tokenInd2 + length2).clear();
    textArr.get(lineNum2).addAll(tokenInd2, tmp1);
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
      textArr.add(tokenList);
    }

    //Ok so we need to create an array of random transformation sequences
    //Add-Delete
    //key - token - line # - word index 
    ArrayList<String> seq = new ArrayList<String>();
    //seq.add("a"); seq.add("frog"); seq.add("2"); seq.add("3");
    //seq.add("d"); seq.add("0"); seq.add("2"); 

    // Test transpose
    // key - line #1 - word index #1 - length of seq #1
    //     - line #2 - word index #2 - length of seq #2
    seq.add("t"); seq.add("0"); seq.add("0"); seq.add("4");
                  seq.add("2"); seq.add("2"); seq.add("1");
    seq.add("t"); seq.add("0"); seq.add("0"); seq.add("1");
                  seq.add("1"); seq.add("5"); seq.add("9");

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
      } else if (seq.get(i).equals("t")) {
        int lineNum1 = Integer.parseInt(seq.get(i+1));
        int tokenInd1 = Integer.parseInt(seq.get(i+2));
        int length1 = Integer.parseInt(seq.get(i+3));
        int lineNum2 = Integer.parseInt(seq.get(i+4));
        int tokenInd2 = Integer.parseInt(seq.get(i+5));
        int length2 = Integer.parseInt(seq.get(i+6));
        transpose(lineNum1, tokenInd1, length1, lineNum2, tokenInd2, length2);
        i+=6;
      } else {
        System.out.println("Invalid transformation key: " + seq.get(i));
      }
    }

    // Print array list values for debugging
    //System.out.println("Size = " + textArr.size());
    for(int i = 0; i < textArr.size(); i++){
      //System.out.println("Size[" + i + "] = " + textArr.get(i).size());
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
