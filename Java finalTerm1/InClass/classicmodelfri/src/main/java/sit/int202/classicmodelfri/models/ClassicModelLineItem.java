package sit.int202.classicmodelfri.models;

import sit.int202.classicmodelfri.entities.Product;


public class ClassicModelLineItem implements CartItem {
    private Product product;
    private int quantity;
    private double percentDiscount;

    public ClassicModelLineItem(Product product) {
        this(product, 1, 0.0);
    }

    public ClassicModelLineItem(Product product, int quantity) {

        this(product, quantity, 0.0);
    }

    public ClassicModelLineItem(Product product, int quantity, double percentDiscount) {
        this.product = product;
        this.quantity = quantity;
        this.percentDiscount = percentDiscount;
    }

    public Product getProduct() {
        return product; //รายitemนี้productเป็นอะไร
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getUnitPrice() {
        return this.product.getPrice();
    }

    @Override
    public double getTotal() {
        return this.quantity*getUnitPrice();
    }

    @Override
    public double getPercentDiscount() {
        return getUnitPrice()*this.quantity-
                this.quantity*getUnitPrice()*this.percentDiscount;
    }

    @Override
    public String toString() {
        return  '{' + product.getProductName() + ", "
                + getUnitPrice() + ", " + quantity + ", "
                + percentDiscount +
                "% }";
    }
}
