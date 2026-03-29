-- liquibase formatted sql

-- changeset thinh:3
CREATE TABLE page_contents (
    id SERIAL PRIMARY KEY,
    page_id INTEGER REFERENCES pages(id),
    title VARCHAR(255) NOT NULL,
    description TEXT,
    effective_date DATE
);

CREATE TABLE menus (
    id SERIAL PRIMARY KEY,
    page_id INTEGER REFERENCES pages(id),
    title VARCHAR(255) NOT NULL,
    description TEXT,
    effective_date DATE
);

CREATE TABLE images (
    id SERIAL PRIMARY KEY,
    page_id INTEGER REFERENCES pages(id),
    url TEXT NOT NULL,
    source_type VARCHAR(50) NOT NULL,
    alt_text VARCHAR(250) -- HERO, CAROUSEL, CONTENT, REVIEW
);
