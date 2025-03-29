package com.note.app.dto;

public class NoteDTO {
    private String title;
    private String editedDate;
    private String editedTime;
    private String message;
    private String diaryPin;
    private boolean diary;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(String editedDate) {
        this.editedDate = editedDate;
    }

    public String getEditedTime() {
        return editedTime;
    }

    public void setEditedTime(String editedTime) {
        this.editedTime = editedTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDiaryPin() {
        return diaryPin;
    }

    public void setDiaryPin(String diaryPin) {
        this.diaryPin = diaryPin;
    }

    public boolean isDiary() {
        return diary;
    }

    public void setDiary(boolean diary) {
        this.diary = diary;
    }
}
