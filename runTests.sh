#!/bin/bash
#
# sets the default platform encoding temporary to utf-8
#
export JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF8"
mvn clean integration-test
