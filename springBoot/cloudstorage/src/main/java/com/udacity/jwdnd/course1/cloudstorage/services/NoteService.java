package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NoteService {

    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    public Integer createNote(Note note){
        return noteMapper.createNote(note);
    }

    public Integer updateNote(Note note){
        return noteMapper.updateNote(note);
    }

    public List<Note> getAllNotesByUSerId(Integer userId){
        return noteMapper.getAllNotesByUSerId(userId);
    }

   public Note getNoteByID(Integer noteID){
        return noteMapper.getNoteByNoteID(noteID);
   }

    public Integer deleteNoteByNoteID(Integer noteID){

        return noteMapper.deleteNoteByNoteID(noteID);
    }


    public Note duplicateNoteEntry(String title,Integer userId){
        return noteMapper.getNoteByTitleUserID(title,userId) ;
    }
}
