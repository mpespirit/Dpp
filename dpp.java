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

class dpp{   
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
      textArr.add(tokenList);
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
