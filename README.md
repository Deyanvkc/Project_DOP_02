# MyMarvinBootstrap

Epitech DevOps project: configure a Jenkins instance as code with JCasC and Job DSL.

## Local setup

1. Copy the environment template:

```bash
cp .env.example .env
```

2. Replace every placeholder password in `.env` with local values.
3. Start Jenkins:

```bash
docker compose up --build
```

The JCasC file reads Jenkins user passwords from environment variables. `.env` is intentionally ignored and must never be committed; `.env.example` contains only non-sensitive placeholders.
