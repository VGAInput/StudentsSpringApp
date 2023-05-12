-- liquibase formatted sql

-- changeset cs3:
CREATE TABLE avatars
(
    id         SERIAL,
    filePath   VARCHAR,
    fileSize   INTEGER,
    mediaType  VARCHAR,
    data       SMALLINT[],
    student_id INTEGER
)