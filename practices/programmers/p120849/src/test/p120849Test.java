package test;


import org.junit.jupiter.api.*;
import solution.Solution;


public class p120849Test {


    @Test
    @DisplayName("Test Case : bus")
    public void case01() {
        Solution s = new Solution();
        Assertions.assertEquals("bs", s.solution("bus"));
    }

    @Test
    @DisplayName("Test Case : nice to meet you")
    public void case02() {
        Solution s = new Solution();
        Assertions.assertEquals("nc t mt y", s.solution("nice to meet you"));
    }

}
