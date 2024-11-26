CREATE TABLE usuario(
usuario_id INTEGER NOT NULL PRIMARY KEY,
usuario_username VARCHAR(20),
usuario_nome TEXT,
usuario_imagem TEXT,
usuario_socialMedia TEXT,
usuario_localizacao TEXT,
usuario_idade DATE,
usuario_info TEXT,
usuario_email TEXT,
usuario_palavrapass TEXT,
usuario_musicstreaming TEXT,
usuario_follow_id INTEGER,
usuario_match_id INTEGER,
usuario_us_id INTEGER,
usuario_up_id INTEGER
)engine = innodb;


CREATE TABLE playlist(
playlist_id INTEGER NOT NULL,
playlist_up_id INTEGER,
playlist_ps_id INTEGER,
playlist_creator TEXT,
playlist_nome TEXT,
PRIMARY KEY (playlist_id)
)engine = innodb;


CREATE TABLE song(
song_id INTEGER NOT NULL,
song_nome TEXT,
song_imagem TEXT,
song_duration timestamp,
song_us_id INTEGER,
song_ps_id INTEGER,
song_gs_id INTEGER,
song_sa_id INTEGER,
PRIMARY KEY (song_id)
)engine = innodb;


CREATE TABLE artist(
artist_id INTEGER NOT NULL,
artist_nome TEXT,
artist_sa_id INTEGER,
PRIMARY KEY (artist_id)
)engine = innodb;


CREATE TABLE matched(
matched_id INTEGER NOT NULL,
matched_userMatched_id INTEGER,
matched_user_id INTEGER,
matched_estado_id INTEGER,
matched_compatibilidade INTEGER,
PRIMARY KEY (matched_id)
)engine = innodb;


CREATE TABLE follow(
follow_id INTEGER NOT NULL,
follow_user_id INTEGER,
follow_userFollowed BOOLEAN,
follow_userFollower BOOLEAN,
follow_compatibilidade INTEGER,
PRIMARY KEY (follow_id)
)engine = innodb;


CREATE TABLE genero(
genero_id INTEGER NOT NULL,
genero_nome TEXT,
genero_gs_id INTEGER,
PRIMARY KEY (genero_id)
);

CREATE TABLE estado(
estado_id INTEGER NOT NULL,
estado_stanby BOOLEAN,
estado_aceite BOOLEAN,
estado_recusado BOOLEAN,
PRIMARY KEY (estado_id)
)engine = innodb;


CREATE TABLE up(
up_id INTEGER NOT NULL,
up_user_id INTEGER,
up_playlist_id INTEGER,
PRIMARY KEY (up_id)
)engine = innodb;


CREATE TABLE us(
us_id INTEGER NOT NULL,
us_user_id INTEGER,
us_song_id INTEGER,
us_instant TIMESTAMP,
us_musicPlaying BOOLEAN,
PRIMARY KEY (us_id)
)engine = innodb;


CREATE TABLE ps(
ps_id INTEGER NOT NULL,
ps_playlist_id INTEGER,
ps_song_id INTEGER,
PRIMARY KEY (ps_id)
)engine = innodb;


CREATE TABLE sa(
sa_id INTEGER NOT NULL,
sa_song_id INTEGER,
sa_artist_id INTEGER,
PRIMARY KEY (sa_id)
)engine = innodb;


CREATE TABLE gs(
gs_id INTEGER NOT NULL,
gs_genero_id INTEGER,
gs_song_id INTEGER,
PRIMARY KEY (gs_id)
)engine = innodb;

ALTER TABLE usuario
ADD FOREIGN KEY (usuario_follow_id) REFERENCES follow (follow_id),
ADD FOREIGN KEY (usuario_match_id) REFERENCES matched (matched_id),
ADD FOREIGN KEY (usuario_us_id) REFERENCES us (us_id),
ADD FOREIGN KEY (usuario_up_id) REFERENCES up (up_id);

ALTER TABLE playlist
ADD FOREIGN KEY (playlist_up_id) REFERENCES up (up_id),
ADD FOREIGN KEY (playlist_ps_id) REFERENCES ps (ps_id);

ALTER TABLE song
ADD FOREIGN KEY (song_us_id) REFERENCES us (us_id),
ADD FOREIGN KEY (song_ps_id) REFERENCES ps (ps_id),
ADD FOREIGN KEY (song_gs_id) REFERENCES gs (gs_id),
ADD FOREIGN KEY (song_sa_id) REFERENCES sa (sa_id);

ALTER TABLE artist
ADD FOREIGN KEY (artist_sa_id) REFERENCES sa (sa_id);

ALTER TABLE matched
ADD FOREIGN KEY (matched_userMatched_id) REFERENCES usuario (usuario_id),
ADD FOREIGN KEY (matched_user_id) REFERENCES usuario (usuario_id),
ADD FOREIGN KEY (matched_estado_id) REFERENCES estado (estado_id);

ALTER TABLE follow
ADD FOREIGN KEY (follow_user_id) REFERENCES usuario (usuario_id);

ALTER TABLE genero
ADD FOREIGN KEY (genero_gs_id) REFERENCES gs (gs_id);

ALTER TABLE up 
ADD FOREIGN KEY (up_user_id) REFERENCES usuario (usuario_id),
ADD FOREIGN KEY (up_playlist_id) REFERENCES playlist (playlist_id);

ALTER TABLE us
ADD FOREIGN KEY (us_user_id) REFERENCES usuario (usuario_id),
ADD FOREIGN KEY (us_song_id) REFERENCES song (song_id);

ALTER TABLE ps
ADD FOREIGN KEY (ps_playlist_id) REFERENCES playlist (playlist_id),
ADD FOREIGN KEY (ps_song_id) REFERENCES song (song_id);

ALTER TABLE sa
ADD FOREIGN KEY (sa_song_id) REFERENCES song (song_id),
ADD FOREIGN KEY (sa_artist_id) REFERENCES artist (artist_id);

ALTER TABLE gs
ADD FOREIGN KEY (gs_genero_id) REFERENCES genero (genero_id),
ADD FOREIGN KEY (gs_song_id) REFERENCES song (song_id);
