package csc22100.turtlelogo.commands;

public class ForwardCommand implements Command {
    private final int distance;

    public ForwardCommand(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
