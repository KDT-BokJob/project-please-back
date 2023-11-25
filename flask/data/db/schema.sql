CREATE TABLE `Recruit` (
	`recruit_id`	bigint	NOT NULL,
	`job_code`	varchar(20)	NOT NULL,
	`company_id`	bigint	NOT NULL,
	`title`	varchar(100)	NULL,
	`content`	varchar(100)	NULL,
	`created_at`	timestamp	NULL,
	`expired_at`	timestamp	NULL,
	`salary`	integer(45)	NULL,
	`work_type`	varchar(45)	NULL,
	`work_location`	varchar(100)	NULL,
	`work_period`	integer(45)	NULL,
	`work_days_week`	integer(45)	NULL,
	`work_start_hour`	integer(45)	NULL,
	`work_end_hour`	integer(45)	NULL
);

CREATE TABLE `Apply` (
	`apply_id`	bigint	NOT NULL,
	`user_id`	bigint	NOT NULL,
	`recruit_id`	bigint	NOT NULL,
	`resume_id`	bigint	NULL,
	`status`	varchar(45)	NULL
);

CREATE TABLE `Career` (
	`career_id`	bigint	NOT NULL,
	`resume_id`	bigint	NOT NULL,
	`job`	varchar(45)	NULL,
	`responsibility`	varchar(45)	NULL,
	`started_at`	timestamp	NULL,
	`ended_at`	timestamp	NULL,
	`work_performance`	varchar(100)	NULL,
	`detail`	varchar(100)	NULL
);

CREATE TABLE `Job_Code` (
	`job_code`	varchar(20)	NOT NULL,
	`job_name`	varchar(45)	NULL
);

CREATE TABLE `Visa_Filter` (
	`job_code`	varchar(20)	NOT NULL,
	`visa`	varchar(5)	NOT NULL
);

CREATE TABLE `User_Visa` (
	`user_id`	bigint	NOT NULL,
	`visa`	varchar(5)	NOT NULL,
	`created_at`	timestamp	NULL,
	`expired_at`	timestamp	NULL
);

CREATE TABLE `Visa` (
	`visa`	varchar(5)	NOT NULL,
	`validity_period`	integer(45)	NULL
);

CREATE TABLE `User` (
	`user_id`	bigint	NOT NULL,
	`email`	varchar(45)	NULL,
	`name`	varchar(45)	NULL,
	`profile_image`	varchar(400)	NULL,
	`role`	varchar(45)	NULL
);

CREATE TABLE `Resume_Default` (
	`resume_id`	bigint	NOT NULL,
	`user_id`	bigint	NOT NULL,
	`first_name`	varchar(45)	NULL,
	`last_name`	varchar(45)	NULL,
	`phone`	varchar(45)	NULL,
	`birthdate`	datetime	NULL,
	`address`	varchar(100)	NULL,
	`gender`	varchar(45)	NULL,
	`nationality`	varchar(100)	NULL,
	`period`	integer(45)	NULL,
	`korean_proficiency`	tinyint	NULL,
	`degree`	varchar(100)	NULL,
	`is_experienced`	tinyint	NULL,
	`is_disabled`	tinyint	NULL,
	`cover_letter`	varchar(100)	NULL,
	`hexaco`	varchar(45)	NULL
);

CREATE TABLE `Company` (
	`company_id`	bigint	NOT NULL,
	`user_id`	bigint	NOT NULL,
	`business_code`	varchar(20)	NULL,
	`name`	varchar(45)	NOT NULL,
	`employee_count`	integer(45)	NULL	DEFAULT 1,
	`foreign_employee_count`	integer(45)	NULL	DEFAULT 1,
	`phone`	varchar(45)	NULL,
	`address`	varchar(100)	NULL,
	`is_visa_transform`	tinyint	NULL	DEFAULT 0
);

ALTER TABLE `Recruit` ADD CONSTRAINT `PK_RECRUIT` PRIMARY KEY (
	`recruit_id`
);

ALTER TABLE `Apply` ADD CONSTRAINT `PK_APPLY` PRIMARY KEY (
	`apply_id`
);

ALTER TABLE `Career` ADD CONSTRAINT `PK_CAREER` PRIMARY KEY (
	`career_id`
);

ALTER TABLE `Job_Code` ADD CONSTRAINT `PK_JOB_CODE` PRIMARY KEY (
	`job_code`
);

ALTER TABLE `Visa_Filter` ADD CONSTRAINT `PK_VISA_FILTER` PRIMARY KEY (
	`job_code`,
	`visa`
);

ALTER TABLE `User_Visa` ADD CONSTRAINT `PK_USER_VISA` PRIMARY KEY (
	`user_id`
);

ALTER TABLE `Visa` ADD CONSTRAINT `PK_VISA` PRIMARY KEY (
	`visa`
);

ALTER TABLE `User` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`user_id`
);

ALTER TABLE `Resume_Default` ADD CONSTRAINT `PK_RESUME_DEFAULT` PRIMARY KEY (
	`resume_id`
);

ALTER TABLE `Company` ADD CONSTRAINT `PK_COMPANY` PRIMARY KEY (
	`company_id`
);

ALTER TABLE `Recruit` ADD CONSTRAINT `FK_Job_Code_TO_Recruit_1` FOREIGN KEY (
	`job_code`
)
REFERENCES `Job_Code` (
	`job_code`
);

ALTER TABLE `Recruit` ADD CONSTRAINT `FK_Company_TO_Recruit_1` FOREIGN KEY (
	`company_id`
)
REFERENCES `Company` (
	`company_id`
);

ALTER TABLE `Apply` ADD CONSTRAINT `FK_User_TO_Apply_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `User` (
	`user_id`
);

ALTER TABLE `Apply` ADD CONSTRAINT `FK_Recruit_TO_Apply_1` FOREIGN KEY (
	`recruit_id`
)
REFERENCES `Recruit` (
	`recruit_id`
);

ALTER TABLE `Career` ADD CONSTRAINT `FK_Resume_Default_TO_Career_1` FOREIGN KEY (
	`resume_id`
)
REFERENCES `Resume_Default` (
	`resume_id`
);

ALTER TABLE `Visa_Filter` ADD CONSTRAINT `FK_Job_Code_TO_Visa_Filter_1` FOREIGN KEY (
	`job_code`
)
REFERENCES `Job_Code` (
	`job_code`
);

ALTER TABLE `Visa_Filter` ADD CONSTRAINT `FK_Visa_TO_Visa_Filter_1` FOREIGN KEY (
	`visa`
)
REFERENCES `Visa` (
	`visa`
);

ALTER TABLE `User_Visa` ADD CONSTRAINT `FK_User_TO_User_Visa_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `User` (
	`user_id`
);

ALTER TABLE `User_Visa` ADD CONSTRAINT `FK_Visa_TO_User_Visa_1` FOREIGN KEY (
	`visa`
)
REFERENCES `Visa` (
	`visa`
);

ALTER TABLE `Resume_Default` ADD CONSTRAINT `FK_User_TO_Resume_Default_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `User` (
	`user_id`
);

ALTER TABLE `Company` ADD CONSTRAINT `FK_User_TO_Company_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `User` (
	`user_id`
);

