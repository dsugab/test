public class ChessBoard {

    private Coordinates[][] positions;

    public ChessBoard() {

        positions = new Coordinates[8][8];

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8 ; j++) {
                String row = Character.toString((char) (i + 'a'));
                String col = Integer.toString(8 - j);
                positions[i][j] = new Coordinates(row, col, null);
            }
        }

        fillBoard();
    }

    public Coordinates[][] getPositions() {
        return positions;
    }

    public void setPositions(Coordinates[][] positions) {
        this.positions = positions;
    }

    public void fillBoard() {

        // row, then column
        positions[0][1].setPiece(new Piece(Color.Red, Rank.Pawn));
        positions[0][3].setPiece(new Piece(Color.Red, Rank.Pawn));
        positions[0][5].setPiece(new Piece(Color.Red, Rank.Pawn));
        positions[0][7].setPiece(new Piece(Color.Red, Rank.Pawn));

        positions[1][0].setPiece(new Piece(Color.Red, Rank.Pawn));
        positions[1][2].setPiece(new Piece(Color.Red, Rank.Pawn));
        positions[1][4].setPiece(new Piece(Color.Red, Rank.Pawn));
        positions[1][6].setPiece(new Piece(Color.Red, Rank.Pawn));

        positions[2][1].setPiece(new Piece(Color.Red, Rank.Pawn));
        positions[2][3].setPiece(new Piece(Color.Red, Rank.Pawn));
        positions[2][5].setPiece(new Piece(Color.Red, Rank.Pawn));
        positions[2][7].setPiece(new Piece(Color.Red, Rank.Pawn));

        positions[7][0].setPiece(new Piece(Color.White, Rank.Pawn));
        positions[7][2].setPiece(new Piece(Color.White, Rank.Pawn));
        positions[7][4].setPiece(new Piece(Color.White, Rank.Pawn));
        positions[7][6].setPiece(new Piece(Color.White, Rank.Pawn));

        positions[6][1].setPiece(new Piece(Color.White, Rank.Pawn));
        positions[6][3].setPiece(new Piece(Color.White, Rank.Pawn));
        positions[6][5].setPiece(new Piece(Color.White, Rank.Pawn));
        positions[6][7].setPiece(new Piece(Color.White, Rank.Pawn));

        positions[5][0].setPiece(new Piece(Color.White, Rank.Pawn));
        positions[5][2].setPiece(new Piece(Color.White, Rank.Pawn));
        positions[5][4].setPiece(new Piece(Color.White, Rank.Pawn));
        positions[5][6].setPiece(new Piece(Color.White, Rank.Pawn));
    }
}
