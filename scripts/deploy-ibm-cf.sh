#!/usr/bin/env bash

ibmcloud login --api-key ${1} -r eu-gb
ibmcloud target -o ${2} -s ${3}
ibmcloud cf push -f ${4}