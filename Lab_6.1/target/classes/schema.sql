CREATE TABLE IF NOT EXISTS departments ( 
		department_id INT NOT NULL, 
        department_name CHAR(32) NOT NULL,
        PRIMARY KEY (department_id)
        );
        
CREATE TABLE IF NOT EXISTS courses ( 
        course_id INT NOT NULL, 
        department_id INT NOT NULL, 
        course_code CHAR(32) NOT NULL, 
        course_name CHAR(128) NOT NULL DEFAULT '', 
        created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (course_id),
        FOREIGN KEY(department_id) REFERENCES departments(department_id) 
        );
        
CREATE TABLE IF NOT EXISTS schedules ( 
        schedule_id INT NOT NULL, 
        course_id INT NOT NULL, 
        year INT(4) NOT NULL DEFAULT 0, 
        quarter INT(1) NOT NULL DEFAULT 0, 
        instructor CHAR(64) NOT NULL DEFAULT '',
        PRIMARY KEY (schedule_id),
        FOREIGN KEY(course_id) REFERENCES courses(course_id) 
        );
        
CREATE TABLE IF NOT EXISTS students ( 
        student_id INT NOT NULL, 
        student_name CHAR(64) NOT NULL DEFAULT '',
        PRIMARY KEY (student_id)
        );

CREATE TABLE IF NOT EXISTS registrations ( 
        registration_id INT NOT NULL, 
        student_id INT NOT NULL, 
        schedule_id INT NOT NULL, 
        reg_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
        PRIMARY KEY (registration_id), 
        FOREIGN KEY(student_id) REFERENCES students(student_id), 
        FOREIGN KEY(schedule_id) REFERENCES schedules(schedule_id) 
        );