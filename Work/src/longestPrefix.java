public class longestPrefix{
    public static void main(String[] args) {
      System.out.println(longestCommonPrefix(new String[] {"flower", "flow","flight"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        int minLength = Integer.MAX_VALUE;
        for(String s : strs){
            minLength = Math.min(s.length(),minLength);
        }
        for(int i=minLength; i>=0;i--){
            boolean works = true;
            String standard = strs[0].substring(0, i);
            for(String s : strs){
                if(!s.substring(0, i).equals(standard)){
                    works=false;
                }
            }
            if(works){
                return standard;
            }
        }
        return "";
    }
}