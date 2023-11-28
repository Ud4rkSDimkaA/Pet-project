package com.example.deliverypetproject.repository;

import com.example.deliverypetproject.model.PhoneNumber;
import com.example.deliverypetproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PhoneRepository extends JpaRepository<PhoneNumber, Long> {
    public Optional<PhoneNumber> getPhoneNumberById(Long id);

    public Optional<List<PhoneNumber>> getPhoneNumbersByUserId(Long userId);

    public Optional<PhoneNumber> getPhoneNumberByUserPhoneNumber(Long userPhoneNumber);
}
