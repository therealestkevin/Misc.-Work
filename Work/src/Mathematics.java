
import java.util.*;
import java.io.*;
public class Mathematics {
	public static void main (String[]args) throws IOException {
		BufferedReader rd = new BufferedReader(new FileReader("mathematics.txt"));
		int lines = Integer.parseInt(rd.readLine());
		
		for(int i=0; i<lines;i++) {
			StringTokenizer st = new StringTokenizer(rd.readLine());
			String current = st.nextToken();
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			char[] bob = current.toCharArray();
			for(int b=start;b<end;b++) {
				bob[b]=' ';
			}
			for(char c : bob) {
				if(c==' ') {
					
				}else {
					System.out.print(c);
				}
			}
			System.out.println();
		}
	
	}
}
