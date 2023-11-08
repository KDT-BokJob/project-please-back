from pprint import pprint

import pandas as pd
import pymysql.cursors

# Connect to the database
connection = pymysql.connect(host='localhost', user='root', password='root', database='Please', charset='utf8mb4',
                             cursorclass=pymysql.cursors.DictCursor)


def get_user_df():
    with connection:
        # with connection.cursor() as cursor:
        #     # Create a new record
        #     sql = "INSERT INTO `user` (`email`, `password`) VALUES (%s, %s)"
        #     cursor.execute(sql, ('webmaster@python.org', 'very-secret'))
        #
        # # connection is not autocommit by default. So you must commit to save
        # # your changes.
        # connection.commit()

        with connection.cursor() as cursor:
            # Read a single record
            # sql = "SELECT `id`, `password` FROM `users` WHERE `email`=%s"
            # cursor.execute(sql, ('webmaster@python.org',))

            sql = """
            SELECT
                A.user_id
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
                ,C.total_day_worked
                ,C.total_indicators
            FROM resume_default as A, user_visa as B,
            (SELECT
                stats.resume_id AS resume_id
                ,SUM(stats.day_worked) AS total_day_worked
                ,SUM(stats.has_indicator) AS total_indicators
            FROM (SELECT
                    career_id
                    ,resume_id
                    ,job
                    ,responsibility
                    ,datediff(ended_at, started_at) as day_worked
                    ,NOT isnull(work_performance) as has_indicator
                    ,NOT isnull(detail) as has_detail
                FROM please.career) AS stats
            GROUP BY resume_id) AS C
            WHERE A.user_id = B.user_id and A.resume_id = C.resume_id
            """
            cursor.execute(sql)
            result = cursor.fetchall()
            return pd.DataFrame(result)



