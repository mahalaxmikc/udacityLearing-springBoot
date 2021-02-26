package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
public class HomeController {

    private NoteService noteService;
    private UserService userService;
    private AuthenticationService authenticationService;
    @Autowired
    private CredentailService credentailService;
    @Autowired
    private FileService fileService;

    public HomeController(NoteService noteService,AuthenticationService authenticationService,UserService userService) {
        this.noteService = noteService;
        this.authenticationService =authenticationService;
        this.userService = userService;
    }

   /* private List<File> fileList;
    private List<Note> notesList;
    private List<Credential> credentialList;

    @PostConstruct
    public void postConstructor(){
        fileList = new ArrayList<File>();
        notesList= new ArrayList<Note>();
        credentialList= new ArrayList<Credential>();
    }*/

    @GetMapping
    public String displayHome(Model model, Note note,Authentication authentication){
        String userName = authentication.getName();
        Integer userID= userService.getUserByUserName(userName);

        Comparator<File> compareByFileName = Comparator
                .comparing(File::getFileName);
        Comparator<Credential> compareByUserName = Comparator
                .comparing(Credential::getUsername);
        Comparator<Note> compareByNoteTitle = Comparator
                .comparing(Note::getNoteTitle);
        String userNotAvailable = null;
        if (userID== null){
            model.addAttribute("userNotAvailable","Error no user");
            return "result";
        }

     model.addAttribute("noteslist",
                        noteService.getAllNotesByUSerId(userID).stream().sorted(compareByNoteTitle).collect(Collectors.toList()));
     model.addAttribute("credentialList",
             credentailService.getAllCredentialByUSerId(userID).stream().sorted(compareByUserName).collect(Collectors.toList()));

        model.addAttribute("fileList",
                fileService.getAllFilesByUserID(userID).stream().sorted(compareByFileName).collect(Collectors.toList()));


      return "home";
    }


}
