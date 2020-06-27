#!/bin/sh
echo "Cleaning up keys"
rm ca.* server.* client.* serial certindex.txt* *.pem

echo '0001' > serial
touch certindex.txt

echo "Generating CA"
openssl req -new -x509 -extensions v3_ca -keyout ca.key -out ca.crt -days 365 -config openssl.conf

echo "Generating server key"
openssl req -new -nodes -out server.req -keyout server.key -days 365 -config openssl.conf

openssl ca -out server.crt -days 365 -extensions v3_ca -config openssl.conf -infiles server.req

echo "Generating client key"
openssl req -new -nodes -out client.req -keyout client.key -days 365 -config openssl.conf

openssl ca -out client.crt -days 365 -extensions v3_ca -config openssl.conf -infiles client.req
