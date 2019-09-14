import java.util.ArrayList;
import java.util.List;

public class IBCS {
    public static void main (String[]args) {
        int[][] n = {{1,2,3}, { 3,2,1}, {8,7,9}};
        System.out.println(findMax(n));
        printRows(n);
        System.out.println();
        printCols(n);
        List<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test1.add(2);
        test1.add(3);
        test1.add(4);
        List<Integer> test2 = new ArrayList<>();
        test2.add(1);
        test2.add(3);
        test2.add(3);
        test2.add(5);
        System.out.println(returnIntersect(test1, test2));
    }
    public static int findMax(int[][] n){
        int max = Integer.MIN_VALUE;
        for(int[] i : n){
            for(int j : i){
                if(j>max){
                    max = j;
                }
            }
        }
        return max;
    }

    public static void printRows(int[][]n){
        for(int[] i : n){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void printCols(int[][]n){
        for(int i=0; i<n[0].length; i++){
            for(int j=0; j<n.length; j++){
                System.out.print(n[j][i]+ " ");
            }
            System.out.println();
        }
    }

    public static List<Integer> returnIntersect(List<Integer> n1, List<Integer> n2){
        List<Integer> results = new ArrayList<>();
        for(int i : n1){
            if(!results.contains(i) && n2.contains(i)){
                results.add(i);
            }
        }

        return results;
    }

}
