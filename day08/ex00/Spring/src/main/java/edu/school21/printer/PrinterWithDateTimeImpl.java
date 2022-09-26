package edu.school21.printer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {

    Renderer renderer;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String message) {
        renderer.print(message + " " + LocalDateTime.now());
    }
}
