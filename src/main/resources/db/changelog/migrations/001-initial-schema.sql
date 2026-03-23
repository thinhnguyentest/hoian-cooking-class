-- liquibase formatted sql

-- changeset thinh:1
CREATE TABLE page_types (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(50) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE pages (
    id SERIAL PRIMARY KEY,
    page_type_id INTEGER REFERENCES page_types(id),
    title VARCHAR(255) NOT NULL,
    description TEXT,
    slug VARCHAR(255) NOT NULL UNIQUE
);

-- changeset thinh:2
INSERT INTO page_types (name, code, description) VALUES 
('Cooking Class', 'COOKING_CLASS', 'Cooking class page type'),
('Food Tour', 'FOOD_TOUR', 'Food tour page type'),
('Making Lantern', 'MAKING_LANTERN', 'Making lantern page type'),
('Making Coffee', 'MAKING_COFFEE', 'Making coffee page type');

INSERT INTO pages (page_type_id, title, description, slug) VALUES 
(1, 'Hoi An Cooking Class', 'Learn to cook traditional food', '/'),
(2, 'Hoi An Food Tour', 'Explore street food in Hoi An', '/food-tour'),
(3, 'Making Lantern', 'Create your own lantern', '/making-lantern'),
(4, 'Making Coffee', 'Learn to make Vietnamese coffee', '/making-coffee-class');
