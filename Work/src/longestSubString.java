import java.util.ArrayList;

public class longestSubString {
    public static void main (String[]args){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
            char[] toChar = s.toCharArray();
            int max = 0;
            for(int i=0; i<toChar.length;i++){
                if(max>toChar.length-i){
                    return max;
                }
                int cur =0;
                ArrayList<Character> temp = new ArrayList<>();
                temp.clear();
                for(int j=i; j<toChar.length;j++){
                    if(!temp.contains(toChar[j])){
                        temp.add(toChar[j]);
                        cur++;
                    }else{
                        break;
                    }
                }
                max = Math.max(max,cur);

            }
            return max;
    }
}
