import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.util.List;
import java.util.Vector;

class Board {
    int number;

    Board(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Board Number" + this.number;

    }
}

public class VectorExample {

    public static void main(String[] args) {

        List<Board> list = new Vector<>();
        list.add(new Board(1));
        list.add(new Board(2));
        list.add(new Board(3));
        list.add(new Board(4));

        for (Board e : list) {
            System.out.println(e);
        }

    }
}
