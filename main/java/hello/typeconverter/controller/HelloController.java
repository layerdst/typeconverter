package hello.typeconverter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest req){
        String data = req.getParameter("data");
        Integer intValue = Integer.valueOf(data);
        System.out.println(intValue);
        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        System.out.println(data);
        return "ok";
    }
}
