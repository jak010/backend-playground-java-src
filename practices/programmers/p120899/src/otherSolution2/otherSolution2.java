package otherSolution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class otherSolution2 {


    public int[] solution(int[] array) {
        int[] answer = new int[2];

        int maxNumber = 0;
        List<Integer> arrayInt = new ArrayList<>();
        for (int a : array) {
            arrayInt.add(a);
            maxNumber = Math.max(maxNumber, a);
        }

        answer[0] = maxNumber;
        answer[1] = arrayInt.indexOf(maxNumber);
        return answer;
    }

    /**
     * `Math` 를 이용한 solution
     */
    public static void main(String[] args) {
        int[] array = {1, 8, 3};

        otherSolution2 os2 = new otherSolution2();


        System.out.println(Arrays.toString(os2.solution(array)));

    }
}
