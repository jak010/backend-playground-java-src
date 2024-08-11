package othersolution;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/120849
 */
public class OtherSolution {


    public String otherSolution(String my_string) {
        return my_string.replaceAll("[aeiou]", "");
    }


    public static void main(String[] args) {
        OtherSolution s = new OtherSolution();
        System.out.println(s.otherSolution("bus")); // expect, bs
        System.out.println(s.otherSolution("nice to meet you")); // expect, nc t mt y

    }

}
