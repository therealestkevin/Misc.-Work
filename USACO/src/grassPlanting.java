import java.io.*;
import java.util.*;

public class grassPlanting {
	
		
	public static void main (String[]args) throws  IOException {
	       
		BufferedReader rd = new BufferedReader(new FileReader("mixmilk.txt"));
		int status = Integer.parseInt(rd.readLine());
		int[][] data = new int[status-1][2];
		ArrayList<Neighbor> data2 = new ArrayList<Neighbor>();
		for(int i=0;i<status-1;i++) {
			StringTokenizer st = new StringTokenizer(rd.readLine());
			
			int [] temp= new int[2];
			temp[0]=Integer.parseInt(st.nextToken());
			temp[1]=Integer.parseInt(st.nextToken());
			Arrays.sort(temp);
			
			data[i][0]=temp[0];
			data[i][1]=temp[1];
		}
		java.util.Arrays.sort(data, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return Double.compare(a[0], b[1]);
		    }
		});
		for(int i=0; i<status;i++) {
			Neighbor temp = new Neighbor();
			temp.values= i;
			data2.add(temp);
		}
		System.out.println(Arrays.deepToString(data));
		System.out.println(data[0][1]);
		for(int i=0; i<data[0].length;i++) {
			data2.get(data[0][i]-1).neighbor.add(data2.get(data[1][i]-1));
			data2.get(data[1][i]-1).neighbor.add(data2.get(data[0][i]-1));
		}
		
		
		
		for(int i=0; i<data2.size();i++) {
			boolean stat =false;
			boolean stat2 =false;
			while(stat==false) {
				
				for(int b=0; b<data2.get(i).neighbor.size();b++) {
					if(data2.get(i).neighbor.get(b).values==data2.get(i).values&&stat2==false) {
						stat2=true;
						data2.get(i).values++;
					}
				}
				if(stat2==false) {
					stat=true;
				}
			}
		}
		Set<Integer> answer = new HashSet<Integer>();
		for(int i=0; i<data2.size();i++) {
			answer.add(data2.get(i).values);
		}
		
		PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("planting.txt")));
		out.println(answer.size()-1);
		out.close();
		rd.close();
	}
	
	public static class Neighbor{
		int values=0;
		ArrayList<Neighbor> neighbor=new ArrayList<Neighbor>();
		
	}
		
		
	}
	

