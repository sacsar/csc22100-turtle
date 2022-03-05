package csc22100.turtlelogo;

public class Main {
    public static void main(String [] args) {
        Canvas canvas = new Canvas(20,20);
        Turtle turtle = new Turtle(canvas);

        turtle.turnRight();
        turtle.forward(10);
        turtle.turnRight();
        turtle.forward(10);
        turtle.turnRight();
        turtle.forward(10);
        turtle.turnRight();
        turtle.forward(10);

        canvas.printCanvas();
    }

    // Want: Some means to parse inputs and turn them into turtle commands
    // pu, pd, rt, lt, fw N
    public void parseInput(String s, Turtle t) {
        switch (s) {
            case "pu":
                t.penUp();
                break;
            case "pd":
                t.penDown();
                break;
            case "lt":
                t.turnLeft();
                break;
            case "rt":
                t.turnRight();
                break;
            default:
                throw new IllegalArgumentException(String.format("Unknown command %s", s));
        }
    }

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }
}

