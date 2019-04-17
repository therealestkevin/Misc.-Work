

public class findCombination {
	public static void main (String[]args) {
		System.out.println(Integer.toBinaryString(16 | 2));
		int[] arr = {1,2,3,4};
	    int n = arr.length;
	    int N = (int) Math.pow(2, Double.valueOf(n));  
	   
	    for (int i = 1; i < N; i++) {
	    	
	        String code = String.format("%4s", Integer.toBinaryString(i)).replace(' ', '0');
	        System.out.println();
	       System.out.println(code); System.out.println();
	        for (int j = 0; j < n; j++) {
	            if (code.charAt(j) == '1') {
	                System.out.print(arr[j]);
	            }
	        }
	        System.out.println();
	    }
		
		
	}
	
	
}
