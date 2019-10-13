package com.example.petclinic.services.springdatajpa;

import com.example.petclinic.model.Speciality;
import com.example.petclinic.repositories.SpecialtyRepository;
import com.example.petclinic.services.SpecialitiesService;

import java.util.HashSet;
import java.util.Set;

public class VetSpecialtySDJpaService implements SpecialitiesService {
    private SpecialtyRepository specialtyRepository;

    public VetSpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialtyRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
