package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class NoteController {

 private UserService userService;
 private NoteService noteService;

    public NoteController(UserService userService, NoteService noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }


    @PostMapping("/saveNote")
    public String saveUpdateNote(Note note, Model model, Authentication  authentication){

        boolean isUpdate= false;
        String noteError = null;
        Integer userID= userService.getUserByUserName(authentication.getName());


        if(note.getNoteID() !=null && note.getNoteID() >=1 ){
            isUpdate= true;
            if(noteService.updateNote(note)< 1)
                noteError ="Error while updating the note";
        }

        if (!isUpdate){
                if(noteService.duplicateNoteEntry(note.getNoteTitle(), userID) != null)
                noteError = "Duplicate Entry,note already exist";

                else {
                    note.setUserID(userID);
                    if (noteService.createNote(note) < 1)
                        noteError = "Error while creating the Note";
                }
        }


        if (noteError == null) {

            model.addAttribute("successCreateUpdate", true);
        } else {
            model.addAttribute("errorUpdateCreate", noteError);
        }



        return  "result";
    }


    @GetMapping(value = "/delete-note/{noteID}")
    public String deleteNote(@PathVariable int noteID, Model model) {

        String errorNote = null;
        int deletedNoteId = noteService.deleteNoteByNoteID(noteID);
        if (deletedNoteId == noteID) {

            model.addAttribute("successDelete", true);
        } else {
            errorNote = "Error while deleteing the note";
            model.addAttribute("errorDelete", errorNote);
        }


            return "result";

    }
}
