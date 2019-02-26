import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class herd {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("herding.in"));
        PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("herding.out")));
        int[] positions = new int[3];
        StringTokenizer st  = new StringTokenizer(f.readLine());
        for(int i=0; i<3;i++){
            positions[i] = Integer.parseInt(st.nextToken());
        }
        int[] spaces = spaceArray(positions);
        if(isDone(spaces)){
            out.println(0);
            out.println(0);
        }else{
            out.println(getMin(spaces));
            out.println(getMax(spaces));
        }
        f.close();
        out.close();
    }
    public static int getMin(int[]spaces){
        boolean spaceone = false;
        for(int i=0; i<spaces.length;i++){
            if(spaces[i]==1){
                spaceone=true;
            }
        }
        if(spaceone){
            return 1;
        }else{
            return 2;
        }
    }
    public static int getMax(int[]spaces){
        int maxReturn =-1;
        for(int i: spaces){
            if(i>maxReturn){
                maxReturn=i;
            }
        }
        return maxReturn;
    }
    public static boolean isDone(int[]spaces){
        boolean returnValue = true;
        for(int i : spaces){
            if(i!=0){
                returnValue = false;
            }
        }
        return returnValue;
    }
    public static int[] spaceArray(int[] positions){
        int[] result = new int[positions.length-1];
        Arrays.sort(result);
        for(int i = 0;i < positions.length-1; i++){
            int spcs = positions[i+1] - positions[i] - 1;

                result[i] = spcs;

        }
        return Arrays.copyOfRange(result, 0, result.length);
    }
}
