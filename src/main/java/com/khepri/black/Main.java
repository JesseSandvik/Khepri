package com.khepri.black;

import com.khepri.black.services.json.IJsonService;
import com.khepri.black.services.json.JsonServiceImpl;
import com.khepri.black.services.systems.file.IFileSystemService;
import com.khepri.black.services.systems.file.FileSystemServiceImpl;

import java.util.Properties;

public class Main {
    private static final IFileSystemService fileSystemService = new FileSystemServiceImpl();
    private static final IJsonService jsonService = new JsonServiceImpl();
    public static void main(String[] args) {
        Properties properties = fileSystemService.getPropertiesFromJsonFile("khepri.json");
        System.out.println(" - [ Welcome to Khepri Black ] ----------------------------------------------------\n");
        System.out.println("   [ USER INFORMATION ]");
        System.out.println("        > NAME:  " + properties.getProperty("user.name"));
        System.out.println("        > EMAIL: " + properties.getProperty("user.email"));
        System.out.println("        > AGE:   " + properties.getProperty("user.age"));
        System.out.println("\n");
    }
}
