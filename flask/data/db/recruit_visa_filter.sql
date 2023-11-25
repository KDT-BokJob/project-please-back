CREATE OR REPLACE VIEW recruit_visa_filter AS
SELECT
	T1.recruit_id
    ,T1.work_location
	,T1.job_code
    ,T2.visa
    ,T3.job_name
    ,concat(T1.title, T1.content, T1.work_type) as keyword
FROM
	recruit as T1,
    visa_filter as T2,
    job_code as T3
WHERE
	T1.job_code = T2.job_code AND
    T1.job_code = T3.job_code;

SELECT
	DISTINCT recruit_id
FROM recruit_visa_filter
WHERE
	(work_location LIKE "%서울%"
    OR work_location LIKE "%인천%")
    AND
    visa IN ("H-2", "E-9")
    AND
    job_name LIKE "%제조%";

-- 지역 조회
-- SELECT
-- 	recruit_id
--     ,job_code
--     ,work_location
-- FROM recruit
-- WHERE
-- 	work_location LIKE "%서울%"
--     OR work_location LIKE "%창원%";