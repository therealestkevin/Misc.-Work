import java.io.*;

public class friday {
    /*
ID: kevinxu4
LANG: JAVA
TASK: friday
*/
    public static void main (String[]args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        int years = Integer.parseInt(f.readLine());
        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] fridayCount= new int[7];
        int startDay=0;
        for(int i=0; i<years;i++){
            if(((1900+i)%4==0&&(1900+i)%100!=0)||(1900+i)%400==0){
                monthDays[1]=29;
            }else{
                monthDays[1]=28;
            }
            for(int j=0; j<12;j++){
                for(int k=0; k<monthDays[j];k++){
                    if(k==12){
                        fridayCount[startDay]++;
                    }
                    if(startDay+1==7){
                        startDay=0;
                    }else{
                        startDay++;
                    }
                }
            }

        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        out.print(fridayCount[5]+" "+fridayCount[6]);
        for(int i=0;i<5;i++){
            out.print(" "+fridayCount[i]);

        }
        out.println();
    out.close();
        f.close();
    }
}
