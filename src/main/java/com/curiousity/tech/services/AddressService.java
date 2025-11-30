package com.curiousity.tech.services;

import com.curiousity.tech.domain.Address;
import com.curiousity.tech.factory.AddressFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {
    private List<Address> addresses;

    public AddressService() {
        this.addresses = new java.util.ArrayList<>();
    }

    @Override
    public Address createAddress(String street, String city, String province, String postalCode) {
        Address address = AddressFactory.create(street, city, province, postalCode);
        addresses.add(address);
        return address;
    }

    @Override
    public Optional<Address> getAddressById(String id) {
        return addresses.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    @Override
    public List<Address> getAllAddresses() {
        return new java.util.ArrayList<>(addresses);
    }

    @Override
    public List<Address> getAddressesByUserId(String userId) {
        return addresses.stream().filter(a -> a.getId().contains(userId)).toList();
    }

    @Override
    public Address updateAddress(Address address) {
        Optional<Address> existing = getAddressById(address.getId());
        if (existing.isPresent()) {
            addresses.remove(existing.get());
            addresses.add(address);
        }
        return address;
    }

    @Override
    public boolean deleteAddress(String id) {
        return addresses.removeIf(a -> a.getId().equals(id));
    }
}

