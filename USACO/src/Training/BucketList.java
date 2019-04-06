package Training;
/*
ID: kevinxu8099
LANG: JAVA
TASK: The Bucket List
*/

import java.io.*;
import java.util.*;

public class BucketList {
	public static void main (String[]args) throws IOException {
		BufferedReader rd = new BufferedReader(new FileReader("mixmilk.txt"));
		int status = Integer.parseInt(rd.readLine());
		int[][]data = new int[status][3];
		for(int i=0; i<status;i++) {
			StringTokenizer st = new StringTokenizer(rd.readLine());
			data[i][0]=Integer.parseInt(st.nextToken());
			data[i][1]=Integer.parseInt(st.nextToken());
			data[i][2]=Integer.parseInt(st.nextToken());
		}
			
			Arrays.sort(data, new Comparator<int[]>() {
			    public int compare(int[] a, int[] b) {
			        return Integer.compare(a[0], b[0]);
			    }
			});
			ArrayList<ArrayList<Integer>> buck = new ArrayList<>();
			for(int g=0;g<status;g++) {
				buck.add(new ArrayList<Integer>());
				
			}
			
			boolean[] used = new boolean[1000000];
			int max = -1;
			for(int c=0; c<status;c++) {
				if(data[c][1]>max) {
					max=data[c][1];
					
				}
			}
			for(int d=0;d<max;d++) {
				for(int e=0;e<status;e++) {
					if(d==data[e][1]) {
						for(int x=0;x<buck.get(e).size();x++) {
							used[buck.get(e).get(x)]=false;
						}
					}else if(d==data[e][0]) {
						int start=0;
						for(int z=0;z<data[e][2];z++) {
							boolean check=false;
							while(check==false) {
								if(used[start]==false) {
									used[start]=true;
									buck.get(e).add(start);
									check=true;
								}else if(used[start]==true) {
									start++;
								}
							}
						}
					}
				}
			}
			int answer=-1;
			for(int y=0;y<buck.size();y++) {
				for(int m=0;m<buck.get(y).size();m++) {
					if(buck.get(y).get(m)>answer) {
						answer=buck.get(y).get(m);
					}
				}
			}
			PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("mixmilk.txt")));
			out.println(answer+1);
			out.close();
			rd.close();
			/*System.out.println(buck.toString());
			System.out.println(answer);
			System.out.println(max);
			System.out.println(Arrays.deepToString(data));*/
			System.exit(0);
	}
}
