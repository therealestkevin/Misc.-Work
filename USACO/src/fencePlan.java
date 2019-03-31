import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class fencePlan {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("fenceplan.txt"));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] cowCoOrd = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer temp = new StringTokenizer(f.readLine());
            cowCoOrd[i][0] = Integer.parseInt(temp.nextToken());
            cowCoOrd[i][1] = Integer.parseInt(temp.nextToken());
        }
        System.out.println(Arrays.deepToString(cowCoOrd));
        ArrayList<Integer> connect = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer temp = new StringTokenizer(f.readLine());
            connect.add(Integer.parseInt(temp.nextToken()));
            connect.add(Integer.parseInt(temp.nextToken()));

        }
        f.close();
        System.out.println(connect);
        ArrayList<ArrayList<Integer>> findNetwork = new ArrayList<>();
        for (int i = 0; i < connect.size(); i += 2) {
            boolean isIn = false;
            int foundIn = -1;
            for (int j = 0; j < findNetwork.size(); j++) {
                if (findNetwork.get(j).contains(connect.get(i)) || findNetwork.get(j).contains(connect.get(i + 1))) {
                    isIn = true;
                    foundIn = j;
                }
            }
            if (isIn == false) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(connect.get(i));
                temp.add(connect.get(i + 1));
                findNetwork.add(temp);
            } else if (foundIn != -1) {
                if (findNetwork.get(foundIn).contains(connect.get(i))) {
                    findNetwork.get(foundIn).add(connect.get(i + 1));

                } else {
                    findNetwork.get(foundIn).add(connect.get(i));
                }
            }
        }
        System.out.println(findNetwork);
        int minPerim = Integer.MAX_VALUE;
        for (ArrayList<Integer> i : findNetwork) {
            int minX = Integer.MAX_VALUE;
            int maxX = -1;
            int minY = Integer.MAX_VALUE;
            int maxY = -1;

            for (int j = 0; j < i.size(); j++) {
                int[] temper = cowCoOrd[i.get(j) - 1];
                if (temper[0] < minX) {
                    minX = temper[0];
                }
                if (temper[0] > maxX) {
                    maxX = temper[0];
                }
                if (temper[1] < minY) {
                    minY = temper[1];
                }
                if (temper[1] > maxY) {
                    maxY = temper[1];
                }

            }
            int curPerim = (2 * (maxX - minX)) + (2 * (maxY - minY));
            if (curPerim < minPerim) {
                minPerim = curPerim;
            }
        }
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));

        System.out.println(minPerim);
        // out.close();
    }
}
