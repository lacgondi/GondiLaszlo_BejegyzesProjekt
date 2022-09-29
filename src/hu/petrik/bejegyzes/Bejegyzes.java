package hu.petrik.bejegyzes;

import java.time.LocalDateTime;

public class Bejegyzes {
    private String author;
    private String content;
    private int likes;
    private LocalDateTime creation;
    private LocalDateTime edited;

    public Bejegyzes(String author, String content) {
        this.author = author;
        this.content = content;
        likes = 0;
        creation = LocalDateTime.now();
        edited = LocalDateTime.now();
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        edited = LocalDateTime.now();
    }

    public int getLikes() {
        return likes;
    }

    public LocalDateTime getCreation() {
        return creation;
    }

    public LocalDateTime getEdited() {
        return edited;
    }

    public void like(){
        likes++;
    }
}
