package com.PortfolioAP.PortfolioAP.Interface;

import com.PortfolioAP.PortfolioAP.Entity.Skills;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.List;
import java.util.Optional;

public interface ISkillSer {

    public List<Skills>list();

    public Optional<Skills>getOne(int id);

    public Optional<Skills>getByNombre(String nombre);

    public void save(Skills skills);

    public void delete(int id);

    public boolean existsBynombre(String nombre);


    public boolean existById(int id);

}
