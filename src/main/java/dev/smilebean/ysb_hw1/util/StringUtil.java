package dev.smilebean.ysb_hw1.util;

import java.util.List;

public class StringUtil {

    public static String getSqlStrConditionCollection(String field, List<?> conditions) {
        StringBuilder strConditions = new StringBuilder();
        if (conditions != null && !conditions.isEmpty()) {
            int count = conditions.size();

            for(int i = 0; i < count; i++) {
                String condition = conditions.get(i).toString();
                strConditions.append("'").append(condition).append("'");
                if (i < count - 1) {
                    strConditions.append(",");
                }
            }
            return field + " IN (" + strConditions.toString() + ")";
        } else {
            return "1=1";
        }
    }

    public static String getSqlConditionCollection(String field, List<?> conditions) {
        StringBuilder strConditions = new StringBuilder();
        if (conditions != null && !conditions.isEmpty()) {
            int count = conditions.size();

            for(int i = 0; i < count; i++) {
                String condition = conditions.get(i).toString();
                strConditions.append(condition);
                if (i < count - 1) {
                    strConditions.append(",");
                }
            }
            return field + " IN (" + strConditions.toString() + ")";
        } else {
            return "1=1";
        }
    }
}
