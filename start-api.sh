#!/bin/bash
orbd -ORBInitialPort 900 -ORBInitialHost 0.0.0.0 &
sleep 10
catalina.sh run
