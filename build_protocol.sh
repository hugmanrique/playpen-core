#!/bin/sh
protoc -Isrc/main/proto --java_out=src/main/java src/main/proto/*.proto