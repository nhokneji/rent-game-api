package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.RentConstant;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Rin-DTS
 */
public class RentUtil {
    public volatile static Integer sequence = 1;

    public static synchronized Integer getSequence() {
        return sequence;
    }

    public static synchronized void setSequence() {
        sequence = sequence + 1;
        if (sequence == 9999)
            sequence = 1;
    }

    public static int buildPart(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String time = dateFormat.format(date);
        return Integer.parseInt(time);
    }


    public static String buildTransId(Date date, Integer partner_id) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
        String trans_id = partner_id + dateFormat.format(date) + getSequence();
        return trans_id;
    }

    public static String buildTransId(Date date, String partner_id) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
        String trans_id = partner_id + dateFormat.format(date) + getSequence();
        return trans_id;
    }

    public static Integer getStartPage(Integer offset) {
        if (offset == null || offset < 0)
            offset = 0;
        return offset * RentConstant.PAGE_SIZE;
    }

    public static String parseString(Object object) {
        return object == null ? "" : String.valueOf(object);
    }

    public static Float parseFloat(Object object) {
        if (object == null) {
            return 0.0F;
        } else {
            Float ret = 0.0F;

            try {
                ret = Float.parseFloat(parseString(object));
            } catch (Exception var3) {
                ;
            }

            return ret;
        }
    }

    public static Integer parseInt(Object object) {
        if (object == null) {
            return 0;
        } else {
            Integer ret = 0;

            try {
                ret = Integer.parseInt(parseString(object));
            } catch (Exception var3) {
                ;
            }

            return ret;
        }
    }

    public static Short parseShort(Object object) {
        if (object == null) {
            return Short.valueOf((short) 0);
        } else {
            Short ret = Short.valueOf((short) 0);

            try {
                ret = Short.parseShort(parseString(object));
            } catch (Exception var3) {
                ;
            }

            return ret;
        }
    }

    public static Long parseLong(Object object) {
        if (object == null) {
            return 0L;
        } else {
            Long ret = 0L;

            try {
                ret = Long.parseLong(parseString(object));
            } catch (Exception var3) {
                ;
            }

            return ret;
        }
    }


    public static int callSkips(int offset, int pageSize) {
        if (offset <= 0) {
            return 0;
        }
        return (pageSize * (offset - 1));
    }


}
