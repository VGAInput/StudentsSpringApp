-- liquibase formatted sql

-- changeset cs2:
CREATE TABLE students
(
    id         SERIAL,
    name       VARCHAR,
    age        INTEGER check ( age > 15 ),
    faculty_id INTEGER,
    avatar     INTEGER,
    students   INTEGER[]
)