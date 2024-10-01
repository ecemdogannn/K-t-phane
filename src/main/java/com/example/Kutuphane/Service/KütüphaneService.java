package com.example.Kutuphane.Service;

import com.example.Kutuphane.Entity.Kütüphane;
import com.example.Kutuphane.Repository.KütüphaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KütüphaneService {
    @Autowired
    private KütüphaneRepository repo;

    public List<Kütüphane> findAll(){
        return repo.findAll();
    }

    public Kütüphane getKitapById(String kitapAd){

        Kütüphane kütüphane = null;
        Optional <Kütüphane> kitap =  repo.findById(kitapAd);
        if (kitap.isPresent()){
            kütüphane = kitap.get();
        }
        else {
            throw new RuntimeException("kitap bulunamadı");
        }
        return kütüphane;
    }

    public Kütüphane addBook(Kütüphane kitaplar){
        return repo.save(kitaplar);
    }

    public void  deleteById(String kitapAd){
        repo.deleteById(kitapAd);
    }

    public Kütüphane UpdateKütüphane(Kütüphane kütüphane){
        Optional<Kütüphane> theBook = repo.findById(kütüphane.getKitapAd());//kullanıcı adını kullanarak mevcut kullanıcı bulunur.
        if (theBook.isPresent()){ //kullanıcı varsa
            Kütüphane UpdateKütüphane = theBook.get(); //user nesnesindeki değeri alır ve  UpdateUser değişkenine atar.
            return repo.save(UpdateKütüphane);// Güncellenmiş kullanıcıyı veritabanına kaydeder ve döndürür.
        }
        else { //eğer mevcut değilse
            return repo.save(kütüphane); //yeni kullanıcıyı dbye ekle
        }
    }
}
