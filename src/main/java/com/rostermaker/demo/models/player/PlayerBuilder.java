package com.rostermaker.demo.models.player;

import com.rostermaker.demo.enums.Type;
import com.rostermaker.demo.models.instrument.Instrument;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class PlayerBuilder {

    public Type type;

    public Instrument primaryInstrument;
    public int rank;
    public Collection<Instrument> otherInstruments = new ArrayList<>();

    public String firstNameArea;
    public String lastName;
    public String email;
    public String homePhone;
    public String cellPhone;
    public String addressLine1;
    public String addressLine2;
    public String city;
    public String state;
    public String zip;

    public String username;
    public String password;
    public String role;
    public List<Instrument> instruments = new ArrayList<>();

    public PlayerBuilder() {
    }

    public PlayerBuilder firstNameArea(String firstNameArea) {
        Optional<String> firstNameOpt = Optional.ofNullable(firstNameArea);
        firstNameOpt.ifPresent(gottenFirst -> this.firstNameArea = gottenFirst);
        return this;
    }

    public PlayerBuilder lastName(String lastName) {
        Optional<String> firstNameOpt = Optional.ofNullable(lastName);
        firstNameOpt.ifPresent(gotten -> this.lastName = gotten);
        return this;
    }

    public PlayerBuilder type(Type type) {
        Optional<Type> typeOpt = Optional.ofNullable(type);
        typeOpt.ifPresent(gotten -> this.type = gotten);
        return this;
    }

    public PlayerBuilder rank(int rank) {
        if (rank > 0) {
            this.rank = rank;
        }
        return this;
    }

    public PlayerBuilder instruments(List<Instrument> instruments) {
        Optional<List<Instrument>> instOpt = Optional.ofNullable(instruments);
        instOpt.ifPresent(gottenParts -> this.instruments = gottenParts);
        return this;
    }

    public PlayerBuilder addAnInstrument (Instrument instrument) {
        Optional<Instrument> partOpt = Optional.ofNullable(instrument);
        partOpt.ifPresent(gotten -> this.instruments.add(gotten));
        return this;
    }

    public PlayerBuilder email(String email) {
        Optional<String> emailOpt = Optional.ofNullable(email);
        if (emailOpt.isPresent()) {
            this.email = email;
            this.username = email;
        }
        return this;
    }

    public PlayerBuilder homePhone(String homePhone) {
        Optional<String> homePhoneOpt = Optional.ofNullable(homePhone);
        homePhoneOpt.ifPresent(gotten -> this.homePhone = gotten);
        return this;
    }

    public PlayerBuilder cellPhone(String cellPhone) {
        Optional<String> cellPhoneOpt = Optional.ofNullable(cellPhone);
        cellPhoneOpt.ifPresent(gotten -> this.cellPhone = gotten);
        return this;
    }

    public PlayerBuilder addressLine1(String addressLine1) {
        Optional<String> addressLine1Opt = Optional.ofNullable(addressLine1);
        addressLine1Opt.ifPresent(gotten -> this.addressLine1 = gotten);
        return this;
    }

    public PlayerBuilder addressLine2(String addressLine2) {
        Optional<String> addressLine2Opt = Optional.ofNullable(addressLine2);
        addressLine2Opt.ifPresent(gotten -> this.addressLine2 = gotten);
        return this;
    }

    public PlayerBuilder city(String city) {
        Optional<String> cityOpt = Optional.ofNullable(city);
        cityOpt.ifPresent(gotten -> this.city = gotten);
        return this;
    }

    public PlayerBuilder state(String state) {
        Optional<String> stateOpt = Optional.ofNullable(state);
        stateOpt.ifPresent(gotten -> this.state = gotten);
        return this;
    }

    public PlayerBuilder zip(String zip) {
        Optional<String> zipOpt = Optional.ofNullable(zip);
        zipOpt.ifPresent(gotten -> this.zip = gotten);
        return this;
    }

    //username is above in email()
    public PlayerBuilder password(String password) {
        Optional<String> passwordOpt = Optional.ofNullable(password);
        passwordOpt.ifPresent(gotten -> this.password = gotten);
        return this;
    }

    public PlayerBuilder role(String role) {
        Optional<String> roleOpt = Optional.ofNullable(role);
        roleOpt.ifPresent(gotten -> this.role = gotten);
        return this;
    }

    public Player build() {
        return new Player(this);
    }


}
