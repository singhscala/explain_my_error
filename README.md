# Explain My Error

Explain My Error is an AI-powered debugging assistant built with Java, Spring Boot, and Spring AI. It helps developers understand Java and Spring errors by generating explanations, identifying likely causes, suggesting debugging checks, and providing practical fixes.

### Key Features
- **AI-Powered Error Analysis:** Uses an LLM through Spring AI's `ChatClient` to explain programming errors in a developer-friendly format.
- **Structured Responses:** Maps AI-generated explanations to a Java DTO containing the error type, explanation, likely cause, debugging checks, suggested fix, and relevant concepts.
- **Analysis History:** Saves error analyses to a database and provides a REST API to retrieve previous records.
- **Text Embeddings:** Uses Spring AI's `EmbeddingModel` to generate vector representations of text.

### Tech Stack
- Java
- Spring Boot
- Spring AI
- Gemini API
- REST APIs
- Maven
- Spring Data JPA

### Learning Outcomes
- Integrating an LLM into a Java backend application.
- Writing prompts for more structured AI responses.
- Mapping AI output to Java DTOs.
- Persisting AI-generated analysis.
- Understanding text embeddings and their potential use in semantic search.

### Project Goal
To make debugging easier for Java developers by turning confusing error messages into understandable explanations and actionable troubleshooting steps.
