package model;

public abstract class Component {
    private Integer id;
    private String name;
    private Integer price;
    private byte[] image;

    public Component() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public abstract String getDetails();
}
