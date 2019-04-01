import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class cowJump {
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

        int[] counter = new int[N];

        HashSet<Integer> intersected = new HashSet<>();

        int answer = search(coOrd, counter, intersected);
        if (answer == 0) {
            int min = Integer.MAX_VALUE;
            for (int i : intersected) {
                min = Math.min(min, i);
            }
            out.println(min);
        } else {
            out.println(answer);
        }

        out.close();


    }

    private static int search(int[][] coOrd, int[] counter, HashSet<Integer> intersected) {
        for (int i = 1; i < coOrd.length + 1; i++) {
            for (int k = i + 1; k < coOrd.length + 1; k++) {

                if (findIntersect(coOrd[i - 1][0], coOrd[i - 1][1], coOrd[i - 1][2], coOrd[i - 1][3], coOrd[k - 1][0], coOrd[k - 1][1], coOrd[k - 1][2], coOrd[k - 1][3])) {
                    counter[i - 1]++;
                    intersected.add(i);
                    counter[k - 1]++;
                    intersected.add(k);
                    if (counter[i - 1] >= 2) {
                        return i;

                    } else if (counter[k - 1] >= 2) {
                        return k;

                    }
                }
            }

        }
        return 0;
    }
    public static boolean findIntersect(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {

        int xMin = Math.min((int) x1, (int) x2);

        int xMax = Math.max((int) x1, (int) x2);

        int yMin = Math.min((int) y1, (int) y2);

        int yMax = Math.max((int) y1, (int) y2);

        if ((x3 < xMin && x4 < xMin) ||
                (x3 > xMax && x4 > xMax) ||
                (y3 < yMin && y4 < yMin) ||
                (y3 > yMax && y4 > yMax)) {
            return false;
        } else {
            if (x1 == x2 && y1 == y2 ||
                    x3 == x4 && y3 == y4) {
                return x1 == x3 && y1 == y3;
            }

            double ax = x2 - x1;

            double bx = x3 - x4;

            double cx = x1 - x3;

            double ay = y2 - y1;

            double by = y3 - y4;

            double cy = y1 - y3;

            double temp = by * cx - bx * cy;
            double calcer = ay * bx - ax * by;
            if (calcer > 0) {
                if (temp < 0 || temp > calcer) {

                    return false;

                }
            } else if (calcer < 0) {

                if (temp > 0 || temp < calcer) {

                    return false;

                }
            }

            double vert = ax * cy - ay * cx;

            if (calcer > 0) {

                if (vert < 0 || vert > calcer) {

                    return false;

                }

            } else if (calcer < 0) {

                if (vert > 0 || vert < calcer) {

                    return false;

                }
            }
            if (calcer == 0) {

                double less = y3 - y1;

                double straight = x1 * (y2 - y3) + x2 * (less) + x3 * (y1 - y2);

                if (straight == 0) {

                    if (x1 >= x3 && x1 <= x4 ||
                            x1 <= x3 && x1 >= x4 ||
                            x2 >= x3 && x2 <= x4 ||
                            x2 <= x3 && x2 >= x4 ||
                            x3 >= x1 && x3 <= x2 ||
                            x3 <= x1 && x3 >= x2) {
                        if (y1 >= y3 && y1 <= y4 ||
                                y1 <= y3 && y1 >= y4 ||
                                y2 >= y3 && y2 <= y4 ||
                                y2 <= y3 && y2 >= y4 ||
                                y3 >= y1 && y3 <= y2 ||
                                y3 <= y1 && y3 >= y2) {

                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
    }

}