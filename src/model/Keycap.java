package model;

public class Keycap extends Component {
    private String material;
    private String profile;

    public Keycap() {
    }

    public Keycap(String name, Integer price, byte[] image, String material, String profile) {
        setName(name);
        setPrice(price);
        setImage(image);
        this.material = material;
        this.profile = profile;
    }

    @Override
    public String getDetails() {
        return "Name: " + getName() + "\nPrice: " + getPrice() + "\nMaterial: " + material + "\nProfile: " + profile;
    }

    public String getMaterial() {
        return material;
    }

    public String getProfile() {
        return profile;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
