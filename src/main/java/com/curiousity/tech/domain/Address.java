package com.curiousity.tech.domain;

public class Address {

    private String id;
    private String street;
    private String city;
    private String province;
    private String postalCode;


    protected Address() {
    }

    public Address(Builder builder) {
        this.id = builder.id;
        this.street = builder.street;
        this.city = builder.city;
        this.province = builder.province;
        this.postalCode = builder.postalCode;
    }

    public String getId() {
        return id;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;



    }
    public String getProvince() {
        return province;
    }
    public String getPostalCode() {
        return postalCode;

    }

    @Override
    public String toString() {
        return "AddressRepository{" +
                "id='" + id + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String street;
        private String city;
        private String province;
        private String postalCode;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Address build() {
            return new Address(this);
        }

        public Builder copy() {
            return new Builder()
                    .setId(this.id)
                    .setStreet(this.street)
                    .setCity(this.city)
                    .setProvince(this.province)
                    .setPostalCode(this.postalCode);
        }

    }

}
