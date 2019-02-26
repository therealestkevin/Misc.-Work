import java.io.*;
import java.util.StringTokenizer;

public class paintbarn {
    public static void main(String[]args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("paintbarn.in"));
        String nums = f.readLine();
        StringTokenizer st = new StringTokenizer(nums);
        int rects = Integer.parseInt(st.nextToken());
        int coats = Integer.parseInt(st.nextToken());
        int[][] coords = new int[rects][4];
        for (int i = 0; i < rects; i++) {
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            for (int b = 0; b < 4; b++) {
                coords[i][b] = Integer.parseInt(st2.nextToken());
            }
        }
        int maxX = -1;
        int minX = 1001;
        for (int c = 0; c < coords.length; c++) {
            if (coords[c][0] > maxX) {
                maxX = coords[c][0];
            }
            if (coords[c][2] > maxX) {
                maxX = coords[c][2];
            }
            if (coords[c][0] < minX) {
                minX = coords[c][0];
            }
            if (coords[c][2] < minX) {
                minX = coords[c][2];
            }
        }
        int maxY = -1;
        int minY = 1001;
        for (int c = 0; c < coords.length; c++) {
            if (coords[c][1] > maxY) {
                maxY = coords[c][1];
            }
            if (coords[c][3] > maxY) {
                maxY = coords[c][3];
            }
            if (coords[c][1] < minY) {
                minY = coords[c][1];
            }
            if (coords[c][3] < minY) {
                minY = coords[c][3];
            }
        }
        System.out.println("MaxX: " + maxX);
        System.out.println("MinX: " + minX);
        System.out.println("MaxY: " + maxY);
        System.out.println("MinY: " + minY);
        int[][] coOrdPlot = new int[maxY - minY + 1][maxX - minX + 1];


        for (int i = 0; i < coords.length; i++) {
            for (int b = coords[i][3]; b > coords[i][1]; b--) {


                for (int c = coords[i][0]; c < coords[i][2]; c++) {
                    coOrdPlot[b-minY][c-minX]++;

                }
            }
        }
        int count=0;
        for (int i = 0; i < coOrdPlot.length; i++) {
            for (int j = 0; j < coOrdPlot[i].length; j++) {
                if(coOrdPlot[i][j]==coats){
                    count++;
                }
            }

        }
        PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("paintbarn.out")));
        out.println(count);
        out.close();
        f.close();
    }
}
