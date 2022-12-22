package com.rostermaker.demo.controllers;

//import com.rostermaker.demo.legos.emptyChair.Chair;

import com.rostermaker.demo.models.piece.Piece;
import com.rostermaker.demo.models.piece.PieceBuilder;
import com.rostermaker.demo.models.piece.PieceEditor;
import com.rostermaker.demo.repos.PieceRepo;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@CrossOrigin
@RestController
public class PieceRest {

    @Resource
    PieceRepo pieceRepo;

    @RequestMapping("/get-all-pieces")
    public Collection<Piece> getAllPerformances() {
        return (Collection<Piece>) pieceRepo.findAll();
    }

    @PostMapping("/add-piece")
    public Collection<Piece> addPieceToDatabase(@RequestBody Piece incoming) throws IOException {

        try {
            pieceRepo.save(new PieceBuilder()
                    .prefix(incoming.getPrefix())
                    .libNumber(incoming.getLibNumber())
                    .suffix(incoming.getSuffix())
                    .composerLast(incoming.getComposerLast())
                    .composerFirst(incoming.getComposerFirst())
                    .arranger(incoming.getArranger())
                    .title(incoming.getTitle())
                    .otherName(incoming.getOtherName())
                    .publisher(incoming.getPublisher())
                    .duration(incoming.getDuration())
                    .windsBrass(incoming.getWindsBrass())
                    .vocalistSoloist(incoming.getVocalistSoloist())
                    .percBreakdown(incoming.getPercBreakdown())
                    .notes(incoming.getNotes())
                    .status(incoming.getStatus())
                    .sign(incoming.getSign())
                    .updated(incoming.getUpdated())
                    .build());

        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return (Collection<Piece>) pieceRepo.findAll();
    }

    @PostMapping("/edit-piece")
    public Collection<Piece> editPlayerInDatabase(@RequestBody Piece incoming) throws IOException {
        try {
            Optional<Piece> pieceToFind = pieceRepo.findById(incoming.getId());
            if (pieceToFind.isPresent()) {
                Piece pieceToEdit = pieceToFind.get();
                PieceEditor editor = new PieceEditor();
                pieceRepo.save(editor.editFrom(incoming, pieceToEdit));
            }
            return (Collection<Piece>) pieceRepo.findAll();

        } catch (Exception error) {
            error.printStackTrace();
        }
        return (Collection<Piece>) pieceRepo.findAll();
    }

    @RequestMapping("/get-sorted-pieces/{sortType}")
    public Collection<Piece> getSortedPieces(@PathVariable String sortType) {
        try {
            return pieceRepo.findAllBy(Sort.by(sortType));
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return null;
    }

}
