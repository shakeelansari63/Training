# Neo4j

Neo4j is a graph databse which stores and shows data in graph data structure.  
Neo4j uses cypher language to store and retrieve data from Database.

## Data for initial setup

Data for initial setup can be picked from [here](https://github.com/harblaith7/Neo4j-Crash-Course/blob/main/01-initial-data.cypher)

## Querying Nodes

To query Data, we use `MATCH` keyword along with `RETURN`

Nodes are represented in cypher with paranthesis `()`.  
e.g. Following query will get all nodes in database

```cypher
MATCH (n)
RETURN n
```

### Query nodes with Specific type/label

If we need data of specific label, we can specify it within `(x:LABEL)`  
e.g. Following query will get data for `PLAYER` label only

```cypher
MATCH (n:PLAYER)
RETURN n
```

### Query Specific Property of nodes

If we just need some property of nodes, we can return specific properties.  
e.g. Following query return names of all players

```cypher
MATCH (n:PLAYER)
RETURN n.name
```

We can also return multiple propertties.

```cypher
MATCH (n:PLAYER)
RETURN n.name, n.age
```

We can also alias return properties

```cypher
MATCH (n:PLAYER)
RETURN n.name as player_name, n.age as player_age
```

### Filtering nodes by Properties

We can filter nodes not just by labels but also by some properties.  
e.g. Following query return players whose age is above 30

```cypher
MATCH (p:PLAYER)
WHERE p.age > 30
RETURN p
```

If we are just searching by equality, we can provide the where condition within node itself. And it will return node which match the condition.  
e.g. Following query return nodes where player's age is 33.

```cypher
MATCH (p:PLAYER {age: 33})
RETURN p
```

#### We can have following comparision operators in where

| Operation                    | Operator    |
| ---------------------------- | ----------- |
| EQUAL                        | =           |
| NOT EQUAL                    | <>          |
| GREATER THAN                 | >           |
| GREATER THAN OR EQUAL        | >=          |
| LESS THAN                    | <           |
| LESS THAN OR EQUAL           | <=          |
| String Starts with substring | STARTS WITH |
| String Ends with substring   | ENDS WITH   |
| String Contains substring    | CONTAINS    |
| Regular Expression           | =~          |

We can also have some calculations in `WHERE` clause  
e.g. Following query returns Players whose BMI [Weight in KG / (Height in Metres)^2 ].

```cypher
MATCH (p:PLAYER)
WHERE (p.weight / (p.height * p.height)) > 25
RETURN p
```

#### We can also combine checks with `AND` and `OR`

e.g. Following query returns players whose weight is greater than 100kg and height is less than 2m.

```cypher
MATCH (p:PLAYER)
WHERE p.weight >= 100 AND p.height <= 2
RETURN p
```

#### We can also have logical `NOT` to flip some conditions

e.g. Following query returns players whose weight is not greater than 100kg and height is not less than 2m.

```cypher
MATCH (p:PLAYER)
WHERE NOT (p.weight >= 100 AND p.height <= 2)
RETURN p
```

### Skip and Limit the number of records

If we want to streap data page wise, we can utilize `SKIP` and `LIMIT` to limit the return size.

|           |                            |
| --------- | -------------------------- |
| **LIMIT** | Limit the Output rows to x |
| **SKIP**  | Skips top x rows           |

e.g. Following Query retunrn only first 3 players

```cypher
MATCH (p:PLAYER)
RETURN p
LIMIT 3
```

And following query will skip above 3 abd show next 3.

```cypher
MATCH (p:PLAYER)
RETURN p
SKIP 3
LIMIT 3
```

### Data Ordering

We can also order the returned data rows using `ORDER BY`
e.g. Following Query will return players in descending order of their height. So tallest player will be first and shortest will be last.

```cypher
MATCH (p:PLAYER)
RETURN p
ORDER BY p.height DESC
```

note: You won't see any difference in Neo4j's Graph visualization. But in table we can see difference.

#### Data Order

| Orering    | Key  |
| ---------- | ---- |
| Ascending  | ASC  |
| Descending | DESC |

### Querying Multiple Nodes

We can query multiple nodes. Since relationship is already defined in Neo4j, we don't have to join or anything. And along with querying multiple nodes, we can filter on multiple nodes as well
e.g. Following query returns Players and Coaches where players are taller than 2m and coaches name starts with 's'.

```cypher
MATCH (p:PLAYER), (c:COACH)
WHERE p.height >= 2.1 AND c.name STARTS WITH 'S'
RETURN p, c
```

## Querying Relationships

The relationship can be shown with arrow and box `-[:RELATION]->`.  
The arrow head can go any side, but make sure the relationship direction is correct.  
e.g. Following query returns all players which plays for LA Lakers.

```cypher
MATCH (p:PLAYER) -[r:PLAYS_FOR]-> (t:TEAM)
WHERE t.name = 'LA Lakers'
RETURN p
```

Above query can also be written with other arrow head if we switch node places.  
like -

```cypher
MATCH (t:TEAM) <-[r:PLAYS_FOR]- (p:PLAYER)
WHERE t.name = 'LA Lakers'
RETURN p
```

And we can also include th team in the above graph.

```cypher
MATCH (t:TEAM) <-[r:PLAYS_FOR]- (p:PLAYER)
WHERE t.name = 'LA Lakers'
RETURN p, t
```

### Filter on Relationship

In Neo4j like Node, relation can also have property which can be used for filter.  
e.g. Following query returns players whose salary is greater than $35M. You will notice player does not have salary propery. Salary property us stored on PLAYS_FOR relationship.

```
MATCH (p:PLAYER) -[contract:PLAYS_FOR]-> (t:TEAM)
WHERE contract.salary >= 35000000
RETURN p, t
```

### Subqueries with relationships

We can have multiple matches in a query which can act as subqueries.  
e.g. Following query returns players who are "LeBron James'" teammates and take salary more than $35M.

```cypher
MATCH (lebron:PLAYER {name: 'LeBron James'}) -[:TEAMMATES]-> (p:PLAYER)
MATCH (p) -[contract:PLAYS_FOR]-> (t:TEAM)
WHERE contract.salary >= 35000000
RETURN lebron, p, t
```

## Data Agregation

Along with selecting some nodes, we can also aggregate some data.  
We have a PLAYED_AGAINST relation between teams and players which has some properties. We aggreagte the data there.  
e.g. Following query returns each player and average point for their each game.

```cypher
MATCH (p:PLAYER) -[game:PLAYED_AGAINST]-> (:TEAM)
RETURN p.name, COUNT(game) AS games_playes, AVG(game.points) AS avg_points_per_game
```

#### There are many agregation methods which can be used

| Methods | Usage                         |
| ------- | ----------------------------- |
| AVG     | Average                       |
| COUNT   | Count                         |
| SUM     | Sum all                       |
| MAX     | Maximum                       |
| MIN     | Minimum                       |
| COLLECT | Collect values in single list |
| STDEV   | Standard Ddeviation           |
