public class palindrome {
    public static void main(String[]args){
        reverse(-123);
        System.out.println(isPalindrome(-121));
    }
    public static boolean isPalindrome(int x) {
         String curX = "" + x;
         StringBuilder sb = new StringBuilder("");
         for(int i =0; i<curX.length();i++){
             sb.append(curX.charAt(curX.length()-1-i));
         }
         String reverse = sb.toString();
         if(reverse.equals(curX)){
             return true;
         }
         return false;
    }
    public static int reverse(int x) {
        int result;
        String curX = "" + x;
        boolean negative = false;
        if(curX.charAt(0)=='-'){
            negative=true;
        }
        if(negative){
            curX = curX.substring(1,curX.length());
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<curX.length();i++){
            sb.append(curX.charAt(curX.length()-1-i));
        }
        try{
             result = Integer.parseInt(sb.toString());
        }catch(NumberFormatException e){
            return 0;
        }

        if(negative){
            return result*-1;
        }
        return result;

    }
}
