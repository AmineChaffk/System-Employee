package com.system_employee.employee.Controller;


import com.system_employee.employee.Dtos.SinApp;
import com.system_employee.employee.Service.sinAppService;
import com.system_employee.employee.Shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auto")
public class AutoController {

    @Autowired
    private sinAppService userAccount;


    @PostMapping("/sinapp")
    public ResponseEntity<GlobalResponse<String>> Login(
            @RequestBody @Valid SinApp SinAppRequest
    ) {
        userAccount.sinApp(SinAppRequest);
        return new ResponseEntity<>(new GlobalResponse<>("Signed Up"), HttpStatus.OK);
    }
}
