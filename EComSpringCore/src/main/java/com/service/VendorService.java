package com.service;

import com.exception.InvalidListException;
import com.model.Vendor;
import com.repository.VendorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    private final VendorRepo vendorRepo;
    public VendorService(VendorRepo vendorRepo){
        this.vendorRepo = vendorRepo;
    }
    public List<Vendor> getVendors() {
        return vendorRepo.getAllVendors();
    }

    public Vendor getVendorsById(int vendorId) {
        List<Vendor> vendorList = vendorRepo.getVendorsById(vendorId);
        if(vendorList == null || vendorList.isEmpty()){
            throw new InvalidListException("List given is Empty or null");
        }
        return vendorList.getFirst();
    }
}
