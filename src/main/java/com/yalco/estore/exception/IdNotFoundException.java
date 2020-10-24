package com.yalco.estore.exception;

public class IdNotFoundException extends Exception{
  private String id;

    public IdNotFoundException(String message, String id) {
        super(message);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return super.getMessage()+getId();
    }
}
