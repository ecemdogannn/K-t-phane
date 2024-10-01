package com.example.Kutuphane.Repository;

import com.example.Kutuphane.Entity.Kütüphane;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KütüphaneRepository extends MongoRepository<Kütüphane, String> {
}
