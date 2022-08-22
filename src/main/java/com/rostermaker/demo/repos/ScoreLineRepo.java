package com.rostermaker.demo.repos;

import com.rostermaker.demo.legos.scoreline.ScoreLine;
import com.rostermaker.demo.models.part.Part;
import com.rostermaker.demo.models.piece.Piece;
import com.rostermaker.demo.models.show.Show;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ScoreLineRepo extends CrudRepository<ScoreLine, Long> {


    boolean existsByPiece(Piece piece);

    Collection<ScoreLine> findAllByPiece(Piece piece);

    boolean existsByPrimaryPartAndPiece(Part part, Piece piece);

    ScoreLine findByPrimaryPartAndPiece(Part part, Piece piece);

    boolean existsByPrimaryPartAndShow(Part stringPart, Show retrievedShow);


}
