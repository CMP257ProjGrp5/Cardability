package com.cardability.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Card findOne(long primaryKey);

    Card findByName(String name);

    void delete(Card entity);

    boolean exists(Long primaryKey);

}
