package com.bookishjava.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.bookishjava.models.database.Copy;
import com.bookishjava.repositories.CopyRepository;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class CopyController {

    private final CopyRepository repository;

    CopyController(CopyRepository repository){
        this.repository = repository;
    }

    @GetMapping("/copies")
    List<Copy> getCopies(){
        return repository.findAll();
    }

    @GetMapping("copy/{id}")
    Optional<Copy> getCopyById(@PathVariable Long id)
    {
        return repository.findById(id);
    }

    @PostMapping("/new-copy")
    void insertBook(Copy copy)
    {
        String sqlQuery = "INSERT INTO public.copy ";
    }
}
