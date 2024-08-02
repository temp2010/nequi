-- Create Database
CREATE DATABASE franchise ENCODING 'UTF8';
-- Create User
CREATE USER franchise WITH ENCRYPTED PASSWORD 'oQC2dHYEK4gc2zvrJfDM';
-- Permissions
ALTER DATABASE franchise OWNER TO franchise;
GRANT ALL PRIVILEGES ON DATABASE franchise TO franchise;