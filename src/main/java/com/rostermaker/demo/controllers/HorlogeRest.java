package com.rostermaker.demo.controllers;


import com.rostermaker.demo.enums.Event;
import com.rostermaker.demo.models.show.Horloge;
import com.rostermaker.demo.models.show.HorlogeBuilder;
import com.rostermaker.demo.models.show.HorlogeEditor;
import com.rostermaker.demo.models.show.Show;
import com.rostermaker.demo.repos.HorlogeRepo;
import com.rostermaker.demo.repos.ShowRepo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class HorlogeRest {

    @Resource
    HorlogeRepo horlogeRepo;

    @Resource
    ShowRepo showRepo;

    @RequestMapping("/get-all-primary-dates")
    public List<Horloge> getAllPrimaryDateHorlogesInDatabase() {
        List<Horloge> primaryDates = horlogeRepo.findByEvent(Event.PRIMARYDATE);
        Collections.sort(primaryDates);
        return primaryDates;
    }

    @RequestMapping("/get-performances-by-primary-date")
    public List<Show> getAllShowsByPrimaryDate() {

        try {
            List<Show> showsToReturn = new ArrayList<>();

            List<Horloge> primaryDates = horlogeRepo.findByEvent(Event.PRIMARYDATE);
            Collections.sort(primaryDates);

            for (Horloge horloge : primaryDates) {
                showsToReturn.add(horloge.getShow());
            }

            for (Show show : showRepo.findAll()) {
                if (!showsToReturn.contains(show)) {
                    showsToReturn.add(show);
                }
            }
            return showsToReturn;

        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return null;
    }

    @PostMapping("/add-horloge")
    public Horloge addHorloge(@RequestBody Horloge incoming) throws IOException {

        Horloge newOne = new HorlogeBuilder()
                .date(incoming.getDate())
                .show(incoming.getShow())
                .event(incoming.getEvent())
                .startTime(incoming.getStartTime())
                .endTime(incoming.getEndTime())
                .location(incoming.getLocation())
                .build();
        horlogeRepo.save(newOne);
        return newOne;
    }

    @PostMapping("/edit-horloge")
    public Optional<Horloge> editHorloge(@RequestBody Horloge incoming) throws IOException {
        Optional<Horloge> horlogeToFind = horlogeRepo.findById(incoming.getId());

        try {
            if (horlogeToFind.isPresent()) {
                Horloge horlogeToEdit = horlogeToFind.get();
                HorlogeEditor editor = new HorlogeEditor(horlogeToEdit);
                editor.editFrom(incoming);
                horlogeRepo.save(horlogeToEdit);
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return horlogeToFind;
    }


    @PostMapping("/get-date-from-show")
    public LocalDate getPrimaryDateFromShow(@RequestBody Show show) {
        try {
            Optional<Show> showToFind = showRepo.findById(show.getId());
            if (showToFind.isPresent()) {
                Show foundShow = showToFind.get();
                if (horlogeRepo.existsByEventAndShow(Event.PRIMARYDATE, foundShow)) {
                    return horlogeRepo.findByEventAndShow(Event.PRIMARYDATE, foundShow).getDate();
                }
            }
        } catch (
                Exception error) {
            error.printStackTrace();

        }
        return null;
    }

    @PostMapping("/get-all-concerts-of-show")
    public List<Horloge> getAllConcertsInShow(@RequestBody Show incoming) throws IOException {

        List<Horloge> datesToReturn = new ArrayList<>();

        try {
            Optional<Show> showToFind = showRepo.findById(incoming.getId());
            if (showToFind.isPresent()) {
                Show foundShow = showToFind.get();
                if (horlogeRepo.existsByEventAndShow(Event.PRIMARYDATE, foundShow)) {
                    datesToReturn.add(horlogeRepo.findByEventAndShow(Event.PRIMARYDATE, foundShow));
                }
                if (horlogeRepo.existsByEventAndShow(Event.CONCERT, foundShow)) {
                    datesToReturn.addAll(horlogeRepo.findAllByEventAndShow(Event.CONCERT, foundShow));
                }
                Collections.sort(datesToReturn);
            }
            return datesToReturn;
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return null;
    }


    @PostMapping("/get-full-schedule-of-show")
    public List<Horloge> getAllServicesOfShow(@RequestBody Show incoming) throws IOException {
        List<Horloge> datesToReturn = new ArrayList<>();

        try {
            Optional<Show> showToFind = showRepo.findById(incoming.getId());
            if (showToFind.isPresent()) {
                Show foundShow = showToFind.get();
                if (horlogeRepo.existsByShow(foundShow)) {
                    datesToReturn.addAll(horlogeRepo.findAllByShow(foundShow));
                }
                Collections.sort(datesToReturn);
            }
            return datesToReturn;
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return null;
    }
}
