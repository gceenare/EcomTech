package com.curiousity.tech.domain;

public class Order {

    private String Id;
    private String Date;
    private String totalAmount;
    private String status;

    protected Order() {
    }
    public Order(Builder builder) {
        this.Id = builder.Id;
        this.Date = builder.Date;
        this.totalAmount = builder.totalAmount;
        this.status = builder.status;
    }
    public String getId() {
        return Id;
    }
    public String getDate() {
        return Date;
    }
    public String getTotalAmount() {
        return totalAmount;
    }
    public String getStatus() {
        return status;
    }
    @Override
    public String toString() {
        return "Order{" +
                "Id='" + Id + '\'' +
                ", Date='" + Date + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", status='" + status + '\'' +
                '}';}
    public static class Builder {
        private String Id;
        private String Date;
        private String totalAmount;
        private String status;
        public Builder setId(String Id) {
            this.Id = Id;
            return this;
        }
        public Builder setDate(String Date) {
            this.Date = Date;
            return this;
        }
        public Builder setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
            return this;

        }
        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }
        public Order build() {
            return new Order(this);


    }

        public Builder copy(Order order) {
            this.Id = order.Id;
            this.Date = order.Date;
            this.totalAmount = order.totalAmount;
            this.status = order.status;
            return this;
        }
    }

}
