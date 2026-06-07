-- liquibase formatted sql

-- changeset thinh:14
-- Description: Add price field to pages table

ALTER TABLE pages ADD COLUMN price DECIMAL(10, 2);

-- Update existing pages with default prices
-- Page 1: Cooking Class (/)
UPDATE pages SET price = 38.00 WHERE id = 1;

-- Page 2: Food Tour (/food-tour)
UPDATE pages SET price = 26.00 WHERE id = 2;

-- Page 3: Making Lantern (/making-lantern)
UPDATE pages SET price = 28.00 WHERE id = 3;

-- Page 4: Making Coffee (/making-coffee-class)
UPDATE pages SET price = 25.00 WHERE id = 4;
