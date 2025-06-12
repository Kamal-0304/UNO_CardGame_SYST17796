package ca.sheridancollege.project;


import java.util.ArrayList;

public abstract class Game {
    protected ArrayList<Player> players;

    public Game(ArrayList<Player> players) {
        this.players = players;
    }

    public abstract void play();
}
