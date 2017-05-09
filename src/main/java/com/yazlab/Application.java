package com.yazlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);

		SQLite sqLite = new SQLite();

		Ev ev1 = new Ev();

		ev1.setEvID(3);
		ev1.setEvIL("Ankara");
		ev1.setEvEmlakTipi("Kiralık");
		ev1.setEvAlan(100);
		ev1.setEvOdaSayisi(5);
		ev1.setEvBinaYasi(6);
		ev1.setEvBulKat(2);
		ev1.setEvFiyat(200000);
		ev1.setEvAciklama("Güzel ev...");

		sqLite.insertEv(ev1);

		Resim resim1 = new Resim();

		resim1.setResimID(1);
		resim1.setResimYol("/resim1.jpg");
		resim1.setResimEvID(3);

		sqLite.insertResim(resim1);
	}
}