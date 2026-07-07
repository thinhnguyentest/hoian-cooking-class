-- liquibase formatted sql

-- changeset thinh:15
-- Description: Rename making-lantern slug, page title and page type to private-dinner
UPDATE page_types SET name = 'Private Dinner', code = 'PRIVATE_DINNER' WHERE id = 3;
UPDATE pages SET title = 'Private Dinner', slug = '/private-dinner' WHERE id = 3;
UPDATE system_settings SET setting_value = REPLACE(setting_value, '/making-lantern', '/private-dinner') WHERE setting_key = 'FOOTER_EXPERIENCES';
