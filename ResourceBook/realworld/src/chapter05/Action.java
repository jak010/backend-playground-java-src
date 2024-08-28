package chapter05;

@FunctionalInterface
public interface Action {

    void execute();

    void execute(Facts facts);

}
