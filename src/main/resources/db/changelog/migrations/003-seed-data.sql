-- liquibase formatted sql

-- changeset thinh:4
-- Seed data for page_contents
INSERT INTO page_contents (page_id, title, description, effective_date) VALUES 
(1, 'Introduction', 'Take a break from the busy streets of Hoi An and enjoy a peaceful 3-hour cooking class in a quiet countryside area, surrounded by rice fields and fresh air. This experience is hosted by Lily and her sister, who will guide you step by step in a warm, relaxed, and personal way.', CURRENT_DATE),
(1, 'Highlights', '• Around 3 hours, relaxed and not rushed\n• Located in a quiet countryside area, far from tourist crowds\n• Beautiful rice field views and a calm atmosphere\n• Small group with personal guidance by local hosts\n• Simple, everyday dishes that reflect local life in Hoi An', CURRENT_DATE),
(2, 'Introduction', 'Journey through hidden alleyways and savor the unique flavors that define our ancient town’s culinary heritage.', CURRENT_DATE),
(2, 'Full Description', 'Hoi An is more than just an ancient town with its charming yellow heritage houses – it''s a vibrant crossroads where Vietnamese, Chinese, and Japanese culinary traditions have merged over centuries, creating distinctive flavors found nowhere else in the world.', CURRENT_DATE),
(3, 'Introduction', 'Create your own beautiful Hoi An silk lantern in our traditional craft workshop. Learn from local artisans and take home a piece of Vietnamese heritage.', CURRENT_DATE),
(3, 'Experience', 'In this engaging workshop, we invite you to immerse yourself in the art of lantern making. Under the guidance of skilled craftsmen, you will learn how to bend bamboo, apply vibrant silk, and complete your very own traditional lantern.', CURRENT_DATE),
(4, 'Introduction', 'Learn to make authentic Vietnamese egg coffee, coconut coffee, and salt coffee in our hands-on workshop in Hoi An. Discover the secrets of the Phin filter.', CURRENT_DATE),
(4, 'The Art of Coffee', 'Vietnam boasts one of the most unique coffee cultures in the world. From the robust beans grown in the Central Highlands to the creative ways we mix ingredients, coffee here is an art form.', CURRENT_DATE);

-- Seed data for menus
INSERT INTO menus (page_id, title, description, effective_date) VALUES 
(1, 'Banh Xeo', 'Vietnamese crispy pancake', CURRENT_DATE),
(1, 'Banana flower salad', 'Freshly prepared banana flower salad with aromatic Vietnamese herbs', CURRENT_DATE),
(1, 'Caramelized fish', 'Traditional Vietnamese stylized caramelized fish cooked in a clay pot', CURRENT_DATE),
(1, 'Cao Lau', 'Hoi An’s famous noodle dish', CURRENT_DATE),
(2, 'Bánh Mỳ', 'Vietnamese baguette with uniquely Hoi An-style filling', CURRENT_DATE),
(2, 'Cao Lầu', 'An exclusive noodle dish found only in Hoi An with our secret broth recipe', CURRENT_DATE),
(2, 'Bánh Xèo', 'Golden, crispy pancakes served with fresh aromatic herbs', CURRENT_DATE),
(2, 'Nem', 'Fragrant grilled spring rolls wrapped in fresh rice paper', CURRENT_DATE),
(2, 'Thịt Nướng', 'Charcoal-grilled meat with rich, smoky flavors', CURRENT_DATE),
(3, 'Introduction to Lantern History', 'Learn about the significance of lanterns in Hoi An''s heritage', CURRENT_DATE),
(3, 'Selecting Materials', 'Choose your favorite bamboo frame shape and beautiful Vietnamese silk colors', CURRENT_DATE),
(3, 'Crafting Process', 'Step-by-step guidance on applying glue, stretching the silk, and trimming the edges', CURRENT_DATE),
(4, 'Vietnamese Phin Coffee', 'Traditional dark roast robusta brewed with a stainless steel filter', CURRENT_DATE),
(4, 'Hanoi Egg Coffee (Cà Phê Trứng)', 'A creamy, dessert-like coffee topped with whipped egg yolks and condensed milk', CURRENT_DATE),
(4, 'Coconut Coffee (Cà Phê Cốt Dừa)', 'A refreshing blend of coconut milk, condensed milk, and strong coffee', CURRENT_DATE),
(4, 'Salt Coffee (Cà Phê Muối)', 'A unique central Vietnam specialty combining savory and sweet notes', CURRENT_DATE);

-- Seed data for images
INSERT INTO images (page_id, url, source_type) VALUES 
(1, '/images/webp/cooking-class-hero.webp', 'HERO'),
(1, '/images/webp/cooking-class-group.webp', 'CAROUSEL'),
(1, '/images/webp/fresh-ingredients.webp', 'CAROUSEL'),
(1, '/images/webp/shrimp-salad.webp', 'CAROUSEL'),
(1, '/images/webp/finished-dish.webp', 'CAROUSEL'),
(1, '/images/webp/caramelized-fish.webp', 'CONTENT'),
(1, '/images/webp/banana-flower-salad.webp', 'CONTENT'),
(2, '/images/webp/food-tour-hoi-an-13.webp', 'HERO'),
(2, '/images/webp/food-tour-hoi-an-6.webp', 'CAROUSEL'),
(2, '/images/webp/food-tour-hoi-an-4.webp', 'CAROUSEL'),
(2, '/images/webp/food-tour-hoi-an-8.webp', 'CAROUSEL'),
(2, '/images/webp/food-tour-hoi-an-1.webp', 'CONTENT'),
(3, '/images/webp/lantern-class-hero.webp', 'HERO'),
(3, '/images/webp/lantern-class-main.webp', 'CAROUSEL'),
(3, '/images/webp/stock-lantern-1.webp', 'CAROUSEL'),
(3, '/images/webp/stock-lantern-2.webp', 'CAROUSEL'),
(3, '/images/webp/stock-lantern-8.webp', 'CONTENT'),
(4, '/images/webp/coffee-class-hero.webp', 'HERO'),
(4, '/images/webp/coffee-class-main.webp', 'CAROUSEL'),
(4, '/images/webp/stock-coffee-1.webp', 'CAROUSEL'),
(4, '/images/webp/stock-coffee-2.webp', 'CAROUSEL'),
(4, '/images/webp/stock-coffee-9.webp', 'CONTENT');
