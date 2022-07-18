package main.exception;

public class ExistStorageException extends StorageException{
    public ExistStorageException(String uuid){
        super("ResumeService " + uuid + " already exist");
    }
}