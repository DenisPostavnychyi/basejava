package main.exception;

public class ExistStorageException extends StorageException{
    public ExistStorageException(String uuid){
        super("ResumePrint " + uuid + " already exist");
    }
}