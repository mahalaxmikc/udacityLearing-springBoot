package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {


    @Select("select * from FILES where userID = #{userID}")
    public List<File> getFilesByUserID(Integer userID);

    @Select("select * from FILES where fileID = #{fileID}")
    public File getFileByFileId(Integer fileID);

    @Select("select * from FILES where fileName = #{fileName} and userid = #{userID}")
    public File getFileByFileUserID(String fileName, Integer userID);

    @Insert("insert into FILES(fileName, contentType, fileSize, userID, fileData) " +
            "values(#{fileName}, #{contentType}, #{fileSize}, #{userID}, #{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileID")
    public int saveFile(File file);

    @Delete("delete from FILES where fileID = #{fileID}")
    public int deleteFileByFileId(int fileID);
}
