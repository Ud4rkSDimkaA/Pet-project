package com.example.deliverypetproject.repository;

import com.example.deliverypetproject.model.Address;
import com.example.deliverypetproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Long> {
    Optional<List<Address>> getAddressByCity(String city);
    Optional<List<Address>> getAddressByCountry(String country);
    Optional<List<Address>> getAddressByUser(User user);
}
