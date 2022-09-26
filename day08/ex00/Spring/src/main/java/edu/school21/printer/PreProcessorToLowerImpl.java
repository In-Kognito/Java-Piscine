package edu.school21.printer;

public class PreProcessorToLowerImpl implements PreProcessor {

    @Override
    public String changes(String message) {
        return message.toLowerCase();
    }
}
