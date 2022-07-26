package test;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File dir = new File("D:\\Java Learning\\base\\basejava\\basejava");

        printFileNames(dir, "");
    }

    public static void printFileNames(File dir, String indent) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(indent + "File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(indent + "Directory: " + file.getName());
                    printFileNames(file, indent + "  ");
                }
            }
        }
    }
}
