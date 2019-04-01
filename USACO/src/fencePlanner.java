import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class fencePlanner {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("fenceplan.in"));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] cowCoOrd = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer temp = new StringTokenizer(f.readLine());
            cowCoOrd[i][0] = Integer.parseInt(temp.nextToken());
            cowCoOrd[i][1] = Integer.parseInt(temp.nextToken());
        }
        //System.out.println(Arrays.deepToString(cowCoOrd));
        int[][] connect = new int[M][2];

        for (int i = 0; i < M; i++) {
            StringTokenizer temp = new StringTokenizer(f.readLine());
            connect[i][0] = Integer.parseInt(temp.nextToken()) - 1;
            connect[i][1] = (Integer.parseInt(temp.nextToken()) - 1);

        }
        //System.out.println(Arrays.deepToString(connect));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
        out.println(FindMinSize(N, M, cowCoOrd, connect));
        f.close();
        out.close();
    }

    // for cowConnections, converted to 0 based array indexes
    public static int FindMinSize(int n, int m, int[][] cowPositions, int[][] cowConnections) {
        int[] parents = new int[n];
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>(n);
        for (int j = 0; j < n; j++) {
            parents[j] = j;
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(j);
            lists.add(list);
        }

        for (int i = 0; i < m; i++) {
            // if both a[i] and b[i] are merged before
            // first check if it is valid to merge
            int[] connection = cowConnections[i];
            if (parents[connection[0]] != parents[connection[1]]) {
                // merge the smaller one to the large

                if (lists.get(connection[0]).size() > lists.get(connection[1]).size()) {
                    // merge b[i] to a[i]
                    ArrayList<Integer> parentList = lists.get(connection[0]);
                    for (int item : lists.get(connection[1])) {
                        parents[item] = parents[connection[0]];
                        parentList.add(item);
                        lists.set(item, parentList);
                    }
                } else {
                    // merge a[i] to b[i]
                    ArrayList<Integer> parentList = lists.get(connection[1]);
                    for (int item : lists.get(connection[0])) {
                        parents[item] = parents[connection[1]];
                        parentList.add(item);
                        lists.set(item, parentList);
                    }
                }
            }
        }

        HashSet set = new HashSet<Integer>();
        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (set.contains(parents[i])) {
                continue;
            }

            set.add(parents[i]);
            // check the min size
            int minX = Integer.MAX_VALUE;
            int maxX = -1;
            int minY = Integer.MAX_VALUE;
            int maxY = -1;
            for (int item : lists.get(i)) {
                //
                minX = Math.min(minX, cowPositions[item][0]);
                maxX = Math.max(maxX, cowPositions[item][0]);
                minY = Math.min(minY, cowPositions[item][1]);
                maxY = Math.max(maxY, cowPositions[item][1]);
            }

            int size = (maxX - minX + maxY - minY) * 2;
            minSize = Math.min(minSize, size);

        }
        return minSize;
    }


}
