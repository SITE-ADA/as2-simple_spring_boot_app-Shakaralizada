package com.as.assignment.repo;

import com.as.assignment.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository public interface ManufacturerRepo extends JpaRepository<Manufacturer, Integer> {
    @Query("update Manufacturer m set m.name = ?2 where m.id = ?1")
    @Modifying void update(Integer id, String name);

    @Query(value = "delete from phone_manufacturer where m_id = ?1", nativeQuery = true)
    @Modifying void delete_phones_from_manufacturer(Integer id);

    @Query(value = "delete from phone_manufacturer where m_id = ?1 and p_id = ?2", nativeQuery = true)
    @Modifying void delete_phone_from_manufacturer(Integer id_1, Integer id_2);
}
