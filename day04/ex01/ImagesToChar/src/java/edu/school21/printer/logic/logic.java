package edu.school21.printer.logic;
import edu.school21.printer.app.Program;

import java.awt.image.BufferedImage;

public class logic {
    public static void printPic(int[][] arrayPic, BufferedImage buffered) {
        for (int i = 0; i < buffered.getHeight(); i++) {
            for (int j = 0; j < buffered.getWidth(); j++) {
                System.out.print(((char)arrayPic[i][j]));
            }
            System.out.println();
        }
    }
}
