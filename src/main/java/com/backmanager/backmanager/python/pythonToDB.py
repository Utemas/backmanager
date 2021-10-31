import cx_Oracle
connect = cx_Oracle.connect('scott','tiger','localhost/orcl')

cursor = connect.cursor()

sql = 'select * from emp'

cursor.execute(sql)

for result in cursor:
    print(result)

cursor.close()

connect.close()