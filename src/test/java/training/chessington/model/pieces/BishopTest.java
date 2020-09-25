package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class BishopTest {
    @Test
    public void bishopMoveDiagonallyUpLeft() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7,7);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1,-1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2,-2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3,-3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-4,-4)));
        assertThat(moves).contains(new Move(coords, coords.plus(-5,-5)));
        assertThat(moves).contains(new Move(coords, coords.plus(-6,-6)));
        assertThat(moves).contains(new Move(coords, coords.plus(-7,-7)));
    }

    @Test
    public void bishopMoveDiagonallyUpRight() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7,0);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1,+1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2,+2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3,+3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-4,+4)));
        assertThat(moves).contains(new Move(coords, coords.plus(-5,+5)));
        assertThat(moves).contains(new Move(coords, coords.plus(-6,+6)));
        assertThat(moves).contains(new Move(coords, coords.plus(-7,+7)));
    }
}
