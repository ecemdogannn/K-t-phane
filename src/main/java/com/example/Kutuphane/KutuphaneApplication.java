package com.example.Kutuphane;

import com.example.Kutuphane.Entity.Kütüphane;
import com.example.Kutuphane.Repository.KütüphaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KutuphaneApplication implements CommandLineRunner {

	@Autowired
	private KütüphaneRepository kütüphaneRepository;

	public static void main(String[] args) {
		SpringApplication.run(KutuphaneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Kütüphane kütüphane = new Kütüphane("1","Pinokyo", "daniel collo", 150);

		kütüphaneRepository.save(kütüphane);
		System.out.println("veri eklendi: " + kütüphane.getKitapAd());
	}
}
