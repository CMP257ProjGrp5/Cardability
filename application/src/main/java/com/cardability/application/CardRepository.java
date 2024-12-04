package com.cardability.application;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Card findOne(long primaryKey);

    Card findByName(String name);

    void delete(Card entity);

    boolean exists(Long primaryKey);

    @Modifying
    @Transactional
    @Query("UPDATE Card c SET c.name =?1 WHERE c.id =?2")
    void updateCard (String name, Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Card c SET c.r =?1 , c.g =?2, c.b=?3 WHERE c.id=?4")
    void updateCard(int r, int g, int b, Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Card c SET c.desc =?1 WHERE c.id=?2")
    void updateCard(Long id, String description);

    

}
