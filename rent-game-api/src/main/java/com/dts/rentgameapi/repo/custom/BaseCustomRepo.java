package com.dts.rentgameapi.repo.custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Rin-DTS
 */
public class BaseCustomRepo {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @PersistenceContext
    protected EntityManager entityManager;
}
