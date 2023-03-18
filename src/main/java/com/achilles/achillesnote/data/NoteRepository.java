package com.achilles.achillesnote.data;

import com.achilles.achillesnote.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository  extends JpaRepository<Note, Integer> {

}
