# Use official OpenJDK runtime as a base image
FROM eclipse-temurin:20-jre-alpine

# Create non-root user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Set working directory
WORKDIR /app

# Copy source files
COPY --chown=appuser:appgroup target/employee-1.0.jar /app/employee-1.0.jar

# Expose default Spring Boot port
EXPOSE 9000

USER appuser

# Run the Spring Boot application
# JVM optimizations for containers
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75", "-jar", "employee-1.0.jar"]
#ENTRYPOINT ["java","-jar","employee-1.0.jar"]
