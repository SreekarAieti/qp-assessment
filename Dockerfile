FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/GroceryBooking.jar /app/GroceryBooking.jar
EXPOSE 8001
CMD ["java", "-jar", "GroceryBookingApp.jar"]
