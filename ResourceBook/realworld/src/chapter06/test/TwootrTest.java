package chapter06.test;

import chapter06.RecevierEndPoint;
import chapter06.SenderEndPoint;

import static chapter06.TestData.*;

import chapter06.TestData;
import chapter06.Twootr;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class TwootrTest {

    private Twootr twootr;

    @Before
    public void setUp() {
        twootr = new Twootr();
    }

    //  151page
    @Test
    public void shouldBeAbleToAuthenticateUser() {

        // 유효 사용자의 로그온 메시지 수신

        // 로그온 메서드는 새 엔드포인트 반환

        // 엔드포인트 유효성을 확인하는 어서션
    }

    @Test
    public void shouldNotAuthenticateUserWithWrongPassword() {
        final Optional<SenderEndPoint> endPoint = twootr.onLogon(
                TestData.USER_ID, "bad password", new RecevierEndPoint()
        );

        assertFalse(endPoint.isPresent());
    }


    private SenderEndPoint login(String userId, RecevierEndPoint recevier) {

        final Optional<SenderEndPoint> endPoint = twootr.onLogon(userId, "123", recevier);
        assertTrue(endPoint.isPresent(), "Failed to login");
        return endPoint.get();
    }


}
