package com.goura.test.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class RecursiveDeleteTest {

    private static final String BASE_PATH = "C:\\Users\\gourahax\\Desktop\\temp\\PathTest\\testing1";

    public static void main(String[] args) throws Exception {
        // Delete a direcory recursively.
        Path dirPath = Paths.get(BASE_PATH);
        Files.walkFileTree(dirPath, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
                if (null == e) {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                } else {
                    throw e;
                }
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
            
        });
    }

}
