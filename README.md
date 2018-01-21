# Reactive Machine Learning Systems
Repository of code following the Manning book
[Reactive Machine Learning Systems](https://www.manning.com/books/reactive-machine-learning-systems)
by Jeff Smith

## Prerequisites
* Scala
* Docker
* Docker Compose

## Deviations from book

Cassandra is used as the fact database instead of Couchbase

## Supporting Infrastructure

Docker Compose is used to provide a single node cassandra database cluster.
Run the following from the root of the project to start the servers

```
docker-compose up
```

## Tests

Tests built with [ScalaTest](http://www.scalatest.org/) You can run from sbt.
From the root of the project run

```
sbt test
```







