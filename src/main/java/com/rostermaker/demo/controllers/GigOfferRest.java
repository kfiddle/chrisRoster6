package com.rostermaker.demo.controllers;

import com.rostermaker.demo.enums.Event;
import com.rostermaker.demo.enums.LogType;
import com.rostermaker.demo.legos.playerInChair.PIC;
import com.rostermaker.demo.models.gigOffer.GigOffer;
import com.rostermaker.demo.models.logEvent.LogEvent;
import com.rostermaker.demo.models.player.Player;
import com.rostermaker.demo.models.show.Horloge;
import com.rostermaker.demo.models.show.Show;
import com.rostermaker.demo.repos.*;
import com.rostermaker.demo.service.GigOfferReplyManager;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class GigOfferRest {

    @Resource
    private GigOfferRepo gigOfferRepo;

    @Resource
    private LogEventRepo logEventRepo;

    @Resource
    private ShowRepo showRepo;

    @Resource
    private ShowPieceRepo showPieceRepo;

    @Resource
    private PlayerRepo playerRepo;

    @Resource
    private PICRepo picRepo;

    @Resource
    private HorlogeRepo horlogeRepo;

    @RequestMapping("/get-all-gig-offers")
    public Collection<GigOffer> getAllOffers() throws IOException {
        return (Collection<GigOffer>) gigOfferRepo.findAll();
    }

    @RequestMapping("/delete-all-gig-offers")
    public String deleteAllOffers() throws IOException {
        gigOfferRepo.deleteAll();
        return "All is lost";
    }

    @RequestMapping("/offers-by-player/{playerId}")
    public List<GigOffer> findAllOffersMadeToPlayer(@PathVariable Long playerId) throws IOException {
        List<GigOffer> offersToReturn = new ArrayList<>();

        try {
            Optional<Player> playerToFind = playerRepo.findById(playerId);
            if (playerToFind.isPresent()) {
                Collection<GigOffer> offers = gigOfferRepo.findAllByPlayer(playerToFind.get());
                if (offers.size() > 0) {
                    for (Horloge horloge : horlogeRepo.findAllByEventOrderByDate(Event.PRIMARYDATE)) {
                        for (GigOffer offer : offers) {
                            if (horloge.getShow().equals(offer.getShow())) {
                                offersToReturn.add(offer);
                            }
                        }
                    }
                    return offersToReturn;
                }
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/compute-offers-for-player/{playerId}")
    public String computeOffersForPlayer(@PathVariable Long playerId) throws IOException {

        try {
            Optional<Player> playerToFind = playerRepo.findById(playerId);
            if (playerToFind.isPresent()) {
                Player playerToOffer = playerToFind.get();

                Collection<GigOffer> gigsToOffer = new ArrayList<>();

                for (Show show : showRepo.findAll()) {
                    Collection<PIC> picsInShow = picRepo.findAllByShow(show);

                    for (PIC pic : picsInShow) {
                        if (pic.getPrimaryPart().equals(playerToOffer.getPrimaryInstrument()) &&
                                pic.getPrimaryPart().getRank() == playerToOffer.getRank()) {
                            return "TRUE";
                        }
                    }
                }
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return "nope";
    }

    @PostMapping("/make-gig-offer")
    public GigOffer makeAnOffer(@RequestBody GigOffer offerToMake) throws IOException {
        try {
            LocalDate dateOffered = LocalDate.now();
            Optional<Show> showToFind = showRepo.findById(offerToMake.getShow().getId());
            Optional<Player> playerToFind = playerRepo.findById(offerToMake.getPlayer().getId());

            if (showToFind.isPresent() && playerToFind.isPresent()) {
                GigOffer offer = new GigOffer(showToFind.get(), playerToFind.get(), dateOffered);
                gigOfferRepo.save(offer);
                System.out.println(offer.getPlayer().getFirstNameArea());
                System.out.println("will be playing on ...");
                System.out.println(offer.getShow().getTitle());
                System.out.println("offer was made on  " + dateOffered);
                logEventRepo.save(new LogEvent(offer, LogType.MESSAGE_SENT, dateOffered));
                return offer;
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return null;
    }

    @PostMapping("/gig-offer-replies")
    public Collection<GigOffer> logPlayerPSAResponses(@RequestBody Collection<GigOffer> incomingAnswers) throws IOException {
        Collection<GigOffer> amendedOffers = new ArrayList<>();
        GigOfferReplyManager gigOfferReplyManager = new GigOfferReplyManager(gigOfferRepo, logEventRepo, picRepo, showPieceRepo);

        try {

            incomingAnswers.forEach(gigOffer -> {
                Optional<GigOffer> offerToFind = gigOfferRepo.findById(gigOffer.getId());
                offerToFind.ifPresent(foundOffer -> amendedOffers.add(gigOfferReplyManager.saveAndFillChairs(foundOffer, gigOffer.getReply())));

            });

            return amendedOffers;

        } catch (Exception error) {
            error.printStackTrace();
        }
        return null;
    }

    @PostMapping("/gig-offer-reply")
    public GigOffer logPlayerResponseToGigOffer(@RequestBody GigOffer incomingReply) throws IOException {


        try {
            Optional<GigOffer> offerToFind = gigOfferRepo.findById(incomingReply.getId());
            GigOfferReplyManager gigOfferReplyManager = new GigOfferReplyManager(gigOfferRepo, logEventRepo, picRepo, showPieceRepo);

            if (offerToFind.isPresent()) {
                return gigOfferReplyManager.saveAndFillChairs(offerToFind.get(), incomingReply.getReply());
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return null;
    }


}
