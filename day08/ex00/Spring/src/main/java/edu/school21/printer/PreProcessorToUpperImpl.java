package edu.school21.printer;

public class PreProcessorToUpperImpl implements PreProcessor {

    @Override
    public String changes(String message) {
        return message.toUpperCase();
    }


}
