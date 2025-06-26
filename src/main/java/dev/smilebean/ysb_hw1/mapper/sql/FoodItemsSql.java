package dev.smilebean.ysb_hw1.mapper.sql;

import org.apache.ibatis.jdbc.SQL;

public class FoodItemsSql {
    public String getFoodItems() {
        SQL sql = new SQL();

        sql.SELECT("category, food_name, price");
        sql.FROM("food_items");

        return sql.toString();
    }
}
