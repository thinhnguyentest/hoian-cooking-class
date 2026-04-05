-- liquibase formatted sql

-- changeset thinh:11
-- Description: Reseed all page content and menus to fix duplication issues and ensure data relevance

-- Clean up all existing data for pages 1, 2, 3, 4
DELETE FROM menus WHERE page_id IN (1, 2, 3, 4);
DELETE FROM page_contents WHERE page_id IN (1, 2, 3, 4);

-- ========== PAGE 1: COOKING CLASS ==========
INSERT INTO page_contents (page_id, section_type, title, content, sort_order) VALUES 
(1, 'INTRODUCTION', 'The Art of Vietnamese Flavor', 'Take a break from the busy streets of Hoi An and enjoy a peaceful 3-hour cooking class in a quiet countryside area, surrounded by rice fields and fresh air. This experience is hosted by Lily and her sister, who will guide you step by step in a warm, relaxed, and personal way.', 1),
(1, 'EXPERIENCE', 'Authentic Connection', 'After being picked up at the meeting point, you’ll travel to a calm rural location outside the city. Here, you can slow down, enjoy the green rice field views, and experience a simpler, more authentic side of local life.', 2),
(1, 'HIGHLIGHTS', 'Key Features', 'Around 3 hours, relaxed and not rushed', 1),
(1, 'HIGHLIGHTS', 'Key Features', 'Located in a quiet countryside area, far from tourist crowds', 2),
(1, 'HIGHLIGHTS', 'Key Features', 'Beautiful rice field views and a calm atmosphere', 3),
(1, 'HIGHLIGHTS', 'Key Features', 'Small group with personal guidance by local hosts', 4),
(1, 'HIGHLIGHTS', 'Key Features', 'Simple, everyday dishes that reflect local life in Hoi An', 5),
(1, 'INCLUDES', NULL, 'Professional instructor & Local host', 1),
(1, 'INCLUDES', NULL, 'All local ingredients & recipes', 2),
(1, 'INCLUDES', NULL, 'Full tasting of all prepared dishes', 3),
(1, 'INCLUDES', NULL, 'Complimentary local herbal tea', 4),
(1, 'NOT_SUITABLE', NULL, 'Children under 5 years without supervision', 1);

INSERT INTO menus (page_id, name, description, sort_order) VALUES 
(1, 'Bánh Xèo (Crispy Pancake)', 'Traditional Vietnamese savory pancake with shrimp, sprouts and herbs', 1),
(1, 'Banana Flower Salad', 'Freshly prepared salad with aromatic Vietnamese herbs and crushed peanuts', 2),
(1, 'Caramelized Fish in Clay Pot', 'Traditional Vietnamese stylized fish cooked slowly in a savory glaze', 3),
(1, 'Cao Lầu specialty', 'Hoi An’s famous noodle dish made with secret local techniques', 4);


-- ========== PAGE 2: FOOD TOUR ==========
INSERT INTO page_contents (page_id, section_type, title, content, sort_order) VALUES 
(2, 'INTRODUCTION', 'A Culinary Soul Journey', 'Journey through hidden alleyways and savor the unique flavors that define our ancient town''s culinary heritage.', 1),
(2, 'EXPERIENCE', 'Historical Crossroads', 'Hoi An is more than just an ancient town with its charming yellow heritage houses – it''s a vibrant crossroads where Vietnamese, Chinese, and Japanese culinary traditions have merged over centuries, creating distinctive flavors found nowhere else in the world.', 2),
(2, 'EXPERIENCE', 'Local Native Perspective', 'As a native of Hoi An, I invite you to join me through hidden alleyways and time-honored family establishments, where you’ll savor authentic dishes that carry stories of our history, culture, and people. This isn’t just a food tour – It’s an authentic journey into the soul of Hoi An, shared by someone who calls this place home.', 3),
(2, 'INCLUDES', NULL, 'English-speaking local tour guide', 1),
(2, 'INCLUDES', NULL, 'All food and standard beverage samples', 2),
(2, 'INCLUDES', NULL, 'One bottle of mineral water', 3),
(2, 'EXCLUDES', NULL, 'Entrance ticket to Old Town ($6 USD per person)', 1),
(2, 'NOT_SUITABLE', NULL, 'Babies under 1 year', 1),
(2, 'NOT_SUITABLE', NULL, 'People over 95 years old', 2);

INSERT INTO menus (page_id, name, description, sort_order) VALUES 
(2, 'Bánh Mỳ Hội An', 'Vietnamese baguette with uniquely Hoi An-style pâté and local layers', 1),
(2, 'Cao Lầu Noodle', 'An exclusive noodle dish found only in Hoi An with our secret broth recipe', 2),
(2, 'Bánh Xèo', 'Golden, crispy pancakes served with fresh local aromatic herbs', 3),
(2, 'Nem Lụi', 'Fragrant grilled lemongrass spring rolls wrapped in fresh rice paper', 4),
(2, 'Thịt Nướng', 'Charcoal-grilled skewered meat with rich, smoky Hoi An flavors', 5),
(2, 'Trà or Chè', 'Local herbal tea or traditional sweet bean dessert', 6),
(2, 'Bánh Xoài (Mango cake)', 'A sweet, chewy finale featuring our region''s beloved traditional treat', 7);


-- ========== PAGE 3: LANTERN MAKING ==========
INSERT INTO page_contents (page_id, section_type, title, content, sort_order) VALUES 
(3, 'INTRODUCTION', 'Craft Your Legacy', 'Hoi An is internationally renowned for its colorful silk lanterns that illuminate the old town every evening. Making these beautiful cultural symbols is a craft passed down through generations.', 1),
(3, 'EXPERIENCE', 'Heritage Workshop', 'In this engaging workshop, we invite you to immerse yourself in the art of lantern making. Under the guidance of skilled craftsmen, you will learn how to bend bamboo, apply vibrant silk, and complete your very own traditional lantern.', 2),
(3, 'INCLUDES', NULL, 'Local master artisan instructor', 1),
(3, 'INCLUDES', NULL, 'All materials (bamboo, silk, specialized glue)', 2),
(3, 'INCLUDES', NULL, 'Your finished lantern to take home', 3),
(3, 'INCLUDES', NULL, 'A cup of authentic local herbal tea', 4),
(3, 'EXCLUDES', NULL, 'Personal shopping', 1),
(3, 'EXCLUDES', NULL, 'Pick up and drop off service', 2),
(3, 'NOT_SUITABLE', NULL, 'Children under 3 years old without adult supervision', 1);

INSERT INTO menus (page_id, name, description, sort_order) VALUES 
(3, 'Lantern History Talk', 'Learn about the deep cultural significance of lanterns in Hoi An''s heritage', 1),
(3, 'Selecting Materials', 'Choose your bamboo frame shape and beautiful Vietnamese silk colors', 2),
(3, 'Stretching the Silk', 'Master the technique of applying glue and stretching silk perfectly over frames', 3),
(3, 'Finishing & Decoration', 'Detailing the lantern and attaching the decorative tail tassel', 4);


-- ========== PAGE 4: COFFEE CLASS ==========
INSERT INTO page_contents (page_id, section_type, title, content, sort_order) VALUES 
(4, 'INTRODUCTION', 'Master the Brew', 'Vietnam boasts one of the most unique coffee cultures in the world. From the robust beans grown in the Central Highlands to the creative ways we mix ingredients, coffee here is an art form.', 1),
(4, 'EXPERIENCE', 'Hands-on Brewing', 'Join our hands-on workshop to uncover the secrets behind Vietnam''s famous brews. You''ll learn the history, the proper way to use a traditional Phin filter, and how to whip up the perfect egg and coconut coffees.', 2),
(4, 'EXPERIENCE', 'Sensory Journey', 'Whether you are a casual drinker or a coffee aficionado, this class offers a rich, aromatic experience.', 3),
(4, 'INCLUDES', NULL, 'Professional coffee instructor', 1),
(4, 'INCLUDES', NULL, 'All premium coffee beans and ingredients', 2),
(4, 'INCLUDES', NULL, 'Tasting session for all drinks prepared', 3),
(4, 'INCLUDES', NULL, 'Digital or printed recipe guide', 4),
(4, 'EXCLUDES', NULL, 'Entrance tickets to other sites', 1),
(4, 'EXCLUDES', NULL, 'Personal shopping', 2),
(4, 'NOT_SUITABLE', NULL, 'Children under 10 years of age', 1),
(4, 'NOT_SUITABLE', NULL, 'People with extreme sensitivity to caffeine', 2);

INSERT INTO menus (page_id, name, description, sort_order) VALUES 
(4, 'Vietnamese Phin Coffee', 'Traditional dark roast robusta brewed patiently with a stainless steel filter', 1),
(4, 'Hanoi Egg Coffee (Cà Phê Trứng)', 'A creamy, dessert-like coffee topped with whipped egg yolks and condensed milk', 2),
(4, 'Coconut Coffee (Cà Phê Cốt Dừa)', 'A refreshing blend of coconut milk, condensed milk, and strong coffee', 3),
(4, 'Salt Coffee (Cà Phê Muối)', 'A unique central Vietnam specialty combining savory and sweet notes', 4);
