package com.system_employee.employee.Repo;


import com.system_employee.employee.Entity.userAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinAppRepo extends JpaRepository<userAccount, Integer> {

}
