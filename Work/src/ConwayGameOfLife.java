import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;



public class ConwayGameOfLife {
    public static int curRow = 0;
    public static int curCol = 0;
    public static int[][] life = new int[20][20];
    private static Timer timer;
    public static JButton[][] container;
    private static boolean isOn = false;
    public static void main (String[]args) throws InterruptedException {
        int[][] n = {{1,2,3}, { 3,2,1}, {8,7,9}};
        System.out.println(findMax(n));
        printRows(n);
        System.out.println();
        printCols(n);



        life = gameOfLife(life);

        System.out.println();
        for(int[] row : life){
            System.out.println(Arrays.toString(row));
        }

        JFrame frame = new JFrame("Mappings");
        JPanel cur = getPanel(life);



        frame.add(cur, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,  500);
        frame.setVisible(true);
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                life = gameOfLife(life);
                frame.getContentPane().removeAll();

                frame.add(getPanel(life), BorderLayout.CENTER);
                frame.validate();
                frame.repaint();
            }
        });
        timer.start();





    }
    public static JPanel getPanel(int[][] bool){
        JPanel grid = new JPanel();
        container = new JButton[bool.length][bool[0].length];
        grid.setLayout(new GridLayout(bool.length, bool[0].length));
        //JLabel[][] gridlayout = new JLabel[bool.length][bool[0].length];
        for(int i = 0; i<bool.length;i++) {
            for (int j = 0; j < bool[0].length; j++) {
                JButton temp = new JButton();
                if (bool[i][j] == 0) {
                    temp.setBackground(Color.white);
                } else {
                    temp.setBackground(Color.BLACK);
                }
                temp.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        isOn = true;
                        timer.stop();
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        isOn = false;
                        timer.start();
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        JButton clicked = (JButton)e.getSource();
                        if(isOn){
                            temp.setBackground(Color.BLACK);
                            for(int i = 0; i < bool.length; i++){
                                for(int j=0; j< bool[0].length; j++){
                                    if(container[i][j] == e.getSource()){
                                        life[i][j] = 1;

                                    }
                                }
                            }
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                temp.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for(int i = 0; i < bool.length; i++){
                            for(int j=0; j< bool[0].length; j++){
                                if(container[i][j] == e.getSource()){
                                    if(life[i][j] == 0){
                                        life[i][j] = 1;
                                        temp.setBackground(Color.BLACK);
                                    }else{
                                        life[i][j] = 0;
                                        temp.setBackground(Color.WHITE);
                                    }
                                }
                            }
                        }

                    }
                });
                container[i][j] = temp;
                grid.add(temp);
                //grid.add(gridlayout[i][j]);
            }
        }
        return grid;
    }
    public static int findMax(int[][] n){
        int max = Integer.MIN_VALUE;
        for(int[] i : n){
            for(int j : i){
                if(j>max){
                    max = j;
                }
            }
        }
        return max;
    }

    public static void printRows(int[][]n){
        for(int[] i : n){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void printCols(int[][]n){
        for(int i=0; i<n[0].length; i++){
            for(int j=0; j<n.length; j++){
                System.out.print(n[j][i]+ " ");
            }
            System.out.println();
        }
    }
    public static int[][] gameOfLife(int[][]n){
        for(int[] row : n){
            System.out.println(Arrays.toString(row));
        }

        int[][] neighborCount = new int[n.length][n[0].length];

        for(int i = 0; i<n.length; i++){
            for(int j = 0; j<n[i].length; j++){
                neighborCount[i][j] = countNeighbor(n, i, j);
                // System.out.print(countNeighbor(n, i, j)+ " ");
            }
        }
        System.out.println();
        for(int[] row : neighborCount){
            System.out.println(Arrays.toString(row));
        }
        int[][] solution = new int[n.length][n[0].length];


        for(int i = 0; i<n.length; i++) {
            for (int j = 0; j < n[i].length; j++) {
                if(neighborCount[i][j] == 3){
                    solution[i][j] = 1;
                }else if(neighborCount[i][j] > 3){
                    solution[i][j] = 0;
                }
            }
        }
        return solution;
    }


    public static int countNeighbor(int[][]n, int i, int j){
        int neighbors = 0;
        for(int k = -1; k <= 1; k++){
            for(int h = -1; h <= 1; h++){
                int curRow = i + k;
                int curCol = j + h;
                // System.out.println(curRow + " " + curCol);
                try{
                    if(!(curRow == i && curCol == j) && n[curRow][curCol] == 1)
                        neighbors++;
                }catch(ArrayIndexOutOfBoundsException e){
                    //System.out.println(curRow + " " + curCol);
                }
            }
        }
        return neighbors;
    }
}


