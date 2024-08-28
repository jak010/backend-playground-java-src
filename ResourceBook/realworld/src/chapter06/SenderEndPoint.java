package chapter06;

import java.util.Objects;

public class SenderEndPoint {

    private final User user;
    private final Twootr twootr;


    public SenderEndPoint(User user, Twootr twootr) {
        Objects.requireNonNull(user);
        Objects.requireNonNull(twootr);

        this.user = user;
        this.twootr = twootr;
    }


}
