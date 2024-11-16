# WikiMedia-Kafka

## Overview
WikiMedia-Kafka is a Spring Boot application designed to produce and consume real-time Wikimedia event data. The application leverages Kafka for message streaming, enabling efficient processing and storage of Wikimedia's live update streams.<br> **Note: You need kafka to run this application**


## Features
- **Real-time Event Streaming**: Consumes Wikimedia's live update stream.
- **Kafka Integration**: Produces and consumes events using Apache Kafka.
- **Data Persistence**: Stores event data in a relational database using JPA.
- **Configurable Kafka Topics**: Easily set up Kafka topics via application properties.

## Technologies Used
- **Spring Boot**: Backend framework.
- **Kafka**: Message broker for event streaming.
- **Spring Data JPA**: ORM for database interaction.
- **MySQL**: Database for storing event data.
  
## Endpoints
- Producer Start: The producer automatically streams data from Wikimedia.
- Consumer Listener: Listens to Kafka topics and persists data to the database.

## Data Persistence
- All consumed Wikimedia event data is stored in a MySQL database.

#### **MySQL Table: wiki_media**

| Column Name     | Type                   | Description                                       |
| :---:           | :---:                  | :---:                                             |
| id              | BIGINT (Primary Key)   | Auto-generated unique identifier.                 |
| wiki_event_data | TEXT                   | JSON or raw string data of the Wikimedia event.   |


## Run Kafka ( Default port number: 9092 )
- Start Zookeeper: Open a terminal and run the following command: `bin/zookeeper-server-start.sh config/zookeeper.properties` 
- Start Kafka Server: `bin/kafka-server-start.sh config/server.properties`
- Consume message: `bin/kafka-console-consumer.sh --topic {topic-name} --from-beginning --bootstrap-server localhost:9092`

## ScreenShots: 
#### Producing Wikimedia Event Data
<img width="1398" alt="image" src="https://github.com/user-attachments/assets/6d01ed30-8722-4db5-a73b-bcf4aae6dd95">

#### Consuming Wikimedia Event Data
<img width="1361" alt="image" src="https://github.com/user-attachments/assets/3a94696b-4180-481c-a409-a5a0e56ce409">

#### Storing Event Data in MySQL
<img width="1512" alt="image" src="https://github.com/user-attachments/assets/987edb70-956d-4f63-a659-fa28546d142c">



# Credits
**This project was created by Yash Mehta 🚀**
