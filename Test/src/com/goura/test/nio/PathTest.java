package com.goura.test.nio;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

    private static final String BASE_PATH = "C:\\Users\\gourahax\\Desktop\\temp\\PathTest";

    public static void main(String[] args) throws Exception {
        Path dirPath = Paths.get(BASE_PATH + "\\testing");
        // Create a directoy.
        Files.createDirectories(dirPath);

        // Create a file.
        Path filePath = FileSystems.getDefault().getPath(BASE_PATH + "\\testing\\test.txt");
        Path file = Files.createFile(filePath);

        // Copy a file
        Path filePath2 = FileSystems.getDefault().getPath(BASE_PATH + "\\testing\\test1.txt");
        Files.copy(file, filePath2);

        // Copy a Directory
        Path srcDir = FileSystems.getDefault().getPath(BASE_PATH + "\\testing");
        Path destDir = FileSystems.getDefault().getPath(BASE_PATH + "\\testing1");
        Files.copy(srcDir, destDir);
    }

}
