package com.tdr.registrationv3.utils;

import com.parry.utils.code.RegexUtils;

public class RegularUtil {
    public static boolean isMobileExact(String value) {
        return RegexUtils.isMobileExact(value);
    }

    public static boolean isIDCard18(String value) {
        return RegexUtils.isIDCard18(value);
    }
}
