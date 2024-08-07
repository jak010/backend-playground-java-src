package avoid_nullpointer_exception_in_conditions;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Collections;

public class LogBackProblem {

    /**
     *  NullPointerException 문제
     *  - message or location이 null이면 NullPointerException이 터짐
     * */
    void writeMessage(String message, Path location) throws IOException {

        if (Files.isDirectory(location)) {
            throw new IllegalArgumentException("The Path is invalid!");
        }

        if (message.trim().equals("") || message == null) {
            throw new IllegalArgumentException("The Message is invalid");
        }

        String entry = LocalDate.now() + ":" + message;
        Files.write(
                location,
                Collections.singletonList(entry),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }
}
