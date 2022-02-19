package csc22100.turtlelogo;

import java.util.Arrays;

public class Canvas {
    
    private char[][] canvas;

    public Canvas(int x, int y){
        canvas = new char[x][y];

        for (int i = 0; i < x; i++) {
            Arrays.fill(canvas[i], ' ');
        }
    }
}
