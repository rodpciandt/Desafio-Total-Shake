package br.com.desafio.totalshake.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;

@RestController
@RequestMapping("")
public class TotalShakeController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public HashMap<String, Object> healtCheck() {
        var response = new HashMap<String, Object>();

        response.put("api", "Total Shake API");
        response.put("status", 200);
        response.put("timestamp", LocalDateTime.now());
        return response;
    }

    @GetMapping(value = "/hello-world")
    public String helloWorld(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {

        return messageSource.getMessage("hello.world.message",
                null,
                "Default Message",
                locale); //  LocaleContextHolder.getLocale()




    }

}
