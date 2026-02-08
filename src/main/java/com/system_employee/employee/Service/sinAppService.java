package com.system_employee.employee.Service;


import com.system_employee.employee.Dtos.SinApp;
import com.system_employee.employee.Entity.Employee;
import com.system_employee.employee.Entity.userAccount;
import com.system_employee.employee.Repo.SinAppRepo;
import com.system_employee.employee.Repo.employeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class sinAppService {

    @Autowired
    private employeeRepo userAccountRepo;
    @Autowired
    private SinAppRepo SinAppRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public void sinApp(SinApp SinAppRequest) {
        userAccount account = new userAccount();
        Employee e1 = userAccountRepo.findById(SinAppRequest.employee_Id())
                .orElseThrow(() -> new RuntimeException("Employee Id = " + SinAppRequest.employee_Id() + " is Not Found"));
        account.setUsername(SinAppRequest.username());
        account.setPassword(passwordEncoder.encode(SinAppRequest.password()));
        account.setEmployee_Id(e1);
        SinAppRepo.save(account);
    }


}
