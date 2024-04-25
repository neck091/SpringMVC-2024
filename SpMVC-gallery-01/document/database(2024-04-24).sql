-- galleryDB
DROP DATABASE gallertyDB2;
CREATE DATABASE galleryDB2;
use galleryDB2;

DROP TABLE tbl_gallery;
CREATE TABLE tbl_gallery (
g_id	VARCHAR(125)	PRIMARY KEY,
g_date	VARCHAR(10)	NOT NULL,
g_time	VARCHAR(10)	NOT NULL,
g_author	VARCHAR(20)	NOT NULL,
g_subject	VARCHAR(20)	NOT NULL,
g_content	VARCHAR(100)	NOT NULL,
g_origin_image	VARCHAR(255)	NOT NULL,
g_up_image	VARCHAR(255)	NOT NULL
);

DESC TABLE tbl_gallery;