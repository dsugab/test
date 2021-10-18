 enum Color {
    Red("R")
    , White("W");

    private String descriptionColour;
    Color(String description) {
        this.descriptionColour = description;
    }

    public String getDescriptionColour() {
        return descriptionColour;
    }
}

 enum Rank {
     Pawn("P")
     , King("K");

     private String descriptionRank;
     Rank(String descriptionRank) {
         this.descriptionRank = descriptionRank;
     }

     public String getDescriptionRank() {
         return descriptionRank;
     }
 }
public class Piece {

    private Color color;
    private Rank  rank;

    Piece(Color color, Rank rank) {
        this.color = color;
        this.rank = rank;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}