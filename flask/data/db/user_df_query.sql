
CREATE OR REPLACE VIEW user_visa_info AS
SELECT
	A.resume_id
	,A.user_id
	,datediff(now(), A.birthdate)/365 AS age
	,A.address
	,A.gender
	,A.nationality
	,A.period
	,A.korean_proficiency
	,A.degree
	,A.is_experienced
	,A.is_disabled
	,B.visa
	,datediff(B.expired_at, now()) as day_remains
FROM resume_default as A, user_visa as B
WHERE A.user_id = B.user_id;

CREATE OR REPLACE VIEW career_stats AS (
WITH stats AS (
		SELECT
			career_id
			,resume_id
			,job
			,responsibility
			,datediff(ended_at, started_at) as day_worked
			,NOT isnull(work_performance) as has_indicator
			,NOT isnull(detail) as has_detail
		FROM please.career
	)
	SELECT
		stats.resume_id AS resume_id
		,SUM(stats.day_worked) AS total_day_worked
		,SUM(stats.has_indicator) AS total_indicators
	FROM stats
	GROUP BY resume_id
);

SELECT
	T1.user_id
    ,T1.age
    ,T1.address
    ,T1.gender
    ,T1.nationality
    ,T1.period
    ,T1.korean_proficiency
    ,T1.is_experienced
    ,T1.is_disabled
    ,T1.visa
    ,T1.day_remains
    ,IFNULL(T2.total_day_worked, 0) AS total_day_worked
	,IFNULL(T2.total_indicators, 0) AS total_indicators
FROM user_visa_info AS T1
LEFT JOIN career_stats AS T2
ON T1.resume_id = T2.resume_id;