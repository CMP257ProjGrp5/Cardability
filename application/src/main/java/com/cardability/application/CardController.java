package com.cardability.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CardController {

    @Autowired
    private CardRepository cardRepository;


    @PostMapping
    Card newCard(@RequestBody Card newCard) {
        return cardRepository.save(newCard);
    }
}