# Neo4j

Neo4j is a graph databse which stores and shows data in graph data structure.  
Neo4j uses cypher language to store and retrieve data from Database.

## Crash Course

[Video Link](https://www.youtube.com/watch?v=8jNPelugC2s)

[Project](https://github.com/harblaith7/Neo4j-Crash-Course/tree/main)

## Data for initial setup

Data for initial setup can be picked from [here](https://github.com/shakeelansari63/Training/blob/master/NEO4J/initial-data.cypher)

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

### Filtering node by ID

Querying a node by ID is little different that other properties since ID in builtin field.

e.g. Following query will return a node with ID `0`.

```cypher
MATCH (n)
WHERE ID(n) = 0
RETURN n
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
| STDEV   | Standard Deviation            |

## Delete Nodes and Relationships

### Delete Nodes

We can delete a node by first searching it and then deleting it.
e.g.

```cypher
MATCH (a:SOMETYPE {someproperty: 'some value'})
DELETE a
```

But this won't delete the node if it has active relationships. This is because neo4j tries to avoid dangling relationships.

So if we want to delete a node which has active relationships, we should delete its relationships as well. And this is done with `DETACH DELETE`
e.g. Following query deletes a node for 'Ja Morant' and its relationships as well.

```cypher
MATCH (ja {name: 'Ja Morant'})
DETACh DELETE ja
```

### Delete Relationships

Deleting relationship is easy. Relationships have no dependency and hence can be deleted quickly.

e.g. Following query deletes PLAYS_FOR relationship between Joel and hit team.

```cypher
MATCH (joel {name: 'Joel Embiid'}) -[r:PLAYS_FOR]-> (:TEAM)
DELETE r
```

## Creating Nodes and Relationships

### Creating Nodes

Nodes can be created using `CREATE` keyword within `()`.  
e.g. Following query creates a node

```cypher
CREATE (:MOVIE {name: "YJHD", release: 2013})
```

Node can also be created with multiple Labels
e.g.

```cypher
CREATE (:MOVIE:WEBSERIES {name: "Bahubali"})
```

Above query only creates node, but if you want to return node after creating it, use `RETURN`.  
e.g.

```cypher
CREATE (bb:MOVIE:WEBSERIES {name: "Bahubali"})
RETURN bb
```

### Creating Nodes with Relationships

We can use the arrow syntax for creating new node with relationships.  
e.g. Following query creates 2 nodes and 1 relationship.

```cypher
CREATE (:ACTOR {name: "Prabhas"}) -[:ACTED_IN {salary: 20000000}]-> (:MOVIE {name: "Bahubali"})
```

### Creating Relationship between existing Nodes

To Create a relationship between existing notes, we will first find the nodes by match and then create relationship.  
Lets create following nodes first -

```cypher
CREATE (:MOVIE {name: "Pushpa"}),
(:ACTOR {name: "Allu Arjun"})
```

Currently these nodes are not connected. But we can connect them with following.

```cypher
MATCH (aa:ACTOR {name: "Allu Arjun"}),
(pushpa:MOVIE {name: "Pushpa"})
CREATE (aa) -[:ACTED_IN]-> (pushpa)
```

And now we have relationship between these nodes.

## Update Data

### Update Nodes

We can add new properties or update existing properties of Node using `SET` operator.

e.g. Following query will add new property release to movie Pushpa and update its name.

```cypher
MATCH (p:MOVIE {name: "Pushpa"})
SET p.release = 2020,
p.name = "Pushpa, The Rise"
RETURN p
```

We can also add new labels to node

```cypher
MATCH (p:MOVIE {name: "Pushpa, The Rise"})
SET p:HITMOVIE
RETURN p
```

### Update Relationships

Updating relationship is same as node. We match to find it and the use `SET` operator to update it.

e.g. Following query will update salary of Allu Arjun for Pushpa. Right now we don't have salary on ACTED_IN.

```cypher
MATCH (:ACTOR {name: "Allu Arjun"}) -[worked:ACTED_IN]-> (:MOVIE {name: "Pushpa, The Rise"})
SET worked.salary = 30000000
RETURN worked
```

### Delete Properties

For deleting properties use `REMOVE` operator with match.

e.g. Following query will remove release property of Pushpa Movie

```cypher
MATCH (n:MOVIE {name: "Pushpa, The Rise"})
REMOVE n.release
RETURN n
```

And we can also remove labels

```cypher
MATCH (n:MOVIE {name: "Pushpa, The Rise"})
REMOVE n:HITMOVIE
RETURN n
```
