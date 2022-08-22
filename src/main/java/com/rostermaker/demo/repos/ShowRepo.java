package com.rostermaker.demo.repos;

import com.rostermaker.demo.models.show.Show;
import org.springframework.data.repository.CrudRepository;

public interface ShowRepo extends CrudRepository<Show, Long> {

    boolean existsByTitle(String title);

}
