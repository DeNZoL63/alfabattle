#!/bin/sh

rm *.jks

keytool -importkeystore -deststorepass 123456 -destkeypass 123456 -destkeystore server.jks -srckeystore server.p12 -srcstoretype PKCS12 -srcstorepass 123456 -alias server

keytool -importkeystore -deststorepass 123456 -destkeypass 123456 -destkeystore client.jks -srckeystore client.p12 -srcstoretype PKCS12 -srcstorepass 123456 -alias client

keytool -import -v -trustcacerts -keystore client_trustore.jks -storepass 123456 -alias server -file server.crt

keytool -import -v -trustcacerts -keystore server_truststore.jks -storepass 123456 -file ca.crt -alias cacrt
