package com.example.demo.service;

import com.example.demo.domain.Dessert;
import com.example.demo.domain.Snack;
import com.example.demo.repositories.SnackRepository;
import com.example.demo.repositories.DessertRepository;
import com.example.demo.repositories.SnackRepository;
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
public class InhousePartServiceImpl implements InhousePartService {
    private SnackRepository partRepository;

    @Autowired
    public InhousePartServiceImpl(SnackRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<Snack> findAll() {
        return (List<Snack>) partRepository.findAll();
    }

    @Override
    public Snack findById(int theId) {
        Long theIdl=(long)theId;
        Optional<Snack> result = partRepository.findById(theIdl);

        Snack thePart = null;

        if (result.isPresent()) {
            thePart = result.get();
        }
        else {
            // we didn't find the InhousePart id
            //throw new RuntimeException("Did not find part id - " + theId);
            return null;
        }

        return thePart;
    }

    @Override
    public void save(Snack thePart) {
        partRepository.save(thePart);

    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        partRepository.deleteById(theIdl);
    }

}
