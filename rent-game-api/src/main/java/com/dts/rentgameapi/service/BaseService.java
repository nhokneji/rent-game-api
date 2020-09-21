package com.dts.rentgameapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Rin-DTS
 */
public class BaseService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected Timestamp getCurrentTimestamp() {
        return new Timestamp(new Date().getTime());
    }

}
