package chapter04;

import java.io.*;

import java.io.IOException;

public interface Importer {

    Document importFile(File file) throws IOException;

}
