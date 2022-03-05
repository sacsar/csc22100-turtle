package csc22100.turtlelogo;

import java.util.Arrays;

public class Canvas {
    
    private char[][] canvas;
    private int numCols;
    private int numRows;


    public Canvas(int x, int y){
        canvas = new char[x][y];
        numCols = y;
        numRows = x;

        for (int i = 0; i < x; i++) {
            Arrays.fill(canvas[i], ' ');
        }
    }


    public void fill(int x, int y) {
        canvas[x][y] = 'x';
    }

    public void printCanvas() {
        for (char[] row : canvas) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int getNumCols() {
        return numCols;
    }

    public int getNumRows() {
        return numRows;
    }
}
