## Springboot - Spring AI - Ollama local LLM - Vaadin

inspired by https://www.youtube.com/watch?v=cfm5wtgpf0k

## Run local LLM

run ollama docker container

```
docker run -d -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama
```

download and run llama3 (~4.7GB)

```
docker exec -it ollama ollama run llama3
```

other models: https://ollama.com/library

## Start App

- set env "API_KEY" (generated on docker startup - get from docker run console output)
- mvn clean install
- run SpringbootAiVaadinApplication
- open http://localhost:8080
