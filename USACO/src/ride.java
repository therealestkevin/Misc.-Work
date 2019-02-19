import java.io.*;
/*
ID: kevinxu4
LANG: JAVA
TASK: ride
*/
public class ride {
    public static void main (String[]args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        char[] cometName = f.readLine().toCharArray();
        char[] groupName = f.readLine().toCharArray();
        int productComet=1;
        int productGroup=1;
        for(char c : cometName){
            productComet*=(((int)(c))-64);
        }
        for(char c : groupName){
           productGroup*=(((int)(c))-64);
        }
        PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("ride.out")));
        if(productComet%47==productGroup%47){
            out.println("GO");
        }else{
            out.println("STAY");
        }
        out.close();
        f.close();
    }
}
