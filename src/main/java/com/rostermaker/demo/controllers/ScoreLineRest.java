package com.rostermaker.demo.controllers;


import com.rostermaker.demo.legos.scoreline.ScoreLine;
import com.rostermaker.demo.models.piece.Piece;
import com.rostermaker.demo.repos.*;
import com.rostermaker.demo.service.ScoreLineMaker;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin
public class ScoreLineRest {

    @Resource
    ScoreLineRepo scoreLineRepo;

    @Resource
    PieceRepo pieceRepo;

    @Resource
    ShowRepo showRepo;

    @Resource
    ShowPieceRepo showPieceRepo;

    @Resource
    PICRepo picRepo;

    @Resource
    InstrumentRepo instrumentRepo;

    @Resource
    PlayerRepo playerRepo;


    @PostMapping("/add-scoreline")
    public ScoreLine addChairWrapper(@RequestBody ScoreLine incomingScoreLine) throws IOException {
        try {
            ScoreLineMaker scoreLineMaker = new ScoreLineMaker(scoreLineRepo, pieceRepo, showRepo, instrumentRepo, picRepo, showPieceRepo);
            return scoreLineMaker.addScoreLine(incomingScoreLine);

        } catch (Exception error) {
            error.printStackTrace();
        }
        return null;
    }

    @PostMapping("/add-scorelines")
    public Collection<ScoreLine> addScoreLinesCollection(@RequestBody Collection<ScoreLine> incomingScoreLines) throws IOException {
        Collection<ScoreLine> scoreLinesToReturn = new ArrayList<>();
        ScoreLineMaker scoreLineMaker = new ScoreLineMaker(scoreLineRepo, pieceRepo, showRepo, instrumentRepo, picRepo, showPieceRepo);

        try {
            for (ScoreLine scoreLine : incomingScoreLines) {
                scoreLinesToReturn.add(scoreLineMaker.addScoreLine(scoreLine));
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return scoreLinesToReturn;
    }

    @PostMapping("/get-scorelines-in-piece")
    public Collection<ScoreLine> getOrchestrationOfPiece(@RequestBody Piece incomingPiece) throws IOException {
        Optional<Piece> pieceCheck = pieceRepo.findById(incomingPiece.getId());

        try {
            if (pieceCheck.isPresent()) {
                List<ScoreLine> scoreLinesToReturn = (List<ScoreLine>) scoreLineRepo.findAllByPiece(pieceCheck.get());
                Collections.sort(scoreLinesToReturn);
                return scoreLinesToReturn;
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return null;
    }


}
