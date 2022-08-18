CREATE TABLE resume (
                        uuid      varchar(256) PRIMARY KEY NOT NULL,
                        full_name varchar(256)                 NOT NULL
);

CREATE TABLE contact (
                         id          SERIAL,
                         resume_uuid varchar(256) NOT NULL REFERENCES resume (uuid) ON DELETE CASCADE,
                         type        TEXT     NOT NULL,
                         value       TEXT     NOT NULL
);
CREATE UNIQUE INDEX contact_uuid_type_index
    ON contact (resume_uuid, type);

CREATE TABLE section (
                         id          SERIAL PRIMARY KEY,
                         resume_uuid varchar(256) NOT NULL REFERENCES resume (uuid) ON DELETE CASCADE,
                         type        TEXT     NOT NULL,
                         content     TEXT     NOT NULL
);
CREATE UNIQUE INDEX section_idx
    ON section (resume_uuid, type);


INSERT INTO resume (uuid, full_name) VALUES
                                         ('7de882da-02f2-4d16-8daa-60660aaf4071', 'Name1'),
                                         ('a97b3ac3-3817-4c3f-8a5f-178497311f1d', 'Name2'),
                                         ('dd0a70d1-5ed3-479a-b452-d5e04f21ca73', 'Name3');

INSERT INTO resume (uuid, full_name) VALUES
                                         ('uuid1', 'Name1'),
                                         ('uuid2', 'Name2'),
                                         ('uuid3', 'Name3');

DELETE FROM resume
