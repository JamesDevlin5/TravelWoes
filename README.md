
# CS 3000 Programming Challenge: Travel Woes

[URL](http://hr.gs/CS3000Spring2019)

## Input

Lines of String to **STDIN**:

* [*The number of cities total*] [*The number of flight routes total*]
* [*src*] [*dst*] [*cost*]
* *...*
* [*origin*] [*target*]

## Output

To **STDOUT**, the minimum cost to travel from the origin to the target using the flights listed, or -1 if there is no possible route.

## Constraints

An efficient algorithm for this problem should run in **O((|*cities*| + |*flights*|) \* log|*cities*|)** time.
**Do not** import, include, or use any additional libraries that are not already defined and provided by the head, except Scanner to read input.
Additionally, it is given that the following rules will be followed on input:

    * 1 <= |cities|                 <= 50000
    * 1 <= |flights|                <= 600000
    * 1 <= origin, src, dst, target <= |cities|
    * 1 <= target                   <= 5000