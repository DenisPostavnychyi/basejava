package main.exception;

public class NotExistStorageException extends StorageException{
    public NotExistStorageException(String uuid) {
        super("ResumeService " + uuid + " not exist");
    }
}