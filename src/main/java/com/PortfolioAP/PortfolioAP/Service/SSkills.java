package com.PortfolioAP.PortfolioAP.Service;

import com.PortfolioAP.PortfolioAP.Entity.Skills;
import com.PortfolioAP.PortfolioAP.Interface.ISkillSer;
import com.PortfolioAP.PortfolioAP.Repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SSkills implements ISkillSer {

    @Autowired
    SkillsRepository skillsRepository;
    @Override
    public List<Skills> list() {
        return skillsRepository.findAll();
    }

    @Override
    public Optional<Skills> getOne(int id) {
        return skillsRepository.findById(id);
    }

    @Override
    public Optional<Skills> getByNombre(String nombre) {
        return skillsRepository.findByNombre(nombre);
    }

    @Override
    public void save(Skills skills) {
       skillsRepository.save(skills);
    }

    @Override
    public void delete(int id) {
        skillsRepository.deleteById(id);
    }

    @Override
    public boolean existsBynombre(String nombre) {
        return skillsRepository.existsByNombre(nombre);
    }

    @Override
    public boolean existById(int id) {
        return skillsRepository.existsById(id);
    }
}
