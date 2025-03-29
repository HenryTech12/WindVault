package com.note.app.mapper;

import com.note.app.dto.NoteDTO;
import com.note.app.model.MyNote;
import org.aspectj.weaver.ast.Not;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteMapper {

    @Autowired
    private ModelMapper mapper;

    public NoteDTO convertMyNoteToDTO(MyNote myNote) {
        if(myNote != null)
          return mapper.map(myNote, NoteDTO.class);
        else
          return new NoteDTO();
    }

    public MyNote convertDTOToNote(NoteDTO noteDTO) {
        if(noteDTO != null)
            return mapper.map(noteDTO, MyNote.class);
        else
            return new MyNote();
    }
}
