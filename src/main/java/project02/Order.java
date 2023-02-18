package project02;

public class Order {
    public static void main(String[] args) {

        System.out.println();
    }
    public int orderCode;

    public DishMenu dish;
    public double dishPrice;

    public CafeMenu cafe;
    public  double cafePrice;

    public double orderPrice;

    public int numOfProduct;


    public Order(CafeMenu cafe, int numOfProduct) {

        this.cafe = cafe;
        this.numOfProduct = numOfProduct;
        this.orderPrice = this.cafe.getPrice()*this.numOfProduct;
    }

    public Order(DishMenu dish, int numOfProduct) {
        this.dish = dish;
        this.numOfProduct = numOfProduct;
        this.orderPrice = this.dish.getPrice()*this.numOfProduct;
    }

    public void setOrderCode(int orderCode){
        this.orderCode=orderCode;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderCode=" + orderCode +
                ", dish=" + dish +
                ", dishPrice=" + dishPrice +
                ", cafe=" + cafe +
                ", cafePrice=" + cafePrice +
                ", orderPrice=" + orderPrice +
                ", numOfProduct=" + numOfProduct +
                '}';
    }
}
