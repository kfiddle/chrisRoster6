package com.rostermaker.demo.models.player;


import com.rostermaker.demo.enums.Type;
import com.rostermaker.demo.legos.playerInChair.PIC;
import com.rostermaker.demo.models.instrument.Instrument;
import com.rostermaker.demo.models.part.Part;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player implements Comparable<Player> {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    private Instrument primaryInstrument;

    private int rank;

    @ManyToMany
    private List<Instrument> instruments = new ArrayList<>();

    private String firstNameArea;
    private String lastName;
    private String email;
    private String homePhone;
    private String cellPhone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;

    private String username;
    private String password;
    private String role;

    public Player() {
    }

    public Player(PlayerBuilder playerBuilder) {
        firstNameArea = playerBuilder.firstNameArea;
        lastName = playerBuilder.lastName;
        instruments = playerBuilder.instruments;
        if (instruments.size() > 0) {
            primaryInstrument = instruments.get(0);
        }
        type = playerBuilder.type;
        rank = playerBuilder.rank;
        email = playerBuilder.email;
        homePhone = playerBuilder.homePhone;
        cellPhone = playerBuilder.cellPhone;
        addressLine1 = playerBuilder.addressLine1;
        addressLine2 = playerBuilder.addressLine2;
        city = playerBuilder.city;
        state = playerBuilder.state;
        zip = playerBuilder.zip;


        username = playerBuilder.username;
        password = playerBuilder.password;
        role = "player";
    }


    public void setType(Type type) {
        this.type = type;
    }

    public void setPrimaryInstrument(Instrument primaryInstrument) {
        this.primaryInstrument = primaryInstrument;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
        primaryInstrument = instruments.get(0);
    }

    public void setFirstNameArea(String firstNameArea) {
        this.firstNameArea = firstNameArea;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Instrument getPrimaryInstrument() {
        return primaryInstrument;
    }

    public int getRank() {
        return rank;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public String getFirstNameArea() {
        return firstNameArea;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public boolean couldSitHere(PIC pic) {
        for (Part part : pic.getParts()) {
            if (!instruments.contains(part.getInstrument())) {
                return false;
            }
        }
        return true;
    }


    @Override
    public int compareTo(Player otherPlayer) {
        if (primaryInstrument.compareTo(otherPlayer.getPrimaryInstrument()) != 0) {
            return primaryInstrument.compareTo(otherPlayer.getPrimaryInstrument());
        } else if (rank < otherPlayer.getRank()) {
            return -1;
        } else return type.compare(otherPlayer.getType());
    }


}
