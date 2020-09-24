package training.chessington.model.pieces;

import org.omg.CORBA.CODESET_INCOMPATIBLE;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;
import training.chessington.view.PieceDisplay;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> allowedMoves = new ArrayList<>();
        Coordinates to = null;
        if ((from.getRow() != 0 && this.getColour() == PlayerColour.WHITE) || (this.getColour() == PlayerColour.BLACK && from.getRow() != 7)) {
            moveForwardOne(board, from, allowedMoves);
            moveForwardTwo(board, from, allowedMoves);
            moveDiagonalToCapture(board, from, allowedMoves);
        }

        return allowedMoves;
    }

    public void moveForwardOne (Board board, Coordinates from, List<Move> allowedMoves) {
        if (this.getColour() == PlayerColour.WHITE) {
            Coordinates to = new Coordinates(from.getRow()-1, from.getCol());
            if (board.get(to) == null) {
                allowedMoves.add(new Move(from, to));
            }
        }
        if (this.getColour() == PlayerColour.BLACK) {
            Coordinates to = new Coordinates(from.getRow()+1, from.getCol());
            if (board.get(to) == null) {
                allowedMoves.add(new Move(from, to));
            }
        }
    }

    public void moveForwardTwo (Board board, Coordinates from, List<Move> allowedMoves) {
        if (this.getColour() == PlayerColour.WHITE) {
            if (from.getRow() == 6) {
                Coordinates to = new Coordinates(from.getRow()-2, from.getCol());
                if (board.get(to) == null) {
                    allowedMoves.add(new Move(from, to));
                }
            }
        }
        if (this.getColour() == PlayerColour.BLACK) {
            if (from.getRow() == 1) {
                Coordinates to = new Coordinates(from.getRow()+2, from.getCol());
                if (board.get(to) == null) {
                    allowedMoves.add(new Move(from, to));
                }
            }
        }
    }

    public void moveDiagonalToCapture (Board board, Coordinates from, List<Move> allowedMoves) {
        if (this.getColour() == PlayerColour.WHITE) {
            if (from.getCol() != 0) {
                Coordinates to = new Coordinates(from.getRow() - 1, from.getCol() - 1);
                if (board.get(to) != null) {
                    if (board.get(to).getColour() != PlayerColour.WHITE) {
                        allowedMoves.add(new Move(from, to));
                    }
                }
            }
            if (from.getCol() != 7) {
                Coordinates to = new Coordinates(from.getRow() - 1, from.getCol() + 1);
                if (board.get(to) != null) {
                    if (board.get(to).getColour() != PlayerColour.WHITE) {
                        allowedMoves.add(new Move(from, to));
                    }
                }
            }
        }
        if (this.getColour() == PlayerColour.BLACK) {
            if (from.getCol() != 0) {
                Coordinates to = new Coordinates(from.getRow() + 1, from.getCol() - 1);
                if (board.get(to) != null) {
                    if (board.get(to).getColour() != PlayerColour.BLACK) {
                        allowedMoves.add(new Move(from, to));
                    }
                }
            }
            if (from.getCol() != 7) {
                Coordinates to = new Coordinates(from.getRow() + 1, from.getCol() + 1);
                if (board.get(to) != null) {
                    if (board.get(to).getColour() != PlayerColour.BLACK) {
                        allowedMoves.add(new Move(from, to));
                    }
                }
            }
        }
    }
}