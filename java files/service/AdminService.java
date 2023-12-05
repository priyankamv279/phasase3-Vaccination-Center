package com.example.demo.service;
import com.example.demo.pojo.Admin;
import com.example.demo.repo.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin insert(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin findByUsernameAndPassword(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);
    }
}

