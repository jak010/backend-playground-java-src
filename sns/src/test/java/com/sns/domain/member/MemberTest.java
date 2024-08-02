package com.sns.domain.member;

import com.sns.util.MemberFixtureFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MemberTest {

    @DisplayName("회원은 닉네임을 변경할 수 있다.")
    @Test
    public void testChagneName() {
        var member = MemberFixtureFactory.create();
        var expected = "changeName";
        member.changeNickName(expected);
        Assertions.assertEquals(expected, member.getNickname());
    }

    @DisplayName("회원의 닉네임은 10자를 초과할 수 없다.")
    @Test
    public void testNickNameMaxxLength() {
        var member = MemberFixtureFactory.create(123L);
        var overMaxLength = "changeNamechagneName";

        Assertions.assertThrows(
                IllegalArgumentException.class, () -> {
                    member.changeNickName(overMaxLength);
                });
    }

}
