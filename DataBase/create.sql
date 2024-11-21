CREATE TABLE usuario(
id INTEGER,
username VARCHAR(20),
nome TEXT,
idade DATE,
follow_id INTEGER,
match_id INTEGER,
us_id INTEGER,
up_id INTEGER,
info TEXT,
email TEXT,
palavrapass TEXT,
musicstreaming TEXT
);

CREATE TABLE playlist(
id INTEGER,
up_id INTEGER,
ps_id INTEGER,
creator TEXT,
nome TEXT
);

CREATE TABLE song(
id INTEGER,
nome TEXT,
duration timestamp,
us_id INTEGER,
ps_id INTEGER,
gs_id INTEGER,
sa_id INTEGER
);

CREATE TABLE artist(
id INTEGER,
nome TEXT,
sa_id INTEGER
);

CREATE TABLE matched(
id INTEGER,
userMatched_id INTEGER,
user_id INTEGER,
estado_id INTEGER,
compatibilidade INTEGER
);

CREATE TABLE follow(
id INTEGER,
user_id INTEGER,
userFollowed BOOLEAN,
userFollower BOOLEAN,
compatibilidade INTEGER
);

CREATE TABLE genero(
id INTEGER,
nome TEXT,
gs_id INTEGER
);

CREATE TABLE estado(
id INTEGER,
stanby BOOLEAN,
aceite BOOLEAN,
recusado BOOLEAN
);

CREATE TABLE up(
id INTEGER,
user_id INTEGER,
playlist_id INTEGER
);

CREATE TABLE us(
id INTEGER,
user_id INTEGER,
song_id INTEGER,
instant TIMESTAMP,
musicPlaying BOOLEAN
);

CREATE TABLE ps(
id INTEGER,
playlist_id INTEGER,
song_id INTEGER
);

CREATE TABLE sa(
id INTEGER,
song_id INTEGER,
artist_id INTEGER
);

CREATE TABLE gs(
id INTEGER,
genero_id INTEGER,
song_id INTEGER
);

