package com.github.Xswinger.blsslaboratorywork1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.Xswinger.blsslaboratorywork1.entities.Brand;
import com.github.Xswinger.blsslaboratorywork1.entities.CarClass;
import com.github.Xswinger.blsslaboratorywork1.entities.Country;
// import com.github.Xswinger.blsslaboratorywork1.interfaces.TransportService;
import com.github.Xswinger.blsslaboratorywork1.entities.Model;

import com.github.Xswinger.blsslaboratorywork1.repositories.BrandRepository;
import com.github.Xswinger.blsslaboratorywork1.repositories.ClassRepository;
import com.github.Xswinger.blsslaboratorywork1.repositories.CountryRepository;
import com.github.Xswinger.blsslaboratorywork1.repositories.ModelRepository;

import java.util.*;

@Service("cars")
public class CarsService{

    private final BrandRepository brandRepository;

    private final ModelRepository modelRepository;

    private final ClassRepository classRepository;

    private final CountryRepository countryRepository;
    
    @Autowired
    CarsService(BrandRepository brandRepository, ModelRepository modelRepository, ClassRepository classRepository, CountryRepository countryRepository) {
        this.brandRepository = brandRepository;
        this.classRepository = classRepository;
        this.modelRepository = modelRepository;
        this.countryRepository = countryRepository;
    }

    // @Override
    public List<Brand> getBrands() {
        List<Brand> brands = brandRepository.findAll();
        return brands;
    }

    public List<Brand> getBrandsByCountry(Long id) {
        List<Brand> brands = brandRepository.findAllByCountry_Id(id);
        return brands;
    }

    public List<Model> getModels() {
        List<Model> models = modelRepository.findAll();
        return models;
    }

    public List<CarClass> getCarClasses() {
        List<CarClass> classes = classRepository.findAll();
        return classes;
    }

    public List<Country> getCountries() {
        List<Country> classes = countryRepository.findAll();
        return classes;
    }

    public List<Model> getModelsByFilter(Long countryId, Long lineUpId) {
        List<Model> models = modelRepository.findAllByCountry_IdAndLineUp_Id(countryId, lineUpId);
        return models;
    }
}
