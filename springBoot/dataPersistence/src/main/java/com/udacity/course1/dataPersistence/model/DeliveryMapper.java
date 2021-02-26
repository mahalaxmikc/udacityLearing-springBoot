package com.udacity.course1.dataPersistence.model;

import org.apache.ibatis.annotations.*;

import java.time.Instant;

@Mapper
public interface DeliveryMapper {
    @Select("SELECT * FROM Delivery WHERE id = #{id}")
    Delivery findDelivery(Integer id);

    @Insert("INSERT INTO USERS ( orderId, time) " +
            "VALUES(#{orderId}, #{time})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int addDelivery(Delivery delivery);

    @Delete("SELECT * FROM Delivery WHERE id = #{id}")
    void deleteDelivery(Integer id);
}
