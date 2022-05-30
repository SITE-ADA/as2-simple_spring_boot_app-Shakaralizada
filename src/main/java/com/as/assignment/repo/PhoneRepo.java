package com.as.assignment.repo;

import com.as.assignment.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository public interface PhoneRepo extends JpaRepository<Phone, Integer> {
    @Query(value = "update phone p set p.name = :name where p.p_id = :id", nativeQuery = true)
    @Modifying void update(@Param("id") Integer id, @Param("name") String name);

    @Query(value = "delete from phone_manufacturer where p_id = ?1", nativeQuery = true)
    @Modifying void delete_phone_from_manufacturer(Integer id);
}
