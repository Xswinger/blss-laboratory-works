package com.github.Xswinger.blsslaboratorywork1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.github.Xswinger.blsslaboratorywork1.config.AtomikosConfig;
import com.github.Xswinger.blsslaboratorywork1.entities.Brand;
import com.github.Xswinger.blsslaboratorywork1.entities.CarClass;
import com.github.Xswinger.blsslaboratorywork1.entities.Country;
import com.github.Xswinger.blsslaboratorywork1.interfaces.TransportService;
import com.github.Xswinger.blsslaboratorywork1.entities.Model;

import com.github.Xswinger.blsslaboratorywork1.repositories.BrandRepository;
import com.github.Xswinger.blsslaboratorywork1.repositories.ClassRepository;
import com.github.Xswinger.blsslaboratorywork1.repositories.CountryRepository;
import com.github.Xswinger.blsslaboratorywork1.repositories.ModelRepository;

import java.util.*;

@Service("cars")
public class CarsService{

    private final PlatformTransactionManager transactionManager;

    private final BrandRepository brandRepository;

    private final ModelRepository modelRepository;

    private final ClassRepository classRepository;

    private final CountryRepository countryRepository;
    
    @Autowired
    CarsService(BrandRepository brandRepository, ModelRepository modelRepository, ClassRepository classRepository, CountryRepository countryRepository, AtomikosConfig config) throws Throwable {
        this.brandRepository = brandRepository;
        this.classRepository = classRepository;
        this.modelRepository = modelRepository;
        this.countryRepository = countryRepository;
        this.transactionManager = config.transactionManager();
    }

    // @Override
    public List<Brand> getBrands() {
        List<Brand> brands = brandRepository.findAll();
        return brands;
    }

    public List<Brand> saveBrand(@NonNull Brand newBrand) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("brandCreating");
        TransactionStatus status = transactionManager.getTransaction(def);

        List<Brand> brands = new ArrayList<>();
        try {
            brandRepository.save(newBrand);
            brands = brandRepository.findAll();
        } catch (Exception ex) {
            transactionManager.rollback(status);
            throw ex;
        }
        transactionManager.commit(status);
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

    public List<Model> saveModel(@NonNull Model newModel) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("brandCreating");
        TransactionStatus status = transactionManager.getTransaction(def);

        List<Model> brands = new ArrayList<>();
        try {
            modelRepository.save(newModel);
            brands = modelRepository.findAll();
        } catch (Exception ex) {
            transactionManager.rollback(status);
            throw ex;
        }
        transactionManager.commit(status);
        return brands;
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

    public List<CarClass> saveClass(@NonNull CarClass newClass) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("countryCreating");
        TransactionStatus status = transactionManager.getTransaction(def);

        List<CarClass> classes = new ArrayList<>();
        try {
            classRepository.save(newClass);
            classes = classRepository.findAll();
        } catch (Exception ex) {
            transactionManager.rollback(status);
            throw ex;
        }
        transactionManager.commit(status);
        return classes;
    }

    public void deleteClass(@NonNull Long id) {
        classRepository.deleteById(id);
    }

    public List<Country> getCountries() {
        List<Country> classes = countryRepository.findAll();
        return classes;
    }

    public List<Country> saveCountry(@NonNull Country country) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("countryCreating");
        TransactionStatus status = transactionManager.getTransaction(def);

        List<Country> countries = new ArrayList<>();
        try {
            countryRepository.save(country);
            countries = countryRepository.findAll();
        } catch (Exception ex) {
            transactionManager.rollback(status);
            throw ex;
        }
        transactionManager.commit(status);
        return countries;
    }

    public void deleteCountry(@NonNull Long id) {
        countryRepository.deleteById(id);
    }

    public List<Model> getModelsByFilter(Long countryId, Long lineUpId) {
        List<Model> models = modelRepository.findAllByCountry_IdAndLineUp_Id(countryId, lineUpId);
        return models;
    }
}
