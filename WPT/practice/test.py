# write a code to join to mysql database
def conn():
    import MySQLdb as mdb
    db = mdb.connect("localhost","root","password","mydatabase")
    return db
# function to insert data into the table
def insert_data():
    db = conn()
    cursor = db.cursor()
    cursor.execute("INSERT INTO mytable (name, age) VALUES ('John', 20)")
    db.commit()
    db.close()
# function to read data from the table
def read_data():
    db = conn()
    cursor = db.cursor()
    cursor.execute("SELECT * FROM mytable")
    data = cursor.fetchall()
    print data
    db.close()
# function to update data in the table
def update_data():
    db = conn()
    cursor = db.cursor()
    cursor.execute("UPDATE mytable SET age = 30 WHERE name = 'John'")
    db.commit()
    db.close()
# function to delete data from the table
def delete_data():
    db = conn()
    cursor = db.cursor()
    cursor.execute("DELETE FROM mytable WHERE name = 'John'")
    db.commit()
    db.close()