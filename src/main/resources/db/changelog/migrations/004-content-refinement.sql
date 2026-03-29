-- liquibase formatted sql

-- changeset thinh:5
-- Refine page_contents table to support structure
ALTER TABLE page_contents ADD COLUMN section_type VARCHAR(50) DEFAULT 'EXPERIENCE';
ALTER TABLE page_contents ADD COLUMN sort_order INT DEFAULT 0;
ALTER TABLE page_contents ALTER COLUMN title DROP NOT NULL;
ALTER TABLE page_contents RENAME COLUMN description TO content;

-- Refine menus table
ALTER TABLE menus ADD COLUMN sort_order INT DEFAULT 0;
ALTER TABLE menus RENAME COLUMN title TO name;

-- Seed detailed data for Page 1 (Cooking Class)
DELETE FROM page_contents WHERE page_id = 1;
DELETE FROM menus WHERE page_id = 1;

-- Experience Section for Cooking Class
INSERT INTO page_contents (page_id, section_type, content, sort_order) VALUES 
(1, 'EXPERIENCE', 'After being picked up at the meeting point, you’ll travel to a calm rural location outside the city. Here, you can slow down, enjoy the green rice field views, and experience a simpler, more authentic side of local life.', 1),
(1, 'EXPERIENCE', 'During the class, you will learn how to cook traditional local dishes using fresh ingredients and easy techniques.', 2),
(1, 'EXPERIENCE', 'You will take part in the cooking yourself and then enjoy the meal you’ve prepared in a peaceful countryside setting.', 3),
(1, 'EXPERIENCE', '🌱 Vegetarian option is available — just let us know in advance.', 4);

-- Highlights Section for Cooking Class
INSERT INTO page_contents (page_id, section_type, content, sort_order) VALUES 
(1, 'HIGHLIGHTS', 'Around 3 hours, relaxed and not rushed', 1),
(1, 'HIGHLIGHTS', 'Located in a quiet countryside area, far from tourist crowds', 2),
(1, 'HIGHLIGHTS', 'Beautiful rice field views and a calm atmosphere', 3),
(1, 'HIGHLIGHTS', 'Small group with personal guidance by local hosts', 4),
(1, 'HIGHLIGHTS', 'Simple, everyday dishes that reflect local life in Hoi An', 5);

-- Menus for Cooking Class
INSERT INTO menus (page_id, name, description, sort_order) VALUES 
(1, 'Banh Xeo (Vietnamese crispy pancake)', NULL, 1),
(1, 'Banana flower salad', NULL, 2),
(1, 'Caramelized fish', NULL, 3),
(1, 'Cao Lau, Hoi An’s famous noodle dish', NULL, 4);
