package com.rostermaker.demo.repos;

import com.rostermaker.demo.enums.Type;
import com.rostermaker.demo.models.player.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface PlayerRepo extends CrudRepository<Player, Long> {

    Collection<Player> findAllByType(Type type);

    boolean existsByFirstNameAreaAndLastName(String firstNameArea, String lastName);

    Player findByFirstNameAreaAndLastName(String firstNameArea, String lastName);

    Optional<Player> findByUsername(String username);
}
