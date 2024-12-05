package com.cardability.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {


    @Autowired
    private CardRepository cardRepository;

    public Card createCard(Card card){
        return cardRepository.save(card);
    }
    public Optional<Card> findCardById(Long Id) {return cardRepository.findById(Id);}

    public void changeCardName(Long cardId, String name) {
        cardRepository.findById(cardId).ifPresent(card -> {
            card.setName(name);
            cardRepository.updateCardName(card.getName(), card.getId());
        });
    }

    public void changeCardDescription(Long cardId, String description) {
        cardRepository.findById(cardId).ifPresent(card -> {
            card.setDescription(description);
            cardRepository.updateCardDescription(card.getDescription(), card.getId());
        });
    }

    public void changeCardColor(Long cardId, int r, int g, int b) {
        cardRepository.findById(cardId).ifPresent(card -> {
            card.setR(r);
            card.setG(g);
            card.setB(b);
            cardRepository.updateCardColor(r, g, b, card.getId());
        });
    }

    public void deleteCard(Long cardId) {
        cardRepository.findById(cardId).ifPresent(cardRepository::delete);
    }

}
