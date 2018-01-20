//Dpp

import java.io.*;
import java.util.Scanner;

class Dpp{    
    public static void main(String[] args) throws IOException{
        Scanner in = null;
        PrintWriter out = null;
        //String line = "";
        
        if(args.length != 2){
            System.err.println("Usage: FileIO infile outfile");
            System.exit(1);
        }

        in = new Scanner(new File(args[0]));
        out = new PrintWriter(new FileWriter(args[1]));

        // Count number of lines and store each line in String[]
        in = new Scanner(new File(args[0]));
        
        // Close files
        in.close();
        out.close();
    }
}