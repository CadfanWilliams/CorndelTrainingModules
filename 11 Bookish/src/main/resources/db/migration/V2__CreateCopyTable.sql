CREATE TABLE copy (
    id SERIAL PRIMARY KEY,
    book_id INTEGER,
    FOREIGN KEY (book_id) REFERENCES book (id)
);