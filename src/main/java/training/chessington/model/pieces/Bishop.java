package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> allowedMoves = new ArrayList<>();
        Coordinates to = null;
        moveDiagonallyUpLeft(board, from, allowedMoves);
        moveDiagonallyUpRight(board, from, allowedMoves);
        moveDiagonallyDownLeft(board, from, allowedMoves);
        moveDiagonallyDownRight(board, from, allowedMoves);

        return allowedMoves;
    }

    public void moveDiagonallyUpLeft(Board board, Coordinates from, List<Move> allowedMoves) {
        boolean pieceInWay = false;
        boolean outsideBoard = false;
        int row = from.getRow();
        int column = from.getCol();
        while (!pieceInWay && !outsideBoard) {
            row--;
            column--;
            if (row >= 0 && column >= 0) {
                Coordinates to = new Coordinates(row, column);
                if (board.get(to) == null) {
                    allowedMoves.add(new Move(from, to));
                } else if (board.get(to) != null) {
                    if (board.get(to).getColour() != this.getColour()) {
                        allowedMoves.add(new Move(from, to));
                    }
                    pieceInWay = true;
                }
            } else {
                outsideBoard = true;
            }
        }
    }

    public void moveDiagonallyUpRight(Board board, Coordinates from, List<Move> allowedMoves) {
        boolean pieceInWay = false;
        boolean outsideBoard = false;
        int row = from.getRow();
        int column = from.getCol();
        while (!pieceInWay && !outsideBoard) {
            row--;
            column++;
            if (row >= 0 && column <= 7) {
                Coordinates to = new Coordinates(row, column);
                if (board.get(to) == null) {
                    allowedMoves.add(new Move(from, to));
                } else if (board.get(to) != null) {
                    if (board.get(to).getColour() != this.getColour()) {
                        allowedMoves.add(new Move(from, to));
                    }
                    pieceInWay = true;
                }
            } else {
                outsideBoard = true;
            }
        }
    }

    public void moveDiagonallyDownLeft(Board board, Coordinates from, List<Move> allowedMoves) {
        boolean pieceInWay = false;
        boolean outsideBoard = false;
        int row = from.getRow();
        int column = from.getCol();
        while (!pieceInWay && !outsideBoard) {
            row++;
            column--;
            if (row <= 7 && column >= 0) {
                Coordinates to = new Coordinates(row, column);
                if (board.get(to) == null) {
                    allowedMoves.add(new Move(from, to));
                } else if (board.get(to) != null) {
                    if (board.get(to).getColour() != this.getColour()) {
                        allowedMoves.add(new Move(from, to));
                    }
                    pieceInWay = true;
                }
            } else {
                outsideBoard = true;
            }
        }
    }

    public void moveDiagonallyDownRight(Board board, Coordinates from, List<Move> allowedMoves) {
        boolean pieceInWay = false;
        boolean outsideBoard = false;
        int row = from.getRow();
        int column = from.getCol();
        while (!pieceInWay && !outsideBoard) {
            row++;
            column++;
            if (row <= 7 && column <= 7) {
                Coordinates to = new Coordinates(row, column);
                if (board.get(to) == null) {
                    allowedMoves.add(new Move(from, to));
                } else if (board.get(to) != null) {
                    if (board.get(to).getColour() != this.getColour()) {
                        allowedMoves.add(new Move(from, to));
                    }
                    pieceInWay = true;
                }
            } else {
                outsideBoard = true;
            }
        }
    }
}