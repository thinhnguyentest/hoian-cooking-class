-- liquibase formatted sql

-- changeset thinh:6
-- Refine content for Page 2 (Food Tour)
DELETE FROM page_contents WHERE page_id = 2;
INSERT INTO page_contents (page_id, section_type, content, sort_order) VALUES 
(2, 'EXPERIENCE', 'Journey through hidden alleyways and savor the unique flavors that define our ancient town’s culinary heritage.', 1),
(2, 'EXPERIENCE', 'Hoi An is more than just an ancient town with its charming yellow heritage houses – it''s a vibrant crossroads where Vietnamese, Chinese, and Japanese culinary traditions have merged over centuries.', 2),
(2, 'EXPERIENCE', 'Our local guides will lead you to the best street food stalls, sharing the stories behind each dish.', 3);

-- Refine content for Page 3 (Lantern Making)
DELETE FROM page_contents WHERE page_id = 3;
INSERT INTO page_contents (page_id, section_type, content, sort_order) VALUES 
(3, 'EXPERIENCE', 'Create your own beautiful Hoi An silk lantern in our traditional craft workshop. Learn from local artisans and take home a piece of Vietnamese heritage.', 1),
(3, 'EXPERIENCE', 'In this engaging workshop, we invite you to immerse yourself in the art of lantern making. Under the guidance of skilled craftsmen, you will learn how to bend bamboo, apply vibrant silk, and complete your very own traditional lantern.', 2);

-- Refine content for Page 4 (Coffee Class)
DELETE FROM page_contents WHERE page_id = 4;
INSERT INTO page_contents (page_id, section_type, content, sort_order) VALUES 
(4, 'EXPERIENCE', 'Learn to make authentic Vietnamese egg coffee, coconut coffee, and salt coffee in our hands-on workshop in Hoi An. Discover the secrets of the Phin filter.', 1),
(4, 'EXPERIENCE', 'Vietnam boasts one of the most unique coffee cultures in the world. From the robust beans grown in the Central Highlands to the creative ways we mix ingredients, coffee here is an art form.', 2);

-- Ensure all images are correctly mapped (already seeded in 003 but ensuring consistency)
-- No changes needed if 003 is already run.
