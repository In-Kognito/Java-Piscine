package edu.school21.printer;

public class RendererStandardImpl implements Renderer {

    PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void print(String message) {
        System.out.println(preProcessor.changes(message));
    }
}
