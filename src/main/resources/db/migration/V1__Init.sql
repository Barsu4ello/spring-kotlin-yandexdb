CREATE TABLE users(
    id Text NOT NULL,
    name Text,
    PRIMARY KEY (id)
);

CREATE TABLE role(
    id Int32 NOT NULL,
    name Text,
    PRIMARY KEY (id)
);

CREATE TABLE users_role(
    user_id Text,
    role_id Int32,
    PRIMARY KEY (user_id, role_id)
);

INSERT INTO users(id ,name)
VALUES
    ('1', 'Vlad'),
    ('2', 'Pasha'),
    ('3', 'Sasha'),
    ('4', 'Danil');

INSERT INTO role(id ,name)
VALUES
    (1, 'User'),
    (2, 'Admin'),
    (3, 'Role3');


INSERT INTO users_role(user_id ,role_id)
VALUES
    ('1', 1),
    ('1', 2),
    ('1', 3),
    ('2', 1),
    ('2', 2),
    ('3', 1),
    ('4', 3);
