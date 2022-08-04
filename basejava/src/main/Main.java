package main;

import main.model.Resume;
import main.storage.Storage;

public class Main {

    public static void main(String[] args) {

        Storage storage = Config.get().getStorage();


        Resume resume = new Resume("qwer", "qwewe");

        storage.save(resume);
    }
}
