package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TypeRepository extends CrudRepository<Type, Long>
{
    @Transactional
    @Modifying
    @Query(value = "DELETE from UserType where userid = :userid")
    void deleteUserTypesByUserId(long userid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO UserTypes(userid, typeid) values (:userid, :typeid)",
            nativeQuery = true)
    void insertUserTypes(long userid, long typeid);

    Type findByNameIgnoreCase(String name);
}