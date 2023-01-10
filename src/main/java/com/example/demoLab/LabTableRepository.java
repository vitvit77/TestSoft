package com.example.demoLab;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LabTableRepository extends JpaRepository<LabTable,Long>  {
    List<LabTable> findAllByName(String name);
}
