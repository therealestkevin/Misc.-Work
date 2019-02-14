import java.util.*;
import java.io.*;
public class Quadratics {
	public static void main (String[]args) throws  IOException {
		BufferedReader rd = new BufferedReader(new FileReader("mathematics.txt"));
		int lines = Integer.parseInt(rd.readLine());
		for(int i=0; i<lines;i++) {
			StringTokenizer st = new StringTokenizer(rd.readLine());
			
		}
		System.out.println(checkInt("5.0"));
	}
	public static boolean checkInt(String n) {
		try {
			int b = Integer.parseInt(n);
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}
}
