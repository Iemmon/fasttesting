SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS tests;
DROP TABLE IF EXISTS topics;
DROP TABLE IF EXISTS results;
DROP TABLE IF EXISTS users;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(320) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  `role` VARCHAR(45) DEFAULT 'STUDENT' NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `results` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `score` INT(11) NOT NULL,
  `test_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `topics` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `tests` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `topic_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_topics_id`
    FOREIGN KEY (`topic_id`)
    REFERENCES `topics` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `questions` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `question_text` TEXT NOT NULL,
  `test_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_test_id`
    FOREIGN KEY (`test_id`)
    REFERENCES `tests` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `answers` (
  `id` BIGINT NOT NULL  AUTO_INCREMENT,
  `answer_text` VARCHAR(255) NOT NULL,
  `is_correct` TINYINT(1) NULL,
  `question_id` BIGINT NULL,
  PRIMARY KEY (`id`),
    CONSTRAINT `fk_question_id`
    FOREIGN KEY (`question_id`)
    REFERENCES `questions` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
INSERT INTO users(id, email, password, role) VALUES (1, 'pavelorlov@gmail.com', 'Fjb7cil1M', 'STUDENT');
INSERT INTO users(id, email, password, role) VALUES (2, 'nadezhdamyronova@yahoo.com', '1sjR4vdao', 'STUDENT');
INSERT INTO users(id, email, password, role) VALUES (3, 'tatyana@yahoo.com', 'NICrifw3', 'STUDENT');
INSERT INTO users(id, email, password, role) VALUES (4, 'oleh@@aol.com', 'PCheiWf8xa', 'STUDENT');
INSERT INTO users(id, email, password, role) VALUES (5, 'sviatoslav@yahoo.com', 'NCqQCHIR53', 'STUDENT');
INSERT INTO users(id, email, password, role) VALUES (6, 'ihor@ygm.com', 'QNnSir6', 'STUDENT');
INSERT INTO users(id, email, password, role) VALUES (7, 'roman@yahoo.com', 'OECRneio92ds', 'STUDENT');
INSERT INTO users(id, email, password, role) VALUES (8, 'natalia@games.com', 'Password1', 'STUDENT');
INSERT INTO users(id, email, password, role) VALUES (9, 'vasylyna@aol.com', 'UIgsidn22', 'STUDENT');
INSERT INTO users(id, email, password, role) VALUES (10, 'novdjdscjsd@games.com', 'sdkreVENTf0', 'STUDENT');
INSERT INTO users(id, email, password, role) VALUES (11, 'sdfkvuxfic@gaol.com', 'vERohr4', 'STUDENT');
INSERT INTO users(id, email, password, role) VALUES (12, 'e@ygm.com', 'APrvmat2', 'STUDENT');
INSERT INTO users(id, email, password, role) VALUES (13, 'onxewjn@yahoo.com', 'Ssirhw3', 'STUDENT');
INSERT INTO users(id, email, password, role) VALUES (14, 'oifvrknu@gmail.com', 'YOjbx5ms', 'STUDENT');
INSERT INTO users(id, email, password, role) VALUES (15, 'wuxfklkfc@games.com', 'nvkrhfakR29', 'STUDENT');
INSERT INTO users(id, email, password, role) VALUES (16, 'uyweocnzmz@ygm.com', 'fsbfc7SST', 'STUDENT');

INSERT INTO topics(id, name) VALUES (1, 'Java Programming');
INSERT INTO topics(id, name) VALUES (2, 'Database');
INSERT INTO topics(id, name) VALUES (3, 'Computer Science');
INSERT INTO topics(id, name) VALUES (4, 'Networking');
INSERT INTO topics(id, name) VALUES (5, 'C++ Programming');


INSERT INTO tests(id, name, topic_id) VALUES (1, 'Language Fundamentals', 1);

INSERT INTO questions(id, question_text, test_id) VALUES (1, 'Which one of these lists contains only Java programming language keywords?', 1);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (1, 'class, if, void, long, Int, continue', 0,  1);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (2, 'goto, instanceof, native, finally, default, throws', 1,  1);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (3, 'try, virtual, throw, final, volatile, transient', 0,  1);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (4, 'strictfp, constant, super, implements, do', 0,  1);

INSERT INTO questions(id, question_text, test_id) VALUES (2, 'Which will legally declare, construct, and initialize an array?', 1);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (5, 'int [] myList = {"1", "2", "3"};', 0,  2);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (6, 'int [] myList = (5, 8, 2);', 0,  2);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (7, 'int myList [] [] = {4,9,7,0};', 0,  2);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (8, 'int myList [] = {4, 3, 7};', 1,  2);

INSERT INTO questions(id, question_text, test_id) VALUES (3, 'Which is a reserved word in the Java programming language?', 1);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (9, 'method', 0,  3);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (10, 'native', 1,  3);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (11, 'subclasses', 0,  3);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (12, 'reference', 0,  3);

INSERT INTO questions(id, question_text, test_id) VALUES (4, 'Which is a valid keyword in java?', 1);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (13, 'interface', 1,  4);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (14, 'string', 0,  4);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (15, 'Float', 0,  4);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (16, 'unsigned', 0,  4);

INSERT INTO questions(id, question_text, test_id) VALUES (5, 'Which one of the following will declare an array and initialize it with five numbers?', 1);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (17, 'Array a = new Array(5);', 0,  5);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (18, 'int [] a = {23,22,21,20,19};', 1,  5);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (19, 'int a [] = new int[5];', 0,  5);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (20, 'int [5] array;', 0,  5);

INSERT INTO questions(id, question_text, test_id) VALUES (6, 'Which is the valid declarations within an interface definition?', 1);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (21, 'public double methoda();', 1,  6);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (22, 'public final double methoda();', 0,  6);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (23, 'static void methoda(double d1);', 0,  6);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (24, 'protected void methoda(double d1);', 0,  6);

INSERT INTO questions(id, question_text, test_id) VALUES (7, 'Which one is a valid declaration of a boolean?', 1);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (25, 'boolean b1 = 0;', 0,  7);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (26, 'boolean b2 = \'false\';', 0,  7);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (27, 'boolean b3 = false;', 1,  7);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (28, 'boolean b4 = Boolean.false();', 0,  7);

INSERT INTO questions(id, question_text, test_id) VALUES (8, 'Which is a valid declarations of a String?', 1);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (29, 'String s1 = null;', 1,  8);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (30, 'String s2 = \'null\';', 0,  8);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (31, 'String s3 = (String) \'abc\';', 0,  8);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (32, 'String s4 = (String) \'\ufeed\';', 0,  8);

INSERT INTO questions(id, question_text, test_id) VALUES (9, 'What is the numerical range of a char?', 1);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (33, '-128 to 127', 0,  9);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (34, '-(215) to (215) - 1', 0,  9);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (35, '0 to 32767', 0,  9);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (36, '0 to 65535', 1,  9);

INSERT INTO questions(id, question_text, test_id) VALUES (10, 'Which of the following are Java modifiers?', 1);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (37, 'public', 1,  10);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (38, 'private', 1,  10);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (39, 'friendly', 0,  10);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (40, 'vagrant', 0,  10);

INSERT INTO tests(id, name, topic_id) VALUES (2, 'Inner Classes', 1);
INSERT INTO questions(id, question_text, test_id) VALUES (11, 'Which is true about an anonymous inner class?', 2);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (41, 'It can extend exactly one class and implement exactly one interface.', 0,  11);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (42, 'It can extend exactly one class and can implement multiple interfaces.', 0,  11);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (43, 'It can extend exactly one class or implement exactly one interface.', 1,  11);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (44, 'It can implement multiple interfaces regardless of whether it also extends a class.', 0,  11);

INSERT INTO questions(id, question_text, test_id) VALUES (12, 'Which is true about a method-local inner class?', 2);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (45, 'It must be marked final.', 0,  12);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (46, 'It can be marked abstract.', 1,  12);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (47, 'It can be marked public.', 0,  12);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (48, 'It can be marked static.', 0,  12);

INSERT INTO questions(id, question_text, test_id) VALUES (13, 'Which statement is true about a static nested class?', 2);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (49, 'You must have a reference to an instance of the enclosing class in order to instantiate it.', 0,  13);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (50, 'It does not have access to nonstatic members of the enclosing class.', 1,  13);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (51, 'It\'s variables and methods must be static.', 0,  13);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (52, 'It must extend the enclosing class.', 0,  13);

INSERT INTO questions(id, question_text, test_id) VALUES (14, 'Which constructs an anonymous inner class instance?', 2);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (53, 'Runnable r = new Runnable() { };', 0,  14);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (54, 'Runnable r = new Runnable(public void run() { });', 0,  14);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (55, 'Runnable r = new Runnable { public void run(){}};', 0,  14);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (56, 'System.out.println(new Runnable() {public void run() { }});', 1,  14);

INSERT INTO questions(id, question_text, test_id) VALUES (15, 'Which of the following is true about anonymous inner classes?', 2);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (57, 'Which of the following is true about anonymous inner classes?', 0,  15);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (58, 'You can create ‘n’ number of objects to anonymous inner classes.', 0,  15);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (59, 'Anonymous inner classes will not have the name.', 0,  15);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (60, 'You can instantiate anonymous inner classes only once.', 1,  15);

INSERT INTO questions(id, question_text, test_id) VALUES (16, 'Local inner classes can not be declared as abstract.', 2);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (61, 'True', 0,  16);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (62, 'False', 1,  16);


INSERT INTO questions(id, question_text, test_id) VALUES (17, 'Can you instantiate anonymous inner classes more than once?', 2);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (63, 'Yes', 0,  17);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (64, 'No', 1,  17);

INSERT INTO questions(id, question_text, test_id) VALUES (18, 'Can we access static members of outer class inside a member inner class?', 2);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (65, 'Yes', 1,  18);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (66, 'No', 0,  18);


INSERT INTO questions(id, question_text, test_id) VALUES (19, 'Can interfaces have inner classes in them?', 2);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (67, 'Yes', 1,  19);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (68, 'No', 0,  19);


INSERT INTO questions(id, question_text, test_id) VALUES (20, 'Can interfaces have inner classes in them?', 2);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (69, 'Yes', 1,  20);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (70, 'No', 0,  20);


INSERT INTO tests(id, name, topic_id) VALUES (3, 'Declarations and Access Control', 1);
INSERT INTO questions(id, question_text, test_id) VALUES (21, 'You want subclasses in any package to have access to members of a superclass. Which is the most restrictive access that accomplishes this objective?', 3);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (71, 'public', 0,  21);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (72, 'private', 0,  21);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (73, 'protected', 1,  21);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (74, 'transient', 0,  21);


INSERT INTO questions(id, question_text, test_id) VALUES (22, 'What is the most restrictive access modifier that will allow members of one class to have access to members of another class in the same package?', 3);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (75, 'abstract', 0,  22);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (76, 'protected', 0,  22);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (77, 'synchronized', 0,  22);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (78, 'default access', 1,  22);

INSERT INTO questions(id, question_text, test_id) VALUES (23, 'Which cause a compiler error?', 3);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (79, 'int[ ] scores = {3, 5, 7};', 0,  23);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (80, 'int [ ][ ] scores = {2,7,6}, {9,3,45};', 1,  23);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (81, 'String cats[ ] = {"Fluffy", "Spot", "Zeus"};', 0,  23);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (82, 'boolean results[ ] = new boolean [] {true, false, true};', 0,  23);

INSERT INTO questions(id, question_text, test_id) VALUES (24, 'You want a class to have access to members of another class in the same package. Which is the most restrictive access that accomplishes this objective?', 3);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (83, 'public', 0,  24);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (84, 'private', 0,  24);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (85, 'protected', 0,  24);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (86, 'default access', 1,  24);

INSERT INTO questions(id, question_text, test_id) VALUES (25, 'Which one creates an instance of an array?', 3);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (87, 'int[ ] ia = new int[15];', 1,  25);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (88, 'float fa = new float[20];', 0,  25);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (89, 'char[ ] ca = "Some String";', 0,  25);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (90, 'int ia[ ] [ ] = { 4, 5, 6 }, { 1,2,3 };', 0,  25);

INSERT INTO questions(id, question_text, test_id) VALUES (26, 'Which of the following class level (nonlocal) variable declarations will not compile?', 3);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (91, 'protected int a;', 0,  26);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (92, 'transient int b = 3;', 0,  26);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (93, 'private synchronized int e;', 1,  26);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (94, 'volatile int d;', 0,  26);


INSERT INTO questions(id, question_text, test_id) VALUES (27, 'Given a method in a protected class, what access modifier do you use to restrict access to that method to only the other members of the same class?', 3);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (95, 'final', 0,  27);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (96, 'static', 0,  27);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (97, 'private', 1,  27);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (98, 'protected', 0,  27);

INSERT INTO questions(id, question_text, test_id) VALUES (28, 'Which is a valid declaration within an interface?', 3);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (99, 'public static short stop = 23;', 1,  28);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (100, 'protected short stop = 23;', 0,  28);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (101, 'transient short stop = 23;', 0,  28);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (102, 'final void madness(short stop);', 0,  28);

INSERT INTO questions(id, question_text, test_id) VALUES (29, 'Which two statements are true for any concrete class implementing the java.lang.Runnable interface?
    1. You can extend the Runnable interface as long as you override the public run() method.
    2. The class must contain a method called run() from which all code for that thread will be initiated.
    3. The class must contain an empty public void method named run().questions
    4. The class must contain a public void method named runnable().
    5. The class definition must include the words implements Threads and contain a method called run().
    6. The mandatory method must be public, with a return type of void, must be called run(), and cannot take any arguments.', 3);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (103, '1 and 3', 0,  29);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (104, '2 and 4', 0,  29);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (105, '1 and 5', 0,  29);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (106, '2 and 6', 1,  29);


INSERT INTO questions(id, question_text, test_id) VALUES (30, 'Which three statements are true?
    1. The default constructor initialises method variables.
    2. The default constructor has the same access as its class.
    3. The default constructor invokes the no-arg constructor of the superclass.
    4. If a class lacks a no-arg constructor, the compiler always creates a default constructor.
    5. The compiler creates a default constructor only when there are no other constructors for the class.', 3);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (107, '1, 2 and 4', 0,  30);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (108, '2, 3 and 5', 1,  30);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (109, '3, 4 and 5', 0,  30);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (110, '1, 2 and 3', 0,  30);


INSERT INTO tests(id, name, topic_id) VALUES (4, 'Objects and Collections', 1);
INSERT INTO questions(id, question_text, test_id) VALUES (31, 'Suppose that you would like to create an instance of a new Map that has an iteration order that is the same as the iteration order of an existing instance of a Map. Which concrete implementation of the Map interface should be used for the new instance?', 4);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (111, 'TreeMap', 0,  31);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (112, 'HashMap', 0,  31);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (113, 'LinkedHashMap', 1,  31);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (114, 'The answer depends on the implementation of the existing instance.', 0,  31);

INSERT INTO questions(id, question_text, test_id) VALUES (32, 'Which class does not override the equals() and hashCode() methods, inheriting them directly from class Object?', 4);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (115, 'java.lang.String', 0,  32);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (116, 'java.lang.Double', 0,  32);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (117, 'java.lang.StringBuffer', 1,  32);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (118, 'java.lang.Character', 0,  32);

INSERT INTO questions(id, question_text, test_id) VALUES (33, 'Which collection class allows you to grow or shrink its size and provides indexed access to its elements, but whose methods are not synchronized?', 4);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (119, 'java.util.HashSet', 0,  33);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (120, 'java.util.LinkedHashSet', 0,  33);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (121, 'java.util.List', 0,  33);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (122, 'java.util.ArrayList', 1,  33);

INSERT INTO questions(id, question_text, test_id) VALUES (34, 'You need to store elements in a collection that guarantees that no duplicates are stored and all elements can be accessed in natural order. Which interface provides that capability?', 4);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (123, 'java.util.Map', 0,  34);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (124, 'java.util.Set', 1,  34);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (125, 'java.util.List', 0,  34);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (126, 'java.util.Collection', 0,  34);

INSERT INTO questions(id, question_text, test_id) VALUES (35, 'Which interface does java.util.Hashtable implement?', 4);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (127, 'Java.util.Map', 1,  35);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (128, 'Java.util.List', 0,  35);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (129, 'Java.util.HashTable', 0,  35);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (130, 'Java.util.Collection', 0,  35);

INSERT INTO questions(id, question_text, test_id) VALUES (36, 'Which interface provides the capability to store objects using a key-value pair?', 4);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (131, 'Java.util.Map', 1,  36);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (132, 'Java.util.Set', 0,  36);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (133, 'Java.util.List', 0,  36);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (134, 'Java.util.Collection', 0,  36);

INSERT INTO questions(id, question_text, test_id) VALUES (37, 'Which collection class allows you to associate its elements with key values, and allows you to retrieve objects in FIFO (first-in, first-out) sequence?', 4);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (135, 'java.util.ArrayList', 0,  37);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (136, 'java.util.LinkedHashMap', 1,  37);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (137, 'java.util.HashMap', 0,  37);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (138, 'java.util.TreeMap', 0,  37);

INSERT INTO questions(id, question_text, test_id) VALUES (38, 'Which collection class allows you to access its elements by associating a key with an element\'s value, and provides synchronization?', 4);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (139, 'java.util.SortedMap', 0,  38);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (140, 'java.util.TreeMap', 0,  38);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (141, 'java.util.TreeSet', 0,  38);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (142, 'java.util.Hashtable', 1,  38);

INSERT INTO questions(id, question_text, test_id) VALUES (39, 'Which is valid declaration of a float?', 4);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (143, 'float f = 1F;', 1,  39);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (144, 'float f = 1.0;', 0,  39);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (145, 'float f = "1";', 0,  39);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (146, 'float f = 1.0d;', 0,  39);

INSERT INTO questions(id, question_text, test_id) VALUES (40, 'What is the numerical range of char?', 4);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (147, '0 to 32767', 0,  40);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (148, '0 to 65535', 1,  40);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (149, '-256 to 255', 0,  40);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (150, '-32768 to 32767', 0,  40);


INSERT INTO tests(id, name, topic_id) VALUES (5, 'Introduction to Database', 2);
INSERT INTO questions(id, question_text, test_id) VALUES (41, 'The DBMS acts as an interface between what two components of an enterprise-class database system?', 5);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (151, 'Database application and the database', 1,  41);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (152, 'Data and the database', 0,  41);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (153, 'The user and the database application', 0,  41);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (154, 'Database application and SQL', 0,  41);

INSERT INTO questions(id, question_text, test_id) VALUES (42, 'Which of the following products was an early implementation of the relational model developed by E.F. Codd of IBM?', 5);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (155, 'IDMS', 0,  42);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (156, 'DB2', 1,  42);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (157, 'dBase-II', 0,  42);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (158, 'R:base', 0,  42);

INSERT INTO questions(id, question_text, test_id) VALUES (43, 'The following are components of a database except ________ .', 5);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (159, 'user data', 0,  43);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (160, 'metadata', 0,  43);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (161, 'reports', 1,  43);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (162, 'indexes', 0,  43);

INSERT INTO questions(id, question_text, test_id) VALUES (44, 'An application where only one user accesses the database at a given time is an example of a(n) ________ .', 5);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (163, 'single-user database application', 1,  44);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (164, 'multiuser database application', 0,  44);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (165, 'e-commerce database application', 0,  44);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (166, 'data mining database application', 0,  44);

INSERT INTO questions(id, question_text, test_id) VALUES (45, 'An on-line commercial site such as Amazon.com is an example of a(n) ________ .', 5);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (167, 'single-user database application', 0,  45);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (168, 'multiuser database application', 0,  45);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (169, 'e-commerce database application', 1,  45);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (170, 'data mining database application', 0,  45);

INSERT INTO questions(id, question_text, test_id) VALUES (46, 'Which of the following products was the first to implement true relational algebra in a PC DBMS?', 5);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (171, 'IDMS', 0,  46);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (172, 'Oracle', 0,  46);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (173, 'dBase-II', 0,  46);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (174, 'R:base', 1,  46);

INSERT INTO questions(id, question_text, test_id) VALUES (47, 'SQL stands for ________ .', 5);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (175, 'Structured Query Language', 1,  47);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (176, 'Sequential Query Language', 0,  47);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (177, 'Structured Question Language', 0,  47);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (178, 'Sequential Question Language', 0,  47);

INSERT INTO questions(id, question_text, test_id) VALUES (48, 'Because it contains a description of its own structure, a database is considered to be ________ .', 5);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (179, 'described', 0,  48);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (180, 'metadata compatible', 0,  48);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (181, 'self-describing', 1,  48);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (182, 'an application program', 0,  48);

INSERT INTO questions(id, question_text, test_id) VALUES (49, 'The following are functions of a DBMS except ________ .', 5);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (183, 'creating and processing forms', 1,  49);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (184, 'creating databases', 0,  49);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (185, 'processing data', 0,  49);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (186, 'administrating databases', 0,  49);

INSERT INTO questions(id, question_text, test_id) VALUES (50, 'Helping people keep track of things is the purpose of a(n) ________ .', 5);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (187, 'database', 1,  50);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (188, 'table', 0,  50);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (189, 'instance', 0,  50);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (190, 'relationship', 0,  50);


INSERT INTO tests(id, name, topic_id) VALUES (6, 'Introduction to SQL', 2);
INSERT INTO questions(id, question_text, test_id) VALUES (51, 'You can add a row using SQL in a database with which of the following?', 6);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (191, 'ADD', 0,  51);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (192, 'CREATE', 0,  51);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (193, 'INSERT', 1,  51);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (194, 'MAKE', 0,  51);


INSERT INTO questions(id, question_text, test_id) VALUES (52, 'The command to remove rows from a table \'CUSTOMER\' is:', 6);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (195, 'REMOVE FROM CUSTOMER ...', 0,  52);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (196, 'DROP FROM CUSTOMER ...', 0,  52);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (197, 'DELETE FROM CUSTOMER WHERE ...', 1,  52);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (198, 'UPDATE FROM CUSTOMER ...', 0,  52);

INSERT INTO questions(id, question_text, test_id) VALUES (53, 'The SQL WHERE clause:', 6);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (199, 'limits the column data that are returned.', 0,  53);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (200, 'limits the row data are returned.', 1,  53);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (201, 'Both A and B are correct.', 0,  53);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (202, 'Neither A nor B are correct.', 0,  53);


INSERT INTO questions(id, question_text, test_id) VALUES (54, 'Which of the following is the original purpose of SQL?', 6);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (203, 'To specify the syntax and semantics of SQL data definition language', 0,  54);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (204, 'To specify the syntax and semantics of SQL data definition language', 0,  54);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (205, 'To specify the syntax and semantics of SQL manipulation language', 0,  54);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (206, 'To define the data structures', 1,  54);


INSERT INTO questions(id, question_text, test_id) VALUES (55, 'The wildcard in a WHERE clause is useful when?', 6);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (207, 'An exact match is necessary in a SELECT statement.', 0,  55);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (208, 'An exact match is not possible in a SELECT statement.', 1,  55);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (209, 'An exact match is necessary in a CREATE statement.', 0,  55);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (210, 'An exact match is not possible in a CREATE statement.', 0,  55);


INSERT INTO questions(id, question_text, test_id) VALUES (56, 'A view is which of the following?', 6);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (211, 'A virtual table that can be accessed via SQL commands', 1,  56);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (212, 'A virtual table that cannot be accessed via SQL commands', 0,  56);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (213, 'A base table that can be accessed via SQL commands', 0,  56);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (214, 'A base table that cannot be accessed via SQL commands', 0,  56);

INSERT INTO questions(id, question_text, test_id) VALUES (57, 'The command to eliminate a table from a database is:', 6);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (215, 'REMOVE TABLE CUSTOMER;', 0,  57);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (216, 'DROP TABLE CUSTOMER;', 1,  57);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (217, 'DELETE TABLE CUSTOMER;', 0,  57);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (218, 'UPDATE TABLE CUSTOMER;', 0,  57);


INSERT INTO questions(id, question_text, test_id) VALUES (58, 'ON UPDATE CASCADE ensures which of the following?', 6);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (219, 'Normalization', 0,  58);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (220, 'Data Integrity', 1,  58);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (221, 'Materialized Views', 0,  58);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (222, 'All of the above.', 0,  58);


INSERT INTO questions(id, question_text, test_id) VALUES (59, 'SQL data definition commands make up a(n) ________ .', 6);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (223, 'DDL', 1,  59);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (224, 'DML', 0,  59);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (225, 'HTML', 0,  59);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (226, 'XML', 0,  59);


INSERT INTO questions(id, question_text, test_id) VALUES (60, 'Which of the following is valid SQL for an Index?', 6);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (227, 'CREATE INDEX ID;', 1,  60);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (228, 'CHANGE INDEX ID;', 0,  60);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (229, 'ADD INDEX ID;', 0,  60);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (230, 'REMOVE INDEX ID;', 0,  60);


INSERT INTO tests(id, name, topic_id) VALUES (7, 'JDBC, Java Server Pages, and MySQL', 2);
INSERT INTO questions(id, question_text, test_id) VALUES (61, 'How many JDBC driver types does Sun define?', 7);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (231, 'One', 0,  61);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (232, 'Two', 0,  61);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (233, 'Three', 0,  61);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (234, 'Four', 1,  61);


INSERT INTO questions(id, question_text, test_id) VALUES (62, 'Where is metadata stored in MySQL?', 7);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (235, 'In the MySQL database metadata', 0,  62);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (236, 'In the MySQL database metasql', 0,  62);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (237, 'In the MySQL database mysql', 1,  62);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (238, 'None of the above is correct.', 0,  62);


INSERT INTO questions(id, question_text, test_id) VALUES (63, 'Who invented Java?', 7);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (239, 'Netscape', 0,  63);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (240, 'Microsoft', 0,  63);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (241, 'Sun', 1,  63);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (242, 'None of the above is correct.', 0,  63);


INSERT INTO questions(id, question_text, test_id) VALUES (64, 'To run a compiled Java program, the machine must have what loaded and running?', 7);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (243, 'Java virtual machine', 1,  64);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (244, 'Java compiler', 0,  64);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (245, 'Java bytecode', 0,  64);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (246, 'A Web browser', 0,  64);


INSERT INTO questions(id, question_text, test_id) VALUES (65, 'Which JDBC driver Type(s) can be used in either applet or servlet code?', 7);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (247, 'Both Type 1 and Type 2', 0,  65);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (248, 'Both Type 1 and Type 3', 0,  65);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (249, 'Both Type 3 and Type 4', 1,  65);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (250, 'Type 4 only', 0,  65);


INSERT INTO questions(id, question_text, test_id) VALUES (66, '________ is an open source DBMS product that runs on UNIX, Linux and Windows.', 7);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (251, 'MySQL', 1,  66);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (252, 'JSP/SQL', 0,  66);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (253, 'JDBC/SQL', 0,  66);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (254, 'Sun ACCESS', 0,  66);


INSERT INTO questions(id, question_text, test_id) VALUES (67, 'What is sent to the user via HTTP, invoked using the HTTP protocol on the user\'s computer, and run on the user\'s computer as an application?', 7);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (255, 'A Java application', 0,  67);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (256, 'A Java applet', 1,  67);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (257, 'A Java servlet', 0,  67);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (258, 'None of the above is correct.', 0,  67);


INSERT INTO questions(id, question_text, test_id) VALUES (68, 'What MySQL property is used to create a surrogate key in MySQL?', 7);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (259, 'UNIQUE', 0,  68);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (260, 'SEQUENCE', 0,  68);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (261, 'AUTO_INCREMENT', 1,  68);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (262, 'None of the above -- Surrogate keys are not implemented in MySQL.', 0,  68);


INSERT INTO questions(id, question_text, test_id) VALUES (69, 'What is not true of a Java bean?', 7);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (263, 'There are no public instance variables.', 0,  69);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (264, 'All persistent values are accessed using getxxx and setxxx methods.', 0,  69);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (265, 'It may have many constructors as necessary.', 1,  69);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (266, 'All of the above are true of a Java bean.', 0,  69);


INSERT INTO questions(id, question_text, test_id) VALUES (70, 'A JSP is transformed into a(n):', 7);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (267, 'Java applet.', 0,  70);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (268, 'Java servlet.', 1,  1);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (269, 'Either 1 or 2 above.', 0,  70);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (270, 'Neither 1 nor 2 above.', 0,  70);


INSERT INTO tests(id, name, topic_id) VALUES (8, 'JDBC, Java Server Pages, and MySQL Part2', 2);
INSERT INTO questions(id, question_text, test_id) VALUES (71, 'Which JDBC driver Type(s) can you use in a three-tier architecture and if the Web server and the DBMS are running on the same machine?', 8);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (271, 'Type 1 only', 0,  71);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (272, 'Type 2 only', 0,  71);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (273, 'Both Type 3 and Type 4', 0,  71);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (274, 'All of Type 1, Type 2, Type 3 and Type 4', 1,  71);


INSERT INTO questions(id, question_text, test_id) VALUES (72, 'What programming language(s) or scripting language(s) does Java Server Pages (JSP) support?', 8);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (275, 'VBScript only', 0,  72);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (276, 'Jscript only', 0,  72);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (277, 'Java only', 1,  72);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (278, 'All of the above are supported', 0,  72);


INSERT INTO questions(id, question_text, test_id) VALUES (73, 'What servlet processor was developed by Apache Foundation and Sun?', 8);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (279, 'Apache Tomcat', 1,  73);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (280, 'Apache Web server', 0,  73);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (281, 'Sun servlet processor', 0,  73);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (282, 'None of the above is correct.', 0,  73);


INSERT INTO questions(id, question_text, test_id) VALUES (74, 'What is bytecode?', 8);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (283, 'Machine-specific code', 0,  74);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (284, 'Java code', 0,  74);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (285, 'Machine-independent code', 1,  74);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (286, 'None of the above is correct.', 0,  74);


INSERT INTO questions(id, question_text, test_id) VALUES (75, 'What is invoked via HTTP on the Web server computer when it responds to requests from a user\'s Web browser?', 8);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (287, 'A Java application', 0,  75);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (288, 'A Java applet', 0,  75);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (289, 'A Java servlet', 1,  75);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (290, 'None of the above is correct.', 0,  75);


INSERT INTO questions(id, question_text, test_id) VALUES (76, 'Which JDBC driver Type(s) is(are) the JDBC-ODBC bridge?', 8);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (291, 'Type 1', 1,  76);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (292, 'Type 2', 0,  76);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (293, 'Type 3', 0,  76);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (294, 'Type 4', 0,  76);


INSERT INTO questions(id, question_text, test_id) VALUES (77, 'How many copies of a JSP page can be in memory at a time?', 8);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (295, 'One', 1,  77);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (296, 'Two', 0,  77);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (297, 'Three', 0,  77);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (298, 'Unlimited', 0,  77);


INSERT INTO questions(id, question_text, test_id) VALUES (78, 'Which JDBC driver Types are for use over communications networks?', 8);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (299, 'Type 3 only', 0,  78);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (300, 'Type 4 only', 0,  78);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (301, 'Both Type 3 and Type 4', 1,  78);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (302, 'Neither Type 3 nor Type 4', 0,  78);


INSERT INTO questions(id, question_text, test_id) VALUES (79, 'JDBC stands for:', 8);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (303, 'Java Database Connectivity', 1,  79);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (304, 'Java Database Components', 0,  79);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (305, 'Java Database Control', 0,  79);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (306, 'None of the above is correct.', 0,  79);


INSERT INTO questions(id, question_text, test_id) VALUES (80, 'How does Tomcat execute a JSP?', 8);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (307, 'As a CGI script', 0,  80);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (308, 'As an independent process', 0,  80);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (309, 'By one of Tomcat\'s threads', 1,  80);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (310, 'None of the above is correct.', 0,  80);



INSERT INTO tests(id, name, topic_id) VALUES (9, 'Advanced SQL', 2);
INSERT INTO questions(id, question_text, test_id) VALUES (81, 'What type of join is needed when you wish to include rows that do not have matching values?', 9);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (311, 'Equi-join', 0,  81);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (312, 'Natural join', 0,  81);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (313, 'Outer join', 1,  81);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (314, 'All of the above.', 0,  81);


INSERT INTO questions(id, question_text, test_id) VALUES (82, 'What type of join is needed when you wish to return rows that do have matching values?', 9);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (315, 'Equi-join', 0,  82);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (316, 'Natural join', 0,  82);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (317, 'Outer join', 0,  82);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (318, 'All of the above.', 1,  82);


INSERT INTO questions(id, question_text, test_id) VALUES (83, 'Which of the following is true concerning a procedure?', 9);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (319, 'You do not create them with SQL.', 0,  83);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (320, 'They do not need to have a unique name.', 0,  83);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (321, 'They include procedural and SQL statements.', 1,  83);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (322, 'They are the same thing as a function.', 0,  83);


INSERT INTO questions(id, question_text, test_id) VALUES (84, 'A CASE SQL statement is which of the following?', 9);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (323, 'A way to establish an IF-THEN-ELSE in SQL.', 1,  84);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (324, 'A way to establish a loop in SQL.', 0,  84);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (325, 'A way to establish a data definition in SQL.', 0,  84);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (326, 'All of the above.', 0,  84);


INSERT INTO questions(id, question_text, test_id) VALUES (85, 'Which of the following statements is true concerning routines and triggers?', 9);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (327, 'Both consist of procedural code.', 1,  85);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (328, 'Both have to be called to operate.', 0,  85);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (329, 'Both run automatically.', 0,  85);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (330, 'Both are stored in the database.', 0,  85);

INSERT INTO questions(id, question_text, test_id) VALUES (86, 'Which of the following is one of the basic approaches for joining tables?', 9);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (331, 'Subqueries', 0,  86);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (332, 'Union Join', 0,  86);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (333, 'Natural join', 0,  86);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (334, 'All of the above', 1,  86);


INSERT INTO questions(id, question_text, test_id) VALUES (87, 'Which of the following is true concerning systems information in an RDBMS?', 9);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (335, 'RDBMS store database definition information in system-created tables.', 0,  87);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (336, 'This information can be accessed using SQL.', 0,  87);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (337, 'This information often cannot be updated by a user.', 0,  87);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (338, 'All of the above.', 1,  87);

INSERT INTO questions(id, question_text, test_id) VALUES (88, 'The following SQL is which type of join: SELECT CUSTOMER_T. CUSTOMER_ID, ORDER_T. CUSTOMER_ID, NAME, ORDER_ID FROM CUSTOMER_T,ORDER_T WHERE CUSTOMER_T. CUSTOMER_ID = ORDER_T. CUSTOMER_ID', 9);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (339, 'Equi-join', 1,  88);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (340, 'Natural join', 0,  88);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (341, 'Outer join', 0,  88);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (342, 'Cartesian join', 0,  88);


INSERT INTO questions(id, question_text, test_id) VALUES (89, 'Embedded SQL is which of the following?', 9);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (343, 'Hard-coded SQL statements in a program language such as Java.', 1,  89);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (344, 'The process of making an application capable of generating specific SQL code on the fly.', 0,  89);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (345, 'Hard-coded SQL statements in a procedure.', 0,  89);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (346, 'Hard-coded SQL statements in a trigger.', 0,  89);


INSERT INTO questions(id, question_text, test_id) VALUES (90, 'A UNION query is which of the following?', 9);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (347, 'Combines the output from no more than two queries and must include the same number of columns.', 0,  90);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (348, 'Combines the output from no more than two queries and does not include the same number of columns.', 0,  90);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (349, 'Combines the output from multiple queries and must include the same number of columns.', 1,  90);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (350, 'Combines the output from multiple queries and does not include the same number of columns.', 0,  90);



INSERT INTO tests(id, name, topic_id) VALUES (10, 'Computer Fundamentals', 3);
INSERT INTO questions(id, question_text, test_id) VALUES (91, 'Which of the following languages is more suited to a structured program?', 10);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (351, 'PL/1', 0,  91);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (352, 'FORTRAN', 0,  91);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (353, 'BASIC', 0,  91);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (354, 'PASCAL', 1,  91);

INSERT INTO questions(id, question_text, test_id) VALUES (92, 'A computer assisted method for the recording and analyzing of existing or hypothetical systems is', 10);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (355, 'Data transmission', 0,  92);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (356, 'Data flow', 1,  92);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (357, 'Data capture', 0,  92);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (358, 'Data processing', 0,  92);


INSERT INTO questions(id, question_text, test_id) VALUES (93, 'The brain of any computer system is', 10);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (359, 'ALU', 0,  93);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (360, 'Memory', 0,  93);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (361, 'CPU', 1,  93);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (362, 'Control unit', 0,  93);



INSERT INTO questions(id, question_text, test_id) VALUES (94, 'What difference does the 5th generation computer have from other generation computers?', 10);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (363, 'Technological advancement', 1,  94);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (364, 'Scientific code', 0,  94);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (365, 'Object Oriented Programming', 0,  94);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (366, 'All of the above', 0,  94);


INSERT INTO questions(id, question_text, test_id) VALUES (95, 'Which of the following computer language is used for artificial intelligence?', 10);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (367, 'FORTRAN', 0,  95);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (368, 'PROLOG', 1,  95);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (369, 'C', 0,  95);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (370, 'COBOL', 0,  95);



INSERT INTO questions(id, question_text, test_id) VALUES (96, 'The tracks on a disk which can be accessed without repositioning the R/W heads is', 10);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (371, 'Surface', 0,  96);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (372, 'Cylinder', 1,  96);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (373, 'Cluster', 0,  96);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (374, 'All of the above', 0,  96);


INSERT INTO questions(id, question_text, test_id) VALUES (97, 'Which of the following is the 1\'s complement of 10?', 10);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (375, '01', 1,  97);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (376, '110', 0,  97);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (377, '11', 0,  97);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (378, '10', 0,  97);


INSERT INTO questions(id, question_text, test_id) VALUES (98, 'A section of code to which control is transferred when a processor is interrupted is known as', 10);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (379, 'M', 1,  98);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (380, 'SVC', 0,  98);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (381, 'IP', 0,  98);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (382, 'MDR', 0,  98);


INSERT INTO questions(id, question_text, test_id) VALUES (99, 'Which part interprets program instructions and initiate control operations.', 10);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (383, 'Input', 0,  99);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (384, 'Storage unit', 0,  99);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (385, 'Logic unit', 0,  99);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (386, 'Control unit', 1,  99);


INSERT INTO questions(id, question_text, test_id) VALUES (100, 'The binary system uses powers of', 10);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (387, '2', 1,  100);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (388, '10', 0,  100);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (389, '8', 0,  100);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (390, '16', 0,  100);




INSERT INTO tests(id, name, topic_id) VALUES (11, 'Computer Fundamentals Part2', 3);
INSERT INTO questions(id, question_text, test_id) VALUES (101, 'A technique used by codes to convert an analog signal into a digital bit stream is known as', 11);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (391, 'Pulse code modulation', 1,  101);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (392, 'Pulse stretcher', 0,  101);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (393, 'Query processing', 0,  101);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (394, 'Queue management', 0,  101);



INSERT INTO questions(id, question_text, test_id) VALUES (102, 'An optical input device that interprets pencil marks on paper media is', 11);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (395, 'O.M.R', 1,  102);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (396, 'Punch card reader', 0,  102);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (397, 'Optical scanners', 0,  102);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (398, 'Magnetic tape', 0,  102);



INSERT INTO questions(id, question_text, test_id) VALUES (103, 'Most important advantage of an IC is its', 11);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (399, 'Easy replacement in case of circuit failure', 0,  103);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (400, 'Extremely high reliability', 1,  103);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (401, 'Reduced cost', 0,  103);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (402, 'Low power consumption', 0,  103);


INSERT INTO questions(id, question_text, test_id) VALUES (104, 'Data division is the third division of a _____ program.', 11);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (403, 'COBOL', 1,  104);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (404, 'BASIC', 0,  104);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (405, 'PASCAL', 0,  104);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (406, 'FORTH', 0,  104);

INSERT INTO questions(id, question_text, test_id) VALUES (105, 'Which language was devised by Dr. Seymour Aubrey Papert?', 11);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (407, 'APL', 0,  105);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (408, 'COBOL', 0,  105);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (409, 'LOGO', 1,  105);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (410, 'FORTRAN', 0,  105);



INSERT INTO questions(id, question_text, test_id) VALUES (106, 'A program that converts computer data into some code system other than the normal one is known as', 11);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (411, 'Encoder', 1,  106);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (412, 'Simulation', 0,  106);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (413, 'Emulator', 0,  106);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (414, 'Coding', 0,  106);



INSERT INTO questions(id, question_text, test_id) VALUES (107, 'A device designed to read information encoded into a small plastic card is', 11);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (415, 'Magnetic tape', 0,  107);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (416, 'Badge reader', 1,  107);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (417, 'Tape puncher', 0,  107);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (418, 'Card puncher', 0,  107);


INSERT INTO questions(id, question_text, test_id) VALUES (108, 'A hybrid computer uses a _____ to convert digital signals from a computer into analog signals.', 11);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (419, 'Modulator', 0,  108);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (420, 'Demodulator', 0,  108);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (421, 'Modem', 1,  108);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (422, 'Decoder', 0,  108);



INSERT INTO questions(id, question_text, test_id) VALUES (109, 'A group of magnetic tapes, videos or terminals usually under the control of one master is', 11);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (423, 'Cylinder', 0,  109);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (424, 'Cluster', 1,  109);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (425, 'Surface', 0,  109);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (426, 'Track', 0,  109);


INSERT INTO questions(id, question_text, test_id) VALUES (110, 'Any device that performs signal conversion is', 11);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (427, 'Modulator', 1,  110);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (428, 'Modem', 0,  110);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (429, 'Keyboard', 0,  110);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (430, 'Plotter', 0,  110);


INSERT INTO tests(id, name, topic_id) VALUES (12, 'Linux Part1', 3);
INSERT INTO questions(id, question_text, test_id) VALUES (111, 'What command is used to count the total number of lines, words, and characters contained in a file?', 12);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (431, 'countw', 0,  111);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (432, 'wcount', 0,  111);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (433, 'wc', 1,  111);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (434, 'count p', 0,  111);

INSERT INTO questions(id, question_text, test_id) VALUES (112, 'What command is used to remove files?', 12);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (435, 'dm', 0,  112);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (436, 'rm', 1,  112);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (437, 'delete', 0,  112);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (438, 'erase', 0,  112);

INSERT INTO questions(id, question_text, test_id) VALUES (113, 'What command is used to remove the directory?', 12);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (439, 'rdir', 0,  113);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (440, 'remove', 0,  113);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (441, 'rd', 0,  113);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (442, 'rmdir', 1,  113);

INSERT INTO questions(id, question_text, test_id) VALUES (114, 'What command is used with vi editor to delete a single character?', 12);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (443, 'x', 1,  114);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (444, 'y', 0,  114);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (445, 'a', 0,  114);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (446, 'z', 0,  114);

INSERT INTO questions(id, question_text, test_id) VALUES (115, 'What hardware architectures are not supported by Red Hat?', 12);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (447, 'SPARC', 0,  115);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (448, 'IBM-compatible', 0,  115);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (449, 'Alpha', 0,  115);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (450, 'Macintosh', 1,  115);

INSERT INTO questions(id, question_text, test_id) VALUES (116, 'The physical layer of a network', 12);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (451, 'constructs packets of data and sends them across the network', 0,  116);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (452, 'controls error detection and correction', 0,  116);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (453, 'defines the electrical characteristics of signals passed between the computer and communication devices', 1,  116);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (454, 'All of the above', 0,  116);

INSERT INTO questions(id, question_text, test_id) VALUES (117, 'What TCP/IP protocol is used for remote terminal connection service?', 12);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (455, 'UDP', 0,  117);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (456, 'RARP', 0,  117);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (457, 'FTP', 0,  117);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (458, 'TELNET', 1,  117);

INSERT INTO questions(id, question_text, test_id) VALUES (118, 'How many networks and nodes per network, are allowed by the Class B network?', 12);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (459, '127 networks and 16,777,216 nodes per network', 0,  118);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (460, '16,384 networks and 65,534 nodes per network', 1,  118);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (461, '2,097,152 networks and 254 nodes per network', 0,  118);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (462, 'All of the above', 0,  118);

INSERT INTO questions(id, question_text, test_id) VALUES (119, 'What service is used to translate domain names to IP addresses?', 12);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (463, 'NFS', 0,  119);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (464, 'SMB', 0,  119);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (465, 'NIS', 0,  119);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (466, 'DNS', 1,  119);

INSERT INTO questions(id, question_text, test_id) VALUES (120, 'Which of the following command is used to create a Linux installation boot floppy?', 12);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (467, 'mkboot disk', 0,  120);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (468, 'bootfp disk', 0,  120);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (469, 'ww and rawwrite', 0,  120);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (470, 'dd and rawrite', 1,  120);

INSERT INTO tests(id, name, topic_id) VALUES (13, 'Linux Part2', 3);
INSERT INTO questions(id, question_text, test_id) VALUES (121, 'What command is used to save the standard output in a file, as well as display it on the terminal?', 13);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (471, 'tee', 1,  121);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (472, 'grep', 0,  121);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (473, 'cat', 0,  121);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (474, 'more', 0,  121);


INSERT INTO questions(id, question_text, test_id) VALUES (122, 'What command is used to count just the number of lines contained in a file?', 13);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (475, 'wc - r', 0,  122);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (476, 'wc - w', 0,  122);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (477, 'wc - c', 0,  122);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (478, 'wc - l', 1,  122);

INSERT INTO questions(id, question_text, test_id) VALUES (123, 'In OSI network architecture, the routing is performed by', 13);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (479, 'session layer', 0,  123);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (480, 'transport layer', 0,  123);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (481, 'data link layer', 0,  123);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (482, 'network layer', 1,  123);

INSERT INTO questions(id, question_text, test_id) VALUES (124, 'The 32-bit internet address 10000000 00001010 00000010 00011110 will be written in dotted decimal notation as', 13);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (483, '128.10.2.30', 1,  124);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (484, '210.20.2.64', 0,  124);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (485, '164.100.9.61', 0,  124);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (486, '148.20.2.30', 0,  124);

INSERT INTO questions(id, question_text, test_id) VALUES (125, 'Which class network is used for a collection of a small number of networks with a large number of nodes?', 13);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (487, 'Class A', 1,  125);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (488, 'Class B', 0,  125);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (489, 'Class C', 0,  125);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (490, 'All of the above', 0,  125);

INSERT INTO questions(id, question_text, test_id) VALUES (126, 'What type of addressing format is used by Class A network.', 13);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (491, 'Net.Net.Net.Node', 0,  126);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (492, 'Net.Net.Node.Node', 0,  126);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (493, 'Net.Node.Net.Node', 0,  126);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (494, 'Net.Node.Node.Node', 1,  126);

INSERT INTO questions(id, question_text, test_id) VALUES (127, 'What types of installations require a special boot disk?', 13);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (495, 'NFS', 0,  127);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (496, 'FTP', 0,  127);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (497, 'PCMCIA', 0,  127);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (498, 'All of the above', 1,  127);

INSERT INTO questions(id, question_text, test_id) VALUES (128, 'RPM', 13);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (499, 'stands for Red Hat Package Manager', 1,  128);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (500, 'is used to install, uninstall, and manage packages', 0,  128);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (501, 'is used to keep track of the users', 0,  128);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (502, 'assigns a dynamic IP address', 0,  128);

INSERT INTO questions(id, question_text, test_id) VALUES (129, 'What command is used to query for a specific package with RPM?', 13);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (503, 'rpm -q', 1,  129);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (504, 'rpm -a', 0,  129);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (505, 'rpm -d', 0,  129);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (506, 'rpm -1', 0,  129);

INSERT INTO questions(id, question_text, test_id) VALUES (130, 'What script is run for setting bash global defaults for all users?', 13);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (507, '/etc/.profile', 0,  130);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (508, '/etc/.bashrc', 0,  130);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (509, '/etc/.log', 0,  130);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (510, '/etc/profile', 1,  130);

INSERT INTO tests(id, name, topic_id) VALUES (14, 'Networking Basics', 4);
INSERT INTO questions(id, question_text, test_id) VALUES (131, 'How long is an IPv6 address?', 14);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (511, '32 bits', 0,  131);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (512, '128 bytes', 0,  131);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (513, '64 bits', 0,  131);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (514, '128 bits', 1,  131);

INSERT INTO questions(id, question_text, test_id) VALUES (132, 'What flavor of Network Address Translation can be used to have one IP address allow many users to connect to the global Internet?', 14);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (515, 'NAT', 0,  132);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (516, 'Static', 0,  132);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (517, 'Dynamic', 0,  132);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (518, 'PAT', 1,  132);

INSERT INTO questions(id, question_text, test_id) VALUES (133, 'What are the two main types of access control lists (ACLs)?
    1. Standard
    2. IEEE
    3. Extended
    4. Specialized', 14);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (519, '1 and 3', 1,  133);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (520, '2 and 4', 0,  133);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (521, '3 and 4', 0,  133);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (522, '1 and 2', 0,  133);

INSERT INTO questions(id, question_text, test_id) VALUES (134, 'What command is used to create a backup configuration?', 14);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (523, 'copy running backup', 0,  134);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (524, 'copy running-config startup-config', 1,  134);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (525, 'config mem', 0,  134);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (526, 'wr mem', 0,  134);

INSERT INTO questions(id, question_text, test_id) VALUES (135, 'You have 10 users plugged into a hub running 10Mbps half-duplex. There is a server connected to the switch running 10Mbps half-duplex as well. How much bandwidth does each host have to the server?', 14);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (527, '100 kbps', 0,  135);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (528, '1 Mbps', 0,  135);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (529, '2 Mbps', 0,  135);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (530, '10 Mbps', 1,  135);

INSERT INTO questions(id, question_text, test_id) VALUES (136, 'Which WLAN IEEE specification allows up to 54Mbps at 2.4GHz?', 14);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (531, 'A', 0,  136);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (532, 'B', 0,  136);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (533, 'G', 1,  136);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (534, 'N', 0,  136);

INSERT INTO questions(id, question_text, test_id) VALUES (137, 'Which of the following is the valid host range for the subnet on which the IP address 192.168.168.188 255.255.255.192 resides?', 14);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (535, '192.168.168.129-190', 1,  137);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (536, '192.168.168.129-191', 0,  137);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (537, '192.168.168.128-190', 0,  137);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (538, '192.168.168.128-192', 0,  137);

INSERT INTO questions(id, question_text, test_id) VALUES (138, 'To back up an IOS, what command will you use?', 14);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (539, 'backup IOS disk', 0,  138);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (540, 'copy ios tftp', 0,  138);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (541, 'copy tftp flash', 0,  138);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (542, 'copy flash tftp', 1,  138);

INSERT INTO questions(id, question_text, test_id) VALUES (139, 'What protocol does PPP use to identify the Network layer protocol?', 14);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (543, 'NCP', 1,  139);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (544, 'ISDN', 0,  139);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (545, 'HDLC', 0,  139);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (546, 'LCP', 0,  139);

INSERT INTO questions(id, question_text, test_id) VALUES (140, 'Which of the following commands will allow you to set your Telnet password on a Cisco router?', 14);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (547, 'line telnet 0 4', 0,  140);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (548, 'line aux 0 4', 0,  140);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (549, 'line vty 0 4', 1,  140);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (550, 'line con 0', 0,  140);

INSERT INTO tests(id, name, topic_id) VALUES (15, 'Networking Part2', 4);
INSERT INTO questions(id, question_text, test_id) VALUES (141, 'Modem is used in data transmission. When was it invented and in which country?', 15);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (551, '1963, USA', 0,  141);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (552, '1965, Germany', 0,  141);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (553, '1950, USA', 1,  141);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (554, '1950, Japan', 0,  141);

INSERT INTO questions(id, question_text, test_id) VALUES (142, 'Which of the following technique is used for Time-To-Line (TTL)?', 15);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (555, 'a technique used in best-effort delivery system to avoid endlessly looping packets.', 1,  142);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (556, 'a technique used by protocols in which a lower level protocol accepts a message from a higher level protocol and places it in the data portion of the low level frame', 0,  142);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (557, 'One of the pieces that results when an IP gateway divides an IP datagram into smaller pieces for transmission across a network that cannot handle the original datagram size.', 0,  142);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (558, 'All of the above', 0,  142);

INSERT INTO questions(id, question_text, test_id) VALUES (143, 'Communication network is', 15);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (559, 'one or more conductors that serve as a common connection for a related group of devices', 0,  143);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (560, 'a continuous frequency capable of being modulated or impressed with a second signal', 0,  143);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (561, 'the condition with two or more stations attempt to use the same channel at the same time', 0,  143);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (562, 'a collection of interconnected functional units that provides a data communications service among stations attached to the network', 1,  143);

INSERT INTO questions(id, question_text, test_id) VALUES (144, 'Which of the following is an advantage to using fiber optics data transmission?', 15);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (563, 'resistance to data theft', 0,  144);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (564, 'fast data transmission rate', 0,  144);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (565, 'low noise level', 0,  144);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (566, 'All of the above', 1,  144);

INSERT INTO questions(id, question_text, test_id) VALUES (145, 'Which of the following statement is incorrect?', 15);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (567, 'if a host moves from one network to another, its IP address must change', 0,  145);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (568, 'routing uses the network portion of the IP address, the path taken by packets travelling to a host with multiple IP addresses depends on the address used.', 0,  145);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (569, 'IP addresses encode both a network and a host on that network, they do not specify an individual machine, but a connection to a network.', 0,  145);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (570, 'All of the above', 1,  145);

INSERT INTO questions(id, question_text, test_id) VALUES (146, 'Bandlimited signal is', 15);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (571, 'transmission of signals without modulation', 0,  146);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (572, 'a signal all of whose energy is contained within a finite frequency range', 1,  146);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (573, 'simultaneous transmission of data to a number of stations', 0,  146);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (574, 'All of the above', 0,  146);

INSERT INTO questions(id, question_text, test_id) VALUES (147, 'Computers in a LAN can be interconnected by radio and infrared technologies.', 15);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (575, 'Wireless LANs', 1,  147);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (576, 'Network Topologies', 0,  147);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (577, 'Multiplexer', 0,  147);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (578, 'Modem', 0,  147);

INSERT INTO questions(id, question_text, test_id) VALUES (148, 'You have a network ID of 134.57.0.0 and you need to divide it into multiple subnets in which at least 600 host IDs for each subnet are available. You desire to have the largest amount of subnets available. Which subnet mask should you assign?', 15);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (579, '255.255.224.0', 0,  148);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (580, '255.255.240.0', 0,  148);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (581, '255.255.248.0', 0,  148);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (582, '255.255.255.0', 1,  148);

INSERT INTO questions(id, question_text, test_id) VALUES (149, 'How many digits of the Network User Address are known as the DNIC (Data Network Identification Code)?', 15);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (583, 'first three', 0,  149);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (584, 'first four', 1,  149);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (585, 'first five', 0,  149);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (586, 'first seven', 0,  149);

INSERT INTO questions(id, question_text, test_id) VALUES (150, 'Which of the following is the address of the router?', 15);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (587, 'The IP address', 0,  150);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (588, 'The TCP address', 0,  150);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (589, 'The subnet mask', 0,  150);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (590, 'The default gateway', 1,  150);

INSERT INTO tests(id, name, topic_id) VALUES (16, 'OOPS Concepts', 5);
INSERT INTO questions(id, question_text, test_id) VALUES (151, 'Which of the following type of class allows only one object of it to be created?', 16);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (591, 'Virtual class', 0,  151);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (592, 'Abstract class', 0,  151);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (593, 'Singleton class', 1,  151);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (594, 'Friend class', 0,  151);

INSERT INTO questions(id, question_text, test_id) VALUES (152, 'Which of the following is not a type of constructor?', 16);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (595, 'Copy constructor', 0,  152);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (596, 'Friend constructor', 1,  152);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (597, 'Default constructor', 0,  152);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (598, 'Parameterized constructor', 0,  152);

INSERT INTO questions(id, question_text, test_id) VALUES (153, 'Which of the following statements is correct?', 16);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (599, 'Base class pointer cannot point to derived class.', 0,  153);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (600, 'Derived class pointer cannot point to base class.', 1,  153);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (601, 'Pointer to derived class cannot be created.', 0,  153);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (602, 'Pointer to base class cannot be created.', 0,  153);

INSERT INTO questions(id, question_text, test_id) VALUES (154, 'Which of the following is not the member of class?', 16);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (603, 'Static function', 0,  154);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (604, 'Friend function', 1,  154);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (605, 'Const function', 0,  154);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (606, 'Virtual function', 0,  154);

INSERT INTO questions(id, question_text, test_id) VALUES (155, 'Which of the following concepts means determining at runtime what method to invoke?', 16);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (607, 'Data hiding', 0,  155);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (608, 'Dynamic Typing', 0,  155);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (609, 'Dynamic binding', 1,  155);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (610, 'Dynamic loading', 0,  155);

INSERT INTO questions(id, question_text, test_id) VALUES (156, 'Which of the following term is used for a function defined inside a class?', 16);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (611, 'Member Variable', 0,  156);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (612, 'Member function', 1,  156);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (613, 'Class function', 0,  156);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (614, 'Classic function', 0,  156);

INSERT INTO questions(id, question_text, test_id) VALUES (157, 'Which of the following concept of oops allows compiler to insert arguments in a function call if it is not specified?', 16);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (615, 'Call by value', 0,  157);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (616, 'Call by reference', 0,  157);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (617, 'Default arguments', 1,  157);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (618, 'Call by pointer', 0,  157);

INSERT INTO questions(id, question_text, test_id) VALUES (158, 'How many instances of an abstract class can be created?', 16);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (619, '1', 0,  158);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (620, '5', 0,  158);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (621, '13', 0,  158);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (622, '0', 1,  158);

INSERT INTO questions(id, question_text, test_id) VALUES (159, 'Which of the following cannot be friend?', 16);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (623, 'Function', 0,  159);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (624, 'Class', 0,  159);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (625, 'Object', 1,  159);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (626, 'Operator function', 0,  159);

INSERT INTO questions(id, question_text, test_id) VALUES (160, 'Which of the following concepts of OOPS means exposing only necessary information to client?', 16);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (627, 'Encapsulation', 0,  160);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (628, 'Abstraction', 0,  160);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (629, 'Data hiding', 1,  160);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (630, 'Data binding', 0,  160);



INSERT INTO tests(id, name, topic_id) VALUES (17, 'OOPS Concepts Part2', 5);
INSERT INTO questions(id, question_text, test_id) VALUES (161, 'Why reference is not same as a pointer?', 17);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (631, 'A reference can never be null.', 0,  161);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (632, 'A reference once established cannot be changed.', 0,  161);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (633, 'Reference doesn\'t need an explicit dereferencing mechanism.', 0,  161);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (634, 'All of the above.', 1,  161);

INSERT INTO questions(id, question_text, test_id) VALUES (162, 'cout is a/an __________ .', 17);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (635, 'operator', 0,  162);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (636, 'function', 0,  162);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (637, 'object', 1,  162);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (638, 'macro', 0,  162);

INSERT INTO questions(id, question_text, test_id) VALUES (163, 'Which of the following concepts provides facility of using object of one class inside another class?', 17);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (639, 'Encapsulation', 0,  163);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (640, 'Abstraction', 0,  163);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (641, 'Composition', 1,  163);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (642, 'Inheritance', 0,  163);

INSERT INTO questions(id, question_text, test_id) VALUES (164, 'How many types of polymorphisms are supported by C++?', 17);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (643, '1', 0,  164);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (644, '2', 1,  164);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (645, '3', 0,  164);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (646, '4', 0,  164);

INSERT INTO questions(id, question_text, test_id) VALUES (165, 'Which of the following is an abstract data type?', 17);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (647, 'int', 0,  165);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (648, 'double', 0,  165);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (649, 'string', 0,  165);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (650, 'Class', 1,  165);

INSERT INTO questions(id, question_text, test_id) VALUES (166, 'Which of the following concepts means adding new components to a program as it runs?', 17);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (651, 'Data hiding', 0,  166);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (652, 'Dynamic typing', 0,  166);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (653, 'Dynamic binding', 0,  166);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (654, 'Dynamic loading', 1,  166);

INSERT INTO questions(id, question_text, test_id) VALUES (167, 'Which of the following statement is correct?', 17);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (655, 'A constructor is called at the time of declaration of an object.', 1,  167);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (656, 'A constructor is called at the time of use of an object.', 0,  167);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (657, 'A constructor is called at the time of declaration of a class.', 0,  167);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (658, 'A constructor is called at the time of use of a class.', 0,  167);

INSERT INTO questions(id, question_text, test_id) VALUES (168, 'Which of the following correctly describes overloading of functions?', 17);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (659, 'Virtual polymorphism', 0,  168);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (660, 'Transient polymorphism', 0,  168);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (661, 'Ad-hoc polymorphism', 1,  168);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (662, 'Pseudo polymorphism', 0,  168);

INSERT INTO questions(id, question_text, test_id) VALUES (169, 'Which of the following approach is adapted by C++?', 17);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (663, 'Top-down', 0,  169);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (664, 'Bottom-up', 1,  169);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (665, 'Right-left', 0,  169);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (666, 'Left-right', 0,  169);

INSERT INTO questions(id, question_text, test_id) VALUES (170, 'Which of the following is correct about function overloading?', 17);

INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (667, 'The types of arguments are different.', 0,  170);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (668, 'The order of argument is different.', 0,  170);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (679, 'The number of argument is same.', 0,  170);
INSERT INTO answers(id, answer_text, is_correct, question_id) VALUES (670, 'Both A and B.', 1,  170);



INSERT INTO results(id, score, test_id, user_id) VALUES (1, 10, 1, 2);
INSERT INTO results(id, score, test_id, user_id) VALUES (2, 9, 1, 4);
INSERT INTO results(id, score, test_id, user_id) VALUES (3, 6, 1, 5);
INSERT INTO results(id, score, test_id, user_id) VALUES (4, 2, 1, 6);
INSERT INTO results(id, score, test_id, user_id) VALUES (5, 8, 1, 7);
INSERT INTO results(id, score, test_id, user_id) VALUES (6, 4, 1, 8);
INSERT INTO results(id, score, test_id, user_id) VALUES (7, 6, 1, 9);
INSERT INTO results(id, score, test_id, user_id) VALUES (8, 10, 1, 10);
INSERT INTO results(id, score, test_id, user_id) VALUES (9, 8, 1, 11);
INSERT INTO results(id, score, test_id, user_id) VALUES (10, 5, 1, 12);
INSERT INTO results(id, score, test_id, user_id) VALUES (12, 8, 1, 13);
INSERT INTO results(id, score, test_id, user_id) VALUES (13, 9, 1, 14);
INSERT INTO results(id, score, test_id, user_id) VALUES (14, 10, 1, 15);
INSERT INTO results(id, score, test_id, user_id) VALUES (15, 10, 1, 16);

