package com.curiousity.tech.domain;

public class CartItem {

    private String id;
    private int quantity;

    protected CartItem() {
    }
    public CartItem(Builder builder) {
        this.id = builder.id;
        this.quantity = builder.quantity;
    }
    public String getId() {
        return id;
    }
    public int getQuantity() {
        return quantity;
    }
    @Override
    public String toString() {
        return "CartItem{" +
                "id='" + id + '\'' +
                ", quantity=" + quantity +
                '}';}
    public static class Builder {
        private String id;
        private int quantity;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public CartItem build() {
            return new CartItem(this);
        }

        public Builder copy(CartItem cartItem) {
            this.id = cartItem.id;
            this.quantity = cartItem.quantity;
            return this;
        }
    }

}
