@echo off

echo ### Criando Chaves no AWS Parameter Store do LocalStack...
aws ssm put-parameter --name "/config/spring-boot-localstack_production/helloWorld" --value "Hello World Parameter Store" --type String
aws ssm put-parameter --name "/config/spring-boot-localstack_production/sqsQueueName" --value "sqsHelloWorld" --type String
aws ssm put-parameter --name "/config/spring-boot-localstack_production/snsNotificationName" --value "snsHelloWorld" --type String
aws ssm put-parameter --name "/config/spring-boot-localstack_production/valor1" --value "Oi Mundo" --type String
aws ssm put-parameter --name "/config/spring-boot-localstack_production/valor2" --value "Hello World" --type String
aws ssm put-parameter --name "/config/spring-boot-localstack_production/valor3" --value "Hola Mundo" --type String
aws ssm put-parameter --name "/config/spring-boot-localstack_production/s3Bucket" --value "s3-helloworld" --type String
aws ssm put-parameter --name "/config/spring-boot-localstack_production/dbUrl" --value "jdbc:mysql://localhost:3306/databasedemo?createDatabaseIfNotExist=true" --type String
aws ssm put-parameter --name "/config/spring-boot-localstack_production/dbUser" --value "admin" --type String
aws ssm put-parameter --name "/config/spring-boot-localstack_production/dbPass" --value "admin123456789" --type String

echo ### Criando Bucket no S3 do LocalStack...
aws s3 mb s3://s3-helloworld

echo ### Criando Queue(Standard) no SQS do LocalStack...
aws sqs create-queue --queue-name sqsHelloWorld

echo ### Criando Queue(Standard) no SNS do LocalStack...
aws sns create-topic --name snsHelloWorld
aws sns subscribe --topic-arn arn:aws:sns:us-east-1:566323339257:snsHelloWorld --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:566323339257:sqsHelloWorld
