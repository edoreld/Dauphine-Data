#!/usr/bin/env bash

set -ex

openapi_route=${1:-https://dauphine-open-datas2.eu-gb.mybluemix.net/openapi.json}
host=$(dirname ${openapi_route})

rm -rf cli
openapi-generator generate -i ${openapi_route} -g bash -o cli #--skip-validate-spec
sed -i 's@host=""@host='${host}'@g' cli/client.sh
sed -i 's@header_content_type=""@header_content_type=application/json@g' cli/client.sh
sed -i $'s@curl_arguments=""@curl_arguments="--fail ${DOD_TOKEN:+"-H \'Authorization: Bearer $DOD_TOKEN\'"}"@g' cli/client.sh


chmod +x cli/client.sh
