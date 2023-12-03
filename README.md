# Project Please Back-end

This repository contains the back-end services for Project Please, an application to help foreigners to easily find their jobs improving accessibility.

- The back-end uses Spring and Python/Flask.
- CI/CD pipelines automate Docker image builds and deployment upon commits to `main` branch
- Multi-container Docker environments used for both development and production
- Hosted on AWS EC2 at [kdt-please.store](http://kdt-please.store/swagger-ui/index.html)

## Architecture

- `spring-service`: Core back-end logic written in Java Spring
- `python-service`: Additional Python microservice for supplemental features
- MySQL database
- Nginx as reverse proxy between the services

## CI/CD

GitHub Actions workflows, defined under `.github/workflows` handle:

- Unit testing and integration testing
- Building Docker images
- Pushing images to DockerHub
- Deploying image updates to production AWS EC2 cluster

GitHub Actions runs these automations on every commit to `main` branch.

## Local Development

### Prerequisites

- Docker and Docker Compose

Clone the repository:

```bash
git clone https://github.com/KDT-BokJob/project-please-back.git
```

Start the dev environment:

```bash
docker-compose up --build
```

This launches both Spring and Python dev containers with file syncing to allow code changes without rebuild.

## Production

The production stack on [kdt-please.store](http://kdt-please.store/swagger-ui/index.html) runs the multi-container Docker environment defined under `docker-compose.yml`.

## More Documentation

- [Public Notion page](https://www.notion.so/K-DT-1a46b10690ce4d9299c8ddf0f5379439)
- [API documentation](http://kdt-please.store/swagger-ui/index.html#/)
