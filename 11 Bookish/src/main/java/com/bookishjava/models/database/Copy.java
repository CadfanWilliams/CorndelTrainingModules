package com.bookishjava.models.database;

import jakarta.persistence.*;

import java.time.chrono.IsoChronology;

@Entity
public class Copy {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private int book_id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
