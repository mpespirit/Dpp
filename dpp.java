// dpp - a better diff tool
// This program takes in an input file and scrambles it based on a 
// provided sequence transformations. Possible transformations include
// add, delete, and transpose. 

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
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

    ArrayList<String> text = new ArrayList<String>();
        
    // Scan 1st text file and insert into an array
    while(in.hasNextLine()){
      text.add(in.nextLine());
    }

    for(int i = 0; i < text.size(); i++){
      out.println(text.get(i));
    }   

    // Close files
    in.close();
    out.close();
  }
}
