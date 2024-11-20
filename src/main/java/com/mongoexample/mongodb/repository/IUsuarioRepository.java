package com.mongoexample.mongodb.repository;

import com.mongoexample.mongodb.documents.Usuarios;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUsuarioRepository extends MongoRepository<Usuarios, Integer> {

}
