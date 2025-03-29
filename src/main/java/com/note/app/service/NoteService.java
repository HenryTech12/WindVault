package com.note.app.service;

import com.note.app.dto.NoteDTO;
import com.note.app.mapper.NoteMapper;
import com.note.app.model.MyNote;
import com.note.app.repo.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepository repo;
    @Autowired
    private NoteMapper noteMapper;

    public List<NoteDTO> getNotes() {
       List<MyNote> notes = repo.findAll();
       List<NoteDTO> dtoList = new ArrayList<>();
       notes.forEach((note) -> {
           System.out.println(note.getId());
           dtoList.add(noteMapper.convertMyNoteToDTO(note));
       });
       return dtoList;
    }

    public NoteDTO getNoteById(int id) {
        return noteMapper.convertMyNoteToDTO(
                repo.findById(id).orElseThrow(
                        () -> {
                            throw new NullPointerException();
                        }
                ));
    }

    public void saveNote(NoteDTO note) {
        if(note != null) {
            if(!noteExists(note)) {
                System.out.println("SAVING NOTE ....");
                repo.save(noteMapper.convertDTOToNote(note));
            }
        }
    }

    public void deleteNoteById(int id) {
          repo.deleteById(id);
        System.out.println("note deleted successfully");
    }

    public void createDiaryPin(NoteDTO noteDTO) {

        if(!Objects.isNull(noteDTO)) {
            System.out.println("not null");
            if(!noteExists(noteDTO)) {
                 System.out.println("SAVING TO DB.....");
                 repo.save(noteMapper.convertDTOToNote(noteDTO));
            }
        }
    }

    public boolean noteExists(NoteDTO noteDTO) {
        MyNote userNote = noteMapper.convertDTOToNote(noteDTO);
        MyNote myNote = repo.findById(userNote.getId())
                .orElse(null);
        if(myNote != null)
            return true;
        else
            return false;
    }

    public boolean accessDiary(int id, NoteDTO noteDTO) {
        Optional<MyNote> optionalMyNote = repo.findById(id);
        if(optionalMyNote.isPresent()) {
            MyNote myNote = optionalMyNote.orElse(new MyNote());
            System.out.println("DB PIN: " + myNote.getDiaryPin());

            String userPin = noteDTO.getDiaryPin();
            System.out.println("USER PIN: " + userPin);

            System.out.println("MATCHES: " + myNote.getDiaryPin().equals(userPin));
            return myNote.getDiaryPin().contains(userPin);
        }
        return false;
    }
    public NoteDTO getDiary(int id) {
        return noteMapper.convertMyNoteToDTO(repo.findById(id).orElse(new MyNote()));
    }
}
