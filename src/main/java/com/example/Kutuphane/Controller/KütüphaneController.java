package com.example.Kutuphane.Controller;

import com.example.Kutuphane.Entity.Kütüphane;
import com.example.Kutuphane.Service.KütüphaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KütüphaneController {

    @Autowired
    private KütüphaneService kütüphaneService;

    @GetMapping("/Booksfer")
    public List<Kütüphane> findALL(){
        return kütüphaneService.findAll();
    }

    @GetMapping("/Booksfer/{kitapAd}")
    public Kütüphane getBook(@PathVariable String kitapAd){
        Kütüphane theBook = kütüphaneService.getKitapById(kitapAd);

        if (theBook == null){
            throw new RuntimeException("no book - " + kitapAd);
        }
        return theBook;
    }

    @PostMapping("/Booksfer")
    public Kütüphane addBook(@RequestBody Kütüphane kütüphane){
        return kütüphaneService.addBook(kütüphane);
    }

    @DeleteMapping("/Booksfer/{kitapAd}")
    public String deleteBook(@PathVariable String kitapAd){
        Kütüphane theBook = kütüphaneService.getKitapById(kitapAd);

        if (theBook == null){
            throw new RuntimeException("no book - " + kitapAd);
        }

        kütüphaneService.deleteById(kitapAd);
        return "delete book - " + kitapAd;
    }


    @PutMapping("/Booksfer")
    public Kütüphane updateBook(@RequestBody Kütüphane kütüphane){
        Kütüphane dbBook = kütüphaneService.addBook(kütüphane);
        return dbBook;
    }


}
