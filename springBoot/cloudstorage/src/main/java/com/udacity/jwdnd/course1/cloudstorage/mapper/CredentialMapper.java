package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;




@Mapper
public interface CredentialMapper {
    @Insert("insert into CREDENTIALS(url,username,key,password,userID)" +
            " values(#{url}, #{username}, #{encryptedKey}, #{password}, #{userID})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialID")
    public Integer createCredential(Credential Credential);



    @Update("update CREDENTIALS set url=#{url}, username=#{username}," +
            "key=#{encryptedKey},password=#{password},userID=#{userID}" +
            " where credentialID=#{credentialID}")
    public Integer updateCredential(Credential Credential);

    @Select("SELECT * FROM  CREDENTIALS WHERE userID = #{userId}")
    public List<Credential> getAllCredentialByUSerId(Integer userId);


    @Select("SELECT * FROM CREDENTIALS WHERE username = #{username} and userID = #{userID}")
    public Credential getCredentialByUsernameUserID(String username, Integer userID);

    @Select("SELECT * FROM CREDENTIALS   where credentialID=#{credentialID}")
    public Credential getCredentialByCredentialID( Integer credentialID);


    /*
    Delete by Id
   */
    @Delete("DELETE FROM  CREDENTIALS where credentialID = #{credentialID}")
    public int deleteNoteByCredentialID(Integer credentialID);


}
