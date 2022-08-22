package com.rostermaker.demo.models.player;

import com.rostermaker.demo.enums.Type;
import com.rostermaker.demo.models.instrument.Instrument;

import java.util.List;
import java.util.Optional;

public class PlayerEditor {

    public PlayerEditor() {
    }

    public Player editFrom(Player incoming, Player storedPlayer) {
        Optional<Type> typeOpt = Optional.ofNullable(incoming.getType());

        int rank = incoming.getRank();

        Optional<List<Instrument>> instrumentsOpt = Optional.ofNullable(incoming.getInstruments());

        if (rank > 0) {
            storedPlayer.setRank(rank);
        }

        typeOpt.ifPresent(storedPlayer::setType);

        Optional<String> firstNameOpt = Optional.ofNullable(incoming.getFirstNameArea());
        Optional<String> lastNameOpt = Optional.ofNullable(incoming.getLastName());
        Optional<String> emailOpt = Optional.ofNullable(incoming.getEmail());
        Optional<String> homePhoneOpt = Optional.ofNullable(incoming.getHomePhone());
        Optional<String> cellPhoneOpt = Optional.ofNullable(incoming.getCellPhone());
        Optional<String> addressLine1Opt = Optional.ofNullable(incoming.getAddressLine1());
        Optional<String> addressLine2Opt = Optional.ofNullable(incoming.getAddressLine2());
        Optional<String> cityOpt = Optional.ofNullable(incoming.getCity());
        Optional<String> stateOpt = Optional.ofNullable(incoming.getState());
        Optional<String> zipOpt = Optional.ofNullable(incoming.getZip());
        Optional<String> passwordOpt = Optional.ofNullable(incoming.getPassword());

        instrumentsOpt.ifPresent(storedPlayer::setInstruments);

        firstNameOpt.ifPresent(storedPlayer::setFirstNameArea);
        lastNameOpt.ifPresent(storedPlayer::setLastName);

        if (emailOpt.isPresent()) {
            storedPlayer.setEmail(emailOpt.get());
            storedPlayer.setUsername(emailOpt.get());
        }

        homePhoneOpt.ifPresent(storedPlayer::setHomePhone);
        cellPhoneOpt.ifPresent(storedPlayer::setCellPhone);
        addressLine1Opt.ifPresent(storedPlayer::setAddressLine1);
        addressLine2Opt.ifPresent(storedPlayer::setAddressLine2);
        cityOpt.ifPresent(storedPlayer::setCity);
        stateOpt.ifPresent(storedPlayer::setState);
        zipOpt.ifPresent(storedPlayer::setZip);
        passwordOpt.ifPresent(storedPlayer::setPassword);

        return storedPlayer;
    }


}
