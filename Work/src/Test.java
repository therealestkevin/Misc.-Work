import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test{
    public static void main(String[] args) {
      /*  int[] test= {3,2,5,1};
        System.out.println(isSum(test,8));
            int a=4;
            for (int i = 6; i < -3; i -= 3)
            System.out.println( i + "");*/
           // int bob;
           // System.out.println(bob);

           Tupac[] elements = {new Biggie(), new Tupac(), new JayZ(), new FiftyCent()};

for (int i = 0; i < elements.length; i++) {

    elements[i].a();

    System.out.println();

    elements[i].b();

    System.out.println();

    System.out.println(elements[i]);

    System.out.println();

}
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
    public static class Biggie extends JayZ {

        public void a() {
    
            System.out.print("Biggie a   ");
    
            super.a();
    
        }
    
     
    
        public String toString() {
    
            return "Biggie";
    
        }
    
    }
    
     
    
    public static class JayZ extends Tupac {
    
        public void a() {
    
            System.out.print("JayZ a   ");
    
            b();
    
        }
    
    }
    public static class FiftyCent extends Biggie {

        public void b() {
    
            System.out.print("FiftyCent b   ");
    
        }
    
    }
    
    public static class Tupac {
    
        public void a() {
    
            System.out.print("Tupac a   ");
    
        }
    
     
    
        public void b() {
    
            System.out.print("Tupac b   ");
    
        }
    
     
    
        public String toString() {
    
            return "Tupac";
    
        }
    
    }
   /* public int update(player[] transaction, player[] master){
        int totalGoals=0;
        for(player i : transaction){
            player cur;
            for(player b : master){
                if(b==i){
                    i.goals+=b.goals;
                    totalGoals+=b.goals;
                }
            }
        }

        return totalGoals;

}*/
}