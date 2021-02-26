package com.udacity.jwdnd.course1.cloudstorage.mapper;


import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {
    @Select("select * from USERS where username = #{username}")
    User getUserByUsername(String username);

    @Select("select * from USERS where userId = #{userId}")
    User getUserById(Integer userId);


    @Insert("insert into USERS(username,firstName, lastName,password,salt ) " +
            "values (#{username}, #{firstName}, #{lastName}, #{password}, #{salt})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(User user);

}
