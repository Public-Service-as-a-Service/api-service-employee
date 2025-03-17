CREATE TABLE employees (
                           id VARCHAR(255) NOT NULL,
                           person_number VARCHAR(255),
                           is_classified BOOLEAN NOT NULL DEFAULT FALSE,
                           givenname VARCHAR(255),
                           middlename VARCHAR(255),
                           lastname VARCHAR(255),
                           loginname VARCHAR(255),
                           email_address VARCHAR(255),
                           reference_number VARCHAR(255),
                           is_manager BOOLEAN NOT NULL DEFAULT FALSE,
                           created DATETIME(6),
                           created_by VARCHAR(255),
                           modified DATETIME(6),
                           modified_by VARCHAR(255),
                           PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE INDEX employees_person_number_index ON employees (person_number);
CREATE INDEX employees_email_address_index ON employees (email_address);
CREATE INDEX employees_is_manager_index ON employees (is_manager);
CREATE INDEX employees_loginname_index ON employees (loginname);

CREATE TABLE employments (
                             id VARCHAR(255) NOT NULL,
                             employee_id VARCHAR(255),
                             company_id INT,
                             start_date DATETIME(6),
                             end_date DATETIME(6),
                             employment_type INT,
                             title VARCHAR(255),
                             manager_code VARCHAR(255),
                             org_id INT,
                             org_name VARCHAR(255),
                             top_org_id INT,
                             top_org_name VARCHAR(255),
                             benefit_group_id INT,
                             form_of_employment_id VARCHAR(255),
                             is_manual BOOLEAN NOT NULL DEFAULT FALSE,
                             pa_team VARCHAR(255),
                             is_main_employment BOOLEAN NOT NULL DEFAULT FALSE,
                             aid VARCHAR(255),
                             event_type VARCHAR(255),
                             event_info TEXT,
                             emp_row_id VARCHAR(255),
                             created DATETIME(6),
                             created_by VARCHAR(255),
                             modified DATETIME(6),
                             modified_by VARCHAR(255),
                             PRIMARY KEY (id),
                             FOREIGN KEY (employee_id) REFERENCES employees(id)
) ENGINE=InnoDB;

CREATE INDEX employments_employee_id_index ON employments (employee_id);
CREATE INDEX employments_company_id_index ON employments (company_id);
CREATE INDEX employments_title_index ON employments (title);

CREATE TABLE managers (
                          id VARCHAR(255) NOT NULL,
                          givenname VARCHAR(255),
                          middlename VARCHAR(255),
                          lastname VARCHAR(255),
                          loginname VARCHAR(255),
                          email_address VARCHAR(255),
                          reference_number VARCHAR(255),
                          created DATETIME(6),
                          created_by VARCHAR(255),
                          modified DATETIME(6),
                          modified_by VARCHAR(255),
                          PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE INDEX managers_email_address_index ON managers (email_address);
CREATE INDEX managers_loginname_index ON managers (loginname);

CREATE TABLE manager_employees (
                                   id VARCHAR(255) NOT NULL,
                                   manager_id VARCHAR(255),
                                   employee_id VARCHAR(255),
                                   created DATETIME(6),
                                   created_by VARCHAR(255),
                                   modified DATETIME(6),
                                   modified_by VARCHAR(255),
                                   PRIMARY KEY (id),
                                   FOREIGN KEY (manager_id) REFERENCES managers(id),
                                   FOREIGN KEY (employee_id) REFERENCES employees(id)
) ENGINE=InnoDB;

CREATE INDEX manager_employees_manager_id_index ON manager_employees (manager_id);
CREATE INDEX manager_employees_employee_id_index ON manager_employees (employee_id);

CREATE TABLE employee_events (
                                 id VARCHAR(255) NOT NULL,
                                 employee_id VARCHAR(255),
                                 company_id INT,
                                 start_date DATETIME(6),
                                 end_date DATETIME(6),
                                 title VARCHAR(255),
                                 org_id INT,
                                 org_name VARCHAR(255),
                                 top_org_id INT,
                                 top_org_name VARCHAR(255),
                                 benefit_group_id INT,
                                 event_type VARCHAR(255),
                                 event_info TEXT,
                                 created DATETIME(6),
                                 created_by VARCHAR(255),
                                 modified DATETIME(6),
                                 modified_by VARCHAR(255),
                                 PRIMARY KEY (id),
                                 FOREIGN KEY (employee_id) REFERENCES employees(id)
) ENGINE=InnoDB;

CREATE INDEX employee_events_employee_id_index ON employee_events (employee_id);
CREATE INDEX employee_events_event_type_index ON employee_events (event_type);

CREATE TABLE portal_person_data (
                                    id VARCHAR(255) NOT NULL,
                                    employee_id VARCHAR(255),
                                    givenname VARCHAR(255),
                                    lastname VARCHAR(255),
                                    fullname VARCHAR(255),
                                    address TEXT,
                                    postal_code VARCHAR(10),
                                    city VARCHAR(255),
                                    work_phone VARCHAR(50),
                                    mobile_phone VARCHAR(50),
                                    extra_mobile_phone VARCHAR(50),
                                    about_me TEXT,
                                    email VARCHAR(255),
                                    mail_nickname VARCHAR(255),
                                    company VARCHAR(255),
                                    company_id INT,
                                    org_tree TEXT,
                                    reference_number VARCHAR(255),
                                    is_manager BOOLEAN NOT NULL DEFAULT FALSE,
                                    loginname VARCHAR(255),
                                    created DATETIME(6),
                                    created_by VARCHAR(255),
                                    modified DATETIME(6),
                                    modified_by VARCHAR(255),
                                    PRIMARY KEY (id),
                                    FOREIGN KEY (employee_id) REFERENCES employees(id)
) ENGINE=InnoDB;

CREATE INDEX portal_person_data_employee_id_index ON portal_person_data (employee_id);
CREATE INDEX portal_person_data_email_index ON portal_person_data (email);
CREATE INDEX portal_person_data_is_manager_index ON portal_person_data (is_manager);
CREATE INDEX portal_person_data_loginname_index ON portal_person_data (loginname);
CREATE INDEX portal_person_data_name_index ON portal_person_data (givenname, lastname);

CREATE TABLE login_names (
                             id VARCHAR(255) NOT NULL,
                             employee_id VARCHAR(255),
                             domain VARCHAR(255),
                             login_name VARCHAR(255),
                             created DATETIME(6),
                             created_by VARCHAR(255),
                             modified DATETIME(6),
                             modified_by VARCHAR(255),
                             PRIMARY KEY (id),
                             FOREIGN KEY (employee_id) REFERENCES employees(id)
) ENGINE=InnoDB;

CREATE INDEX login_names_employee_id_index ON login_names (employee_id);
CREATE INDEX login_names_domain_index ON login_names (domain);
CREATE INDEX login_names_login_name_index ON login_names (login_name);

CREATE TABLE person_images (
                               id VARCHAR(255) NOT NULL,
                               employee_id VARCHAR(255),
                               title VARCHAR(255),
                               image_data LONGBLOB,
                               created DATETIME(6),
                               created_by VARCHAR(255),
                               modified DATETIME(6),
                               modified_by VARCHAR(255),
                               PRIMARY KEY (id),
                               FOREIGN KEY (employee_id) REFERENCES employees(id)
) ENGINE=InnoDB;

CREATE INDEX person_images_employee_id_index ON person_images (employee_id);

CREATE TABLE problem_details (
                                 id VARCHAR(255) NOT NULL,
                                 type VARCHAR(255),
                                 title VARCHAR(255),
                                 status INT,
                                 detail TEXT,
                                 instance VARCHAR(255),
                                 created DATETIME(6),
                                 created_by VARCHAR(255),
                                 modified DATETIME(6),
                                 modified_by VARCHAR(255),
                                 PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE INDEX problem_details_type_index ON problem_details (type);
CREATE INDEX problem_details_status_index ON problem_details (status);