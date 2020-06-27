#!/bin/sh

rm *.p12

openssl pkcs12 -export -in server.crt -inkey server.key -certfile ca.crt -name "Server" -out server.p12

openssl pkcs12 -export -in client.crt -inkey client.key -certfile ca.crt -name "Client" -out client.p12

