#!/usr/bin/env bash

set -ex

openapi_route=${1:-http://localhost:8080/openapi.json}
host=$(dirname ${openapi_route})

rm -rf cli
openapi-generator generate -i ${openapi_route} -g bash -o cli #--skip-validate-spec
sed -i 's@host=""@host='${host}'@g' cli/client.sh
chmod +x cli/client.sh
