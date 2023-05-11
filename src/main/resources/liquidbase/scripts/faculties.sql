-- liquidbase formatted sql

-- changeset cs2:
CREATE TABLE faculties
(
    id         SERIAL,
    name       VARCHAR UNIQUE,
    color      VARCHAR UNIQUE,
    faculty_id INTEGER
)