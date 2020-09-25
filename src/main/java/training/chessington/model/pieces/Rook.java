package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> allowedMoves = new ArrayList<>();
        Coordinates to = null;
        moveUpTheBoard(board, from, allowedMoves);
        moveDownTheBoard(board, from, allowedMoves);

        return allowedMoves;
    }

    public void moveUpTheBoard (Board board, Coordinates from, List<Move> allowedMoves) {
        boolean pieceInWay = false;
        for (int i = from.getRow() - 1; i >= 0; i--) {
            Coordinates to = new Coordinates(i, from.getCol());
            if (!pieceInWay) {
                if (board.get(to) == null) {
                    allowedMoves.add(new Move(from, to));
                } else if (board.get(to) != null) {
                    if (board.get(to).getColour() != this.getColour()) {
                        allowedMoves.add(new Move(from, to));
                    }
                    pieceInWay = true;
                }
            }
        }
    }

    public void moveDownTheBoard (Board board, Coordinates from, List<Move> allowedMoves) {
        boolean pieceInWay = false;
        for (int i = from.getRow() + 1; i <= 7; i++) {
            Coordinates to = new Coordinates(i, from.getCol());
            if (!pieceInWay) {
                if (board.get(to) == null) {
                    allowedMoves.add(new Move(from, to));
                } else if (board.get(to) != null) {
                    if (board.get(to).getColour() != this.getColour()) {
                        allowedMoves.add(new Move(from, to));
                    }
                    pieceInWay = true;
                }
            }
        }
    }
}
