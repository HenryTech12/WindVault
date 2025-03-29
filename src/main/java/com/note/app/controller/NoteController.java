package com.note.app.controller;

import com.note.app.dto.NoteDTO;
import com.note.app.service.NoteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/")
    public String home(Model model) {
        updateHomePage(model);
        updateDiaryPin(model);
        return "index.html";
    }

    @RequestMapping("/home")
    public String gohome(Model model) {
        updateHomePage(model);
        updateDiaryPin(model);
        return "index.html";
    }

    @RequestMapping("/add")
    public String addNote(Model model) {
        model.addAttribute("noteDTO", new NoteDTO());
        return "viewnote.html";
    }

    @PostMapping("/save")
    public String save(Model model, @ModelAttribute NoteDTO noteDTO, HttpServletRequest request) {
        System.out.println(noteDTO.isDiary());
        noteService.saveNote(noteDTO);
        updateHomePage(model);
        updateDiaryPin(model);
        return "index.html";
    }
    @PostMapping("/delete")
    public String delete(Model model, int id) {
        noteService.deleteNoteById(id);
        updateHomePage(model);
        updateDiaryPin(model);
        return "index.html";
    }

    @PostMapping("/open")
    public String open(Model model , int id) {
        //ID YOUR ARE FETCHING IS YOUR POSITION
        System.out.println("pos: "+id);
        NoteDTO noteDTO = noteService.getNoteById(id);

        model.addAttribute("noteDTO", noteDTO);
        updatePos(model,id);
        return "viewnote.html";
    }

    @GetMapping("/edit")
    public String editNote(Model model, @ModelAttribute NoteDTO noteDTO) {

        return "edit.html";
    }

    public void updateHomePage(Model model) {
        NoteList noteList = new NoteList();
        noteList.setNotes(noteService.getNotes());
        model.addAttribute("noteList", noteList);
        model.addAttribute("note", new NoteDTO());
    }
    public void updatePos(Model model, int id) {
        model.addAttribute("id",id);
    }
    public void updateDiaryPin(Model model) {
        model.addAttribute("pin", "");
    }
}


class NoteList {
    private List<NoteDTO> notes;

    public List<NoteDTO> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteDTO> notes) {
        this.notes = notes;
    }
}
