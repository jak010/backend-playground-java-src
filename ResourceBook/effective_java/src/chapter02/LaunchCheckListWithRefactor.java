package chapter02;

import java.util.Arrays;
import java.util.List;

// p63
public class LaunchCheckListWithRefactor {

    List<String> checks = Arrays.asList("cabin Pressues",
            "Communication",
            "Engine");

    Status prepareForTakeoff(Commander commander) {
        for (String check : checks) {
            boolean shouldAbortTakeoff = commander.isFailing(check);
            if (shouldAbortTakeoff) {
                return Status.ABORT_TAKE_OFF;
            }
        }
        return Status.READ_FOR_TAKE_OFF;
    }
}
