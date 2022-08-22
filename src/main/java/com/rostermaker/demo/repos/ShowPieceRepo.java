package com.rostermaker.demo.repos;

import com.rostermaker.demo.legos.ShowPiece;
import com.rostermaker.demo.models.piece.Piece;
import com.rostermaker.demo.models.show.Show;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ShowPieceRepo extends CrudRepository<ShowPiece, Long> {

    Collection<ShowPiece> findAllByShow(Show incomingShow);

    boolean existsByPiece(Piece pieceForChairs);

    Collection<ShowPiece> findAllByPiece(Piece pieceForChairs);

    boolean existsByPieceAndShowAndOrderNum(Piece piece, Show show, int orderNum);

    boolean existsByPieceAndShow(Piece piece, Show show);

    ShowPiece findByPieceAndShow(Piece piece, Show show);

}
