package com.example.demo.service;

import com.example.demo.domain.Dessert;
import com.example.demo.domain.Part;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface OutsourcedPartService {
        public List<Dessert> findAll();
        public Dessert findById(int theId);
        public void save (Dessert thePart);
        public void deleteById(int theId);
}
