package com.example.demo.bootstrap;

import com.example.demo.domain.Dessert;
import com.example.demo.domain.Product;
import com.example.demo.domain.Snack;
import com.example.demo.repositories.DessertRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.SnackRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final SnackRepository snackRepository;
    private final ProductRepository productRepository;
    private final DessertRepository dessertRepository;
    private final PartRepository partRepository;

    public BootStrapData(SnackRepository snackRepository, ProductRepository productRepository, DessertRepository dessertRepository, PartRepository partRepository) {
        this.snackRepository = snackRepository;
        this.productRepository = productRepository;
        this.dessertRepository = dessertRepository;
        this.partRepository = partRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(partRepository.count() == 0) {
            Dessert danish = new Dessert();
            danish.setName("Danish");
            danish.setInv(6);
            danish.setPrice(4.00);
            danish.setId(11);
            danish.setMinInv(1);
            danish.setMaxInv(12);
            partRepository.save(danish);

            Snack muffin = new Snack();
            muffin.setName("Muffin");
            muffin.setInv(6);
            muffin.setPrice(2.25);
            muffin.setId(22);
            muffin.setMinInv(1);
            muffin.setMaxInv(24);
            partRepository.save(muffin);

            Snack frenchFries = new Snack();
            frenchFries.setName("French Fries");
            frenchFries.setInv(20);
            frenchFries.setPrice(4.75);
            frenchFries.setId(33);
            frenchFries.setMinInv(1);
            frenchFries.setMaxInv(25);
            partRepository.save(frenchFries);

            Dessert appleCrumb = new Dessert();
            appleCrumb.setName("Apple Crumb");
            appleCrumb.setInv(6);
            appleCrumb.setPrice(3.50);
            appleCrumb.setId(44);
            appleCrumb.setMinInv(1);
            appleCrumb.setMaxInv(12);
            partRepository.save(appleCrumb);

            Dessert donut = new Dessert();
            donut.setName("Donut");
            donut.setInv(12);
            donut.setPrice(2.00);
            donut.setId(55);
            donut.setMinInv(1);
            donut.setMaxInv(24);
            partRepository.save(donut);
        }
        if(productRepository.count() == 0) {
            Product blackCoffee = new Product();
            blackCoffee.setName("Black Coffee");
            blackCoffee.setInv(11);
            blackCoffee.setPrice(2.00);
            blackCoffee.setId(66);
            productRepository.save(blackCoffee);

            Product espresso = new Product();
            espresso.setName("Espresso");
            espresso.setInv(12);
            espresso.setPrice(4.00);
            espresso.setId(77);
            productRepository.save(espresso);

            Product americano = new Product();
            americano.setName("Americano");
            americano.setInv(10);
            americano.setPrice(2.25);
            americano.setId(88);
            productRepository.save(americano);

            Product Mocha = new Product();
            Mocha.setName("Mocha");
            Mocha.setInv(5);
            Mocha.setPrice(3.00);
            Mocha.setId(99);
            productRepository.save(Mocha);

            Product coldBrew = new Product();
            coldBrew.setName("Cold Brew");
            coldBrew.setInv(15);
            coldBrew.setPrice(3.50);
            coldBrew.setId(101);
            productRepository.save(coldBrew);
        }

        System.out.println("Started in Bootstrap");
    }
}
