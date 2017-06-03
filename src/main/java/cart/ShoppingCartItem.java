package cart;

import dto.ProductData;

public class ShoppingCartItem {

    ProductData productData;
    short quantity;

    public ShoppingCartItem(ProductData productData) {
        this.productData = productData;
        quantity = 1;
    }

    public ProductData getProduct() {
        return productData;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public double getTotal() {
        double amount = 0;
        amount = (this.getQuantity() * productData.getPrice().doubleValue());
        return amount;
    }

}