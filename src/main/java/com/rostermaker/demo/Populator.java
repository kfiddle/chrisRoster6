//package com.rostermaker.demo;
//
//
//import com.rostermaker.demo.enums.Event;
//import com.rostermaker.demo.enums.Type;
//import com.rostermaker.demo.legos.ShowPiece;
//import com.rostermaker.demo.models.gigOffer.GigOffer;
//import com.rostermaker.demo.models.instrument.Instrument;
//import com.rostermaker.demo.models.piece.Piece;
//import com.rostermaker.demo.models.piece.PieceBuilder;
//import com.rostermaker.demo.models.player.Player;
//import com.rostermaker.demo.models.player.PlayerBuilder;
//import com.rostermaker.demo.models.show.Horloge;
//import com.rostermaker.demo.models.show.HorlogeBuilder;
//import com.rostermaker.demo.models.show.Show;
//import com.rostermaker.demo.models.show.ShowBuilder;
//import com.rostermaker.demo.repos.*;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.core.parameters.P;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.Arrays;
//
//@Component
//public class Populator implements CommandLineRunner {
//
//    @Resource
//    InstrumentRepo instrumentRepo;
//
//    @Resource
//    PlayerRepo playerRepo;
//
//    @Resource
//    ShowRepo showRepo;
//
//    @Resource
//    PieceRepo pieceRepo;
//
//    @Resource
//    ShowPieceRepo showPieceRepo;
//
//    @Resource
//    HorlogeRepo horlogeRepo;
//
//    @Resource
//    GigOfferRepo gigOfferRepo;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        BCryptPasswordEncoder robot = new BCryptPasswordEncoder(10);
//
//        String leAnnePass = "$2a$10$kGpFBqAssRWvAD8ZOpaA4OcMAuwF8HhLgcBRaKxtkYJS/nLFslr2q"; //WistromFlute;
//        String seanGPass = "$2a$10$eruF6uYH1f3U7m71kZ7NAuXg1QXHpD.HC77bs4cdBeTATMz0Lp9Qm"; // GabrielFlute;
//        String dannaPass = "$2a$10$4g4MTJQJvGxDOwq8I3o11eK.oprxXzmQoZUKz53ASd4p1M2S5WSd6"; //SundetOboe;
//        String sarahHamPass = robot.encode("HamiltonOboe");
//        String benCPass = "$2a$10$vbcr4fk7Xvmij5S7.PAYHO/EQB/09lSBJW2c53OB0XPrXGtD5SiEC"; //ChenClarinet;
//        String amiPass = "$2a$10$.khi1kIOXsVLPjWHyTC2GexDRWGnfsL0zOi9AsGd5wktcBKp0M97e"; //VardiClarinet;
//        String boutinePass = robot.encode("dbb@Email");
//
//        String kenPass = robot.encode("KenPassword");
//        String chrisPass = robot.encode("managerPass");
//        String troyPass = robot.encode("rookfoot");
//
//
//        Player chrisNewlun = new PlayerBuilder().firstNameArea("Orchestra").lastName("Manager").email("manager@Email").password(chrisPass).build();
//        Player troy = new PlayerBuilder().firstNameArea("Troy").lastName("Harris").email("troyman7000@gmail.com").password(troyPass).build();
//
//        Instrument piccolo = new Instrument("PICCOLO", "PIC", 10);
//        Instrument flute = new Instrument("FLUTE", "FL", 20);
//        Instrument altoFlute = new Instrument("ALTO FLUTE", "AFL", 30);
//        Instrument bassFlute = new Instrument("BASS FLUTE", "BFL", 31);
//        Instrument tenorFlute = new Instrument("FLUTE D'AMORE", "FDA", 32);
//        Instrument oboe = new Instrument("OBOE", "OB", 40);
//        Instrument englishHorn = new Instrument("ENGLISH HORN", "EH", 50);
//        Instrument oboeDamore = new Instrument("OBOE D'AMORE", "ODA", 60);
//        Instrument bassOboe = new Instrument("BASS OBOE", "BOB", 70);
//        Instrument clarinet = new Instrument("CLARINET", "CL", 80);
//        Instrument ebClarinet = new Instrument("EB CLARINET", "EBCL", 90);
//        Instrument bassClarinet = new Instrument("BASS CLARINET", "BCL", 100);
//        Instrument sax = new Instrument("SAX", "SAX", 110);
//        Instrument bassoon = new Instrument("BASSOON", "BSN", 120);
//        Instrument contra = new Instrument("CONTRA", "CBSN", 130);
//        Instrument horn = new Instrument("HORN", "HN", 140);
//        Instrument wagnerTuba = new Instrument("WAGNER TUBA", "WTBA", 150);
//        Instrument piccTrumpet = new Instrument("PICC TRUMPET", "PTPT", 160);
//        Instrument trumpet = new Instrument("TRUMPET", "TPT", 170);
//        Instrument cornet = new Instrument("CORNET", "CRT", 180);
//        Instrument flugelHorn = new Instrument("FLUGELHORN", "FGH", 190);
//        Instrument trombone = new Instrument("TROMBONE", "TBN", 200);
//        Instrument bassTrombone = new Instrument("BASS TROMBONE", "BTRBN", 210);
//        Instrument euphonium = new Instrument("EUPHONIUM", "EUPH", 220);
//        Instrument tuba = new Instrument("TUBA", "TBA", 230);
//        Instrument tenorTuba = new Instrument("TENOR TUBA", "TTBA", 240);
//        Instrument timpani = new Instrument("TIMPANI", 250);
//        Instrument percussion = new Instrument("PERCUSSION", 260);
//        Instrument drumset = new Instrument("DRUMSET", 270);
//        Instrument harp = new Instrument("HARP", 280);
//        Instrument piano = new Instrument("PIANO", 290);
//        Instrument celeste = new Instrument("CELESTE", 300);
//        Instrument keyboard = new Instrument("KEYBOARD", 310);
//        Instrument glock = new Instrument("GLOCKENSPIEL", 320);
//        Instrument organ = new Instrument("ORGAN", 330);
//        Instrument violin1 = new Instrument("VIOLIN1", 340);
//        Instrument violin2 = new Instrument("VIOLIN2", 350);
//        Instrument viola = new Instrument("VIOLA", 360);
//        Instrument cello = new Instrument("CELLO", 370);
//        Instrument bass = new Instrument("BASS", 380);
//
//        instrumentRepo.saveAll(Arrays.asList(piccolo, flute, altoFlute, bassFlute, tenorFlute, oboe, englishHorn, oboeDamore, bassOboe, englishHorn, clarinet, ebClarinet, bassClarinet,
//                sax, bassoon, contra, horn, wagnerTuba, piccTrumpet, trumpet, cornet, flugelHorn, trombone, bassTrombone, euphonium,
//                tuba, tenorTuba, timpani, percussion, drumset, harp, piano, celeste, keyboard, glock, organ, violin1, violin2,
//                viola, cello, bass));
//
//
//        Player leAnne = new PlayerBuilder().firstNameArea("Leanne").lastName("Wistrom").type(Type.CONTRACTED).rank(1).addAnInstrument(flute).password(leAnnePass).email("lw@Email").build();
//        Player seanG = new PlayerBuilder().firstNameArea("Sean").lastName("Gabriel").type(Type.CONTRACTED).rank(2).addAnInstrument(flute).password(seanGPass).email("sg@Email").build();
//        Player danna = new PlayerBuilder().firstNameArea("Danna").lastName("Sundet").type(Type.CONTRACTED).rank(1).addAnInstrument(oboe).password(dannaPass).email("ds@Email").build();
//        Player heatherS = new PlayerBuilder().firstNameArea("Heather").lastName("Story").type(Type.CONTRACTED).rank(2).addAnInstrument(oboe).email("kenjfiddle@gmail.com").build();
//        Player sarahH = new PlayerBuilder().firstNameArea("Sarah").lastName("Hamilton").type(Type.CONTRACTED).rank(3).addAnInstrument(oboe).password(sarahHamPass).email("sh@Email").build();
//        Player ami = new Player(new PlayerBuilder().firstNameArea("Ami").lastName("Vardi").type(Type.CONTRACTED).rank(1).addAnInstrument(clarinet).password(amiPass).email("av@Email"));
//        Player benC = new Player(new PlayerBuilder().firstNameArea("Benjamin").lastName("Chen").type(Type.CONTRACTED).rank(2).addAnInstrument(clarinet).password(benCPass).email("bc@Email"));
//        Player db = new Player(new PlayerBuilder().firstNameArea("David").lastName("Boutin-Bourque").type(Type.CONTRACTED).rank(3).addAnInstrument(clarinet).addAnInstrument(bassClarinet).password(boutinePass).email("dbb@Email"));
//        Player kdo = new Player(new PlayerBuilder().firstNameArea("KeriAnn").lastName("DiBari-Oberle").type(Type.CONTRACTED).rank(4).addAnInstrument(clarinet).addAnInstrument(ebClarinet).email("kenjfiddle@gmail.com"));
//        Player lk = new Player(new PlayerBuilder().firstNameArea("Laura").lastName("Koepke").type(Type.CONTRACTED).rank(1).addAnInstrument(bassoon).email("kenjfiddle@gmail.com"));
//        Player lel = new Player(new PlayerBuilder().firstNameArea("Sarah Elizabeth").lastName("Lee").type(Type.CONTRACTED).rank(2).addAnInstrument(bassoon).email("kenjfiddle@gmail.com"));
//        Player cr = new Player(new PlayerBuilder().firstNameArea("Chris").lastName("Rapier").type(Type.CONTRACTED).rank(1).addAnInstrument(horn).email("kenjfiddle@gmail.com"));
//        Player ma = new Player(new PlayerBuilder().firstNameArea("Mark").lastName("Addleman").type(Type.CONTRACTED).rank(2).addAnInstrument(horn).email("kenjfiddle@gmail.com"));
//        Player es = new Player(new PlayerBuilder().firstNameArea("Emily").lastName("Shelley").type(Type.CONTRACTED).rank(3).addAnInstrument(horn).email("kenjfiddle@gmail.com"));
//        Player ba = new Player(new PlayerBuilder().firstNameArea("Bryan").lastName("Adkins").type(Type.CONTRACTED).rank(4).addAnInstrument(horn).email("kenjfiddle@gmail.com"));
//        Player bs = new Player(new PlayerBuilder().firstNameArea("Benjamin").lastName("Strecker").type(Type.CONTRACTED).rank(5).addAnInstrument(horn).email("kenjfiddle@gmail.com"));
//        Player gd = new Player(new PlayerBuilder().firstNameArea("Gary").lastName("Davis").type(Type.CONTRACTED).rank(1).addAnInstrument(trumpet).email("kenjfiddle@gmail.com"));
//        Player da = new Player(new PlayerBuilder().firstNameArea("Douglas").lastName("Amos").type(Type.CONTRACTED).rank(2).addAnInstrument(trumpet).email("kenjfiddle@gmail.com"));
//        Player mh = new Player(new PlayerBuilder().firstNameArea("Micah").lastName("Holt").type(Type.CONTRACTED).rank(3).addAnInstrument(trumpet).email("kenjfiddle@gmail.com"));
//        Player wc = new Player(new PlayerBuilder().firstNameArea("Whitney").lastName("Claire").type(Type.CONTRACTED).rank(1).addAnInstrument(trombone).email("kenjfiddle@gmail.com"));
//        Player sb = new Player(new PlayerBuilder().firstNameArea("Sean").lastName("Bessette").type(Type.CONTRACTED).rank(1).addAnInstrument(bassTrombone).email("kenjfiddle@gmail.com"));
//        Player kh = new Player(new PlayerBuilder().firstNameArea("Ken").lastName("Heinlein").type(Type.CONTRACTED).rank(1).addAnInstrument(tuba).email("kenjfiddle@gmail.com"));
//        Player bradA = new Player(new PlayerBuilder().firstNameArea("Brad").lastName("Amidon").type(Type.CONTRACTED).rank(1).addAnInstrument(percussion).email("kenjfiddle@gmail.com"));
//        Player ml = new Player(new PlayerBuilder().firstNameArea("Matt").lastName("Larson").type(Type.CONTRACTED).rank(2).addAnInstrument(percussion).email("kenjfiddle@gmail.com"));
//        Player mr = new Player(new PlayerBuilder().firstNameArea("Melody").lastName("Rapier").type(Type.CONTRACTED).rank(1).addAnInstrument(harp).email("kenjfiddle@gmail.com"));
//        Player kj = new Player(new PlayerBuilder().firstNameArea("Ken").lastName("Johnston").type(Type.CONTRACTED).rank(1).addAnInstrument(violin1).password(kenPass).email("kenjfiddle@gmail.com"));
//        Player minji = new Player(new PlayerBuilder().firstNameArea("Minju").lastName("Kim").type(Type.CONTRACTED).rank(2).addAnInstrument(violin1).password(kenPass).email("minjuk622@gmail"));
//
//        Player sls = new Player(new PlayerBuilder().firstNameArea("Sandro").lastName("Leal-Santiesteban").type(Type.CONTRACTED).rank(2).addAnInstrument(violin1));
//        Player jh = new Player(new PlayerBuilder().firstNameArea("Joshua").lastName("Huang").type(Type.CONTRACTED).rank(3).addAnInstrument(violin1));
//        Player melissaH = new Player(new PlayerBuilder().firstNameArea("Melissa").lastName("Hernandez").type(Type.CONTRACTED).rank(3).addAnInstrument(violin1));
//        Player ah = new Player(new PlayerBuilder().firstNameArea("Alexander").lastName("Hettinga").type(Type.CONTRACTED).rank(3).addAnInstrument(violin1));
//        Player stefS = new Player(new PlayerBuilder().firstNameArea("Stefanie").lastName("Schore").type(Type.CONTRACTED).rank(3).addAnInstrument(violin1));
//        Player yk = new Player(new PlayerBuilder().firstNameArea("Yejee").lastName("Kim").type(Type.CONTRACTED).rank(3).addAnInstrument(violin1).email("kenjfiddle@gmail.com"));
//        Player mp = new Player(new PlayerBuilder().firstNameArea("Maura").lastName("Pelinsky").type(Type.CONTRACTED).rank(3).addAnInstrument(violin1).email("kenjfiddle@gmail.com"));
//        Player jc = new Player(new PlayerBuilder().firstNameArea("Janice").lastName("Carlson").type(Type.CONTRACTED).rank(3).addAnInstrument(violin1).email("kenjfiddle@gmail.com"));
//        Player jm = new Player(new PlayerBuilder().firstNameArea("Jonathan").lastName("Moser").type(Type.CONTRACTED).rank(1).addAnInstrument(violin2).email("kenjfiddle@gmail.com"));
//        Player jenJ = new Player(new PlayerBuilder().firstNameArea("Jennifer").lastName("Jansen").type(Type.CONTRACTED).rank(3).addAnInstrument(violin2).email("kenjfiddle@gmail.com"));
//        Player tobias = new Player(new PlayerBuilder().firstNameArea("Tobias").lastName("Chisnall").type(Type.CONTRACTED).rank(3).addAnInstrument(violin2).email("kenjfiddle@gmail.com"));
//        Player jiyeonY = new Player(new PlayerBuilder().firstNameArea("Jiyeon").lastName("Yeo").type(Type.CONTRACTED).rank(3).addAnInstrument(violin2).email("kenjfiddle@gmail.com"));
//        Player cv = new Player(new PlayerBuilder().firstNameArea("Colleen").lastName("Vanderzyden").type(Type.CONTRACTED).rank(3).addAnInstrument(violin2).email("kenjfiddle@gmail.com"));
//        Player kf = new Player(new PlayerBuilder().firstNameArea("Karen").lastName("Ferren").type(Type.CONTRACTED).rank(3).addAnInstrument(violin2).email("kenjfiddle@gmail.com"));
//        Player hl = new Player(new PlayerBuilder().firstNameArea("Howard").lastName("Lyon").type(Type.CONTRACTED).rank(3).addAnInstrument(violin2).email("kenjfiddle@gmail.com"));
//        Player ee = new Player(new PlayerBuilder().firstNameArea("Emilie").lastName("Engel").type(Type.CONTRACTED).rank(3).addAnInstrument(violin2).email("kenjfiddle@gmail.com"));
//        Player jiYoung = new Player(new PlayerBuilder().firstNameArea("Ji Young").lastName("Nam").type(Type.CONTRACTED).rank(1).addAnInstrument(viola).email("kenjfiddle@gmail.com"));
//        Player sy = new Player(new PlayerBuilder().firstNameArea("Si").lastName("Yu").type(Type.CONTRACTED).rank(3).addAnInstrument(viola).email("kenjfiddle@gmail.com"));
//        Player benS = new Player(new PlayerBuilder().firstNameArea("Benjamin").lastName("Schantz").type(Type.CONTRACTED).rank(3).addAnInstrument(viola).email("kenjfiddle@gmail.com"));
//        Player eriS = new Player(new PlayerBuilder().firstNameArea("Eri").lastName("Snowden-Rodriguez").type(Type.CONTRACTED).rank(1).addAnInstrument(cello).email("kenjfiddle@gmail.com"));
//        Player wt = new Player(new PlayerBuilder().firstNameArea("Will").lastName("Teegarden").type(Type.CONTRACTED).rank(2).addAnInstrument(cello).email("kenjfiddle@gmail.com"));
//        Player nadineS = new Player(new PlayerBuilder().firstNameArea("Nadine").lastName("Sherman").type(Type.CONTRACTED).rank(3).addAnInstrument(cello).email("kenjfiddle@gmail.com"));
//        Player jeffS = new Player(new PlayerBuilder().firstNameArea("Jeff").lastName("Singler").type(Type.CONTRACTED).rank(3).addAnInstrument(cello).email("kenjfiddle@gmail.com"));
//        Player bn = new Player(new PlayerBuilder().firstNameArea("Robert").lastName("Nicholson").type(Type.CONTRACTED).rank(3).addAnInstrument(cello).email("kenjfiddle@gmail.com"));
//        Player jv = new Player(new PlayerBuilder().firstNameArea("Jean").lastName("Verdecchia").type(Type.CONTRACTED).rank(3).addAnInstrument(cello).email("kenjfiddle@gmail.com"));
//        Player kieranH = new Player(new PlayerBuilder().firstNameArea("Kieran").lastName("Hanlon").type(Type.CONTRACTED).rank(1).addAnInstrument(bass).email("kenjfiddle@gmail.com"));
//        Player josephH = new Player(new PlayerBuilder().firstNameArea("Joseph").lastName("Hernandez").type(Type.CONTRACTED).rank(2).addAnInstrument(bass).email("kenjfiddle@gmail.com"));
//        Player tomC = new Player(new PlayerBuilder().firstNameArea("Thomas").lastName("Christopherson").type(Type.CONTRACTED).rank(3).addAnInstrument(bass).email("kenjfiddle@gmail.com"));
//        Player jamesM = new Player(new PlayerBuilder().firstNameArea("James").lastName("Mohney").type(Type.CONTRACTED).rank(3).addAnInstrument(bass).email("kenjfiddle@gmail.com"));
//        Player mariaP = new Player(new PlayerBuilder().firstNameArea("Maria").lastName("Park").type(Type.SUB).rank(1).addAnInstrument(violin1).email("kenjfiddle@gmail.com"));
//        Player mikeChen = new Player(new PlayerBuilder().firstNameArea("Mike").lastName("Chen").type(Type.SUB).rank(1).addAnInstrument(flute).email("kenjfiddle@gmail.com"));
//        Player dianaV = new Player(new PlayerBuilder().firstNameArea("Diana").lastName("Pepelea").type(Type.SUB).rank(1).addAnInstrument(flute).email("kenjfiddle@gmail.com"));
//        Player samPetrey = new Player(new PlayerBuilder().firstNameArea("Sam").lastName("Petrey").type(Type.SUB).rank(1).addAnInstrument(flute).email("kenjfiddle@gmail.com"));
//        Player maijaAnstine = new Player(new PlayerBuilder().firstNameArea("Maija").lastName("Anstine").type(Type.SUB).rank(1).addAnInstrument(viola).email("kenjfiddle@gmail.com"));
//        Player chrisBlaha = new Player(new PlayerBuilder().firstNameArea("Chris").lastName("Blaha").type(Type.SUB).rank(1).addAnInstrument(tuba).email("kenjfiddle@gmail.com"));
//        Player erikSund = new Player(new PlayerBuilder().firstNameArea("Erik").lastName("Sundet").type(Type.SUB).rank(1).addAnInstrument(trumpet).email("kenjfiddle@gmail.com"));
//
//        playerRepo.saveAll(Arrays.asList(chrisNewlun, troy, leAnne, seanG, ami, sarahH, danna, heatherS, sarahH, benC, db, kdo, jenJ, jeffS, jiYoung, lk, lel, cr, ma, es, ba, bs, gd,
//                da, mh, wc, sb, kh, bradA, ml, mr, kj, sls, jh, melissaH, ah, stefS, yk, mp, jc, sy, benS,
//                eriS, ee, jiYoung, cv, kf, hl, wt, tobias, jiyeonY, jenJ, mp, jc, jm, nadineS, bn, jv, kieranH, josephH, tomC, jamesM, mariaP, mikeChen, dianaV,
//                samPetrey, maijaAnstine, chrisBlaha, erikSund));
//
//        pieceRepo.saveAll(Arrays.asList(new PieceBuilder().composerName("Beethoven").title("Symphony 9").duration("65:00").build(),
//                new PieceBuilder().composerName("Sigfúsdóttir").title("Oceans").duration("9:30").build(),
//                new PieceBuilder().composerName("Golijov").title("Sidereus").duration("8:00").build(),
//                new PieceBuilder().composerName("Piazzolla").title("Aconcagua").duration("20:00").build(),
//                new PieceBuilder().composerName("Holst").title("The Planets").duration("51:00").build(),
//                new PieceBuilder().composerName("Strauss").title("Emperor Waltzes").duration("10:00").build(),
//                new PieceBuilder().composerName("Schumann").title("Violin Concerto").duration("33:00").build(),
//                new PieceBuilder().composerName("Brahms").title("Symphony 3").duration("37:00").build(),
//                new PieceBuilder().composerName("Auerbach").title("Icarus").duration("12:00").build(),
//                new PieceBuilder().composerName("Tchaikovsky").title("Piano Concerto No. 1").duration("32:00").build(),
//                new PieceBuilder().composerName("Prokofiev").title("Alexander Nevsky Cantata").duration("36:00").build()));
//
//
//        Piece diamond = new PieceBuilder().composerName("Diamond").title("Symphony 4").duration("16:00").build();
//        Piece poulenc = new PieceBuilder().composerName("Poulenc").title("Concerto for Organ and Orchestra").duration("26:00").build();
//        Piece laMer = new PieceBuilder().composerName("Debussy").title("La Mer").duration("23:00").build();
//
//        pieceRepo.saveAll(Arrays.asList(diamond, poulenc, laMer));
//
//        Show sym1 = new ShowBuilder().title("Sym 1").build();
//        Show sym2 = new ShowBuilder().title("Sym 2").build();
//        Show sym3 = new ShowBuilder().title("Sym 3").build();
//        Show sym4 = new ShowBuilder().title("Sym 4").build();
//        Show sym5 = new ShowBuilder().title("Sym 5").build();
//
//        Show pops1 = new ShowBuilder().title("Pops 1: Sheena Easton").build();
//        Show pops2 = new ShowBuilder().title("Pops 2: Empire").build();
//        Show pops3 = new ShowBuilder().title("Pops 3: Holiday Pops").build();
//        Show pops4 = new ShowBuilder().title("Pops 4: Toy Story").build();
//        Show pops5 = new ShowBuilder().title("Pops 5: Cirque").build();
//
//        showRepo.saveAll(Arrays.asList(sym1, sym2, sym3, sym4, sym5, pops1, pops2, pops3, pops4, pops5));
//
//        Horloge sym1Hor = new HorlogeBuilder().date(LocalDate.of(2022, 10, 22)).startTime(LocalTime.of(8, 0)).show(sym1).event(Event.PRIMARYDATE).location("Warner").build();
//        Horloge sym2Hor = new HorlogeBuilder().date(LocalDate.of(2022, 11, 12)).startTime(LocalTime.of(8, 0)).show(sym2).event(Event.PRIMARYDATE).build();
//        Horloge sym3Hor = new HorlogeBuilder().date(LocalDate.of(2023, 1, 28)).startTime(LocalTime.of(8, 0)).show(sym3).event(Event.PRIMARYDATE).build();
//        Horloge sym4Hor = new HorlogeBuilder().date(LocalDate.of(2023, 3, 25)).startTime(LocalTime.of(8, 0)).show(sym4).event(Event.PRIMARYDATE).build();
//        Horloge sym5Hor = new HorlogeBuilder().date(LocalDate.of(2023, 5, 13)).startTime(LocalTime.of(8, 0)).show(sym5).event(Event.PRIMARYDATE).build();
//
//
//        Horloge pops1Hor = new HorlogeBuilder().date(LocalDate.of(2022, 10, 1)).startTime(LocalTime.of(8, 0)).show(pops1).event(Event.PRIMARYDATE).build();
//        Horloge pops2Hor = new HorlogeBuilder().date(LocalDate.of(2022, 11, 5)).startTime(LocalTime.of(8, 0)).show(pops2).event(Event.PRIMARYDATE).build();
//        Horloge pops3Hor = new HorlogeBuilder().date(LocalDate.of(2022, 12, 3)).startTime(LocalTime.of(8, 0)).show(pops3).event(Event.PRIMARYDATE).build();
//        Horloge pops4Hor = new HorlogeBuilder().date(LocalDate.of(2023, 2, 18)).startTime(LocalTime.of(8, 0)).show(pops4).event(Event.PRIMARYDATE).build();
//        Horloge pops5Hor = new HorlogeBuilder().date(LocalDate.of(2023, 4, 15)).startTime(LocalTime.of(8, 0)).show(pops5).event(Event.PRIMARYDATE).build();
//
//        Horloge sym1Rh1 = new HorlogeBuilder().date(LocalDate.of(2022, 10, 18)).startTime(LocalTime.of(7, 30)).endTime(LocalTime.of(10, 0)).show(sym1).event(Event.REHEARSAL).location("Warner").build();
//        Horloge sym1Rh2 = new HorlogeBuilder().date(LocalDate.of(2022, 10, 19)).startTime(LocalTime.of(7, 30)).endTime(LocalTime.of(10, 0)).show(sym1).event(Event.REHEARSAL).location("Warner-Rehearsal Hall").build();
//        Horloge sym1Rh3 = new HorlogeBuilder().date(LocalDate.of(2022, 10, 22)).startTime(LocalTime.of(2, 0)).endTime(LocalTime.of(4, 30)).show(sym1).event(Event.REHEARSAL).location("Warner").build();
//
//
//        horlogeRepo.saveAll(Arrays.asList(sym1Hor, sym2Hor, sym3Hor, sym4Hor, sym5Hor, pops1Hor, pops2Hor, pops3Hor, pops4Hor, pops5Hor,
//                sym1Rh1, sym1Rh2, sym1Rh3
//        ));
//
//
//        ShowPiece diamondOnFirst = new ShowPiece(diamond, sym2, 0);
//        ShowPiece poulencOnFirst = new ShowPiece(poulenc, sym2, 1);
//        ShowPiece laMerOnFirst = new ShowPiece(laMer, sym2, 2);
//
//        showPieceRepo.saveAll(Arrays.asList(diamondOnFirst, poulencOnFirst, laMerOnFirst));
//
//        LocalDate generalDate = LocalDate.of(2022, 6, 17);
//
//        gigOfferRepo.saveAll(Arrays.asList(new GigOffer(pops1, kj, generalDate),
//                new GigOffer(pops4, leAnne, generalDate),
//                new GigOffer(sym1, leAnne, generalDate),
//                new GigOffer(sym2, leAnne, generalDate),
//                new GigOffer(sym3, leAnne, generalDate),
//                new GigOffer(sym4, leAnne, generalDate),
//                new GigOffer(sym5, leAnne, generalDate),
//                new GigOffer(pops1, leAnne, generalDate),
//                new GigOffer(pops2, leAnne, generalDate),
//                new GigOffer(pops3, leAnne, generalDate),
//                new GigOffer(pops5, leAnne, generalDate),
//                new GigOffer(sym1, ami, generalDate),
//                new GigOffer(sym2, ami, generalDate),
//                new GigOffer(sym3, ami, generalDate),
//                new GigOffer(sym2, danna, generalDate)));
//
//    }
//}
