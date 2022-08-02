package wcs.rest.entity;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    /* title - author - description*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "author", length = 100)
    private String author;

    @Column(name = "description")
    private String description;

    public Book(){}

    public Book(int id, String title, String author, String description){
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

