-- liquibase formatted sql

-- changeset thinh:7
-- Additional menus for Page 2 (Food Tour)
INSERT INTO menus (page_id, name, description, sort_order) VALUES 
(2, 'Bánh Mỳ', 'Vietnamese baguette with uniquely Hoi An-style filling', 1),
(2, 'Cao Lầu', 'An exclusive noodle dish found only in Hoi An with our secret broth recipe', 2),
(2, 'Bánh Xèo', 'Golden, crispy pancakes served with fresh aromatic herbs', 3),
(2, 'Nem', 'Fragrant grilled spring rolls wrapped in fresh rice paper', 4),
(2, 'Thịt Nướng', 'Charcoal-grilled meat with rich, smoky flavors', 5),
(2, 'Trà or Chè', 'Traditional herbal tea or sweet dessert', 6),
(2, 'Bánh Xoài (Mango cake)', 'A sweet finale featuring our region''s beloved traditional treat', 7);

-- Additional menus for Page 3 (Lantern Making)
INSERT INTO menus (page_id, name, description, sort_order) VALUES 
(3, 'Introduction to Lantern History', 'Learn about the significance of lanterns in Hoi An''s heritage', 1),
(3, 'Selecting Materials', 'Choose your favorite bamboo frame shape and beautiful Vietnamese silk colors', 2),
(3, 'Crafting Process', 'Step-by-step guidance on applying glue, stretching the silk, and trimming the edges', 3),
(3, 'Finishing Touches', 'Attaching the hanging wire and decorative tail tassel', 4);

-- Additional menus for Page 4 (Coffee Class)
INSERT INTO menus (page_id, name, description, sort_order) VALUES 
(4, 'Vietnamese Phin Coffee', 'Traditional dark roast robusta brewed with a stainless steel filter', 1),
(4, 'Hanoi Egg Coffee (Cà Phê Trứng)', 'A creamy, dessert-like coffee topped with whipped egg yolks and condensed milk', 2),
(4, 'Coconut Coffee (Cà Phê Cốt Dừa)', 'A refreshing blend of coconut milk, condensed milk, and strong coffee', 3),
(4, 'Salt Coffee (Cà Phê Muối)', 'A unique central Vietnam specialty combining savory and sweet notes', 4);

-- Additional contents (Includes, Excludes, Not Suitable)
-- Page 1 (Cooking Class)
INSERT INTO page_contents (page_id, section_type, content, sort_order) VALUES 
(1, 'INCLUDES', 'Professional instructor', 1),
(1, 'INCLUDES', 'All ingredients', 2),
(1, 'INCLUDES', 'Tasting of all dishes', 3),
(1, 'INCLUDES', 'Local herbal tea', 4),
(1, 'NOT_SUITABLE', 'Children under 5 years', 1);

-- Page 2 (Food Tour)
INSERT INTO page_contents (page_id, section_type, content, sort_order) VALUES 
(2, 'INCLUDES', 'English-speaking tour guide', 1),
(2, 'INCLUDES', 'All food', 2),
(2, 'INCLUDES', 'One bottle of water', 3),
(2, 'EXCLUDES', 'Entrance ticket to Old Town ($6 USD/pax)', 1),
(2, 'NOT_SUITABLE', 'Babies under 1 year', 1),
(2, 'NOT_SUITABLE', 'People over 95 years', 2);

-- Page 3 (Lantern Making)
INSERT INTO page_contents (page_id, section_type, content, sort_order) VALUES 
(3, 'INCLUDES', 'Local artisan instructor', 1),
(3, 'INCLUDES', 'All materials (bamboo, silk, glue)', 2),
(3, 'INCLUDES', 'Your finished lantern to keep', 3),
(3, 'INCLUDES', 'A cup of local herbal tea', 4);

-- Page 4 (Coffee Class)
INSERT INTO page_contents (page_id, section_type, content, sort_order) VALUES 
(4, 'INCLUDES', 'Professional instructor', 1),
(4, 'INCLUDES', 'All coffee beans and ingredients', 2),
(4, 'INCLUDES', 'Tasting of all drinks made', 3),
(4, 'INCLUDES', 'Printed recipe guide', 4),
(4, 'NOT_SUITABLE', 'Children under 10 years', 1),
(4, 'NOT_SUITABLE', 'People sensitive to caffeine', 2);
