package com.jerin.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jerin.demo.model.Car;

@Repository
public interface CarMongoRepository extends CrudRepository<Car, String> {


}
