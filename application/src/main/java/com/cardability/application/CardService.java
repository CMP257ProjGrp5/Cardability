package com.cardability.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {


    @Autowired
    private CardRepository cardRepository;

    public Card createCard(Card card){
        return cardRepository.save(card);
    }

    public void changeCardName(Card card, String name){
        card.setName(name);
    }

    public void changeCardDescription(Long cardId, String descrption){
        Card card = cardRepository.findOne(cardId);
        card.setDescription(descrption);
    }

    public void changeCardColor(Long cardId, int r, int g, int b){
        Card card = cardRepository.findOne(cardId);
        card.setColorR(r);
        card.setColorG(g);
        card.setColorB(b);

    }

    
}
