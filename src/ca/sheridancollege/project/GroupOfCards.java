package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {
    private ArrayList<UnoCard> cards;

    public GroupOfCards() {
        cards = new ArrayList<>();
    }

    public void addCard(UnoCard card) {
        cards.add(card);
    }

    public UnoCard drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public ArrayList<UnoCard> getCards() {
        return cards;
    }
}
