package chapter06;

import java.util.Objects;

public class SenderEndPoint {

    private final User user;
    private final Twootr twootr;


    public SenderEndPoint(User user, Twootr twootr) {
        Objects.requireNonNull(user, "user");
        Objects.requireNonNull(twootr, "twootr");

        this.user = user;
        this.twootr = twootr;
    }

    public  FollowerStatus onFollow(final String userIdToFollow) {
        Objects.requireNonNull(userIdToFollow, "userIdToFollow");

        User user = new User(userIdToFollow);
        return twootr.onFollow(user, userIdToFollow);
    }

}
