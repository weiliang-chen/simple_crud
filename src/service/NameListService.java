package service;

import domain.*;

import static service.Data.*;

public class NameListService {

    private Employee[] employees;

    public NameListService() {
        // construct employees size array by the number of data in Data class
        // according to the type to construct different instances, including Employee, Designer, Architect, or Programmer.
        // put the created objects in the array
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < EMPLOYEES.length; i++) {
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            // get Employee data
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][1]);
            Equipment equipment;
            double bonus;
            int stock;

            switch(type) {
                case EMPLOYEE -> {
                    employees[i] = new Employee(id, name, age, salary);
                }
                case PROGRAMMER -> {
                    equipment  = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);

                }
                case DESIGNER -> {
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                }
                case ARCHITECT -> {
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                }
            }
        }
    }

    public Employee[] getAllEmployees(){
        return  employees;
    }

    public Employee getEmployeeById(int id) {
        return null;
    }

    /**
     * create equipment object in the Data class base on the input index
     * @param index the index of equipment in the data, corresponding to the employee index
     * @return the created equipment.
     */
    private Equipment createEquipment(int index) {
        int key = Integer.parseInt(EQUIPMENTS[index][0]);
        String modelOrName = EQUIPMENTS[index][1];
        switch (key) {
            case PC : // 21
                String display = EQUIPMENTS[index][2];
                return new domain.PC(modelOrName, display);
            case NOTEBOOK: // 22
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(modelOrName, price);
            case PRINTER: // 23
                String type = EQUIPMENTS[index][2];
                return new printer(modelOrName, type);
        }
        return null;
    }
}
