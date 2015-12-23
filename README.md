# hackdfw-backend

The backend to HackDFW, written in Scala.

## Building

First, you need Scala and SBT installed. Then, run the following command:

```
sbt compile stage
```

This produces a binary that can be run like so:

```
target/universal/stage/bin/hackdfw-backend
```

## Developing

Run the following command to test the server locally:

```
sbt run
```

## License

ISC
