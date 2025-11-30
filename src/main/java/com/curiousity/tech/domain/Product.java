package com.curiousity.tech.domain;

public class Product {

    private String id;
    private String name;
    private String description;
   private String price;
   private String stockQuantity;
   private String imageUrl;


   protected Product () {
   }

    public Product (Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
        this.imageUrl = builder.imageUrl;
    }
    public String getId () {
        return id;
    }
    public String getName () {
        return name;
    }
    public String getDescription () {
        return description;
    }
    public String getPrice () {
        return price;
    }
    public String getStockQuantity () {
        return stockQuantity;
    }
    public String getImageUrl () {
        return imageUrl;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", stockQuantity='" + stockQuantity + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';

    }
    public static class Builder {
        private String id;
        private String name;
        private String description;
        private String price;
        private String stockQuantity;
        private String imageUrl;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(String price) {
            this.price = price;
            return this;
        }

        public Builder setStockQuantity(String stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    public Builder copy(Product product) {
            this.id = product.id;
            this.name = product.name;
            this.description = product.description;
            this.price = product.price;
            this.stockQuantity = product.stockQuantity;
            this.imageUrl = product.imageUrl;
            return this;
        }
    }

}
