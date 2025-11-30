package com.curiousity.tech.factory;

import com.curiousity.tech.domain.Address;
import java.util.UUID;

public class AddressFactory {

    public static Address create(String street, String city, String province, String postalCode) {
        return new Address.Builder()
                .setId(UUID.randomUUID().toString())
                .setStreet(street)
                .setCity(city)
                .setProvince(province)
                .setPostalCode(postalCode)
                .build();
    }

    public static Address copy(Address address) {
        return new Address.Builder()
                .setId(address.getId())
                .setStreet(address.getStreet())
                .setCity(address.getCity())
                .setProvince(address.getProvince())
                .setPostalCode(address.getPostalCode())
                .build();
    }
}

