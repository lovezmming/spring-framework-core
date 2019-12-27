package com.spring.framework.common.base.util;

import java.util.Collection;
import java.util.Map;

public class TextUtil {
    public static boolean isEmpty(Object pObj) {
        if (pObj == null) {
            return true;
        }
        if (pObj == "") {
            return true;
        }
        if (pObj instanceof String) {
            return ((String) pObj).length() == 0;
        } else if (pObj instanceof Collection) {
            return ((Collection) pObj).isEmpty();
        } else if (pObj instanceof Map) {
            return ((Map) pObj).size() == 0;
        }
        return false;
    }

    public static String expandNum(int tenantId, String prefix, int totalLength) {
        return String.format("%" + prefix + totalLength + "d", tenantId);
    }
}
