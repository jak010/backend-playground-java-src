package chapter03;

import java.util.ArrayList;
import java.util.List;

public class Notification {

    private final List<String> errors = new ArrayList<>();

    public void addError(final String messgae) {
        errors.add(messgae);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public String errorMessage() {
        return errors.toString();
    }

    public List<String> getErrors() {
        return this.errors;
    }


}
