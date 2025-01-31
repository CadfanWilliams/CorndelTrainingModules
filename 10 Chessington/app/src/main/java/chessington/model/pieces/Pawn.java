package chessington.model.pieces;

import chessington.model.Board;
import chessington.model.Coordinates;
import chessington.model.Move;
import chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {


    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }


    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> allowedMoves = new ArrayList<>();
        Move newMove;
        Coordinates newToCoordinates;

        int distance = 1;
        if (!this.firstMoveMade) {
            distance = 2;
        }

        int direction = (this.colour == PlayerColour.WHITE) ? -1 : 1;
        //Straight Lines
        for (int i = 1; i <= distance; i++) {
            newToCoordinates = from.plus(direction * i, 0);
            if (!newToCoordinates.isValidCoords() || board.get(newToCoordinates) != null) {break;}
            else
            {
                newMove = new Move(from, newToCoordinates);
                allowedMoves.add(newMove);
            }
        }
        //check if diagonal is offboard
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
            }
            else
            {
                newToCoordinates = from.plus(direction, i - 1);
                if (newToCoordinates.isValidCoords()) {
                    if (board.get(newToCoordinates) != null && board.get(newToCoordinates).getColour() != colour) {
                        newMove = new Move(from, newToCoordinates);
                        allowedMoves.add(newMove);
                    }
                }
            }
        }



        // if diagonals have a piece check if its oposing colour if true = possible move

        return allowedMoves;
    }

}
