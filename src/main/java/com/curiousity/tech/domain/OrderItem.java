package com.curiousity.tech.domain;

public class OrderItem {
    private String orderId;
    private String quantity;
    private String price;

    protected OrderItem() {
    }

    public OrderItem(Builder builder) {
        this.orderId = builder.orderId;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderId='" + orderId + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public static class Builder {
        private String orderId;
        private String quantity;
        private String price;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setQuantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setPrice(String price) {
            this.price = price;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }

        public Builder copy(OrderItem orderItem) {
            this.orderId = orderItem.orderId;
            this.quantity = orderItem.quantity;
            this.price = orderItem.price;
            return this;
        }
    }
}

