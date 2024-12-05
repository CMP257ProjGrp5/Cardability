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
    public Card findCardById(Long Id) {return cardRepository.findOne(Id);}

    public void changeCardName(Long cardId, String name){
        Card card = cardRepository.findOne(cardId);
        card.setName(name);
        cardRepository.updateCard(card.getName(),card.getId());
    }

    public void changeCardDescription(Long cardId, String descrption){
        Card card = cardRepository.findOne(cardId);
        card.setDescription(descrption);
        cardRepository.updateCard(card.getId(),card.getDescription());
    }

    public void changeCardColor(Long cardId, int r, int g, int b){
        Card card = cardRepository.findOne(cardId);
        card.setColorR(r);
        card.setColorG(g);
        card.setColorB(b);
        cardRepository.updateCard(r,g,b,card.getId());
    }

    public void deleteCard(Long cardId){
        Card card=cardRepository.findOne(cardId);
        cardRepository.delete(card);
    }

}
