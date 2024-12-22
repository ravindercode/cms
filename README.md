Catalog Management System

Entity

**Book**
id
name
code
count
authorName

**Scholar**
id
name
mobile

**Order**
id
scholarId
bookId
dateOfOrder
expectedReturnDate
actualReturnDate

**Issues**
Generic BaseEntity not working
If Relation b/w two tables used simply(Without any field defination of mapping annotations,then mapping table won't store the 
relationship automatically)