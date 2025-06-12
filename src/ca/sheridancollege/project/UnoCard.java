package ca.sheridancollege.project;

public class UnoCard extends Card {
    private String value; // Can be "0-9", "Skip", "Reverse", "Draw Two", "Wild", "Wild Draw Four"

    public UnoCard(String color, String value) {
        super(color);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getColor() + " " + value;
    }
}
