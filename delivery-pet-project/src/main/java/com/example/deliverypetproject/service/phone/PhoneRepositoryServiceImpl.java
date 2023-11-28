package com.example.deliverypetproject.service.phone;

import com.example.deliverypetproject.exception.phone.PhoneNotFoundException;
import com.example.deliverypetproject.model.PhoneNumber;
import com.example.deliverypetproject.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneRepositoryServiceImpl implements PhoneRepositoryService {

    private final PhoneRepository phoneRepository;

    @Override
    public PhoneNumber getPhoneNumberById(Long id) {
        return phoneRepository.getPhoneNumberById(id)
                .orElseThrow(() -> new PhoneNotFoundException("Get-operation", "Number with id: " + id + " is not found"));
    }

    @Override
    public List<PhoneNumber> getPhoneNumbersByUserId(Long userId) {
        return phoneRepository.getPhoneNumbersByUserId(userId)
                .orElseThrow(() -> new PhoneNotFoundException("Get-operation", "Number with user's id " + userId + " is not found"));
    }

}
