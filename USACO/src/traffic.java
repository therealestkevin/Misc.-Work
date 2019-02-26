import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class traffic {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("traffic.txt"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));
        int segments = Integer.parseInt(f.readLine());
        int[][] data = new int[segments][3];
        for(int i =0; i<segments;i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            String status = st.nextToken();
            if(status.equals("none")){
                data[i][0]=0;
            }else if(status.equals("on")){
                data[i][0]=1;
            }else{
                data[i][0]=2;
            }
            data[i][1]= Integer.parseInt(st.nextToken());
            data[i][2] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.deepToString(data));
        int firstNone=0;
        boolean isDone = false;
        for(int i=0; i<data.length;i++){
            if(data[i][0]==0&&!isDone){
                isDone=true;
                firstNone=i;
            }
        }
        int lastNone=0;
        boolean isDone2 = false;
        for(int i=data.length-1; i>=0;i--){
            if(data[i][0]==0&&!isDone2){
                isDone2=true;
                lastNone=i;
            }
        }
        ArrayList<Integer> chainNoneStart= new ArrayList<>();
        ArrayList<Integer> chainNoneEnd = new ArrayList<>();

        System.out.println(firstNone);
        System.out.println(lastNone);
        boolean isDone3 = false;
        chainNoneStart.add(firstNone);
        int counter=1;
        while(!isDone3){
            if(firstNone+counter<data.length) {
                if (data[firstNone + counter][0] != 0) {
                    isDone3 = true;
                }
                if (!isDone3) {
                    chainNoneStart.add(counter + firstNone);
                    counter++;
                }
            }else{
                isDone3=true;
            }
        }
        boolean isDone4 = false;
        chainNoneEnd.add(lastNone);
        int counter2=1;
        while(!isDone4){
            if(lastNone-counter2>=0) {
                if (data[lastNone - counter2][0] != 0) {
                    isDone4 = true;
                }
                if (!isDone4) {
                    chainNoneEnd.add(lastNone - counter2);
                    counter2++;
                }
            }else{
                isDone4=true;
            }
        }
        System.out.println(chainNoneStart);
        System.out.println(chainNoneEnd);
        int[][] currentRange = new int[2][2];
        int maxStartRange =-1;
        int minStartRange=1001;
        for(int i: chainNoneStart){
            if(data[i][1]>maxStartRange){
                maxStartRange=data[i][1];
            }
            if(data[i][2]<minStartRange){
                minStartRange=data[i][2];
            }
        }
        int maxEndRange=-1;
        int minEndRange=1001;
        for(int i: chainNoneEnd){
            if(data[i][1]>maxEndRange){
                maxEndRange=data[i][1];
            }
            if(data[i][2]<minEndRange){
                minEndRange=data[i][2];
            }
        }
        System.out.println(maxStartRange+" - " +minStartRange );
        System.out.println(maxEndRange+" - "+minEndRange);

    for(int i=firstNone-1;i>=0;i--){
        if(data[i][0]==1){
            maxStartRange-=Math.max(data[i][1],data[i][2]);
            minStartRange-=Math.min(data[i][1],data[i][2]);
        }else{
            maxStartRange+=Math.min(data[i][1],data[i][2]);
            minStartRange+=Math.max(data[i][1],data[i][2]);

        }
    }
    for(int i=lastNone+1;i<data.length;i++){
        if(data[i][0]==1){
            maxEndRange+=Math.min(data[i][1],data[i][2]);
            minEndRange+=Math.max(data[i][1],data[i][2]);
        }else{
            maxEndRange-=Math.max(data[i][1],data[i][2]);
            minEndRange-=Math.min(data[i][1],data[i][2]);
        }
    }
        System.out.println(maxStartRange+" " +minStartRange );
       System.out.println(maxEndRange+" "+minEndRange);
        f.close();
        //out.close();
    }

}
