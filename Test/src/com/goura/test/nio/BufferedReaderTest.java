package com.goura.test.nio;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedReaderTest {

    private static final String BASE_PATH = "C:\\Users\\gourahax\\Desktop\\temp\\PathTest\\testing\\code\\devramtdomeuaaapp.json";

    public static void main(String[] args) throws Exception {
        Path filePath = Paths.get(BASE_PATH);
        String line = null;
        try(BufferedReader br = Files.newBufferedReader(filePath, Charset.forName("ISO-8859-1"))) {
            while(null != (line = br.readLine())) {
                System.out.println(line);
            }
        }
    }

}
