-- liquibase formatted sql

-- changeset thinh:12
-- Description: Add system_settings table and initial footer/contact data
CREATE TABLE system_settings (
    id SERIAL PRIMARY KEY,
    setting_key VARCHAR(100) NOT NULL UNIQUE,
    setting_value TEXT,
    description VARCHAR(255)
);

-- Seed initial data for contact and footer sections
INSERT INTO system_settings (setting_key, setting_value, description) VALUES
('INFO_LOCATION', '{
  "title": "Our Sanctuary",
  "address": "V83M+F27 Duy Xuyên District, Quảng Nam, Vietnam",
  "description": "Located in the heart of the Ancient Town, a quiet retreat from the bustling streets."
}', 'Location info for contact section'),

('INFO_SCHEDULE', '{
  "title": "Daily Rhythms",
  "morning": "Morning Session: 08:30 - 12:30",
  "afternoon": "Afternoon Session: 14:30 - 18:30"
}', 'Schedule info for contact section'),

('INFO_INQUIRY', '{
  "title": "Inquiries",
  "phone": "+84 905 340 602",
  "whatsapp_url": "https://wa.me/84905340602",
  "zalo_url": "https://zalo.me/84905340602"
}', 'Inquiry info with phone and social links'),

('FOOTER_CONTACT', '{
  "address": "Cam Thanh Village, Hoi An, Quang Nam, Vietnam",
  "phone": "+84 905 340 602",
  "email": "hello@hoiancooking.com"
}', 'Global contact info for footer'),

('FOOTER_BRAND', '{
  "title": "Hoi An Cooking Class",
  "description": "Discover the authentic flavors of Vietnam through our hands-on cooking classes. Experience the rich culinary heritage of Hoi An in a beautiful, relaxed setting.",
  "instagram_url": "#",
  "facebook_url": "#"
}', 'Brand info and social links for footer'),

('FOOTER_EXPERIENCES', '{
  "title": "EXPERIENCES",
  "links": [
    {"label": "Cooking Class", "url": "/"},
    {"label": "Local Food Tour", "url": "/food-tour"},
    {"label": "Vietnamese Coffee", "url": "/making-coffee-class"},
    {"label": "Lantern Making", "url": "/making-lantern"}
  ]
}', 'List of experience links for footer');
