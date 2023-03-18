#!/bin/bash
nohup /usr/bin/java -jar -Dspring.profiles.active=production /home/ec2-user/spring-boot-localstack/spring-boot-localstack.jar &