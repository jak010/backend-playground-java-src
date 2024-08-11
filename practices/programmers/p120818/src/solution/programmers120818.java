package solution;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120818
 */
public class programmers120818 {


    public static int solution(int price) {
        int answer = 0;

        if (price >= 100_000 && price < 300_000) {
            answer = (int) (price - (price * 0.05));
        } else if (price >= 300_000 && price < 500_000) {
            answer = (int) (price - (price * 0.1));
        } else if (price >= 500_000) {
            answer = (int) (price - (price * 0.2));
        } else {
            return price;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(150_000));
        System.out.println(solution(580_000));


    }

}
