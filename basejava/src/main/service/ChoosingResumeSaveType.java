package main.service;

import main.storage.FileStorage;
import main.storage.PathStorage;
import main.storage.Storage;
import main.storage.serializer.ObjectStreamSerializer;

import java.io.File;
import java.util.Scanner;

public class ChoosingResumeSaveType {
    private Storage storage;
    private String directory;

    public ChoosingResumeSaveType(String directory){
        storage = new FileStorage(new File(directory));
        this.directory = directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void strategySaveInFile(){
        System.out.println("Choose a saving method");
        System.out.println("1 - FileStorage");
        System.out.println("2 - PathStorage");

        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1:
                storage = new FileStorage(new File(directory));
                break;
            case 2:
                storage = new PathStorage(directory, new ObjectStreamSerializer());
                break;
        }
    }
}
