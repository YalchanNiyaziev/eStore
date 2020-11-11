package com.yalco.estore.exception;

public class ElementNotFoundByIdException extends Exception{
  private String id;

    public ElementNotFoundByIdException(String message, String id) {
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
