package solution;

/** Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/120849
 */
public class Solution {

    public String solution(String my_string) {
        char[] removeTargets = {'a', 'e', 'i', 'o', 'u'};

        for (int i = 0; i < my_string.length(); i++) {
            for (char ch : removeTargets) {
                my_string = my_string.replace(String.valueOf(ch), "");
            }
        }

        return my_string;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("bus"));
        System.out.println(s.solution("nice to meet you"));
    }

}
