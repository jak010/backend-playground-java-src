package otherSolution;

import java.util.Arrays;

public class OtherSolution {

    /**
     * 배열을 이용한 풀이
     */
    public void otherSolution(int[] array) {


        int[] answer = new int[2];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > answer[0]) {
                answer[0] = array[i];
                answer[1] = i;
            }
        }

        for (int e : answer) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        int[] array = {1, 8, 3};

        OtherSolution os = new OtherSolution();
        os.otherSolution(array);


    }

}
