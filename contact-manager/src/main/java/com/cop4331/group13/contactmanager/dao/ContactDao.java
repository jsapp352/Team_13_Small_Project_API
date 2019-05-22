package com.cop4331.group13.contactmanager.dao;

import com.cop4331.group13.contactmanager.domain.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactDao extends CrudRepository<Contact, Long> {

    List<Contact> findByUserId(Long userId);

    //@Query(value = "SELECT * FROM contact WHERE user_id = :userId AND (first_name LIKE '%:criteria%' OR last_name LIKE '%:criteria%' OR email LIKE '%:criteria%')", nativeQuery = true)
    @Query(value = "SELECT * FROM contact WHERE user_id = :userId AND first_name LIKE '%:criteria%'", nativeQuery = true)
    List<Contact> findBySearchCriteria(@Param("userId") long userId, @Param("criteria") String searchCriteria);
}
