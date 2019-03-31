import java.io.*;

public class leftOut {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("leftout.out")));
        BufferedReader f = new BufferedReader(new FileReader("leftout.in"));
        int size = Integer.parseInt(f.readLine());
        int[][] cows = new int[size][size];
        for (int i = 0; i < size; i++) {
            String cur = f.readLine();
            for (int j = 0; j < size; j++) {
                if (cur.charAt(j) == 'R') {
                    cows[i][j] = 1;
                } else {
                    cows[i][j] = -1;
                }
            }
        }


        int[] answer = FindFirstCow(size, cows);

        out.println(answer[0] + " " + answer[1]);
        out.close();
        f.close();
    }

    // R: 1
    // L: -1
    public static int[] FindFirstCow(int n, int[][] positions) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // keep i, j not flipped and check if all other positions can be flipped
                // 1 for no flip,
                // -1 for flip
                int[] rowFlipBits = new int[n];
                int[] columnFlipBits = new int[n];
                int currPosition = positions[i][j];
                for (int k = 0; k < n; k++) {
                    if (k == i) {
                        // no flip
                        rowFlipBits[k] = 1;
                    } else if (positions[k][j] == currPosition) {
                        // flip
                        rowFlipBits[k] = -1;
                    } else {
                        rowFlipBits[k] = 1;
                    }

                    if (k == j) {
                        // no flip
                        columnFlipBits[k] = 1;
                    } else if (positions[i][k] == currPosition) {
                        // flip
                        columnFlipBits[k] = -1;
                    } else {
                        columnFlipBits[k] = 1;
                    }
                }

                // verify if the row and column flip flags are valid
                if (checkIfValid(n, positions, currPosition, i, j, rowFlipBits, columnFlipBits)) {
                    return new int[]{i + 1, j + 1};
                }

            }
        }

        return new int[]{-1, -1};
    }

    public static boolean checkIfValid(int size, int[][] positions, int currPosition, int i, int j, int[] rowFlips, int[] columnFlips) {
        for (int m = 0; m < size; m++) {
            for (int n = 0; n < size; n++) {
                if (m == i && n == j) {
                    continue;
                }

                if (rowFlips[m] * columnFlips[n] * positions[m][n] == currPosition) {
                    return false;
                }
            }
        }

        return true;
    }


}
