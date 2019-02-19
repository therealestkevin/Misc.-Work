import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
ID: kevinxu4
LANG: JAVA
TASK: gift1
*/
public class gift1 {
    public static void main (String[]args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        int nameCount = Integer.parseInt(f.readLine());
        HashMap<String,Integer> moneyTrack = new HashMap<>();
        ArrayList<String> nameHolder = new ArrayList<>();
        for(int i=0; i<nameCount;i++ ){
            String temp = f.readLine();

            moneyTrack.put(temp,0);
            nameHolder.add(temp);
        }
        for (int i=0; i<nameCount;i++){
            String curGifter = f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine());

            int money = Integer.parseInt(st.nextToken());
            moneyTrack.put(curGifter,moneyTrack.get(curGifter)-money);
            int moneySplit = Integer.parseInt(st.nextToken());
            if(moneySplit==0){
                moneyTrack.put(curGifter,moneyTrack.get(curGifter)+money);
            }else if(moneySplit>money){
                moneyTrack.put(curGifter,moneyTrack.get(curGifter)+money);
                for(int b=0; b<moneySplit;b++){
                    f.readLine();
                }
            }else{
                int splitMoney = money/moneySplit;
                for(int j=0; j<moneySplit;j++){
                    String nameCur = f.readLine();
                    moneyTrack.put(nameCur,moneyTrack.get(nameCur)+splitMoney);
                    money-=splitMoney;

                }
                moneyTrack.put(curGifter,moneyTrack.get(curGifter)+money);
            }


        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        for(int i=0; i<moneyTrack.size();i++) {

            out.println(nameHolder.get(i) + " " + moneyTrack.get(nameHolder.get(i)));
        }
        out.close();
        f.close();
    }
}
