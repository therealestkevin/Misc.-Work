import java.io.*;
import java.util.StringTokenizer;


public class paintbarn2 {
    public static void main(String args[]) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("paintbarn.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("paintbarn.out")));
        int[][] coOrdPlot = new int[1001][1001];

        int nums = Integer.parseInt(st.nextToken());

        int coats = Integer.parseInt(st.nextToken());
        int count = 0;
        for(int i = 0; i < nums; i++){
            StringTokenizer st2 =  new StringTokenizer(f.readLine());
            int xOne = Integer.parseInt(st2.nextToken());
            int yOne = Integer.parseInt(st2.nextToken());
            int xTwo = Integer.parseInt(st2.nextToken());



            int yTwo= Integer.parseInt(st2.nextToken());
            for(int b = xOne; b < xTwo; b++){
                for(int c = yOne; c < yTwo; c++){
                    coOrdPlot[b][c] ++;
                    if(coOrdPlot[b][c] == coats){
                        count ++;
                    }else if(coOrdPlot[b][c] == coats+1){
                        count--;
                    }
                }
            }
        }

        out.println(count);
        out.close();
        f.close();
    }
}


