package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;

    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        //ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {

        //Conditions for inventory is between min and max value
        if(part.getInv() > part.getMaxInv()){
            //displays error message when inventory is greater than max value
            constraintValidatorContext.buildConstraintViolationWithTemplate("Solution: Fix your Inventory, it's greater than the max value").addConstraintViolation();
            return false;
        }
        else if(part.getInv() < part.getMinInv()){
            //displays error message when inventory is lower than min value
            constraintValidatorContext.buildConstraintViolationWithTemplate("Solution: Fix your Inventory, it's lower than the min value").addConstraintViolation();
            return false;
        }
        return true;
    }
}
