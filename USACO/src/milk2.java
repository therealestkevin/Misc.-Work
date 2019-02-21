import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
/*
ID: kevinxu4
LANG: JAVA
TASK: milk2
*/
public class milk2 {
    public static void main (String[]args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        int num = Integer.parseInt(f.readLine());
        ArrayList<Integer> totalNum = new ArrayList<>();

        for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            totalNum.add(Integer.parseInt(st.nextToken()));
            totalNum.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.addAll(totalNum);
        Collections.sort(totalNum);

        int start = totalNum.get(0);
        int[] milkTrack = new int[totalNum.get(totalNum.size()-1)];
        for(int i=0; i<num;i++){
            int num1 = temp.get(i*2);

            int num2 = temp.get((i*2)+1);

            for(int b=num1;b<num2;b++){
                milkTrack[b]=1;
            }
        }
        System.out.println(Arrays.toString(milkTrack));
        PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("milk2.out")));
        int maxCont=0;
        int maxIdle =0;
        boolean isStart=true;
        int counter=0;
        for(int i=0; i<milkTrack.length;i++){
            if(i+1==milkTrack.length&&milkTrack[i]==1){
                counter++;
                if(counter>maxCont){
                    maxCont=counter;
                }
            }else if(isStart&&milkTrack[i]==1){
                counter++;
                isStart = false;
            }else if(!isStart&&milkTrack[i]==1){
                counter++;
            }else if(milkTrack[i]==0){
                if(counter>maxCont){
                    maxCont=counter;

                }isStart=true;
                counter=0;
            }
        }
        out.print(maxCont);
        System.out.print(maxCont);

        boolean isStart2 =true;
        int counter2=0;
        for(int i=start; i<milkTrack.length;i++){
            if(i+1==milkTrack.length&&milkTrack[i]==0){
                counter2++;
                if(counter2>maxIdle){
                    maxIdle=counter2;
                }
            }else if(isStart2&&milkTrack[i]==0){
                counter2++;
                isStart2 = false;
            }else if(!isStart2&&milkTrack[i]==0){
                counter2++;
            }else if(milkTrack[i]==1||i+1==milkTrack.length){
                if(counter2>maxIdle){
                    maxIdle=counter2;

                }isStart2=true;
                counter2=0;
            }
        }

        out.print(" "+maxIdle);
        System.out.print(" "+maxIdle);
        out.println();
        out.close();
        f.close();
    }
}
