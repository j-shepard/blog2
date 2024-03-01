CREATE TABLE information (
    id uuid DEFAULT uuid_generate_v4() PRIMARY KEY NOT NULL,
    description VARCHAR(2000) NOT NULL,
    json_data JSONB NOT NULL
);

CREATE TABLE users (
    user_name VARCHAR(50) PRIMARY KEY NOT NULL, -- Username must be unique and not null
    full_name VARCHAR(2000) NOT NULL            -- Full name is required
);

CREATE TABLE rating (
    user_name VARCHAR(50) NOT NULL REFERENCES users(user_name), -- References the 'users' table
    info_id uuid NOT NULL REFERENCES information(id), -- References the 'information' table
    rating INTEGER NOT NULL,  -- The required integer rating
    PRIMARY KEY (user_name, info_id) -- Makes user_name and info_id together a primary key
);
