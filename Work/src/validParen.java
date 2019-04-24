import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class validParen{

    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }
    public static boolean isValid(String s) {
       
        HashSet<Character> closers = new HashSet<>();
        closers.add(')');
        closers.add(']');
        closers.add('}'); 
        if(s.length()>0&&closers.contains(s.charAt(0))){
            return false;
        }
        Map<Character,Integer> mappings = new HashMap<>();
        mappings.put('(', 1);
        mappings.put('[', 2);
        mappings.put('{', 3);
        mappings.put(')', 4);
        mappings.put(']', 5);
        mappings.put('}', 6);

        
        int[] count = new int[6];
        for(int i=0; i<s.length();i++){
            char cur = s.charAt(i);
            int type = mappings.get(cur);
            boolean isOpen = false;
            if(closers.contains(cur)){
                count[type-1]++;
            }else{
                count[type-1]++;
                isOpen=true;
            }

            if(isOpen&&i<s.length()-1){
                if(closers.contains(s.charAt(i+1)) && mappings.get(s.charAt(i+1))!=type+3){
                    return false;
                }
            }
            
        }
        if(count[0]==count[3]&&count[1]==count[4]&&count[2]==count[5]){
            return true;
        }
        return false;
    }
}