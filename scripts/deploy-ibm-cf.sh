#!/usr/bin/env bash

set -xe

ibmcloud login --apikey ${1} -r eu-gb
ibmcloud target -o ${2} -s ${3}
ibmcloud cf push -f ${4}