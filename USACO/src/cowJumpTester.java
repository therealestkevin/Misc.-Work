import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class cowJumpTester {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));

        int N = Integer.parseInt(f.readLine());
        int[][] coOrd = new int[N][4];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            coOrd[i][0] = Integer.parseInt(st.nextToken());
            coOrd[i][1] = Integer.parseInt(st.nextToken());
            coOrd[i][2] = Integer.parseInt(st.nextToken());
            coOrd[i][3] = Integer.parseInt(st.nextToken());
        }

        f.close();


            out.println(FindIndexToRemove(N,coOrd));


        out.close();


    }

    public static int FindIndexToRemove(int n, int[][] positions)
    {
        int index = 0;
        ArrayList<ArrayList<Integer>> overlaps = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 0; i < n; i++)
        {
            ArrayList<Integer> overlap = new ArrayList<Integer>();
            overlaps.add(overlap);
        }

        for (int i = 0; i < n-1; i++)
        {
            ArrayList<Integer> overlap = overlaps.get(i);
            for (int j = i+1; j < n; j++)
            {
                // check if there are overlap between i and j
                if (checkOverlap(positions[i], positions[j]))
                {
                    overlap.add(j);
                    overlaps.get(j).add(i);
                    if (overlap.size() >= 2)
                    {
                        return i +1;
                    }

                    if (overlaps.get(j).size() >=2)
                    {
                        return j +1;
                    }
                }
            }
        }

        int itemWithMoreOverlap = 0;
        ArrayList<Integer> overlapMax = overlaps.get(0);
        for (int i = 1; i < n; i++)
        {
            ArrayList<Integer> overlap = overlaps.get(i);
            if (overlap.size() > overlapMax.size())
            {
                itemWithMoreOverlap = i;
                overlapMax = overlap;
            }
        }
        return itemWithMoreOverlap + 1;
    }

    public static boolean checkOverlap(int[] line1, int[] line2)
    {
        int xMin = Math.min(line1[0], line1[2]);
        int xMax = Math.max(line1[0], line1[2]);
        int yMin = Math.min(line1[1], line1[3]);
        int yMax = Math.max(line1[1], line1[3]);
        if ((line2[0] < xMin && line2[2] < xMin) ||
                (line2[0] > xMax && line2[2] > xMax) ||
                (line2[1] < yMin && line2[3] < yMin) ||
                (line2[1] > yMax && line2[3] > yMax))
        {
            return false;
        }

        // check same slope -- same slope and connected then
        int xMin2 = Math.min(line2[0], line2[2]);
        int xMax2 = Math.max(line2[0], line2[2]);
        int yMin2 = Math.min(line2[1], line2[3]);
        int yMax2 = Math.max(line2[1], line2[3]);

        if (xMin == xMax && yMin == yMax ||
                xMin2 == xMax2 && yMin2 == yMax2) {
            return xMin == xMin2 && yMin == yMin2;
        }

        if (xMax == xMin || xMin2 == xMax2)
        {
            if (xMax == xMin && xMin2 == xMax2)
            {
                return xMin == xMin2;
            }
            // one is vertical but the other one is not
            if (xMax == xMin)
            {
                return xMin2 <= xMin && xMax2 >= xMin;
            }
            else if (xMax2 == xMin2)
            {
                return xMin <= xMin2 && xMax >= xMin2;
            }
        }
        else
        {
            double slope1 = (line1[1] - line1[3])*1.0/(line1[0] - line1[2]);
            double slope2 = (line2[1] - line2[3])*1.0/(line2[0] - line2[2]);
            double intercep1 = line1[1] - slope1 *line1[0];
            double intercep2 = line2[1] - slope2 *line2[0];
            if (slope1 == slope2 && intercep1 == intercep2)
            {
                return true;
            }
            else if (slope1 == slope2 )
            {
                return false;
            }
            // different slope
            double x = (intercep2 - intercep1)/(slope1 - slope2);
            double y = slope1*x + intercep1;
            if (x >= xMin && x <= xMax &&
                    y >= yMin && y <= yMax)
            {
                return true;
            }
        }

        return false;
    }







}
