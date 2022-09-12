package info.bessonov.supporttelegrambot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperatorController {

    @GetMapping("/updateChat")
    public List<String> updateChat() {
        return null;
    }
}
