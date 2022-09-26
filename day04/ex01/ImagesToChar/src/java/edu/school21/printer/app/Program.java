package edu.school21.printer.app;

import edu.school21.printer.logic.logic;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Wrong arguments");
            System.exit(-1);
        }
        if (args[0].length() != 1 || args[1].length() != 1) {
            System.err.println("Wrong char");
            System.exit(-2);
        }
        char white = args[0].charAt(0);
        char black = args[1].charAt(0);

        BufferedImage buffered = ImageIO.read(new FileInputStream("./src/resources/it.bmp"));
        int[][] arrayPic = new int[buffered.getHeight()][buffered.getWidth()];

        for (int i = 0; i < buffered.getHeight(); i++) {
            for (int j = 0; j < buffered.getWidth(); j++) {
                int color = buffered.getRGB(j, i);
                if (color == Color.BLACK.getRGB()) {
                    arrayPic[i][j] = black;
                }
                else {
                    arrayPic[i][j] = white;
                }
            }
        }
        logic.printPic(arrayPic, buffered);
    }
}

