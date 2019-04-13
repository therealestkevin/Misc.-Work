import java.util.ArrayList;
import java.util.List;

public class removeOuter {
    public static void main (String[]args){
        String s = "(()())(())";

    }
    public String removeOuterParentheses(String S) {
        int count = 0;
        int start = 0;
        List<String> blob = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '('){
                count++;
            }
            if(S.charAt(i) == ')'){
                count--;
            }
            if(count == 0){
                blob.add(S.substring(start, i+1));
                start = i+1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String p : blob){
            sb.append(p.substring(1,p.length() -1));
        }
        return sb.toString();
    }
}
