package com.curiousity.tech.controller;

import com.curiousity.tech.services.AddressService;
import com.curiousity.tech.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class AddressController {
    @Autowired
    private AddressService addressService;


    public Address createAddress(String street, String city, String province, String postalCode) {
        return addressService.createAddress(street, city, province, postalCode);
    }

    public Optional<Address> getAddressById(String id) {
        return addressService.getAddressById(id);
    }

    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    public List<Address> getAddressesByUserId(String userId) {
        return addressService.getAddressesByUserId(userId);
    }

    public Address updateAddress(Address address) {
        return addressService.updateAddress(address);
    }

    public boolean deleteAddress(String id) {
        return addressService.deleteAddress(id);
    }
}

