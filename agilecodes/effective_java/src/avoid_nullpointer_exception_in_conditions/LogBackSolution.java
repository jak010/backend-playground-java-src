package avoid_nullpointer_exception_in_conditions;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Collections;

/**
 * 조건문에서 NullPointerException 피하기
 */
public class LogBackSolution {


    void writeMessage(String message, Path location) throws IOException {
        /* if 문에 null을 검사하는 로직을 넣자. */
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("The Message is invalid");
        }
        if (location == null || Files.isDirectory(location)) {
            throw new IllegalArgumentException("The Path is invalid!");
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
