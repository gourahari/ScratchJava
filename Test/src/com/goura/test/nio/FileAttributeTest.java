package com.goura.test.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

public class FileAttributeTest {

    private static final String BASE_PATH = "C:\\Users\\gourahax\\Desktop\\temp\\PathTest\\testing\\code\\devramtdomeuaaapp.json";

    public static void main(String[] args) throws Exception {
        Path filePath = Paths.get(BASE_PATH);
        BasicFileAttributeView view = Files.getFileAttributeView(filePath, BasicFileAttributeView.class);
        BasicFileAttributes attr = view.readAttributes();
        System.out.println("Last access time: " + attr.lastAccessTime());
        System.out.println("Last modified time: " + attr.lastModifiedTime());
        System.out.println("Creation time: " + attr.creationTime());
        System.out.println("Directory? " + attr.isDirectory());
        System.out.println("Regular file? " + attr.isRegularFile());
        System.out.println("Symbolic link? " + attr.isSymbolicLink());
    }

}
