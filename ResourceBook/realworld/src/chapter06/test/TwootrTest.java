package chapter06.test;

import chapter06.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;


public class TwootrTest {

    private Twootr twootr;

    private final RecevierEndPoint recevierEndPoint = mock(RecevierEndPoint.class);


    @BeforeEach // Junit5
    public void setUp() {
        this.twootr = new Twootr();
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
//        Twootr twootr = new Twootr();

        final Optional<SenderEndPoint> endPoint = twootr.onLogon(
                TestData.USER_ID, "bad password", recevierEndPoint
        );

        assertFalse(endPoint.isPresent());
    }


//    @Test
//    public void shoulFollowValidUser() {
//        logon();
//        final FollowerStatus followerStatus = endPoint.onFollow(TestData.OTHER_USER_ID);
//
//        assertEquals(FollowerStatus.SUCCESS, followerStatus);
//    }


    private SenderEndPoint login(String userId, RecevierEndPoint recevier) {
        Twootr twootr = new Twootr();

        final Optional<SenderEndPoint> endPoint = twootr.onLogon(userId, "123", recevier);
        assertTrue(endPoint.isPresent(), "Failed to login");
        return endPoint.get();
    }


}
