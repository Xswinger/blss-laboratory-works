package com.github.Xswinger.blsslaboratorywork1.services;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
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

    public Brand saveBrand(@NonNull Brand newBrand) {
        Brand brands = brandRepository.save(newBrand);
        return brands;
    }

    public void deleteBrand(@NonNull Long id) {
        brandRepository.deleteById(id);
    }

    public List<Brand> getBrandsByCountry(Long id) {
        List<Brand> brands = brandRepository.findAllByCountry_Id(id);
        return brands;
    }

    public List<Model> getModels() {
        List<Model> models = modelRepository.findAll();
        return models;
    }

    public Model saveModel(@NonNull Model newModel) {
        Model model = modelRepository.save(newModel);
        return model;
    }

    public void deleteModel(@NonNull Long id) {
        modelRepository.deleteById(id);
    }

    public List<Model> getRandomClassesByCarClass(Long id) {
        List<Model> models = modelRepository.findThreeRandomByCarClass(id);
        return models;
    }

    public List<CarClass> getCarClasses() {
        List<CarClass> classes = classRepository.findAll();
        return classes;
    }

    public CarClass saveClass(@NonNull CarClass newClass) {
        CarClass newCarClass = classRepository.save(newClass);
        return newCarClass;
    }

    public void deleteClass(@NonNull Long id) {
        classRepository.deleteById(id);
    }

    public List<Country> getCountries() {
        List<Country> classes = countryRepository.findAll();
        return classes;
    }

    public Country saveCountry(@NonNull Country country) {
        Country newCountry = countryRepository.save(country);
        return newCountry;
    }

    public void deleteCountry(@NonNull Long id) {
        countryRepository.deleteById(id);
    }

    public List<Model> getModelsByFilter(Long countryId, Long lineUpId) {
        List<Model> models = modelRepository.findAllByCountry_IdAndLineUp_Id(countryId, lineUpId);
        return models;
    }
}
