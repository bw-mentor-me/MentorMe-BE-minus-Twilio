package com.lambdaschool.starthere.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usertypes")
public class UserTypes extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("userTypes")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "typeid")
    @JsonIgnoreProperties("userTypes")
    private Type type;

    public UserTypes()
    {
    }

    public UserTypes(User user, Type type)
    {
        this.user = user;
        this.type = type;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Type getType()
    {
        return type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof UserTypes))
        {
            return false;
        }
        UserTypes userTypes = (UserTypes) o;
        return getUser().equals(userTypes.getUser()) && getType().equals(userTypes.getType());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUser(), getType());
    }
}