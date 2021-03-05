package in.rohaan;

/*
 * Code for https://stackoverflow.com/questions/66469237
 */ 
public class Card {
    public enum Suit {
        HEARTS(0),
        DIAMONDS(1),
        SPADES(2),
        CLUBS(3);

        private final int index;

        Suit(int i) {
            this.index = i;
        }

        public int getIndex() { return this.index; }
    }

    public enum Rank {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(1);

        private final int index;

        Rank(int i) {
            this.index = i;
        }

        public int getIndex() { return this.index; }
    }

    private final Suit suit;
    private final Rank rank;

    public Card(Suit s, Rank r) {
        this.suit = s;
        this.rank = r;
    }

    public Suit getSuit() { return this.suit; }

    public Rank getRank() { return this.rank; }

    public static void main(String[] args) {
        Card card = new Card(Suit.DIAMONDS, Rank.NINE);

        System.out.println(card.getSuit().getIndex());
        System.out.println(card.getRank().getIndex());
    }
}
