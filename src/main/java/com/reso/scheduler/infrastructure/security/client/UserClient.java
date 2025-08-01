package com.reso.scheduler.infrastructure.security.client;

import com.reso.scheduler.business.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "users", url= "${user.url}")
public interface UserClient {

    @GetMapping("/users")
    UserDTO findUserByEmail(@RequestParam("email") String email,
                            @RequestHeader("Authorization") String token);

}
