package com.rostermaker.demo.repos;

import com.rostermaker.demo.models.gigOffer.GigOffer;
import com.rostermaker.demo.models.player.Player;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface GigOfferRepo extends CrudRepository<GigOffer, Long> {

    Collection<GigOffer> findAllByPlayer(Player player);

    List<GigOffer> findAllBy(Sort sort);
    
    boolean existsByPlayer(Player player);

    void deleteAllByPlayer(Player playerToDelete);
}
