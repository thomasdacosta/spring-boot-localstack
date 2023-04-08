aws --endpoint http://localhost:4566 --profile localstack cloudformation deploy --stack-name infra-s3-sqs-sns --template-file "infra-s3-sqs-sns.yml"
aws --endpoint http://localhost:4566 --profile localstack cloudformation delete-stack --stack-name infra-s3-sqs-sns
