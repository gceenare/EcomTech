package com.curiousity.tech.services;

import com.curiousity.tech.domain.Address;
import java.util.List;
import java.util.Optional;

public interface IAddressService {
    Address createAddress(String street, String city, String province, String postalCode);
    Optional<Address> getAddressById(String id);
    List<Address> getAllAddresses();
    List<Address> getAddressesByUserId(String userId);
    Address updateAddress(Address address);
    boolean deleteAddress(String id);
}

