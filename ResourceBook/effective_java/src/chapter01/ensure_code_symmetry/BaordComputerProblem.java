package chapter01.ensure_code_symmetry;

import chapter01.common.CruiseControl;
import chapter01.common.User;

import java.util.Objects;


public class BaordComputerProblem {

    CruiseControl cruiseControl;

    void authorize(User user) {
        Objects.requireNonNull(user);

        if (user.isUnknown()) {
            cruiseControl.logUnauthorizedAccessAttempt();
        } else if (user.isAstronaut()) {
            cruiseControl.grantAccess(user);
        } else if (user.isCommander()) {
            cruiseControl.grantAccess(user);
            cruiseControl.grantAdminAccess(user);
        }
    }
}
