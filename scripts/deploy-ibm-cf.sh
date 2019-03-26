#!/usr/bin/env bash

set -x

ibmcloud target -o ${2} -s ${3}
ibmcloud login --api-key ${1} -r eu-gb
ibmcloud cf push -f ${4}