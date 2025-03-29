package com.note.app.repo;

import com.note.app.model.MyNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<MyNote, Integer> {

}
