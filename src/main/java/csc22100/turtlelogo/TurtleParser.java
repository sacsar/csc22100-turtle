package csc22100.turtlelogo;


import csc22100.turtlelogo.commands.Command;
import csc22100.turtlelogo.commands.ForwardCommand;
import csc22100.turtlelogo.commands.SingleWordCommand;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Parse code in our turtle language
 */
public class TurtleParser {
    // it can either parse commands in three scenarios:
    //  list of commands
    // a file containing the program
    // a single command

    public Command parseCommand(String s) throws ParseException {
        // lexer and parser
        // tokenizer and a parse
        String[] tokens = s.split(" "); // NOTE: can't handle extra whitespace etc
        if (tokens.length == 1) {
            switch (s) {
                case "pu":
                    return SingleWordCommand.PEN_UP;
                default:
                    throw new ParseException("oops", 0);
            }
            // single word command case
        } else if (tokens.length == 2) {
            // forward
            // we need that the second token is an int
            try {
                int numSteps = Integer.parseInt(tokens[1]);
                if ("fw".equals(tokens[0])) {
                    return new ForwardCommand(numSteps);
                } else {
                    throw new ParseException("", 0);
                }
            } catch (NumberFormatException e) {
                throw new ParseException(s, 1);
            }
        } else {
            // throw an error
            throw new ParseException(String.format("Failed to parse %s", s), 0);
        }
    }

    public List<Command> parseCommands(List<String> rawCommands) throws ParseException {
        List<Command> commands = new LinkedList<>();
        for (String s : rawCommands) {
            commands.add(parseCommand(s));
        }
        return commands;
    }
}
