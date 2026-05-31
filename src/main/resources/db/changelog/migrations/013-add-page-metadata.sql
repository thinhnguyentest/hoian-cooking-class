-- liquibase formatted sql

-- changeset thinh:13
-- Description: Add duration, group_size, and cancellation fields to pages table

ALTER TABLE pages ADD COLUMN duration VARCHAR(255);
ALTER TABLE pages ADD COLUMN group_size VARCHAR(255);
ALTER TABLE pages ADD COLUMN cancellation VARCHAR(255);

-- Update existing pages with default details
-- Page 1: Cooking Class (/)
UPDATE pages SET duration = '3 hours', group_size = 'Max 8 participants', cancellation = 'Free up to 24h before' WHERE id = 1;

-- Page 2: Food Tour (/food-tour)
UPDATE pages SET duration = '2.5 hours', group_size = 'Max 8 participants', cancellation = 'Free up to 24h before' WHERE id = 2;

-- Page 3: Making Lantern (/making-lantern)
UPDATE pages SET duration = '2.5 hours', group_size = 'Max 15 participants', cancellation = 'Free up to 24h before' WHERE id = 3;

-- Page 4: Making Coffee (/making-coffee-class)
UPDATE pages SET duration = '2 hours', group_size = 'Max 10 participants', cancellation = 'Free up to 24h before' WHERE id = 4;
