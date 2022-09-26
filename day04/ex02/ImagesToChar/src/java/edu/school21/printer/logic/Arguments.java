package edu.school21.printer.logic;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

@Parameters(separators = "=")
public class Arguments {
    @Parameter(names = "--white")
    private String arg1;
    @Parameter(names = "--black")
    private String arg2;

    public void run() throws IOException {

        BufferedImage buffered = ImageIO.read(new FileInputStream("./src/resources/it.bmp"));
        int[][] arrayPic = new int[buffered.getHeight()][buffered.getWidth()];
        ColoredPrinter cp = new ColoredPrinter.Builder(1, false).build();
        Ansi.BColor color1 = Ansi.BColor.valueOf(arg1);
        Ansi.BColor color2 = Ansi.BColor.valueOf(arg2);
        for (int i = 0; i < buffered.getHeight(); i++) {
            for (int j = 0; j < buffered.getWidth(); j++) {
                int color = buffered.getRGB(j, i);
                if (color == Color.BLACK.getRGB()) {
                    cp.setBackgroundColor(color2);
                    cp.print("   ");
                }
                else {
                    cp.setBackgroundColor(color1);
                    cp.print("   ");
                }
            }
            System.out.println();
        }
    }
}
