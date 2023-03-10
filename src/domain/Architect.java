package domain;

public class Architect extends Designer{
    private double stock;


    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, double stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }
}
