INSERT INTO movies (id, name, release_date, media, description) VALUES (1, 'The Lord of the Rings: The Fellowship of the Ring', STR_TO_DATE('10-12-2001', '%d-%m-%Y'), 'Cinema', 'It is a 2001 epic fantasy adventure film directed by Peter Jackson, based on the 1954 novel The Fellowship of the Ring, the first volume of J. R. R. Tolkien''s The Lord of the Rings. The film is the first instalment in The Lord of the Rings trilogy.');
INSERT INTO movies (id, name, release_date, media, description) VALUES (2, 'The Hobbit: An Unexpected Journey', STR_TO_DATE('14-12-2012', '%d-%m-%Y'), 'Cinema', 'It is the first instalment in a three-part film adaptation based on J. R. R. Tolkien’s 1937 novel The Hobbit.');
INSERT INTO movies (id, name, release_date, media, description) VALUES (3, 'Harry Potter and the Sorcerer''s Stone', STR_TO_DATE('4-11-2001', '%d-%m-%Y'), 'Cinema', 'It is a 2001 fantasy film directed by Chris Columbus and distributed by Warner Bros. Pictures, based on J. K. Rowling''s 1997 novel of the same name.');
INSERT INTO movies (id, name, release_date, media, description) VALUES (4, 'Little Women', STR_TO_DATE('7-2-2019', '%d-%m-%Y'), 'Cinema', 'It is a 2019 American coming-of-age period drama film written and directed by Greta Gerwig. It is the seventh film adaptation of the 1868 novel of the same name by Louisa May Alcott.');

INSERT INTO genres (id, name) VALUES (1, 'Adventure');
INSERT INTO genres (id, name) VALUES (2, 'Action');
INSERT INTO genres (id, name) VALUES (3, 'Drama');
INSERT INTO genres (id, name) VALUES (4, 'Fantastic');
INSERT INTO genres (id, name) VALUES (5, 'Mystery');
INSERT INTO genres (id, name) VALUES (6, 'Horror');
INSERT INTO genres (id, name) VALUES (7, 'Science fiction');
INSERT INTO genres (id, name) VALUES (8, 'Romance');

INSERT INTO movie_genre (movie_id, genre_id) VALUES (1, 1);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (1, 2);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (1, 4);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (2, 1);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (2, 2);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (2, 4);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (2, 8);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (3, 1);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (3, 4);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (4, 3);
INSERT INTO movie_genre (movie_id, genre_id) VALUES (4, 8);

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

INSERT INTO movie_actor (actor_id, movie_id, role_name) VALUES (1, 1, 'Frodo Baggins');
INSERT INTO movie_actor (actor_id, movie_id, role_name) VALUES (2, 1, 'Gandalf');
INSERT INTO movie_actor (actor_id, movie_id, role_name) VALUES (2, 2, 'Gandalf');
INSERT INTO movie_actor (actor_id, movie_id, role_name) VALUES (3, 1, 'Legolas');
INSERT INTO movie_actor (actor_id, movie_id, role_name) VALUES (3, 2, 'Legolas');
INSERT INTO movie_actor (actor_id, movie_id, role_name) VALUES (4, 1, 'Aragorn');
INSERT INTO movie_actor (actor_id, movie_id, role_name) VALUES (5, 2, 'Bilbo Baggins');
INSERT INTO movie_actor (actor_id, movie_id, role_name) VALUES (6, 2, 'Thorin Meşekalkan');
INSERT INTO movie_actor (actor_id, movie_id, role_name) VALUES (7, 3, 'Harry Potter');
INSERT INTO movie_actor (actor_id, movie_id, role_name) VALUES (8, 3, 'Hermione Granger');
INSERT INTO movie_actor (actor_id, movie_id, role_name) VALUES (8, 4, 'Meg March');
INSERT INTO movie_actor (actor_id, movie_id, role_name) VALUES (9, 3, 'Ron Weasley');
INSERT INTO movie_actor (actor_id, movie_id, role_name) VALUES (10, 4, 'Jo March');
INSERT INTO movie_actor (actor_id, movie_id, role_name) VALUES (11, 4, 'Amy March');
INSERT INTO movie_actor (actor_id, movie_id, role_name) VALUES (12, 4, 'Beth March');

INSERT INTO languages (id, name, code) VALUES (1, 'Arabic', 'ar');
INSERT INTO languages (id, name, code) VALUES (2, 'Chinese', 'zh');
INSERT INTO languages (id, name, code) VALUES (3, 'English', 'en');
INSERT INTO languages (id, name, code) VALUES (4, 'French', 'fr');
INSERT INTO languages (id, name, code) VALUES (5, 'German', 'de');
INSERT INTO languages (id, name, code) VALUES (6, 'Persian', 'fa');
INSERT INTO languages (id, name, code) VALUES (7, 'Portuguese', 'pt');
INSERT INTO languages (id, name, code) VALUES (8, 'Russian', 'ru');
INSERT INTO languages (id, name, code) VALUES (9, 'Spanish', 'es');
INSERT INTO languages (id, name, code) VALUES (10, 'Turkish', 'tr');

INSERT INTO movie_language (movie_id, language_id) VALUES (1, 3);
INSERT INTO movie_language (movie_id, language_id) VALUES (2, 3);
INSERT INTO movie_language (movie_id, language_id) VALUES (3, 3);
INSERT INTO movie_language (movie_id, language_id) VALUES (4, 3);