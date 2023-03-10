package service;

/**
 * @Description display the status of employee
 * @author Weiliang Chen
 *
 */
public class Status {
    private final String NAME;

    private Status(String name){
        this.NAME = name;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VACATION = new Status("VACATION");


}
