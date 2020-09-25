package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class RookTest {
    @Test
    public void rookNotAbleToMovePastAllyPiece() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7,7);
        board.placePiece(coords, rook);
        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(4,7);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2,0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3,0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-4,0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-5,0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-6,0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-7,0)));
    }

    @Test
    public void rookNotAbleToMovePastEnemyPiece() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7,7);
        board.placePiece(coords, rook);
        Piece pawn = new Pawn(PlayerColour.BLACK);
        Coordinates pawnCoords = new Coordinates(4,7);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3,0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-4,0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-5,0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-6,0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-7,0)));
    }

    @Test
    public void rookCanMoveUpTheBoardWhite() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7,7);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-4,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-5,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-6,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-7,0)));
    }

    @Test
    public void rookCanMoveUpTheBoardBlack() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(7,7);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-4,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-5,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-6,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-7,0)));
    }

    @Test
    public void rookCanMoveDownTheBoardWhite() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(0,7);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(+1,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(+2,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(+3,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(+4,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(+5,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(+6,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(+7,0)));
    }

    @Test
    public void rookCanMoveDownTheBoardBlack() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0,7);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(+1,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(+2,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(+3,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(+4,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(+5,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(+6,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(+7,0)));
    }
}
