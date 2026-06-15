package com.example.demo.service;

import com.example.demo.domain.Snack;
import com.example.demo.domain.Dessert;
import com.example.demo.domain.Part;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface InhousePartService {
    public List<Snack> findAll();
    public Snack findById(int theId);
    public void save (Snack thePart);
    public void deleteById(int theId);
}
