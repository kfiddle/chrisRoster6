package com.rostermaker.demo;

import com.rostermaker.demo.models.instrument.Instrument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);


//        List<Instrument> insts = new ArrayList<>(Arrays.asList(
//                new Instrument("VIOLA", 360),
//                new Instrument("PICCOLO", "PIC", 1),
//                new Instrument("BASS", 380),
//                new Instrument("CELLO", 370),
//                new Instrument("KAZU", "KZU"),
//                new Instrument("FLUTE", 10)
//
//        ));
//
//        Collections.sort(insts);
//        for (Instrument inst : insts) {
//            System.out.println(inst.getName());
//        }

    }

}
