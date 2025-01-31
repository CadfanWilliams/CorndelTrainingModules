package chessington.model.pieces;

import chessington.model.Board;
import chessington.model.Coordinates;
import chessington.model.Move;
import chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class King extends AbstractPiece {
    public King(PlayerColour colour) {
        super(PieceType.KING, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> moves = new ArrayList<>();
        Coordinates toCoord;
        Move move = null;
        for (int i = -1; i < 2; i++)
        {
            for (int x = -1; x < 2; x++)
            {
                toCoord = from.plus(i,x);
                if(toCoord.isValidCoords())
                {
                    Piece pieceInToCoord = board.get(toCoord);
                    if( pieceInToCoord == null || pieceInToCoord.getColour() != colour )
                    {
                        move = new Move(from, toCoord);
                        moves.add(move);
                    }
                }
            }

        }

        return moves;

    }
}
