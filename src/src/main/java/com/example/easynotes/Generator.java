package com.example.easynotes;

import com.example.easynotes.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

import static java.lang.Integer.parseInt;

public class Generator implements IdentifierGenerator {

    public static final String generatorName = "generator";


    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        int id = (int) uuid.hashCode();
        id = Math.abs(id);
        return id;
    }
}