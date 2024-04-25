-- gallery 

Use galleryDB;

select * FROM tbl_gallerys;
select g_time, length(g_image) from tbl_gallerys ORDER BY g_time DESC;
