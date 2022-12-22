package com.rostermaker.demo.controllers;

import com.rostermaker.demo.models.show.Show;
import com.rostermaker.demo.models.show.ShowBuilder;
import com.rostermaker.demo.models.show.ShowEditor;
import com.rostermaker.demo.repos.ShowRepo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ShowRest {

    @Resource
    ShowRepo showRepo;

    @RequestMapping("/get-all-performances")
    public Collection<Show> getAllShows() {
        List<Show> sortedShows = new ArrayList<>((Collection<Show>) showRepo.findAll());

        try {
            return sortedShows;

        } catch (Exception error) {
            error.printStackTrace();
        }

        return (Collection<Show>) showRepo.findAll();
    }

    @PostMapping("/add-performance")
    public Show addAShow(@RequestBody Show incoming) throws IOException {

        Show showToReturn;

        try {
            if (!showRepo.existsByTitle(incoming.getTitle())) {
                showToReturn = new ShowBuilder()
                        .title(incoming.getTitle())
                        .numberOfServices(incoming.getNumberOfServices())
                        .notes(incoming.getNotes())
                        .build();

                showRepo.save(showToReturn);
                return showToReturn;
            }

        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return null;
    }

    @PostMapping("/edit-performance")
    public Collection<Show> editAShowInDatabase(@RequestBody Show incoming) throws IOException {
        try {
            Optional<Show> showToFind = showRepo.findById(incoming.getId());
            if (showToFind.isPresent()) {
                Show showToEdit = showToFind.get();
                ShowEditor editor = new ShowEditor(showToEdit);
                editor.editFrom(incoming);
                showRepo.save(showToEdit);
            }
            return (Collection<Show>) showRepo.findAll();

        } catch (Exception error) {
            error.printStackTrace();
        }
        return (Collection<Show>) showRepo.findAll();
    }

}



