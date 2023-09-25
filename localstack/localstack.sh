aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/spring-boot-localstack_localstack/helloWorld" --value "Hello World Parameter Store" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/spring-boot-localstack_localstack/sqsQueueName" --value "sqsHelloWorld" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/spring-boot-localstack_localstack/snsNotificationName" --value "snsHelloWorld" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/spring-boot-localstack_localstack/s3Bucket" --value "s3-helloworld" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/spring-boot-localstack_localstack/dbUrl" --value "jdbc:mysql://localhost:3306/databasedemo?createDatabaseIfNotExist=true" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/spring-boot-localstack_localstack/dbUser" --value "admin" --type String
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/spring-boot-localstack_localstack/dbPass" --value "admin123456789" --type String

aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/spring-boot-localstack_localstack --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo\",\"valor2\":\"Hello World\",\"valor3\":\"Hola Mundo\"}"
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/spring-boot-localstack --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo\",\"valor2\":\"Hello World\",\"valor3\":\"Hola Mundo\"}"
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/application --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo\",\"valor2\":\"Hello World\",\"valor3\":\"Hola Mundo\"}"
aws --endpoint http://localhost:4566 --profile localstack secretsmanager create-secret --name /secret/application_localstack --description "Exemplo de Secrets Manager" --secret-string "{\"valor1\":\"Oi Mundo\",\"valor2\":\"Hello World\",\"valor3\":\"Hola Mundo\"}"

aws --endpoint http://localhost:4566 --profile localstack s3 mb s3://s3-helloworld

aws --endpoint http://localhost:4566 --profile localstack sqs create-queue --queue-name sqsHelloWorld
aws --endpoint http://localhost:4566 --profile localstack sqs send-message --queue-url http://localhost:4566/000000000000/sqsHelloWorld --message-body "Hello World SQS!!!" --delay-seconds 1
aws --endpoint http://localhost:4566 --profile localstack sqs receive-message --queue-url http://localhost:4566/000000000000/sqsHelloWorld

aws --endpoint http://localhost:4566 --profile localstack sns create-topic --name snsHelloWorld
aws --endpoint http://localhost:4566 --profile localstack sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:snsHelloWorld --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:sqsHelloWorld
