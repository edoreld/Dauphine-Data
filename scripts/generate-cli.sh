#!/usr/bin/env bash

openapi-generator generate -i ${1:-http://localhost:8080/openapi.json} -g bash -o cli --skip-validate-spec