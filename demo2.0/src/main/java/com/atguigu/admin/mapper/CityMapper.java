package com.atguigu.admin.mapper;

import com.atguigu.admin.beans.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {
    @Select("SELECT * FROM city WHERE id = #{id}")
    public City getCityById(Long id);

    @Insert("INSERT city (name,state,country) VALUES (#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true)
    public void insert(String name,String state,String country);
}
