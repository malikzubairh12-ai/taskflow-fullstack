# TaskFlow API Examples

Create task:

```bash
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Apply at SAP","description":"Send CV and GitHub link","status":"TODO","priority":"HIGH","dueDate":"2026-06-10"}'
```

Get all tasks:

```bash
curl http://localhost:8080/api/tasks
```

Search:

```bash
curl "http://localhost:8080/api/tasks/search?title=Spring"
```

Statistics:

```bash
curl http://localhost:8080/api/tasks/stats
```
