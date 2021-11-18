package com.backmanager.backmanager.po;

public class Note {
    private String noteId; //笔记ID
    private String noteName;//笔记名称
    private String noteContent;//笔记内容
    private String noteCreater;//笔记创建者
    
    public String getNoteId() {
        return noteId;
    }
    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }
    public String getNoteName() {
        return noteName;
    }
    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }
    public String getNoteContent() {
        return noteContent;
    }
    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
    public String getNoteCreater() {
        return noteCreater;
    }
    public void setNoteCreater(String noteCreater) {
        this.noteCreater = noteCreater;
    }
    
}
