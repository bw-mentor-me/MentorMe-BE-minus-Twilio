package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.exceptions.ResourceNotFoundException;
import com.lambdaschool.starthere.models.Type;
import com.lambdaschool.starthere.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "typeService")
public class TypeServiceImpl implements TypeService
{
    @Autowired
    TypeRepository typerepos;

    @Override
    public List<Type> findAll()
    {
        List<Type> list = new ArrayList<>();
        typerepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }


    @Override
    public Type findRoleById(long id)
    {
        return typerepos.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }

    @Override
    public Type findByName(String name)
    {
        Type tt = typerepos.findByNameIgnoreCase(name);

        if (tt != null)
        {
            return tt;
        } else
        {
            throw new ResourceNotFoundException(name);
        }
    }

    @Override
    public void delete(long id)
    {
        typerepos.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
        typerepos.deleteById(id);
    }


    @Transactional
    @Override
    public Type save(Type type)
    {
        return typerepos.save(type);
    }
}