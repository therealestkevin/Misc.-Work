import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test{
    public static void main(String[] args) {
        int[] test= {3,2,5,1};
        System.out.println(isSum(test,8));
            int a=4;
            for (int i = 6; i < -3; i -= 3)
            System.out.println( i + "");
    }

    public static boolean isSum(int []nums, int k){
        Set<Integer> result  = new HashSet<>();        
        

        for(int i : nums){
            
            if(result.contains(k-i)){
                return true;
            }else{
                result.add(i);
            }
            
        }
        return false;
    }
}