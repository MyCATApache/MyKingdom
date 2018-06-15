package io.imking.common.controller;

import io.imking.utils.Result;
import io.imking.utils.ResultEnum;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class IndexController {

	@GetMapping("/")  
    public String html() {  
        return "/common/html/index.html";  
    }


}
