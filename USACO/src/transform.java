import java.io.*;
import java.util.Arrays;

/*
ID: kevinxu4
LANG: JAVA
TASK: transform
*/
public class transform {
    public static void main (String[]args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        int status = Integer.parseInt(f.readLine());
        char[][] bob= new char[status][status];
        for(int i=0; i<status;i++){
            String cur = f.readLine();
            for(int j=0; j<status;j++){
                bob[i][j] = cur.charAt(j);
            }
        }

        System.out.println(Arrays.deepToString(bob));
        char[][] resulting = new char[status][status];
        for(int i=0; i<status;i++){
            String cur = f.readLine();
            for(int j=0; j<status;j++){
                resulting[i][j] = cur.charAt(j);
            }
        }
        System.out.println(Arrays.deepToString(resulting));
        System.out.println(Arrays.deepToString(rotate90(resulting)));
        PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("transform.out")));
                if(Arrays.deepEquals(rotate90(bob),resulting)){
                    out.println(1);
                }else if(Arrays.deepEquals(rotate90(rotate90(bob)),resulting)){
                    out.println(2);
                }else if(Arrays.deepEquals(rotate90(rotate90(rotate90(bob))),resulting)){
                    out.println(3);
                }else if(Arrays.deepEquals(flip(bob),resulting)){
                    out.println(4);
                }else if(Arrays.deepEquals(flip(rotate90(bob)),resulting)||Arrays.deepEquals(flip(rotate90(rotate90(bob))),resulting)|| Arrays.deepEquals(
                        flip(rotate90(rotate90(rotate90(bob)))),resulting)){
                    out.println(5);
                }else if(Arrays.deepEquals(bob,resulting)){
            out.println(6);
                 }else{
                    out.println(7);
                }

      out.close();
                f.close();
    }
    public static char[][] rotate90(char[][] rotate){
        char[][] returnValue = new char[rotate.length][rotate.length];

        for(int i=0;i<rotate.length;i++){
            for(int j=0; j<rotate.length;j++){
                returnValue[i][j] = rotate[rotate.length-j-1][i];
            }
        }

        return returnValue;
    }
    public static char[][] flip(char [][] flip){
        char[][] returnValue = new char[flip.length][flip.length];
        for(int i=0; i<flip.length ; i++){
            for(int j=0; j<flip.length; j++){
                returnValue[i][j]= flip[i][flip.length-1-j];
            }
        }
        return returnValue;
    }
}
