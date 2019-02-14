import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class test {

	public static void main (String[]args) {
		int[]test = {2,7,3,10};
		int[][] test2 = {{1,2,3},
				         {1,2,3,4}};
		System.out.println(Arrays.deepToString(test2));
		
		System.out.println(Arrays.toString(twoSum(test,9)));
	}
	public static int[] twoSum(int []n, int target) {
		HashMap<Integer,Integer> hold = new HashMap<Integer,Integer>();
		int[]answer=new int[2];
		for(int i=0; i<n.length;i++) {
			hold.put(n[i], i);
		}
		boolean status=false;
		for(int i=0; i<n.length;i++) {
			if(hold.containsKey(target-n[i])&&status==false) {
				answer[1]=i;
				answer[0]=hold.get(target-n[i]);
			}
		}
		return answer;
	}
}
