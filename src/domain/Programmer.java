package domain;

import service.Status;

public class Programmer extends Employee{
    private int memberId;
    private Status status;
    private Equipment equipment;

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }


}
