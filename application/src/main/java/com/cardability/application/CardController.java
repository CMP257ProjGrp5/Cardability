package com.cardability.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

@Controller
public class CardController {

    @Autowired
    private CardService cardService;


    @PostMapping
    public Card createCard(@RequestBody Card newCard) {return cardService.createCard(newCard);}

    @GetMapping("/user/{cardId}")
    public Card getCard(@PathVariable Long cardId) {return cardService.findCardById(cardId);}

    @PutMapping("user/{cardId}")
    public Card updateCard(@PathVariable Long cardId, @RequestBody Card card){
        cardService.changeCardColor(cardId, card.getColorR(), card.getColorG(), card.getColorB());
        cardService.changeCardName(cardId, card.getName());
        cardService.changeCardDescription(cardId, card.getDescription());
        return card;
    }

    @DeleteMapping("user/{cardId}")
    public void deleteCard(@PathVariable Long cardId){cardService.deleteCard(cardId);}


}