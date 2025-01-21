TableDesign:
Error:IllegalArgumentException: Result Maps collection does not contain value for cn.itedus.lottery.infrastructure.dao.IActivityDao.activityMap
原因：在mapper.xml文件中 将resultType 和resultMap 混淆

Strategy:
Error：Drawbase：if(1!=strategyMode) return;https://gitcode.net/KnowledgePlanet/Lottery/-/issues/177
原因：单项概率元组未初始化

Award:
数据库字段和infrastructure.po要对应
Error:org.springframework.dao.DataIntegrityViolationException: Error attempting to get column 'award_name' from result set. 
Cause: java.sql.SQLDataException: Cannot determine value type from string 'AirPods'
原因：用lombok自动生成的无参构造，要写全，尤其是 @NoArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
https://blog.csdn.net/m0_37822085/article/details/125894706

Error：显示找不到bean
原因：Goods 没有使用 @Component 注解注册到 bean 中

Activity:
Error:org.springframework.transaction.CannotCreateTransactionException: Could not open JDBC Connection for transaction; nested exception is java.sql.SQLNonTransientConnectionException: Public Key Retrieval is not allowed
原因：从 MySQL 8.0 开始，默认的身份验证插件变更为 caching_sha2_password，这可能导致 JDBC 驱动在尝试连接时需要检索公共密钥：jdbc:mysql://hostname:port/dbname?useSSL=false&allowPublicKeyRetrieval=true

DRoutor
Error： mini-db-router:DataSourceBeanCreationException: Failed to determine a suitable driver class
解决方案：pom.xml加:
<artifactId>spring-boot-configuration-processor</artifactId>
<artifactId>spring-boot-autoconfigure</artifactId>
<artifactId>spring-boot-starter-aop</artifactId>

IUserTakeActivityDao忘记加 @Mapper
queryUserStrategyExportByuId在Mapper.xml里面也要改函数名
数据库路由有bug，tbIdx要+1
jar安装到maven方法
mvn install:install-file -Dfile=/Users/Luopc/Documents/Development/MyJava/db-router-spring-boot-starter/target/db-router-spring-boot-starter-1.0.4.jar -DgroupId=cn.bugstack.middleware -DartifactId=db-router-spring-boot-starter -Dversion=1.0.1-SNAPSHOT -Dpackaging=jar



消息队列：Kafka3.0不需要zookeeper
https://blog.csdn.net/qq_30166123/article/details/89705385
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
    <version>2.8.0</version>
</dependency>

同一个名字可能是不同的包import的时候注意

Kafka命令：
docker exec -it kafka /bin/bash
cd opt/bitnami/kafka/bin/
查看topic：kafka-topics.sh --bootstrap-server localhost:9092 --describe
创建topic：kafka-topics.sh --bootstrap-server localhost:9092 --create --partitions 1 --replication-factor 1 --topic hello-kafka
删除topic：kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic hello-kafka
创建生产者: kafka-console-producer.sh --broker-list localhost:9092 --topic Hello-Kafka
创建消费者: kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Hello-Kafka --from-beginning