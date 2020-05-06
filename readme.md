### Microservices "igual" Spotify usando Spring Cloud e Kafka
##### Criando microservices com Spring Boot, Spring Cloud, Apache Kafka e Cassandra, microservicos Async.

- Rodar os docker-compose que estão na paste ./docker;

- Criar os tópicos abaixo: <br/>
`customer-request-topic`
`customer-reply-topic`
`request-topic-music`
`reply-topic-music`
`topic-music-status`
`request-topic-music-upload`
`reply-topic-music-listener`
`request-topic-music-listener`
<br/>

- Entrar no container de banco cassandra e executar os comandos abaixo: <br/><br/>
docker exec -it `id do container`  /bin/bash
<br/>
cqlsh -u cassandra -p cassandra
<br/>
create keyspace if not exists customer_keyspace with replication = {'class': 'NetworkTopologyStrategy', 'datacenter1': 3};
<br/>
use customer_keyspace;
<br/>
create table customer (id UUID primary key, name text, country text, musicStyle text);
<br/>
create keyspace if not exists music_keyspace with replication = {'class': 'NetworkTopologyStrategy', 'datacenter1': 3};
<br/>
use music_keyspace;
<br/>
create table music (id UUID primary key, name text, path text, status text, uuidCustomer text, size int);