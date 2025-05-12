package model;

public class Switch extends Component {
    private String type;
    private String actuationForce;

    public Switch() {
    }

    public Switch(String name, Integer price, byte[] image, String type, String actuationForce) {
        setName(name);
        setPrice(price);
        setImage(image);
        this.type = type;
        this.actuationForce = actuationForce;
    }

    @Override
    public String getDetails() {
        return "Name: " + getName() + "\nPrice: " + getPrice() + "\nSwitch type: " + type + "\nActuation force: " + actuationForce;
    }

    public String getType() {
        return type;
    }

    public String getActuationForce() {
        return actuationForce;
    }

    public void setActuationForce(String actuation_force) {
        this.actuationForce = actuation_force;
    }

    public void setType(String type) {
        this.type = type;
    }
}
