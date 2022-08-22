package com.rostermaker.demo.controllers;


import com.rostermaker.demo.enums.Type;
import com.rostermaker.demo.legos.ShowPiece;
import com.rostermaker.demo.legos.playerInChair.HornPICSorter;
import com.rostermaker.demo.legos.playerInChair.PIC;
import com.rostermaker.demo.legos.playerInChair.PICBuilder;
import com.rostermaker.demo.models.player.Player;
import com.rostermaker.demo.models.show.Show;
import com.rostermaker.demo.repos.*;
import com.rostermaker.demo.service.PartsListMaker;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin
public class PICRest {

    @Resource
    PICRepo picRepo;

    @Resource
    ShowPieceRepo showPieceRepo;

    @Resource
    ShowRepo showRepo;

    @Resource
    PlayerRepo playerRepo;

    @Resource
    InstrumentRepo instrumentRepo;


    @RequestMapping("/get-all-pics")
    public Collection<PIC> getAllPics() {
        return (Collection<PIC>) picRepo.findAll();
    }


    @PostMapping("/add-pic")
    public PIC addPIC(@RequestBody PIC incomingPIC) throws IOException {
        try {
            PartsListMaker maker = new PartsListMaker(instrumentRepo);
            PIC picToAdd = new PICBuilder()
                    .parts(maker.makeList(incomingPIC.getParts()))
                    .show(incomingPIC.getShow())
                    .showPiece(incomingPIC.getShowPiece())
                    .build();
            picRepo.save(picToAdd);
            return picToAdd;
        } catch (Exception error) {
            error.printStackTrace();
        } return null;
    }

    @PostMapping("/delete-pic")
    public PIC deleteEntireChair(@RequestBody PIC picToRemove) throws IOException {

        try {
            Optional<PIC> pic = picRepo.findById(picToRemove.getId());
            pic.ifPresent(foundPic -> picRepo.deleteById(foundPic.getId()));
            return picToRemove;
        } catch (Exception error) {
            error.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/get-pics-in-show-piece")
    public Collection<PIC> getAllPICSInAPieceOnShow(@RequestBody ShowPiece incomingShowPiece) {
        Optional<ShowPiece> showPieceToFind = showPieceRepo.findById(incomingShowPiece.getId());
        if (showPieceToFind.isPresent()) {
            List<PIC> picsToReturn = (List<PIC>) picRepo.findAllByShowPiece(showPieceToFind.get());
            Collections.sort(picsToReturn);
            HornPICSorter sorter = new HornPICSorter(picsToReturn);
            return sorter.sort();
        }
        return null;
    }

    @RequestMapping("/get-pics-in-show")
    public Collection<PIC> getAllChairsInShow(@RequestBody Show incomingShow) {
        Optional<Show> showToFind = showRepo.findById(incomingShow.getId());
        if (showToFind.isPresent()) {
            List<PIC> picsToReturn = (List<PIC>) picRepo.findAllByShow(showToFind.get());
            Collections.sort(picsToReturn);
            HornPICSorter sorter = new HornPICSorter(picsToReturn);
            return sorter.sort();
        }
        return null;
    }

    @PostMapping("/put-player-in-pic/{picId}")
    public Optional<PIC> putAPlayerInAChair(@RequestBody Player incomingPlayer, @PathVariable Long
            picId) {

        try {
            Optional<PIC> premadePIC = picRepo.findById(picId);
            Optional<Player> playerToFind = playerRepo.findById(incomingPlayer.getId());
            if (premadePIC.isPresent() && playerToFind.isPresent()) {
                PIC pic = premadePIC.get();
                Player foundPlayer = playerToFind.get();
                boolean flagTest = false;

                ShowPiece possibleShowPiece;
                Show possibleShow;

                if (pic.getShow() == null) {
                    possibleShowPiece = pic.getShowPiece();
                    for (PIC pic1 : picRepo.findAllByShowPiece(possibleShowPiece)) {
                        if (pic1.hasThisPlayer(foundPlayer)) {
                            flagTest = true;
                        }
                    }
                } else {
                    possibleShow = pic.getShow();
                    for (PIC pic2 : picRepo.findAllByShow(possibleShow)) {
                        if (pic2.hasThisPlayer(foundPlayer)) {
                            flagTest = true;
                        }
                    }
                }

                if (!flagTest) {
                    pic.setPlayer(foundPlayer);
                    picRepo.save(pic);
                    return premadePIC;
                }

            }
        } catch (
                Exception error) {
            error.printStackTrace();

        }
        return Optional.empty();
    }

    @PostMapping("/get-all-available-players")
    public List<Player> getAllAvailablePlayersForAChair(@RequestBody PIC incomingPIC) {
        try {
            Optional<PIC> picToFind = picRepo.findById(incomingPIC.getId());
            if (picToFind.isPresent()) {
                PIC foundPIC = picToFind.get();

                List<Player> eligiblePlayers = (List<Player>) playerRepo.findAll();

                for (PIC pic : picRepo.findAllByShowPiece(foundPIC.getShowPiece())) {
                    eligiblePlayers.remove(pic.getPlayer());
                }
                return eligiblePlayers;
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return null;
    }

    @PostMapping("/get-possible-players")
    public List<Player> getPossiblePlayersForAChair(@RequestBody PIC incomingPIC) {
        try {
            Optional<PIC> picToFind = picRepo.findById(incomingPIC.getId());
            if (picToFind.isPresent()) {
                PIC foundPIC = picToFind.get();

                List<Player> eligiblePlayers = new ArrayList<>(playerRepo.findAllByType(Type.CONTRACTED));

                eligiblePlayers.removeIf(player -> !player.couldSitHere(foundPIC));

                for (PIC pic : picRepo.findAllByShowPiece(foundPIC.getShowPiece())) {
                    eligiblePlayers.remove(pic.getPlayer());
                }
                return eligiblePlayers;
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return null;
    }

    @PostMapping("/remove-player-from-pic")
    public Optional<PIC> removePlayerFromAChair(@RequestBody PIC incomingPIC) throws IOException {
        Optional<PIC> picToFind = picRepo.findById(incomingPIC.getId());

        try {
            picToFind.ifPresent(playerInChair -> {
                playerInChair.setPlayer(null);
                picRepo.save(playerInChair);
            });
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return picToFind;
    }

    @PostMapping("/change-seating")
    public Collection<PIC> changeSeatingOrder(@RequestBody Collection<PIC> pics) {

        try {
            for (PIC pic : pics) {
                Optional<PIC> picToFind = picRepo.findById(pic.getId());
                if (picToFind.isPresent()) {
                    PIC foundPic = picToFind.get();

                    if (!(foundPic.getPlayer() == null && pic.getPlayer() == null)) {
                        if ((foundPic.getPlayer() == null && pic.getPlayer() != null) || (foundPic.getPlayer() != null && pic.getPlayer() == null)) {
                            foundPic.setPlayer(pic.getPlayer());
                            picRepo.save(foundPic);
                        } else if (!foundPic.getPlayer().equals(pic.getPlayer())) {
                            foundPic.setPlayer(pic.getPlayer());
                            picRepo.save(foundPic);
                        }
                    }
                }
            }
            return pics;
        } catch (Exception error) {
            error.printStackTrace();
        }
        return null;
    }

    @PostMapping("/edit-pic-parts")
    public PIC editPartsInPic(@RequestBody PIC incomingPIC) throws IOException {
        Optional<PIC> picToFind = picRepo.findById(incomingPIC.getId());

        try {
            if (picToFind.isPresent()) {
                PIC foundPIC = picToFind.get();

                PartsListMaker maker = new PartsListMaker(instrumentRepo);
                foundPIC.setParts(maker.makeList(incomingPIC.getParts()));
                picRepo.save(foundPIC);
                return foundPIC;
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return null;
    }

}
