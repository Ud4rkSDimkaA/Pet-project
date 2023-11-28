package com.example.deliverypetproject.service.phone;

import com.example.deliverypetproject.model.PhoneNumber;

import java.util.List;
import java.util.Optional;

public interface PhoneRepositoryService {
    public PhoneNumber getPhoneNumberById(Long id);

    public List<PhoneNumber> getPhoneNumbersByUserId(Long userId);
}
