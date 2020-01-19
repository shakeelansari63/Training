# Heap Representation
### Array
index | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
------|---|---|---|---|---|---|---|---|---|---
data  | 15 | 10 | 9 | 11 | 2 | 7 | 21 | 67 | 12 | 32

### Heap will be represented

![Alt text](https://g.gravizo.com/svg?
  digraph G {
    aize ="4,4";
    main [shape=box];
    main -> parse [weight=8];
    parse -> execute;
    main -> init [style=dotted];
    main -> cleanup;
    execute -> { make_string; printf}
    init -> make_string;
    edge [color=red];
    main -> printf [style=bold,label="100 times"];
    make_string [label="make a string"];
    node [shape=box,style=filled,color=".7 .3 1.0"];
    execute -> compare;
  }
)

![](https://g.gravizo.com/svg?
digraph G {
   15 -> 10;
   15 -> 9;
   10 -> 11;
   10 -> 2;
   9 -> 7;
   9 -> 21;
   11 -> 67;
   11 -> 12;
   2 -> 32;
 }
)
