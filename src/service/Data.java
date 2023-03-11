package service;

    public class Data {
        public static final int EMPLOYEE = 10;
        public static final int PROGRAMMER = 11;
        public static final int DESIGNER = 12;
        public static final int ARCHITECT = 13;

        public static final int PC = 21;
        public static final int NOTEBOOK = 22;
        public static final int PRINTER = 23;

        //Employee  :  10, id, name, age, salary
        //Programmer:  11, id, name, age, salary
        //Designer  :  12, id, name, age, salary, bonus
        //Architect :  13, id, name, age, salary, bonus, stock
        public static final String[][] EMPLOYEES = {
                {"10", "1", "aa", "22", "3000"},
                {"13", "2", "bb", "32", "18000", "15000", "2000"},
                {"11", "3", "cc", "23", "7000"},
                {"11", "4", "dd", "24", "7300"},
                {"12", "5", "ee", "28", "10000", "5000"},
                {"11", "6", "ff", "22", "6800"},
                {"12", "7", "gg", "29", "10800","5200"},
                {"13", "8", "hh", "30", "19800", "15000", "2500"},
                {"12", "9", "ii", "26", "9800", "5500"},
                {"11", "10", "jj", "21", "6600"},
                {"11", "11", "kk", "25", "7100"},
                {"12", "12", "ll", "27", "9600", "4800"}
        };

        //the element in EQUIPMENTS array match with the element in EMPLOYEES array
        //PC      :21, model, display
        //NoteBook:22, model, price
        //Printer :23, name, type
        public static final String[][] EQUIPMENTS = {
                {},
                {"22", "LenovoT4", "6000"},
                {"21", "Dell", "NEC17"},
                {"21", "Dell", "Samsung 17 inch"},
                {"23", "Canon 2900", "laser"},
                {"21", "ASUS", "Samsung 17 inch"},
                {"21", "ASUS", "Samsung 17 inch"},
                {"23", "EPSON20K", "needle"},
                {"22", "HPm6", "5800"},
                {"21", "Dell", "NEC 17 inch"},
                {"21", "ASUS","Samsung inch"},
                {"22", "HPm6", "5800"}
        };
    }
