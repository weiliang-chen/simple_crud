package domain;

public class PC implements Equipment{

    public String model;
    public String display;

    public PC(String model, String display){
        this.model = model;
        this.display = display;
    }

    @Override
    public String getDescription() {
        return getModel() + "(" + getDisplay() + ")";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
