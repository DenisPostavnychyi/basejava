package main.exception;

import java.io.IOException;
import java.sql.SQLException;

public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, String name, IOException e) {
    }

    public StorageException(String message, String name) {
    }

    public StorageException(String message, IOException e) {
    }

    public StorageException(String message, ClassNotFoundException e) {
    }

    public StorageException(SQLException e) {
    }
}