package com.bruce.erpapp.common.utils;

import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class ConvertPlusUtils extends ConvertUtils {

    /**
     * convert string to big decimal
     * <ul>
     * <li>str2BigDecimal(null) = 0</li>
     * <li>str2BigDecimal("AA") = 0</li>
     * <li>str2BigDecimal("2.12") = 2.12</li>
     * </ul>
     *
     * @param sValue
     * @return
     */
    public static BigDecimal str2BigDecimal(String sValue) {
        return str2BigDecimal(sValue, -1, new BigDecimal(0));
    }

    public static BigDecimal str2BigDecimal(String sValue, int iScale, BigDecimal defaultValue) {

        BigDecimal value = null;
        try {
            sValue = StringUtils.trimAllWhitespace(sValue);
            sValue = StringUtils.replace(sValue, ",", "");

            value = new BigDecimal(StringUtils.trimAllWhitespace(sValue));

            if (iScale >= 0) {

                value = value.setScale(iScale, BigDecimal.ROUND_HALF_UP);
            }
        } catch (Exception e) {
            value = defaultValue;
        }
        return value;
    }
}
