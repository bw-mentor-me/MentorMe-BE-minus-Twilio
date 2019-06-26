package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Type;

import java.util.List;

public interface TypeService
{
    List<Type> findAll();

    Type findTypeById(long id);

    void delete(long id);

    Type save(Type type);

    Type findByName(String name);
}