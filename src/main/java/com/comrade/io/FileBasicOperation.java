package com.comrade.io;

import java.io.File;
import java.io.IOException;

public class FileBasicOperation {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\dasar\\Downloads\\Screenshot 2025-05-05 164822.png");
        System.out.println(file.isFile());
        try {
            String canonicalPath = file.getCanonicalPath();
            System.out.println(canonicalPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
