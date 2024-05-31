## Neo4j

Neo4j is a graph databse which stores and shows data in graph data structure.  
Neo4j uses cypher language to store and retrieve data from Database.

### Querying Data

To query Data, we use `MATCH` keyword along with `RETURN`

#### Query Nodes

Nodes are represented in cypher with paranthesis `()`.
e.g. Following query will get all nodes in database

```cypher
MATCH (n)
RETURN n
```
