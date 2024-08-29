package chapter06;

import java.util.Objects;
import java.util.Optional;

public class Twootr {


    public Optional<SenderEndPoint> onLogon(
            final String userId,
            final String password,
            final RecevierEndPoint recevierEndPoint
    ) {
        Objects.requireNonNull(userId, "userId");
        Objects.requireNonNull(password, "password");


        User user = new User(userId);

        return Optional.of(new SenderEndPoint(user, this));
    }

    public FollowerStatus onFollow(final User follow, final String userIdToFollow) {
        return FollowerStatus.SUCCESS;
    }


}
