# Yeetcode

yeetcode is a clone of leetcode (https://leetcode.com/) created for the sake of learning.

## Prequisites:
- docker

## Getting started
1. start postgres database: `docker compose up`
2. assuming you're using IntelliJ build and start the application

### REST API
#### Problems
| Endpoint             | Security    |
|----------------------|-------------|
| /GET problems        | no          |
| /POST problem        | yes (ADMIN) |
| /DELETE problem/{id} | yes (ADMIN) |