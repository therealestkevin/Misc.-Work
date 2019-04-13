import java.util.*;


public class skylines{

    public static void main(String[] args) {
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(    maxIncreaseKeepingSkyline(grid));
    }   
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] maxes = new int[grid.length+grid[0].length];
        for(int i=0; i<grid.length;i++){
            int max = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            for(int j=0; j<grid[i].length;j++){
                    max = Integer.max(max, grid[i][j]);
                    max2 = Integer.max(max2,grid[j][i]);
            }
            maxes[i] = max;
            maxes[i+grid.length] = max2;
        }
       
       int potentialAdd = 0;
       for(int i=0; i<grid.length;i++){
           for(int j=0; j<grid[i].length;j++){
               potentialAdd+= Math.min(maxes[i],maxes[grid.length+j]) - grid[i][j];
           }
       }
       return potentialAdd;

    }
}