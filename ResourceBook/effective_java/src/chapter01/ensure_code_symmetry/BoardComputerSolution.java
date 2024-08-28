package chapter01.ensure_code_symmetry;

import chapter01.common.CruiseControl;
import chapter01.common.User;

import java.util.Objects;

/**
 * 코드 대칭 이루기 - 52page
 */
public class BoardComputerSolution {

    CruiseControl cruiseControl;

    void authorize(User user) {
        Objects.requireNonNull(user);

        if (user.isUnknown()) {
            cruiseControl.logUnauthorizedAccessAttempt();
            return;
        }


        if (user.isAstronaut()) {
            cruiseControl.grantAccess(user);
        } else if (user.isCommander()) {
            cruiseControl.grantAccess(user);
            cruiseControl.grantAdminAccess(user);
        }
    }


}
