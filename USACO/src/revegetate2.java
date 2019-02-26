import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class revegetate2 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int fields = Integer.parseInt(st.nextToken());
        int cows = Integer.parseInt(st.nextToken());
        int[] fieldTrack = new int[fields];
        fieldTrack[0]=1;
        int[][] dataHold = new int[cows][2];
        for(int i=0; i<cows; i++){
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            dataHold[i][0] = Integer.parseInt(st2.nextToken());
            dataHold[i][1] = Integer.parseInt(st2.nextToken());
        }
        int[][] typeTrack = new int[cows][2];
        //System.out.println(Arrays.deepToString(dataHold));
        ArrayList<ArrayList<Integer>> type= new ArrayList<ArrayList<Integer>>();

       for(int i=0; i<fields; i++){
           type.add(new ArrayList<>());
       }
        for(int i=0; i<cows;i++){
            for(int j=0; j<2;j++){
                type.get(dataHold[i][j]-1).add(i);

            }
        }
        //for(ArrayList<Integer> bob : type){
        //    System.out.println(bob);
        //}
        for(int i : type.get(0)){
            typeTrack[i][0]=1;
        }
        int[] answer = new int[fields];
        answer[0]=1;
        //System.out.println(Arrays.deepToString(typeTrack));
        for(int i=1; i<fieldTrack.length;i++){
                boolean isGo=false;
                for(int c=1; c<=4;c++) {
                    if(!isGo){
                        if(checkingValid(typeTrack,type,c,i)){
                            answer[i]=c;
                            isGo=true;
                        }
                    }


                }
        }
        //System.out.println(Arrays.toString(answer));
        for(int i : answer){
            out.print(i);
        }
        out.println();
        f.close();
        out.close();
    }
    public static boolean checkingValid(int[][]typeTrack, ArrayList<ArrayList<Integer>> type, int typeSeed, int field){
        for( int b : type.get(field)){
            if(typeTrack[b][1]==typeSeed||typeTrack[b][0]==typeSeed){
                return false;
            }
        }
        for(int b: type.get(field)){
            if(typeTrack[b][0]==0){
                typeTrack[b][0]=typeSeed;
            }else{
                if(typeTrack[b][1]==0){
                    typeTrack[b][1]=typeSeed;
                }
            }
        }
        return true;
    }
}
