package com.khepri.black.filesystem;

import java.io.*;
import java.util.List;

public class FileSystemService {
    public static Integer executeCommand(List<String> command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command(command);
            Process process = processBuilder.start();
            InputStream inputStream = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();
            return process.exitValue();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
