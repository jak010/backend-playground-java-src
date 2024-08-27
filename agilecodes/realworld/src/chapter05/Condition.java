package chapter05;

@FunctionalInterface
public interface Condition {
    public boolean evaluate(Facts facts);
}
