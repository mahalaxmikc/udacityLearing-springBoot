package com.udacity.jwdnd.course1.cloudstorage.mapper;


import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {




    @Insert("insert into NOTES(noteTitle,noteDescription,userID) values(#{noteTitle}, #{noteDescription}, #{userID})")
    @Options(useGeneratedKeys = true, keyProperty = "noteID")
    public Integer createNote(Note note);


    @Update("update NOTES set noteTitle=#{noteTitle}, noteDescription=#{noteDescription}" +
            " where noteID=#{noteID}")
    public Integer updateNote(Note note);

    @Select("SELECT * FROM  NOTES WHERE userID = #{userId}")
    public List<Note> getAllNotesByUSerId(Integer userId);


    @Select("SELECT * FROM NOTES WHERE noteTitle = #{noteTitle} and userID = #{userID}")
    public Note getNoteByTitleUserID(String noteTitle, Integer userID);

    @Select("SELECT * FROM NOTES   where noteID=#{noteID}")
    public Note getNoteByNoteID( Integer noteID);

    /*
      Delete by Id
     */
    @Delete("DELETE FROM NOTES WHERE noteID = #{noteID}")
    public int deleteNoteByNoteID(Integer noteID);

}
