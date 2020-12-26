package com.pozharsky.dmitri.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberValidator {
    private static final Logger logger = LogManager.getLogger(NumberValidator.class);
    public static final NumberValidator INSTANCE = new NumberValidator();

    private NumberValidator() {
    }

    public boolean isNumber(String value) {
        boolean flag = true;
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            logger.error(e);
            flag = false;
        }
        return flag;
    }
}
