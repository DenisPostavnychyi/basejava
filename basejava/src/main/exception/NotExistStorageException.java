package main.exception;

public class NotExistStorageException extends StorageException{
    public NotExistStorageException(String uuid) {
        super("ResumePrint " + uuid + " not exist");
    }
}