
CREATE TABLE IF NOT EXISTS tbl_lms_assignments
(
    a_id SERIAL PRIMARY KEY,
    a_name VARCHAR(25),
    a_description VARCHAR(30),
    a_comments VARCHAR(30),
	a_due_date date NOT NULL DEFAULT (CURRENT_DATE + INTERVAL'7 days'),
    a_path_attach1 VARCHAR(15),
    a_path_attach2 VARCHAR(15),
    a_path_attach3 VARCHAR(15),
    a_path_attach4 VARCHAR(15),
    a_path_attach5 VARCHAR(15),
    a_created_by VARCHAR(15) NOT NULL,
    a_batch_id integer NOT NULL,
    a_grader_id VARCHAR(15) NOT NULL,
    creation_time timestamp without time zone NOT NULL DEFAULT now(),
    last_mod_time timestamp without time zone NOT NULL DEFAULT now(),
     CONSTRAINT a_batch_id_fk FOREIGN KEY (a_batch_id)
     REFERENCES tbl_lms_batch (batch_id)
 );
 
SELECT * from tbl_lms_assignments;
 