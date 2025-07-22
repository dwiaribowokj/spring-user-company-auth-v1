package com.company.user.auth.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.company.user.auth.v1",
        "com.company.user.lib.core.v1"
})
public class UserCompanyAuthV1Application {

    public static void main(String[] args) {
        SpringApplication.run(UserCompanyAuthV1Application.class, args);
    }

}
