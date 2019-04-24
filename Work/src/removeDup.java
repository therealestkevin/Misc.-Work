import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class removeDup{

    public static void main(String[] args) {
        
    }

    public static int removeDuplicates(int[] nums) {
       Set<Integer> placer = new TreeSet<>();
        for(int i : nums){
            placer.add(i);
        }
        int counter =0;
        for(int i : placer){
            nums[counter] = i;
            counter++;
        }

        return placer.size();
        
    }
}