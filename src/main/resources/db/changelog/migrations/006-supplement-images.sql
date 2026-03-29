-- liquibase formatted sql

-- changeset thinh:7
-- Bổ sung đầy đủ 6 ảnh Carousel cho trang chủ (ID=1)
INSERT INTO images (page_id, url, source_type, alt_text) VALUES 
(1, '/images/webp/cooking-class-hero.webp', 'CAROUSEL', 'Professional cooking class workshop setting'),
(1, '/images/webp/banana-flower-salad.webp', 'CAROUSEL', 'Fresh banana flower salad ready for tasting');

-- Bổ sung thêm ảnh để đạt 5 ảnh Content cho trang chủ (ID=1)
INSERT INTO images (page_id, url, source_type, alt_text) VALUES 
(1, '/images/webp/shrimp-salad.webp', 'CONTENT', 'Close-up of fresh shrimp salad ingredients'),
(1, '/images/webp/fresh-ingredients.webp', 'CONTENT', 'Locally sourced spices and herbs from the market'),
(1, '/images/webp/cooking-class-group.webp', 'CONTENT', 'Small group cooking experience in countryside house');

-- Bổ sung nốt ảnh cho trang Food Tour (ID=2)
-- Hiện tại 003 đã có 3 ảnh carousel (6, 4, 8) -> cần thêm 3 ảnh nữa để đủ 6
INSERT INTO images (page_id, url, source_type, alt_text) VALUES 
(2, '/images/webp/food-tour-hoi-an-13.webp', 'CAROUSEL', 'Hoi An ancient town food tour experience'),
(2, '/images/webp/food-tour-hoi-an-10.webp', 'CAROUSEL', 'Traditional herbal tea in local Hoi An courtyard'),
(2, '/images/webp/food-tour-hoi-an-11.webp', 'CAROUSEL', 'Exploring hidden food gems in Hoi An alleys');

-- Bổ sung để đạt 5 ảnh Content cho trang Food Tour (ID=2)
-- Hiện tại 003 đã có 1 ảnh content (1.webp)
INSERT INTO images (page_id, url, source_type, alt_text) VALUES 
(2, '/images/webp/food-tour-hoi-an-2.webp', 'CONTENT', 'Cao Lau noodles specialty of Hoi An'),
(2, '/images/webp/food-tour-hoi-an-3.webp', 'CONTENT', 'Crispy Banh Xeo pancakes being prepared'),
(2, '/images/webp/food-tour-hoi-an-5.webp', 'CONTENT', 'Local market scene during morning food tour'),
(2, '/images/webp/food-tour-hoi-an-7.webp', 'CONTENT', 'Traditional Mango cake dessert');

-- Đồng bộ ảnh cho trang Making Lantern (ID=3)
DELETE FROM images WHERE page_id = 3;
INSERT INTO images (page_id, url, source_type, alt_text) VALUES 
(3, '/images/webp/lantern-class-hero.webp', 'HERO', 'Traditional Hoi An lantern making workshop hero'),
(3, '/images/webp/lantern-class-main.webp', 'CAROUSEL', 'Main view of lantern making class'),
(3, '/images/webp/stock-lantern-1.webp', 'CAROUSEL', 'Vibrant silk lanterns variety'),
(3, '/images/webp/stock-lantern-2.webp', 'CAROUSEL', 'Handmade bamboo frames for lanterns'),
(3, '/images/webp/stock-lantern-3.webp', 'CAROUSEL', 'Artisan applying glue to lantern frame'),
(3, '/images/webp/stock-lantern-4.webp', 'CAROUSEL', 'Student stretching silk over lantern'),
(3, '/images/webp/stock-lantern-5.webp', 'CAROUSEL', 'Finished handmade lanterns glowing at night'),
(3, '/images/webp/stock-lantern-8.webp', 'CONTENT', 'Close-up of lantern craftsmanship'),
(3, '/images/webp/stock-lantern-1.webp', 'CONTENT', 'Workshop atmosphere with colorful lanterns'),
(3, '/images/webp/stock-lantern-2.webp', 'CONTENT', 'Preparation of bamboo frames'),
(3, '/images/webp/stock-lantern-3.webp', 'CONTENT', 'Detail of applying silk to frame'),
(3, '/images/webp/stock-lantern-4.webp', 'CONTENT', 'Finishing touches on a silk lantern');

-- Đồng bộ ảnh cho trang Making Coffee (ID=4)
DELETE FROM images WHERE page_id = 4;
INSERT INTO images (page_id, url, source_type, alt_text) VALUES 
(4, '/images/webp/coffee-class-hero.webp', 'HERO', 'Vietnamese coffee workshop hero image'),
(4, '/images/webp/coffee-class-main.webp', 'CAROUSEL', 'Traditional coffee brewing process'),
(4, '/images/webp/stock-coffee-1.webp', 'CAROUSEL', 'Freshly brewed Phin coffee'),
(4, '/images/webp/stock-coffee-2.webp', 'CAROUSEL', 'Whisking egg yolks for coffee'),
(4, '/images/webp/stock-coffee-3.webp', 'CAROUSEL', 'Coconut milk coffee preparation'),
(4, '/images/webp/stock-coffee-4.webp', 'CAROUSEL', 'Salt coffee specialty'),
(4, '/images/webp/stock-coffee-5.webp', 'CAROUSEL', 'Roasted coffee beans close-up'),
(4, '/images/webp/stock-coffee-9.webp', 'CONTENT', 'Step-by-step coffee making guide'),
(4, '/images/webp/stock-coffee-1.webp', 'CONTENT', 'Traditional coffee filter and cup'),
(4, '/images/webp/stock-coffee-2.webp', 'CONTENT', 'Creamy egg coffee topping'),
(4, '/images/webp/stock-coffee-3.webp', 'CONTENT', 'Refreshing iced coconut coffee'),
(4, '/images/webp/stock-coffee-4.webp', 'CONTENT', 'Central Vietnam salt coffee experience');
