# How to answer 

Please do not fork the repository and do not do pull request

Follow this path

* clone the repository
* write your answer
* send us a link to your repository


# Dependancies

We really like functionnal programming that's why we use [vavr](https://www.vavr.io/) in the test
We only use a fraction of it

* [List](https://docs.vavr.io/#_list)
* [Option](https://docs.vavr.io/#_option)
* [Tuple](https://docs.vavr.io/#_tuples)

# How to run

We're a scala shop so this is how we will run the code
This is not mandatory for the test, you can use maven / graddle / other...

* git clone
* install [sbt](https://www.scala-sbt.org/)
* run this command

```
cd /some_path/java-interview
sbt clean update compile
sbt test
```
