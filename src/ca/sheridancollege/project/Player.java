package ca.sheridancollege.project;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<UnoCard> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void addCard(UnoCard card) {
        hand.add(card);
    }

    public void removeCard(UnoCard card) {
        hand.remove(card);
    }

    public ArrayList<UnoCard> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public void showHand() {
        for (UnoCard card : hand) {
            System.out.println(card);
        }
    }
}
