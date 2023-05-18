# Impact-Take-Home

## Instructions 
-  Implement code which has the ability to produce a comma delimited list of numbers, grouping the numbers into a range when they are sequential. 

- Implement the NumberRangeSummarizer Interface to produce a comma delimited list of numbers, grouping the numbers into a range when they are sequential.
```
    Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31
    Result: "1, 3, 6-8, 12-15, 21-24, 31"

    The code will be evaluated on
    - functionality
    - style
    - robustness
    - best practices
    - unit tests
```

## Installation and Use of JUnit

Download the latest version of JUnit here : <https://github.com/junit-team/junit4/wiki/Download-and-Install>
(I place mine in ~/java/ for this example)

Add the following lines to terminal conf. file (~/.zshrc)
`export JUNIT_HOME="$HOME/java"`
`export PATH="$PATH:$JUNIT_HOME"`
`export CLASSPATH="$CLASSPATH:$JUNIT_HOME/junit-4.12.jar:$JUNIT_HOME/hamcrest-core-1.3.jar"`

Alias junit in zshrc: `alias junit="java org.junit.runner.JUnitCore"`

You can now run JUnit tests: `junit YourTestClass`