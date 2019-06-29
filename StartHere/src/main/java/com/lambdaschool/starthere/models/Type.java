package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "types")
public class Type extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long typeid;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "type",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties("type")
    private List<UserTypes> userTypes = new ArrayList<>();

    public Type()
    {
    }

    public Type(String name)
    {
        this.name = name;
    }

    public long getTypeid()
    {
        return typeid;
    }

    public void setTypeid(long typeid)
    {
        this.typeid = typeid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<UserTypes> getUserTypes()
    {
        return userTypes;
    }

    public void setUserTypes(List<UserTypes> userTypes)
    {
        this.userTypes = userTypes;
    }
}

