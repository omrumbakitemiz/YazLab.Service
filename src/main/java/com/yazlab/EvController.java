package com.yazlab;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EvController {

    @RequestMapping(value = "/ev", method = RequestMethod.GET)
    public ResponseEntity<List<Ev>> Ev() throws Exception {

        SQLite sqLite = new SQLite();

        ArrayList<Ev> ev = sqLite.selectEv();

        return new ResponseEntity<List<Ev>>(ev, HttpStatus.OK);
    }

    @RequestMapping(value = "/ev", method = RequestMethod.POST)
    public ResponseEntity<List<Ev>> Ev(@RequestBody List<Ev> evList) throws Exception {

        SQLite sqLite = new SQLite();
        Ev ev = new Ev();

        ev.setEvID(evList.get(0).getEvID());
        ev.setEvIL(evList.get(0).getEvIL());
        ev.setEvEmlakTipi(evList.get(0).getEvEmlakTipi());
        ev.setEvAlan(evList.get(0).getEvAlan());
        ev.setEvOdaSayisi(evList.get(0).getEvOdaSayisi());
        ev.setEvBinaYasi(evList.get(0).getEvBinaYasi());
        ev.setEvBulKat(evList.get(0).getEvBulKat());
        ev.setEvFiyat(evList.get(0).getEvFiyat());
        ev.setEvAciklama(evList.get(0).getEvAciklama());

        sqLite.insertEv(ev);

        return new ResponseEntity<List<Ev>> (evList , HttpStatus.OK);
    }

    @RequestMapping(value = "/{path}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@RequestParam("path") String path) throws IOException{

        ClassPathResource imgFile = new ClassPathResource("image/" + path + ".jpg");

        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }
}
