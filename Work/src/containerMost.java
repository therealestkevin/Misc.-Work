

public class containerMost{
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;

        for(int i =0; i<height.length-1;i++){

            for(int j=i+1; j<height.length;j++){
                maxArea = Math.max( (j-i) * Math.min(height[i], height[j]), maxArea);
                
            }
        }
        return maxArea;
    }

    

}