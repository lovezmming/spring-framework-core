package com.spring.framework.user.dataaccess.source;

import java.util.ArrayList;
import java.util.List;

public class DbContextHolder
{
    private static final ThreadLocal contextHolder = new ThreadLocal<>();

    public static List<String> dataSourceIds = new ArrayList<String>();

    public static void setDbType(String dbTypeEnum) {
        contextHolder.set(dbTypeEnum);
    }

    public static String getDbType() {
        return (String)contextHolder.get();
    }

    public static void clearDbType() {
        contextHolder.remove();
    }

    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }
}
