package GUI;

import Game.*;
import Pieces.King;
import Pieces.Rook;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TileMouseListener implements MouseListener {

    private Board board;

	private BoardPanel boardPanel;

    private int tileId;

	public TileMouseListener(Board board, BoardPanel boardPanel, int tileId) {
		this.board = board;
		this.boardPanel = boardPanel;
		this.tileId = tileId;
	}

	private boolean isFirstSelection(){
        return boardPanel.getSelectedSquare() == null;
    }

    private boolean isEmptySquareSelected(){
        return board.getSquare(tileId/8, tileId%8).getPiece() != null;
    }

    private boolean isOwnPieceSelected(){
        return board.getSquare(tileId/8, tileId%8).getPiece().getColor()  == Game.getCurrentPlayer().getColor();
    }

    private void setSelectedSquare(){
        boardPanel.setSelectedSquare(board.getSquare(tileId/8, tileId%8));
    }

	private Square getSelectedSquare(){
		return boardPanel.getSelectedSquare();
	}

	private Square getThisTilesSquare(){
		return board.getSquare(tileId / 8, tileId % 8));
	}

	private boolean isValidMove(Move move){
		return move != null && getSelectedSquare().getPiece().isAbleToMove(move, board) && getSelectedSquare().getPiece().isLegal(move, board);
	}

    private void highlightTheBoard(int tileId){
        boardPanel.highlightTheBoard(boardPanel.getSelectedSquare().getPiece(), this.board);
		boardPanel.borderHighlight(this.tileId);
    }

	private Move createMove(Square from, Square to){

		if(from == to) {
			return null;
		} else if(from.getPiece().getClass() == King.class && to.getPiece() != null && from.getPiece().getColor() == to.getPiece().getColor() && to.getPiece().getClass() == Rook.class){
			return new CastlingMove(from, to);
		} else if (false) {
			return new EnPassantMove(from, to);
		} else if (false) {
			return new PromotionMove(from, to);
		}else{
			return new StandartMove(from, to);
		}

	}

	private void changeTurn(){
		Game.setTurn(Game.getTurn() ^ 1);
	}

    

    @Override
	public void mouseClicked(MouseEvent e) {
		if (isFirstSelection()) {
			if (isEmptySquareSelected()) {
				if (isOwnPieceSelected()) {
					setSelectedSquare();
					highlightTheBoard(this.tileId);
				}
			}

		} else {
			Move move = createMove(getSelectedSquare(), getThisTilesSquare());
			if (isValidMove(move)) {
				Game.newMove = move;
				getSelectedSquare().getPiece().doMove(move, board);
				changeTurn();
			}
			boardPanel.drawBoard(board);
			boardPanel.borderUnhighlight();
			boardPanel.setSelectedSquare(null);

		}
	}
	
	@Override
	public void mousePressed(MouseEvent e){}
	
	@Override
	public void mouseReleased(MouseEvent e){}
	
	@Override
	public void mouseEntered(MouseEvent e){}
	
	@Override
	public void mouseExited(MouseEvent e){}

	//generate getters and setters
	}



