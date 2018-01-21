import java.util.*;
import java.io.*;

class Dpp1{

   public static HashMap<Integer, String> linesHash1;
   public static HashMap<Integer, String> linesHash2; 
   public static void main (String[] args) throws IOException{
      Scanner in1 = null;
      Scanner in2 = null;
      if(args.length !=2){
         System.out.println("Requires two input files");
         System.exit(1);
      }
      in1 = new Scanner( new File(args[0]) );
      in2 = new Scanner( new File(args[1]) );
      //Scanner in2 = new Scanner(args[1]);

      // Read in contents of file and insert them into array list of
      // space-divided strings 
      ArrayList<String[]> a_in1 = new ArrayList<String[]>();
      ArrayList<String[]> a_in2 = new ArrayList<String[]>();
      while(in1.hasNextLine()){
         String s = in1.nextLine();
         a_in1.add( s.split(" ") );
         //System.out.println(s);
      }
      while(in2.hasNextLine()){
         String s = in2.nextLine();
         a_in2.add( s.split(" ") );
      }
      //=======MAY HAVE TO CHANGE CAPACITY AND LOAD FACTOR 
      //=======RE: PIGEONHOLE PRINCIPLE?
      int max = a_in1.size();
      if (a_in2.size() > max ) max=a_in2.size();
      linesHash1 = new HashMap<Integer, String>( max, 1 );
      linesHash2 = new HashMap<Integer, String>( max, 1 );
      for (int i=0; i<a_in1.size(); i++){
         minHash( a_in1.get(i), linesHash1 );
      }
      for (int i=0; i<a_in2.size(); i++){
         minHash( a_in2.get(i), linesHash2 );
      }
      for (Map.Entry<Integer, String> entry : linesHash1.entrySet()) {
          System.out.println(entry.getKey()+" : "+entry.getValue());
      }
      System.out.print("\n\n\n\n\n"); 
      for (Map.Entry<Integer, String> entry : linesHash2.entrySet()) {
          System.out.println(entry.getKey()+" : "+entry.getValue());
      }
   }
   
   public static void minHash( String[] S, HashMap hm ){
      int min = Integer.MAX_VALUE;
      if (S.length < 10 ) hm.put( linkString(S).hashCode(),
                                         linkString(S) ); 
      else{
         String s = "";
         int spread=20;
         for (int i=0; i+spread<S.length; i++) {
            //int c = string.charAt(i);
            //int n = hash.hashInt(c).asInt();
            String r = linkString(S, i, i+spread);
            int h = s.hashCode();
            if (h < min) {
               min = h;
               s = r;
            }
         }
         hm.put( min, linkString(S) );
      }
   }
   
   // Join parts or whole of String array together into single string
   // Used for comparison of chunks of lines
   public static String linkString(String[] S, Integer... i){
      // By default joins entire string array
      Integer i1 = i.length > 0 ? i[0] : 0;
      Integer i2 = i.length > 1 ? i[1] : S.length;
      if (i2>S.length) i2=S.length;
      String s = "";
      for (; i1 < i2; i1++){
         s += " ";
         s += S[i1];
      } 
      return s;
   }

}
