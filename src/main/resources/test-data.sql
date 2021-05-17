INSERT INTO genres (id, name) VALUES (1, 'Drama');
INSERT INTO genres (id, name) VALUES (2, 'Romantik');
INSERT INTO genres (id, name) VALUES (3, 'Fantastik');
INSERT INTO genres (id, name) VALUES (4, 'Macera');
INSERT INTO genres (id, name) VALUES (5, 'Gizem');

INSERT INTO languages (id, name, code) VALUES (1, 'Almanca', 'de');
INSERT INTO languages (id, name, code) VALUES (2, 'İngilizce', 'en');
INSERT INTO languages (id, name, code) VALUES (3, 'Türkçe', 'tr');

INSERT INTO actors (id, full_name) VALUES (1, 'Elijah Wood');            -- The Lord of the Rings
INSERT INTO actors (id, full_name) VALUES (2, 'Ian McKellen');           -- The Lord of the Rings, Hobbit
INSERT INTO actors (id, full_name) VALUES (3, 'Richard Armitage');       -- Hobbit
INSERT INTO actors (id, full_name) VALUES (4, 'Daniel Radcliffe');       -- Harry Potter
INSERT INTO actors (id, full_name) VALUES (5, 'Emma Watson');            -- Harry Potter, Little Woman
INSERT INTO actors (id, full_name) VALUES (6, 'Saoirse Ronan');         -- Little Woman
INSERT INTO actors (id, full_name) VALUES (7, 'Eliza Scanlen');         -- Little Woman

INSERT INTO movies (id, name, release_date, media, description) VALUES (1, 'The Lord of the Rings: The Fellowship of the Ring', STR_TO_DATE('21-12-2001', '%d-%m-%Y'), 'Sinema', 'Peter Jackson''ın yönettiği Yüzüklerin Efendisi üçlemesinin birinci filmidir.');
INSERT INTO movies (id, name, release_date, media, description) VALUES (2, 'The Hobbit: An Unexpected Journey', STR_TO_DATE('14-12-2012', '%d-%m-%Y'), 'Sinema', 'Tolkien''in, Yüzüklerin Efendisi üçlemesinin öncül kitabı olarak da görülen Hobbit''ten, üçlemenin yönetmeni Peter Jackson tarafından sinemaya uyarlanan üç filmlik Hobbit macerasının ilk bölümü.');
INSERT INTO movies (id, name, release_date, media, description) VALUES (3, 'Harry Potter and the Sorcerer''s Stone', STR_TO_DATE('1-2-2002', '%d-%m-%Y'), 'Sinema', 'Chris Columbus tarafından yönetilen, J. K. Rowling''in 1997 tarihli aynı adlı romanından uyarlanan fantezi filmidir.');
INSERT INTO movies (id, name, release_date, media, description) VALUES (4, 'Little Women', STR_TO_DATE('14-2-2019', '%d-%m-%Y'), 'Sinema', 'Küçük Kadınlar, Louisa May Alcott''ın aynı isimdeki romanına dayanan, Greta Gerwig''in yönetmenliğini ve senaristliğini üstlendiği Amerikan dönem-dram filmidir.');

INSERT INTO movie_genre (movie_id, genre_id) VALUES (1, 3);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (1, 4);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (2, 3);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (2, 4);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (3, 3);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (3, 4);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (3, 5);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (4, 1);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (4, 2);

INSERT INTO movie_language (movie_id, language_id) VALUES (1, 1);
INSERT INTO movie_language (movie_id, language_id) VALUES (2, 1);
INSERT INTO movie_language (movie_id, language_id) VALUES (3, 1);
INSERT INTO movie_language (movie_id, language_id) VALUES (4, 1);

INSERT INTO characters (actor_id, movie_id, role_name) VALUES (1, 1, 'Frodo Baggins');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (2, 1, 'Gandalf');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (2, 2, 'Gandalf');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (3, 2, 'Thorin Meşekalkan');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (4, 3, 'Harry Potter');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (5, 3, 'Hermione Granger');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (5, 4, 'Meg March');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (6, 4, 'Jo March');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (7, 4, 'Beth March');