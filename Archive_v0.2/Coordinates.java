public class Coordinates {

    private String x;
    private String y;
    Piece piece;

    public Coordinates(String x, String y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public String getPieceRepresentation() {
        if (piece == null) {
            return "[   ]";
        } else {
            if (piece.getRank()==Rank.Pawn) {
                return ("[" + piece.getColor().getDescriptionColour() + "_P]");
            } else if (piece.getRank()==Rank.King) {
                return ("[" + piece.getColor().getDescriptionColour() + "_K]");
            }
        }

        return "";
    }
}
