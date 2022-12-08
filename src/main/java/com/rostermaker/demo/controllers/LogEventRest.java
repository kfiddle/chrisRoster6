package com.rostermaker.demo.controllers;

import com.rostermaker.demo.models.gigOffer.GigOffer;
import com.rostermaker.demo.models.logEvent.LogEvent;
import com.rostermaker.demo.models.piece.Piece;
import com.rostermaker.demo.repos.GigOfferRepo;
import com.rostermaker.demo.repos.LogEventRepo;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@CrossOrigin
@RestController
public class LogEventRest {

    @Resource
    LogEventRepo logEventRepo;

    @Resource
    GigOfferRepo gigOfferRepo;

    @RequestMapping("/get-all-log-events")
    public List<LogEvent> getAllEventsInLog() throws IOException {
        return logEventRepo.findAllBy(Sort.by("date"));
    }

    @RequestMapping("get-sorted-log-events/{sortType}")
    public Collection<LogEvent> getSortedLogEvents(@PathVariable String sortType) {
        try {
            return logEventRepo.findAllBy(Sort.by(sortType));
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return null;
    }

    // these are redundant- testing for now

    @RequestMapping("get-log-events-by/{sortType}")
    public List<LogEvent> getSortedPieces(@PathVariable String sortType) {
        try {
            if (sortType.equals("DATE")) {
                return logEventRepo.findAllBy(Sort.by("date"));
            } else if (sortType.equals("PLAYER")) {

                List<LogEvent> logsToReturn = new ArrayList<>();
                for (GigOffer gigOffer : gigOfferRepo.findAllBy(Sort.by("player"))) {
                    for (LogEvent logEvent : logEventRepo.findAll()) {
                        if (logEvent.getGigOffer().equals(gigOffer)) {
                            logsToReturn.add(logEvent);
                        }
                    }
                }
                return logsToReturn;
            }
//            return logEventRepo.findAll(Sort.by(Sort.Order.asc("date")));
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return null;
    }
}
