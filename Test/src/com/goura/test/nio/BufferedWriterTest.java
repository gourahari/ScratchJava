package com.goura.test.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BufferedWriterTest {

    private static final String BASE_PATH = "C:\\Users\\gourahax\\Desktop\\temp\\PathTest\\testing\\code";

    public static void main(String[] args) throws Exception {
        Path srcPath = Paths.get(BASE_PATH + "\\devramtdomeuaaapp.json");
        Path destPath = Paths.get(BASE_PATH + "\\a.json");
        String line = null;
        BufferedWriter bw = Files.newBufferedWriter(destPath, Charset.defaultCharset(), StandardOpenOption.TRUNCATE_EXISTING);
        BufferedReader br = Files.newBufferedReader(srcPath, Charset.forName("ISO-8859-1"));
        while (null != (line = br.readLine())) {
            System.out.println(line);
            bw.write(line, 0, line.length());
            bw.newLine();
        }
        bw.flush();

    }

}
