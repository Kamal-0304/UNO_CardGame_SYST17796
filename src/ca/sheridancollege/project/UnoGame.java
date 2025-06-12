package ca.sheridancollege.project;


import java.util.ArrayList;
import java.util.Scanner;

public class UnoGame extends Game {
    private GroupOfCards deck;
    private UnoCard topCard;
    private int currentPlayerIndex = 0;
    private boolean reverse = false;

    public UnoGame(ArrayList<Player> players) {
        super(players);
        initializeDeck();
        dealCards();
        topCard = deck.drawCard();
    }

    private void initializeDeck() {
        deck = new GroupOfCards();
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Skip", "Reverse", "Draw Two"};
        for (String color : colors) {
            for (String value : values) {
                deck.addCard(new UnoCard(color, value));
                deck.addCard(new UnoCard(color, value)); // Two of each except 0
            }
        }
        for (int i = 0; i < 4; i++) {
            deck.addCard(new UnoCard("Black", "Wild"));
            deck.addCard(new UnoCard("Black", "Wild Draw Four"));
        }
        deck.shuffle();
    }

    private void dealCards() {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.addCard(deck.drawCard());
            }
        }
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while (!gameWon) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("\nTop Card: " + topCard);
            System.out.println(currentPlayer.getName() + "'s Turn. Your cards:");
            currentPlayer.showHand();
            System.out.println("Choose card index to play (-1 to draw): ");
            int index = scanner.nextInt();

            if (index == -1) {
                UnoCard drawn = deck.drawCard();
                System.out.println("You drew: " + drawn);
                currentPlayer.addCard(drawn);
            } else {
                UnoCard chosen = currentPlayer.getHand().get(index);
                if (chosen.getColor().equals(topCard.getColor()) || chosen.getValue().equals(topCard.getValue()) || chosen.getColor().equals("Black")) {
                    topCard = chosen;
                    currentPlayer.removeCard(chosen);
                    if (currentPlayer.getHand().isEmpty()) {
                        System.out.println(currentPlayer.getName() + " wins the game!");
                        gameWon = true;
                        break;
                    }
                } else {
                    System.out.println("Invalid card. Turn skipped.");
                }
            }

            // Move to next player
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
        scanner.close();
    }
}
