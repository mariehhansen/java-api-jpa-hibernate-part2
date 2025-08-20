package com.booleanuk.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String genre;

    @Column(insertable = false, updatable = false)
    private int author_id;

    @Column(insertable = false, updatable = false)
    private int publisher_id;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @JsonIncludeProperties(value = {"firstName", "lastName", "alive"})
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    @JsonIncludeProperties(value = {"name", "location"})
    private Publisher publisher;

    public Book(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }
}
