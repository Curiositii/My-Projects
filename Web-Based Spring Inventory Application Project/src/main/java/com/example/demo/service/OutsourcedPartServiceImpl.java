package com.example.demo.service;

import com.example.demo.domain.Dessert;
import com.example.demo.repositories.DessertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Service
public class OutsourcedPartServiceImpl implements OutsourcedPartService{
    private DessertRepository partRepository;

    @Autowired
    public OutsourcedPartServiceImpl(DessertRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<Dessert> findAll() {
        return (List<Dessert>) partRepository.findAll();
    }

    @Override
    public Dessert findById(int theId) {
        Long theIdl=(long)theId;
        Optional<Dessert> result = partRepository.findById(theIdl);

        Dessert thePart = null;

        if (result.isPresent()) {
            thePart = result.get();
        }
        else {
            // we didn't find the OutSourced id
            //throw new RuntimeException("Did not find part id - " + theId);
            return null;
        }

        return thePart;
    }

    @Override
    public void save(Dessert thePart) {
        partRepository.save(thePart);

    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        partRepository.deleteById(theIdl);
    }

}
