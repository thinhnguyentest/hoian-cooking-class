-- Seed content for Food Tour (Page ID: 2)
INSERT INTO page_contents (page_id, section_type, title, content, sort_order) VALUES 
(2, 'EXPERIENCE', 'A Culinary Soul Journey Through Hoi An', 'Hoi An is more than just an ancient town with its charming yellow heritage houses – it''s a vibrant crossroads where Vietnamese, Chinese, and Japanese culinary traditions have merged over centuries, creating distinctive flavors found nowhere else in the world.', 1),
(2, 'EXPERIENCE', 'Local Connection', 'As a native of Hoi An, I invite you to join me through hidden alleyways and time-honored family establishments, where you''ll savor authentic dishes that carry stories of our history, culture, and people. This isn''t just a food tour – It''s an authentic journey into the soul of Hoi An, shared by someone who calls this place home.', 2),
(2, 'INCLUDES', NULL, 'English-speaking tour guide', 1),
(2, 'INCLUDES', NULL, 'All food', 2),
(2, 'INCLUDES', NULL, 'One bottle of water', 3),
(2, 'EXCLUDES', NULL, 'Entrance ticket to Old Town ($6 USD/pax)', 1),
(2, 'NOT_SUITABLE', NULL, 'Babies under 1 year', 1),
(2, 'NOT_SUITABLE', NULL, 'People over 95 years', 2);

INSERT INTO menus (page_id, name, description, sort_order) VALUES 
(2, 'Bánh Mỳ', 'Vietnamese baguette with uniquely Hoi An-style filling', 1),
(2, 'Cao Lầu', 'An exclusive noodle dish found only in Hoi An with our secret broth recipe', 2),
(2, 'Bánh Xèo', 'Golden, crispy pancakes served with fresh aromatic herbs', 3),
(2, 'Nem', 'Fragrant grilled spring rolls wrapped in fresh rice paper', 4),
(2, 'Thịt Nướng', 'Charcoal-grilled meat with rich, smoky flavors', 5),
(2, 'Trà or Chè', 'Tea or Sweet Dessert', 6),
(2, 'Bánh Xoài (Mango cake)', 'A sweet finale featuring our region''s beloved traditional treat', 7);

-- Seed content for Making Lantern (Page ID: 3)
INSERT INTO page_contents (page_id, section_type, title, content, sort_order) VALUES 
(3, 'EXPERIENCE', 'Hoi An Traditional Lantern Making', 'Hoi An is internationally renowned for its colorful silk lanterns that illuminate the old town every evening. Making these beautiful cultural symbols is a craft that has been passed down through generations of local artisans.', 1),
(3, 'EXPERIENCE', 'Hands-on Workshop', 'In this engaging workshop, we invite you to immerse yourself in the art of lantern making. Under the guidance of skilled craftsmen, you will learn how to bend bamboo, apply vibrant silk, and complete your very own traditional lantern to take home as a memorable keepsake.', 2),
(3, 'INCLUDES', NULL, 'Local artisan instructor', 1),
(3, 'INCLUDES', NULL, 'All materials (bamboo, silk, glue)', 2),
(3, 'INCLUDES', NULL, 'Your finished lantern to keep', 3),
(3, 'INCLUDES', NULL, 'A cup of local herbal tea', 4);

INSERT INTO menus (page_id, name, description, sort_order) VALUES 
(3, 'Introduction to Lantern History', 'Learn about the significance of lanterns in Hoi An''s heritage', 1),
(3, 'Selecting Materials', 'Choose your favorite bamboo frame shape and beautiful Vietnamese silk colors', 2),
(3, 'Crafting Process', 'Step-by-step guidance on applying glue, stretching the silk, and trimming the edges', 3),
(3, 'Finishing Touches', 'Attaching the hanging wire and decorative tail tassel', 4);

-- Seed content for Making Coffee (Page ID: 4)
INSERT INTO page_contents (page_id, section_type, title, content, sort_order) VALUES 
(4, 'EXPERIENCE', 'The Art of Vietnamese Coffee', 'Vietnam boasts one of the most unique coffee cultures in the world. From the robust beans grown in the Central Highlands to the creative ways we mix ingredients, coffee here is an art form.', 1),
(4, 'EXPERIENCE', 'Hands-on Brewing', 'Join our hands-on workshop to uncover the secrets behind Vietnam''s famous brews. You''ll learn the history, the proper way to use a traditional Phin filter, and how to whip up the perfect egg and coconut coffees.', 2),
(4, 'INCLUDES', NULL, 'Professional instructor', 1),
(4, 'INCLUDES', NULL, 'All coffee beans and ingredients', 2),
(4, 'INCLUDES', NULL, 'Tasting of all drinks made', 3),
(4, 'INCLUDES', NULL, 'Printed recipe guide', 4),
(4, 'NOT_SUITABLE', NULL, 'Children under 10 years', 1),
(4, 'NOT_SUITABLE', NULL, 'People sensitive to caffeine', 2);

INSERT INTO menus (page_id, name, description, sort_order) VALUES 
(4, 'Vietnamese Phin Coffee', 'Traditional dark roast robusta brewed with a stainless steel filter', 1),
(4, 'Hanoi Egg Coffee (Cà Phê Trứng)', 'A creamy, dessert-like coffee topped with whipped egg yolks and condensed milk', 2),
(4, 'Coconut Coffee (Cà Phê Cốt Dừa)', 'A refreshing blend of coconut milk, condensed milk, and strong coffee', 3),
(4, 'Salt Coffee (Cà Phê Muối)', 'A unique central Vietnam specialty combining savory and sweet notes', 4);
