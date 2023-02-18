package project02;

public class DishMenu {
    private int code;

    private String name;

    private double price;
    public DishMenu(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
    public int getCode() {
        return code;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price ;
    }
}
