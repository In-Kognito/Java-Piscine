package edu.school21.printer.app;

import edu.school21.printer.logic.Arguments;
import java.io.IOException;
import java.nio.file.attribute.AclEntry;
import com.beust.jcommander.JCommander;

public class Program {
    public static void main(String[] args) throws IOException {
        Arguments arguments = new Arguments();
        JCommander.
                newBuilder().
                addObject(arguments).
                build().
                parse(args);

        arguments.run();


    }
}

