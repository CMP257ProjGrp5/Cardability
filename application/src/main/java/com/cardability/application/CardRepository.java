package com.cardability.application;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Card findById(long Id);

    Card findByName(String Id);

    void deleteById(Long Id);

    boolean existsById(Long primaryKey);

    @Modifying
    @Transactional
    @Query("UPDATE Card c SET c.name =:name WHERE c.id =:ids")
    void updateCardName(String name, Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Card c SET c.r =:r, c.g =:g, c.b=:b WHERE c.id=:id")
    void updateCardColor(int r, int g, int b, Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Card c SET c.description = :description WHERE c.id = :id")
    int updateCardDescription(@Param("description") String description, @Param("id") Long id);

}

    

