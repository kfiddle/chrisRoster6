package com.rostermaker.demo.controllers;


import com.rostermaker.demo.enums.Type;
import com.rostermaker.demo.models.gigOffer.GigOffer;
import com.rostermaker.demo.models.instrument.Instrument;
import com.rostermaker.demo.models.player.Player;
import com.rostermaker.demo.models.player.PlayerBuilder;
import com.rostermaker.demo.models.player.PlayerCompare;
import com.rostermaker.demo.models.player.PlayerEditor;
import com.rostermaker.demo.repos.GigOfferRepo;
import com.rostermaker.demo.repos.InstrumentRepo;
import com.rostermaker.demo.repos.PlayerRepo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class PlayerRest {

    @Resource
    PlayerRepo playerRepo;

    @Resource
    InstrumentRepo instrumentRepo;

    @Resource
    GigOfferRepo gigOfferRepo;

    @RequestMapping("/get-all-players")
    public Collection<Player> getAllPlayers() {
        return (Collection<Player>) playerRepo.findAll();
    }

    @PostMapping("/add-player")
    public Player addPlayerToDatabase(@RequestBody Player incomingPlayer) throws IOException {

        try {
            if (playerRepo.existsByFirstNameAreaAndLastName(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName())) {
                return playerRepo.findByFirstNameAreaAndLastName(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName());
            } else {

                List<Instrument> instsToAdd = new ArrayList<>();
                for (Instrument inst : incomingPlayer.getInstruments()) {
                    Optional<Instrument> instToFind = instrumentRepo.findById(inst.getId());
                    instToFind.ifPresent(instsToAdd::add);
                }

                playerRepo.save(new PlayerBuilder().firstNameArea(incomingPlayer.getFirstNameArea())
                        .lastName(incomingPlayer.getLastName())
                        .type(incomingPlayer.getType())
                        .instruments(instsToAdd)
                        .rank(incomingPlayer.getRank())
                        .email(incomingPlayer.getEmail())
                        .homePhone(incomingPlayer.getHomePhone())
                        .cellPhone(incomingPlayer.getCellPhone())
                        .addressLine1(incomingPlayer.getAddressLine1())
                        .addressLine2(incomingPlayer.getAddressLine2())
                        .city(incomingPlayer.getCity())
                        .state(incomingPlayer.getState())
                        .zip(incomingPlayer.getZip())
                        .build());
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return playerRepo.findByFirstNameAreaAndLastName(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName());
    }

    @RequestMapping("/get-all-contracted-players")
    public Collection<Player> getAllContractedPlayers() {
        ArrayList<Player> playersToSendBack = new ArrayList<>(playerRepo.findAllByType(Type.CONTRACTED));

        PlayerCompare playerCompare = new PlayerCompare();
        playersToSendBack.sort(playerCompare);

        return playersToSendBack;
    }

    @RequestMapping("/get-all-sub-players")
    public Collection<Player> getAllSubs() {
        return playerRepo.findAllByType(Type.SUB);
    }

    @RequestMapping("/subs-by-instrument")
    public Collection<Player> getSubsOfInstrument(@RequestBody Instrument incomingInstrument) {
        try {
            Optional<Instrument> instToFind = instrumentRepo.findById(incomingInstrument.getId());
            if (instToFind.isPresent()) {
                Instrument foundInst = instToFind.get();
                Collection<Player> playersToSend = new ArrayList<>();
                for (Player player : playerRepo.findAllByType(Type.SUB)) {
                    for (Instrument inst : player.getInstruments()) {
                        if (inst.equals(foundInst)) {
                            playersToSend.add(player);
                        }
                    }
                }
                return playersToSend;
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return null;
    }

    @PostMapping("/edit-player")
    public Collection<Player> editPlayerInDatabase(@RequestBody Player incomingPlayer) throws IOException {
        try {
            Optional<Player> playerToFind = playerRepo.findById(incomingPlayer.getId());
            if (playerToFind.isPresent()) {
                Player playerToEdit = playerToFind.get();
                PlayerEditor editor = new PlayerEditor();
                playerRepo.save(editor.editFrom(incomingPlayer, playerToEdit));
            }
            return (Collection<Player>) playerRepo.findAll();

        } catch (Exception error) {
            error.printStackTrace();
        }
        return (Collection<Player>) playerRepo.findAll();
    }

    @PostMapping("/delete-player")
    public String LieslDeletePlayerFunction(@RequestBody Player incomingPlayer) throws IOException {
        try {
            Optional<Player> playerToFind = playerRepo.findById(incomingPlayer.getId());
            if (playerToFind.isPresent()) {
                Player playerToDelete = playerToFind.get();
                if (gigOfferRepo.existsByPlayer(playerToDelete)) {
                    Collection<GigOffer> offersOfPlayer = gigOfferRepo.findAllByPlayer(playerToDelete);
                    gigOfferRepo.deleteAll(offersOfPlayer);
                }

                playerRepo.deleteById(incomingPlayer.getId());
                return "Player Removed";
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return "Not Successful";
    }
}
