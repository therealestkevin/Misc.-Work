import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class perimeter {

  public static int curSize = 0, peri = 0;

  public static void main(String[] args) throws NumberFormatException, IOException {
 
        
  BufferedReader rd = new BufferedReader(new FileReader("perimeter.in"));
	int status = Integer.parseInt(rd.readLine());
	int[][]data = new int[status][status];
	for(int i=0; i<status;i++) {
		char[] data2 = rd.readLine().toCharArray();
		
		for(int b=0;b<status;b++) {
			if(data2[b]=='#') {
				data[i][b]=1;
			}else if(data2[b]=='.') {
				data[i][b]=0;
			}
		}
	}
      int[] finale = bestScoop(data);
     System.out.println(Arrays.toString(finale));
     PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("perimeter.out")));
     out.println(finale[0]+" "+finale[1]);
     out.close();
     rd.close();
  }

  private static int[] bestScoop(int[][] nums) {
    int area =0;
    int perimeter=0;
   
    for (int i = 0; i < nums.length; i++) {
      for (int b = 0; b < nums.length; b++) {
        if (nums[i][b] == 1) {
          curSize = 0;
          peri = 0;
          findBlob(nums, i, b);
          if (curSize > area) {
           area = curSize;
            perimeter = peri;
          } else if (curSize == area) {
            perimeter = Math.min(perimeter, peri);
          }
        }
      }
    }
    return new int[] {area,perimeter};
  }

  private static void findBlob(int[][] nums, int i, int b) {
    if (nums[i][b] == 1) { 
      nums[i][b] = 3; 
      curSize++; 
    } else
      return;
    if (b == 0 || nums[i][b - 1] == 0) {
    	peri++;
    }
      
    if (b == nums.length - 1 || nums[i][b + 1] == 0) {
      peri++;
    }
    if (i == 0 || nums[i - 1][b] == 0) {
      peri++; 
    }
    if (i == nums.length - 1 || nums[i + 1][b] == 0) {
      peri++;
    }
   if (i < nums.length - 1) {
      findBlob(nums, i + 1, b);
} if (i > 0) {
      findBlob(nums, i - 1, b);
    }
    
     if (b < nums.length - 1) {
      findBlob(nums, i, b + 1);
    }if (b > 0) {
      findBlob(nums, i, b - 1);
    }
   
  }
}
