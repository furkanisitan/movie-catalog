INSERT INTO genres (id, name) VALUES (1, 'Korku');
INSERT INTO genres (id, name) VALUES (2, 'Drama');
INSERT INTO genres (id, name) VALUES (3, 'Aksiyon');
INSERT INTO genres (id, name) VALUES (4, 'Bilim Kurgu');
INSERT INTO genres (id, name) VALUES (5, 'Romantik');
INSERT INTO genres (id, name) VALUES (6, 'Fantastik');
INSERT INTO genres (id, name) VALUES (7, 'Macera');
INSERT INTO genres (id, name) VALUES (8, 'Gizem');

INSERT INTO languages (id, name, code) VALUES (1, 'Almanca', 'de');
INSERT INTO languages (id, name, code) VALUES (2, 'Çince', 'zh');
INSERT INTO languages (id, name, code) VALUES (3, 'Farsça', 'fa');
INSERT INTO languages (id, name, code) VALUES (4, 'Fransızca', 'fr');
INSERT INTO languages (id, name, code) VALUES (5, 'İngilizce', 'en');
INSERT INTO languages (id, name, code) VALUES (6, 'İspanyolca', 'es');
INSERT INTO languages (id, name, code) VALUES (7, 'Japonca', 'ja');
INSERT INTO languages (id, name, code) VALUES (8, 'Portekizce', 'pt');
INSERT INTO languages (id, name, code) VALUES (9, 'Rusça', 'ru');
INSERT INTO languages (id, name, code) VALUES (10, 'Türkçe', 'tr');

INSERT INTO actors (id, full_name) VALUES (1, 'Elijah Wood');            -- The Lord of the Rings
INSERT INTO actors (id, full_name) VALUES (2, 'Ian McKellen');           -- The Lord of the Rings, Hobbit
INSERT INTO actors (id, full_name) VALUES (3, 'Orlando Bloom');          -- The Lord of the Rings, Hobbit
INSERT INTO actors (id, full_name) VALUES (4, 'Viggo Mortensen');        -- The Lord of the Rings
INSERT INTO actors (id, full_name) VALUES (5, 'Martin Freeman');         -- Hobbit
INSERT INTO actors (id, full_name) VALUES (6, 'Richard Armitage');       -- Hobbit
INSERT INTO actors (id, full_name) VALUES (7, 'Daniel Radcliffe');       -- Harry Potter
INSERT INTO actors (id, full_name) VALUES (8, 'Emma Watson');            -- Harry Potter, Little Woman
INSERT INTO actors (id, full_name) VALUES (9, 'Rupert Grint');           -- Harry Potter
INSERT INTO actors (id, full_name) VALUES (10, 'Saoirse Ronan');         -- Little Woman
INSERT INTO actors (id, full_name) VALUES (11, 'Florence Pugh');         -- Little Woman
INSERT INTO actors (id, full_name) VALUES (12, 'Eliza Scanlen');         -- Little Woman

INSERT INTO movies (id, name, release_date, media, description) VALUES (1, 'The Lord of the Rings: The Fellowship of the Ring', STR_TO_DATE('21-12-2001', '%d-%m-%Y'), 'Sinema', 'Peter Jackson''ın yönettiği Yüzüklerin Efendisi üçlemesinin birinci filmidir.');
INSERT INTO movies (id, name, release_date, media, description) VALUES (2, 'The Hobbit: An Unexpected Journey', STR_TO_DATE('14-12-2012', '%d-%m-%Y'), 'Sinema', 'Tolkien''in, Yüzüklerin Efendisi üçlemesinin öncül kitabı olarak da görülen Hobbit''ten, üçlemenin yönetmeni Peter Jackson tarafından sinemaya uyarlanan üç filmlik Hobbit macerasının ilk bölümü.');
INSERT INTO movies (id, name, release_date, media, description) VALUES (3, 'Harry Potter and the Sorcerer''s Stone', STR_TO_DATE('1-2-2002', '%d-%m-%Y'), 'Sinema', 'Chris Columbus tarafından yönetilen, J. K. Rowling''in 1997 tarihli aynı adlı romanından uyarlanan fantezi filmidir.');
INSERT INTO movies (id, name, release_date, media, description) VALUES (4, 'Little Women', STR_TO_DATE('14-2-2019', '%d-%m-%Y'), 'Sinema', 'Küçük Kadınlar, Louisa May Alcott''ın aynı isimdeki romanına dayanan, Greta Gerwig''in yönetmenliğini ve senaristliğini üstlendiği Amerikan dönem-dram filmidir.');

INSERT INTO movie_genre (movie_id, genre_id) VALUES (1, 6);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (1, 7);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (2, 6);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (2, 7);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (3, 6);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (3, 7);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (3, 8);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (4, 2);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (4, 5);

INSERT INTO movie_language (movie_id, language_id) VALUES (1, 5);
INSERT INTO movie_language (movie_id, language_id) VALUES (1, 6);
INSERT INTO movie_language (movie_id, language_id) VALUES (1, 10);
INSERT INTO movie_language (movie_id, language_id) VALUES (2, 5);
INSERT INTO movie_language (movie_id, language_id) VALUES (3, 5);
INSERT INTO movie_language (movie_id, language_id) VALUES (3, 10);
INSERT INTO movie_language (movie_id, language_id) VALUES (4, 4);
INSERT INTO movie_language (movie_id, language_id) VALUES (4, 5);

INSERT INTO characters (actor_id, movie_id, role_name) VALUES (1, 1, 'Frodo Baggins');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (2, 1, 'Gandalf');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (2, 2, 'Gandalf');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (3, 1, 'Legolas');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (3, 2, 'Legolas');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (4, 1, 'Aragorn');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (5, 2, 'Bilbo Baggins');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (6, 2, 'Thorin Meşekalkan');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (7, 3, 'Harry Potter');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (8, 3, 'Hermione Granger');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (8, 4, 'Meg March');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (9, 3, 'Ron Weasley');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (10, 4, 'Jo March');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (11, 4, 'Amy March');
INSERT INTO characters (actor_id, movie_id, role_name) VALUES (12, 4, 'Beth March');
