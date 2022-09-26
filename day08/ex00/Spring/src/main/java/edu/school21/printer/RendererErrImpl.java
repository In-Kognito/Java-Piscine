package edu.school21.printer;

public class RendererErrImpl implements Renderer {

    PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void print(String message) {
        System.err.println(preProcessor.changes(message));
    }
}
