INSERT INTO users(id, email, password, role, salt) VALUES (1, 'pavelorlov@gmail.com', 'Fjb7%cil1M', 'STUDENT', 'sdfsdfsf');
INSERT INTO users(id, email, password, role, salt) VALUES (2, 'nadezhdamyronova@yahoo.com', '1&sjR4v#ao', 'STUDENT', 'omtvsuvo');

INSERT INTO results(id, score, user_id, test_id) VALUES (1, 60, 1, 1);
INSERT INTO results(id, score, user_id, test_id) VALUES (2, 80, 1, 1);

INSERT INTO topics(id, name) VALUES (1, 'JAVA');
INSERT INTO topics(id, name) VALUES (2, 'SQL');

INSERT INTO tests(id, name, topic_id) VALUES (1, 'Basic', 1);
INSERT INTO tests(id, name, topic_id) VALUES (2, 'Advanced', 1);

INSERT INTO questions(id, question_text, test_id) VALUES (1, 'Information Hiding can also be termed as:', 1);
INSERT INTO questions(id, question_text, test_id) VALUES (2, 'Constructors are used to:', 1);
INSERT INTO questions(id, question_text, test_id) VALUES (3, 'The process by which one object can acquire the properties of another object:?', 1);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (1, 'Encapsulation', 1,  1);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (2, 'Data hiding', 0,  1);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (3, 'Inheritance', 0,  1);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (4, 'To create a sub class.', 0,  2);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (5, 'Initialize a newly created object.', 1,  2);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (6, 'To create a sub class.', 0,  2);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (7, 'Inheritance', 1,  3);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (8, 'Polymorphism', 0,  3);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (9, 'Encapsulation', 0,  3);
