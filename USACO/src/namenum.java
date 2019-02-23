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
    public boolean letterCombinations2(String digits) {
        List<String> list = new ArrayList<String>();
        if(!digits.isEmpty()) {
           if(helper(digits, "", 0, list)==1){
               return true;
           }
        }
        return false;
    }

    public int helper(String digits, String combo, int position, List<String> list) {
        if(position == digits.length()) {
            list.add(combo);
            if(nameDict.contains(combo)){

                out.println(combo);
                return 1;

            }
           return 0;
        }
        String[] letters = getMapping(digits.charAt(position));
        for(int i = 0; i < letters.length; i++){
            helper(digits, combo + letters[i], position + 1, list);
        }
        return 0;
    }

    public String[] getMapping(char c) {
        switch (c) {
            case '2':
                return new String[] {"a", "b", "c"};
            case '3':
                return new String[] {"d", "e", "f"};
            case '4':
                return new String[] {"g", "h", "i"};
            case '5':
                return new String[] {"j", "k", "l"};
            case '6':
                return new String[] {"m", "n", "o"};
            case '7':
                return new String[] {"p", "q", "r", "s"};
            case '8':
                return new String[] {"t", "u", "v"};
            case '9':
                return new String[] {"w", "x", "y", "z"};
        }

        return new String[] {};
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
