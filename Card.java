public class Card {
    String face;
    int value;

    public Card(String face, int value) {
        this.face = face;
        this.value = value;
    }

    public String readCard() {
        return this.face + " (" + this.value + ")";
    }

    public int getValue(){
        return value;
    }
    
}
