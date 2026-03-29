-- liquibase formatted sql

-- changeset thinh:8
-- Bổ sung Media Gallery cho trang Food Tour (ID=2)
INSERT INTO images (page_id, url, source_type, alt_text) VALUES 
(2, '/images/webp/food-tour-hoi-an-1.webp', 'MEDIA', 'Authentic Hoi An Banh My baguette'),
(2, '/images/webp/food-tour-hoi-an-2.webp', 'MEDIA', 'Cao Lau noodles exclusive to Hoi An ancient town'),
(2, '/images/webp/food-tour-hoi-an-3.webp', 'MEDIA', 'Crispy Banh Xeo pancakes with fresh herbs'),
(2, '/images/webp/food-tour-hoi-an-4.webp', 'MEDIA', 'Grilled Nem spring rolls on charcoal'),
(2, '/images/webp/food-tour-hoi-an-5.webp', 'MEDIA', 'Local market vibrant colors and fresh produce'),
(2, '/images/webp/food-tour-hoi-an-6.webp', 'MEDIA', 'Food tour group enjoying local specialties'),
(2, '/images/webp/food-tour-hoi-an-7.webp', 'MEDIA', 'Delicious Mango cake traditional dessert'),
(2, '/images/webp/food-tour-hoi-an-8.webp', 'MEDIA', 'Street food stall in Hoi An ancient town at night'),
(2, '/images/webp/food-tour-hoi-an-10.webp', 'MEDIA', 'Traditional herbal tea served in a local house'),
(2, '/images/webp/food-tour-hoi-an-11.webp', 'MEDIA', 'Hidden alleyway in Hoi An filled with food gems');

-- Bổ sung Media Gallery cho trang Making Power (ID=3)
INSERT INTO images (page_id, url, source_type, alt_text) VALUES 
(3, '/images/webp/stock-lantern-1.webp', 'MEDIA', 'Colorful variety of Hoi An silk lanterns'),
(3, '/images/webp/stock-lantern-2.webp', 'MEDIA', 'Bamboo frames for traditional lantern making'),
(3, '/images/webp/stock-lantern-3.webp', 'MEDIA', 'Artisan applying glue to lantern bamboo frame'),
(3, '/images/webp/stock-lantern-4.webp', 'MEDIA', 'Stretching vibrant yellow silk over lantern frame'),
(3, '/images/webp/stock-lantern-5.webp', 'MEDIA', 'Finished handmade lanterns glowing at night'),
(3, '/images/webp/stock-lantern-6.webp', 'MEDIA', 'Workshop participants crafting their lanterns'),
(3, '/images/webp/stock-lantern-7.webp', 'MEDIA', 'Tassels and decorative elements for lanterns'),
(3, '/images/webp/stock-lantern-8.webp', 'MEDIA', 'Intricate details of a completed Hoi An lantern');

-- Bổ sung Media Gallery cho trang Making Coffee (ID=4)
INSERT INTO images (page_id, url, source_type, alt_text) VALUES 
(4, '/images/webp/stock-coffee-1.webp', 'MEDIA', 'Authentic Vietnamese Phin filter brewing coffee'),
(4, '/images/webp/stock-coffee-2.webp', 'MEDIA', 'Fluffy whipped egg yolks for traditional Hanoi egg coffee'),
(4, '/images/webp/stock-coffee-3.webp', 'MEDIA', 'Freshly prepared coconut coffee with condensed milk'),
(4, '/images/webp/stock-coffee-4.webp', 'MEDIA', 'Savory salt coffee specialty from Central Vietnam'),
(4, '/images/webp/stock-coffee-5.webp', 'MEDIA', 'Coffee beans from the Central Highlands of Vietnam'),
(4, '/images/webp/stock-coffee-6.webp', 'MEDIA', 'Coffee workshop participants learning brewing techniques'),
(4, '/images/webp/stock-coffee-7.webp', 'MEDIA', 'Traditional coffee set in a Hoi An cafe'),
(4, '/images/webp/stock-coffee-8.webp', 'MEDIA', 'Close-up of coffee dripping through a stainless steel Phin');
