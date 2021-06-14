package com.example.meetingOfficePlanner.meetingOfficePlanner.service;
import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.Company;
import com.example.meetingOfficePlanner.meetingOfficePlanner.exception.CompanyNotFoundException;
import com.example.meetingOfficePlanner.meetingOfficePlanner.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyService() {
    }

    public List<Company> getCompanies(){
        return companyRepository.findAll();

    }
    public Company getCompany(int companyId) throws CompanyNotFoundException {
        return companyRepository.findById(companyId).orElseThrow(()->new CompanyNotFoundException(companyId));

    }
    public Company addCompany(Company company){
        return companyRepository.save(company);
    }
    public Company updateCompany(int companyId,Company companyDetails) throws CompanyNotFoundException {
        Company company=companyRepository.findById(companyId).orElseThrow(()-> new CompanyNotFoundException(companyId));
        company.setCompanyId(companyDetails.getCompanyId());
        company.setCompanyName(companyDetails.getCompanyName());
        Company updatedCompany=companyRepository.save(company);
        return updatedCompany;
    }
}
