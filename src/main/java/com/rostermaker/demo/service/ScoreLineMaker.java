package com.rostermaker.demo.service;


import com.rostermaker.demo.legos.ShowPiece;
import com.rostermaker.demo.legos.playerInChair.PICBuilder;
import com.rostermaker.demo.legos.scoreline.ScoreLine;
import com.rostermaker.demo.legos.scoreline.ScoreLineBuilder;
import com.rostermaker.demo.models.piece.Piece;
import com.rostermaker.demo.models.show.Show;
import com.rostermaker.demo.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScoreLineMaker {


    private final ScoreLineRepo scoreLineRepo;
    private final PieceRepo pieceRepo;
    private final ShowRepo showRepo;
    private final InstrumentRepo instrumentRepo;
    private final PICRepo picRepo;
    private final ShowPieceRepo showPieceRepo;


    @Autowired
    public ScoreLineMaker(ScoreLineRepo scoreLineRepo, PieceRepo pieceRepo, ShowRepo showRepo, InstrumentRepo instrumentRepo, PICRepo picRepo, ShowPieceRepo showPieceRepo) {
        this.scoreLineRepo = scoreLineRepo;
        this.pieceRepo = pieceRepo;
        this.showRepo = showRepo;
        this.instrumentRepo = instrumentRepo;
        this.picRepo = picRepo;
        this.showPieceRepo = showPieceRepo;
    }

    public ScoreLine addScoreLine(ScoreLine incomingScoreLine) {
        Piece piece = null;
        Show show = null;
        ScoreLine scoreLineToSave;

        if (incomingScoreLine.getPiece() != null) {
            Optional<Piece> pieceToFind = pieceRepo.findById(incomingScoreLine.getPiece().getId());
            if (pieceToFind.isPresent()) {
                piece = pieceToFind.get();
            }
        } else if (incomingScoreLine.getShow() != null) {
            Optional<Show> showToFind = showRepo.findById(incomingScoreLine.getShow().getId());
            if (showToFind.isPresent()) {
                show = showToFind.get();
            }
        }

        PartsListMaker maker = new PartsListMaker(instrumentRepo);
        scoreLineToSave = new ScoreLineBuilder()
                .parts(maker.makeList(incomingScoreLine.getParts()))
                .piece(piece)
                .show(show)
                .build();
        scoreLineRepo.save(scoreLineToSave);

        if (scoreLineToSave.getShow() != null) {
            picRepo.save(new PICBuilder().show(show).fromScoreLine(scoreLineToSave).build());
        }

        if (piece != null && showPieceRepo.existsByPiece(piece)) {
            for (ShowPiece showPiece : showPieceRepo.findAllByPiece(piece)) {
                picRepo.save(new PICBuilder().showPiece(showPiece).fromScoreLine(scoreLineToSave).build());
            }
        }
        return scoreLineToSave;
    }


}
