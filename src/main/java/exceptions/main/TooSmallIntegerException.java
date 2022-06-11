package exceptions.main;

public class TooSmallIntegerException extends IllegalArgumentException{
    private int minimalAllowed;

    public TooSmallIntegerException(String message, int minimal) {
        super(message);
        this.minimalAllowed = minimal;
    }

    public int getMinimal(){
        return this.minimalAllowed;
    }
}

