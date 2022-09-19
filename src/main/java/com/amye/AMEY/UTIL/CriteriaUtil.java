package com.amye.AMEY.UTIL;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class CriteriaUtil {

    @Autowired
    private static EntityManager entityManager;

    public static CriteriaBuilder getCriteria() {
        return entityManager.getCriteriaBuilder();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
