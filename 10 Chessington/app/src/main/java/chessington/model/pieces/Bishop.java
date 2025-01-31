package chessington.model.pieces;

import chessington.model.Board;
import chessington.model.Coordinates;
import chessington.model.Move;
import chessington.model.PlayerColour;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        int direction1 = -1;
        int direction2 = -1;
        ArrayList<Move> moves = new ArrayList<>();
        Move move;
        Coordinates toCoord;
        for(int i = 1; i <= 8; i++)
        {
            toCoord = from.plus(i * direction1, i * direction2);
            if(toCoord.isValidCoords())
            {
                Piece piece = board.get(toCoord);
                if(piece != null  && piece.getColour() == this.colour)
                {
                    break;
                }
                else
                {
                    move = new Move(from, toCoord);
                    moves.add(move);
                }
            }

        }

        return moves;
    }
}
