-- liquibase formatted sql

-- changeset thinh:16
-- Description: Seed 5 CONTENT images for Private Dinner (page 3) and Making Coffee (page 4)

-- Delete existing content images for page 3 and 4 to avoid duplicates
DELETE FROM images WHERE page_id = 3 AND source_type = 'CONTENT';
DELETE FROM images WHERE page_id = 4 AND source_type = 'CONTENT';

-- Seed CONTENT images for Private Dinner (Page 3)
INSERT INTO images (page_id, url, source_type, alt_text) VALUES 
(3, '/images/webp/stock-lantern-1.webp', 'CONTENT', 'Vibrant silk lanterns variety'),
(3, '/images/webp/stock-lantern-2.webp', 'CONTENT', 'Handmade bamboo frames for lanterns'),
(3, '/images/webp/stock-lantern-3.webp', 'CONTENT', 'Artisan applying glue to lantern frame'),
(3, '/images/webp/stock-lantern-4.webp', 'CONTENT', 'Student stretching silk over lantern'),
(3, '/images/webp/stock-lantern-8.webp', 'CONTENT', 'Close-up of lantern craftsmanship');

-- Seed CONTENT images for Making Coffee (Page 4)
INSERT INTO images (page_id, url, source_type, alt_text) VALUES 
(4, '/images/webp/stock-coffee-1.webp', 'CONTENT', 'Traditional dark roast robusta Phin brewing'),
(4, '/images/webp/stock-coffee-2.webp', 'CONTENT', 'Whipped egg yolk mixture for traditional coffee'),
(4, '/images/webp/stock-coffee-3.webp', 'CONTENT', 'Creamy iced coconut coffee specialty'),
(4, '/images/webp/stock-coffee-4.webp', 'CONTENT', 'Gourmet salt coffee specialty'),
(4, '/images/webp/stock-coffee-9.webp', 'CONTENT', 'Brewing Phin coffee step-by-step guidance');
