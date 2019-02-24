import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
ID: kevinxu4
LANG: JAVA
TASK: namenum
*/
public class namenum {
    static ArrayList<String> nameDict = new ArrayList<>();
    static ArrayList<String> bob = new ArrayList<>();
    static PrintWriter out;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        BufferedReader br = new BufferedReader(new FileReader("dict.txt"));
       out = new PrintWriter( new BufferedWriter( new FileWriter("namenum.out")));
        String tempName;
        while ((tempName = br.readLine()) != null) {
            nameDict.add(tempName);
        }

        String n= f.readLine();

        if(letterCombinations(n)==false){
           out.println("NONE");
        }






        out.close();
        f.close();
        br.close();

    }
    public static boolean letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return false;
        String[] mapping = new String[] {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PRS", "TUV", "WXY"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray()) {
                    ans.add(t + s);
                    if(nameDict.contains(t+s)&&(t+s).length()==digits.length()){
                        out.println(t+s);
                        return true;
                    }
                }
            }
        }
        return false;
    }



}
