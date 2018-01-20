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

        // Count number of lines and store each line in String[]
        in = new Scanner(new File(args[0]));
        String line = in.nextLine();
        int count = 0;
        while (line != null) {
            count++;
            line.nextLine();
        }
        in.close();

        ArrayList text1 = new ArrayList();
        ArrayList text2 = new ArrayList();
        for (int i = 0; i < count; i++) {
        
        }

        // Close files
        in1.close();
        in2.close();
        out.close();
    }
}
