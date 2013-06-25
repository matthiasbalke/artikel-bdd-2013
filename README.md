BDD Artikel 2013
================
[![Build Status](https://travis-ci.org/matthiasbalke/artikel-bdd-2013.png?branch=master)](https://travis-ci.org/matthiasbalke/artikel-bdd-2013)

Example project for the article "Behavior Driven Development" by [Matthias Balke](mailto:matthias.balke@adesso.de) and [Sebastian Laag](mailto:sebastian.laag@adesso.de)

Overview
---------

This is a test project to demonstrate how JBehave can be used in a java project context.

Execute example tests
---------------------

The prepared tests can be run from either command line (maven) or IDE (Eclipse/JUnit). To run the tests from command line using maven execute:
```
mvn clean integration-test
```

To run them from within Eclipse execute the *\*Stories* files located in *src/test/java*. The method *stepsFactory()* defines which tests will be executed.

Note: Some systems like Windows or Mac OS X have an default file encoding other than UTF-8. On this systems the execution from command line may fail. This can be fixed by changing the default file encoding temporarily. For Windows system check out the runTests.bat:
*Windows:*
```bat
:: set the file encoding temporarily to UTF-8
set JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF8"
:: and execute the tests
mvn clean integration-test
```

*Mac OS X/Linux/Unix:*
```bash
#!/bin/bash
# sets the default platform encoding temporary to utf-8
export JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF8"
# and execute the tests
mvn clean integration-test
```

Jenkins Job Configuration
---------

To use the Jenkins job configuration which can be found in this repository, you have to change username and password in the git scm url.

The following plugins are necessary to use it:

* Git Plugin: https://wiki.jenkins-ci.org/display/JENKINS/Git+Plugin
* xUnit Plugin: https://wiki.jenkins-ci.org/display/JENKINS/xUnit+Plugin
* JBehave Hudson plugin: http://jbehave.org/reference/stable/hudson-plugin.html

Requirements
------------

* Maven 3.x.x
* Java 1.6
