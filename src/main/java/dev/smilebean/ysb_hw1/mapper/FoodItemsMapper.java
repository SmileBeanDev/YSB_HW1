package dev.smilebean.ysb_hw1.mapper;

import dev.smilebean.ysb_hw1.mapper.sql.FoodItemsSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface FoodItemsMapper {
    @SelectProvider(type = FoodItemsSql.class, method = "getFoodItems")
    public List<Map<String,Object>> getFoodItems();
}
