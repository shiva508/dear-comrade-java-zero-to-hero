package com.comrade.io;

import org.apache.tika.Tika;

import java.io.*;

public class ReadingFile {
    public static void main(String[] args) throws IOException {
        byte[] fileInputStream = readFileAsByteArray("C:\\Users\\dasar\\Downloads\\Screenshot 2025-05-05 164822.png");
        InputStream inputStream = new ByteArrayInputStream(fileInputStream);
        Tika tika = new Tika();
        String detect = tika.detect(inputStream);
        System.out.println(detect);
    }

    public static byte [] readFileAsByteArray(String filePath){
        try(InputStream fileInputStream = new FileInputStream(filePath)) {
            return fileInputStream.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
