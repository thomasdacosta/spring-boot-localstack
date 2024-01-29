@echo off

echo ### Criando Queue(Standard) no SQS do LocalStack...
aws sqs create-queue --queue-name sqsHelloWorld

echo ### Criando Queue(Standard) no SNS do LocalStack...
aws sns create-topic --name snsHelloWorld
aws sns subscribe --topic-arn arn:aws:sns:us-east-1:566323339257:snsHelloWorld --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:566323339257:sqsHelloWorld
