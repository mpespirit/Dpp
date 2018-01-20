//dpp

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

class dpp{    
    public static void main(String[] args) throws IOException{
        if(args.length != 2){
            System.err.println("Usage: dpp text1 text2");
            System.exit(1);
        }

        Scanner in1 = new Scanner(new File(args[0]));
        Scanner in2 = new Scanner(new File(args[1]));
        PrintWriter out = new PrintWriter(new FileWriter("transformations.txt"));

        ArrayList text1 = new ArrayList();
        ArrayList text2 = new ArrayList();
        
        // Scan 2nd text file first and insert into an array
        for (String line = in2.nextLine(); line != null; line = in2.nextLine()) {
        	text2.add(line);
        }
        
        // Scan 1st text file and insert into an array
        for (String line = in1.nextLine(); line != null; line = in1.nextLine()) {
        	text1.add(line);
        }

        // Close files
        in1.close();
        in2.close();
        out.close();
    }
}
