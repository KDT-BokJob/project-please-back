from pprint import pprint

import pymysql.cursors

# Connect to the database
connection = pymysql.connect(host='localhost',
                             user='root',
                             password='root',
                             database='Please',
                             charset='utf8mb4',
                             cursorclass=pymysql.cursors.DictCursor)

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
        sql = "SELECT * FROM apply"
        cursor.execute(sql)
        result = cursor.fetchone()
        pprint([sql, result])

        sql = "SELECT * FROM career"
        cursor.execute(sql)
        result = cursor.fetchone()
        pprint([sql, result])

        sql = "SELECT * FROM company"
        cursor.execute(sql)
        result = cursor.fetchone()
        pprint([sql, result])

        sql = "SELECT * FROM job_code"
        cursor.execute(sql)
        result = cursor.fetchone()
        pprint([sql, result])

        sql = "SELECT * FROM recruit"
        cursor.execute(sql)
        result = cursor.fetchone()
        pprint([sql, result])

        sql = "SELECT * FROM resume_default"
        cursor.execute(sql)
        result = cursor.fetchone()
        pprint([sql, result])

        sql = "SELECT * FROM user"
        cursor.execute(sql)
        result = cursor.fetchone()
        pprint([sql, result])

        sql = "SELECT * FROM user_visa"
        cursor.execute(sql)
        result = cursor.fetchone()
        pprint([sql, result])

        sql = "SELECT * FROM visa"
        cursor.execute(sql)
        result = cursor.fetchone()
        pprint([sql, result])

        sql = "SELECT * FROM visa_filter"
        cursor.execute(sql)
        result = cursor.fetchone()
        pprint([sql, result])