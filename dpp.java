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
  //    
  void add(){
    
  }

  void delete() {

  }

  //swap method
  void transpose(){

  }

  public static void main(String[] args) throws IOException {
    if(args.length != 1){
      System.err.println("Usage: dpp text1 text2");
      System.exit(1);
    }

    Scanner in = new Scanner(new File(args[0]));
    PrintWriter out = new PrintWriter(new FileWriter("out"));

    List<List<String>> textArr = new ArrayList<List<String>>();
        
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
    //List<List<String>> seqList = new ArrayList<List<String>>();
    ArrayList<String> seq = new ArrayList<String>();
    //seq.add("0"); seq.add("a"); seq.add("frog"); seq.add("d"); seq.add("2");
    //seq.add("d"); seq.add("frog"); seq.add("t"); seq.add("3");
    //seqList.add(seq);
    seq.add("a"); seq.add("frog"); seq.add("2"); seq.add("3");
    seq.add("d"); seq.add("Lorem"); seq.add("0"); 

    //Code to execute transformation sequence
    //add(word, lineIndex, tokenIndex)
    for(int i = 0; i < seq.size(); i++){
      if(seq.get(i).equals("a")){
        System.out.println("Add");
      } else if (seq.get(i).equals("d")) {
        System.out.println("Delete");
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
