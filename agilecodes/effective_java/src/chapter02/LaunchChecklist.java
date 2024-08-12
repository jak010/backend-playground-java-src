package chapter02;

import java.util.Arrays;
import java.util.List;

// p62
public class LaunchChecklist {


    List<String> checks = Arrays.asList("cabin Pressues", "Communication", "Engine");


    Status prepareForTakeOff(Commander commander) {
        for (int i = 0; i < checks.size(); i++) {
            boolean shouldAbortTakeoff = commander.isFailing(checks.get(i));
            if (shouldAbortTakeoff) {
                return Status.ABORT_TAKE_OFF;
            }
        }
        return Status.READ_FOR_TAKE_OFF;
    }

}

