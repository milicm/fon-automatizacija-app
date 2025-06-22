# Deploying Spring Boot Application with GitHub Actions

This repository contains a GitHub Actions pipeline to build, package, and deploy a Spring Boot application to Amazon ECS.

## Prerequisites

1. **AWS Setup**:
    - Ensure you have an ECS cluster, service, and task definition created in AWS (https://github.com/UrosVesic/fon-automatizacija-infra).
    - Store the following secrets in your GitHub repository:
        - `AWS_ACCESS_KEY_ID`
        - `AWS_SECRET_ACCESS_KEY`
    - Adapt `AWS_ACCOUNT_ID` and `AWS_REGION` in the workflow file to match your AWS account and region.

2. **Docker**:
    - Ensure your ECS task definition is configured to use a container image from Amazon ECR.

3. **Java and Maven**:
    - The project uses Java 17 and Maven for building the application.

## Workflow Overview

The pipeline consists of two jobs:
1. **Build**:
    - Checks out the source code.
    - Sets up Java 17.
    - Builds the project using Maven and skips tests.
    - Uploads the build artifact.

2. **Deploy**:
    - Downloads the build artifact.
    - Logs in to Amazon ECR.
    - Builds and pushes the Docker image to Amazon ECR.
    - Updates the ECS task definition with the new image.
    - Deploys the updated task definition to the ECS service.

## How to Trigger the Workflow

1. **On Push**:
    - The workflow is triggered automatically when changes are pushed to the `main` branch.

2. **Manual Trigger**:
    - You can manually trigger the workflow using the `workflow_dispatch` event in the GitHub Actions UI.

## Steps to Use

1. Clone this repository and configure your AWS ECS cluster, service, and task definition.
2. Add the required AWS secrets (`AWS_ACCESS_KEY_ID` and `AWS_SECRET_ACCESS_KEY`) to your GitHub repository.
3. Adapt AWS_ACCOUNT_ID and AWS_REGION in the workflow file to match your AWS account and region.
4. Push your changes to the `main` branch or trigger the workflow manually.
5. Monitor the pipeline in the GitHub Actions tab to ensure successful deployment.

## Notes

- The pipeline uses the `temurin` distribution of Java 17.
- Docker images are tagged with the commit SHA and `latest` for versioning.
- Ensure your ECS task definition includes a container named `fon-automatizacija-container`.