package chapter05;

import java.util.HashMap;
import java.util.Map;

public class Facts {

    private final Map<String, String> facts = new HashMap<>();

    public String getFact(final String name) {
        return this.facts.get(name);
    }

    public void setFacts(final String name, final String value) {
        this.facts.put(name, value);
    }

    public void addFact(final String name, final String value) {
        this.facts.put(name, value);
    }

}
