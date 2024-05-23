package com.tunerart.shop.repository;

import com.tunerart.shop.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {
}
