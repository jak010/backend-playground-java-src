package solution;

public class Solution {

    /**
     *  https://school.programmers.co.kr/learn/courses/30/lessons/120899
     * */
    public int[] solution(int[] array) {

        int current_max = 0;
        int current_index = 0;

        int[] answer = {0, 0};

        for (int i = 0; i < array.length; i++) {
            if (current_max < array[i]) {
                current_max = array[i];
                current_index = i;
            }
        }

        answer[0] = current_max;
        answer[1] = current_index;
        return array;
    }

    public static void main(String[] args) {

        int[] array = {1, 8, 3};

        Solution s = new Solution();
        s.solution(array);


    }

}
