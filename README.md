Catalog Management System

**Entities**

_Book_
id
name
code
count
authorName

_Scholar_
id
name
mobile

_Order_
id
scholarId
bookId
dateOfOrder
expectedReturnDate
actualReturnDate

**Issues**

1. Generic BaseEntity not working.
If Relation b/w two tables used simply without any field defination of mapping annotations,then new mapping table won't store the 
relationship automatically)

**Learning**

1. In Bi-Directional relation, nested objects trails are generated in response object. Use _@JsonIgnore_ annotation the field which 
   needs to be ignored.
2. In relation-mapping, parent entity cannot be deleted unless child entity is deleted, Use _cascade_ attribute in parent side of 
   relation.