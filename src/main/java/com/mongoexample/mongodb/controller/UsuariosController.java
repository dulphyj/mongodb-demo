package com.mongoexample.mongodb.controller;

import com.mongoexample.mongodb.documents.Usuarios;
import com.mongoexample.mongodb.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Usuarios")
public class UsuariosController {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> saveUsuarios(@RequestBody Usuarios usuarios){
        try {
            return ResponseEntity.ok(usuarioRepository.save(usuarios));
        } catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAllUsuarios(){
        try{
            return ResponseEntity.ok(usuarioRepository.findAll());
        } catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable("id") Integer id, @RequestBody Usuarios usuarios){
        try {
            Optional<Usuarios> byIdUsuario = usuarioRepository.findById(id);
            byIdUsuario = Optional.of(usuarioRepository.save(usuarios));
            return ResponseEntity.ok(byIdUsuario);
        } catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") Integer id){
        try {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> findByIdUsuarios(@PathVariable("id") Integer id){
        try{
            return ResponseEntity.ok(usuarioRepository.findById(id));
        } catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
