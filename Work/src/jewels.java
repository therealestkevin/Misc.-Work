import java.util.ArrayList;

public class jewels{
     public static void main(String[] args) {
        
    }
    public int numJewelsInStones(String J, String S) {
        ArrayList<Character> types = new ArrayList<>();

        for(char s : J.toCharArray()){
            types.add(s);
        }

        int finalCount=0;
        for(char s : S.toCharArray()){
            if(types.contains(s)){
                finalCount++;
            }
        }
        return finalCount;
    }
}