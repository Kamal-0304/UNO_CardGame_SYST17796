package ca.sheridancollege.project;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Alice"));
        players.add(new Player("Bob"));

        UnoGame game = new UnoGame(players);
        game.play();
    }
}
