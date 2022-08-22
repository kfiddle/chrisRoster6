package com.rostermaker.demo.repos;

import com.rostermaker.demo.legos.ShowPiece;
import com.rostermaker.demo.legos.playerInChair.PIC;
import com.rostermaker.demo.models.show.Show;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PICRepo extends CrudRepository<PIC, Long> {

    Collection<PIC> findAllByShowPiece(ShowPiece showPiece);

    Collection<PIC> findAllByShow(Show show);

    boolean existsByShowPiece(ShowPiece showPiece);

    void deleteAllByShowPiece(ShowPiece showPiece);


}
