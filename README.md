# Sample test for using different configuration files

There are 3 configuration files under `api`:

- application.conf
- test.conf
- test-int.conf

`build.sbt` defines unit tests and integration tests.

There are 2 test classes:

- SomeTestSpec
- SomeTestISpec

To run test in sbt:

- unit test (SomeTestSpec):

```
test
```

- integration test (SomeTestISpec):

```
test-int:test
```
