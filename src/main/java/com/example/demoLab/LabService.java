package com.example.demoLab;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;


@Service
public class LabService {

    private Logger Log = LoggerFactory.getLogger(LabService.class);

    public String getData() {
        Log.info("Log....{} {} {}", 1, 3, 7);
        return "Hello World";
    }


    public String GetDataWithParams(String val1, String val2) {
        Log.info("val1 = {} , val2 = {}", val1, val2);
        return val1 + "  " + val2;
    }

    public long GetDataForFact(long x) {
        NewCalculator newCalculator = new NewCalculator();
        Log.info("X = {} ", x);
        return newCalculator.Factorial(x);
    }

    public double GetDataForAnyFunction(int x, int y) {
        NewCalculator newCalculator = new NewCalculator();
        Log.info("X = {} Y = {}", x, y);
        return newCalculator.AnyFunction(x, y);
    }

    public double GetDataForRootSquare(int x) {
        NewCalculator newCalculator = new NewCalculator();
        Log.info("X = {} ", x);
        return newCalculator.RootSquare(x);
    }

    @Autowired
    private LabTableRepository labTableRepository;

    public  void save( LabTable labTable) {
        labTableRepository.save(labTable);
    }

    public  List<LabTable> findAll() {
        return labTableRepository.findAll();
    }

    public void update(long Id, String name) {
        Optional<LabTable> optionalLabTable = labTableRepository.findById(Id);
        LabTable labTable = optionalLabTable.get();
        labTable.setName(name);
        labTableRepository.save(labTable);
    }

    public  List<LabTable> findAllByName(String name) {
        return labTableRepository.findAllByName(name);
    }

    public void deleteById (long Id){
        labTableRepository.deleteById(Id);
    }

}
