package main.exception;

import java.io.IOException;

public class StorageException extends RuntimeException{
    public StorageException(String message){
        super(message);
    }

    public StorageException(String message, String name, IOException e) {
    }

    public StorageException(String message, String name) {
    }
}