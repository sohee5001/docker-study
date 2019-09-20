# KAFKA란?

  LinkedIn에서 개발된 분산 메시징 시스템. 오픈소스. 
  
    - Producer : topic에 메시지를 생성한뒤 해당 메시지를 broker에 전달.
    - Consumer : topic별로 분류해서 쌓아놓아진 메시지들을 가져가서 처리함. 
    - broker  : topic을 기준으로 메시지를 관리.
 
 * kafka 특징.
    - broker들이 클러스터로 구성되어 동작하기 때문에 확장성과 고가용성.
    - broker가 1개밖에 없어도 클러스터는 동작.
    - topic은 partition이라는 단위로 쪼개져 클러스터의 각 서버들에 분산되어 저장됨.
    
 * Partition 복제    
    - partition복제는 단일 클러스터에서만 가능.
    
    
  * offset : 메시지의 상대적인 위치. Consumer가 죽었다가 다시 살아나도 마지막으로 읽었던 위치부터 다시 읽어들임.
  
    
  -
  * console 명령어  
    1. topic 리스트 확인 <br>
     => ./kafka-topics --zookeeper 쥬키퍼 호스트 네임:쥬키퍼port --list
        ![topic-list](./image/topic-list.png)
       topic 목록을 보면 4개의 토픽들(test-kafka,test-kafka2,test-kafka3,test1)이 존재한다.
       
    2. topic 생성 <br>
     => ./kafka-topics --zookeeper 쥬키퍼 호스트 네임:쥬키퍼port --topic  testA(추가할 토픽명) --partition 3(파티션수) --replication-factor 3(복제수) --create
        ![topic-list](./image/topic-create.png)
              
    3. topic 상세 보기 <br>  
     => ./kafka-topics --zookeeper 쥬키퍼 호스트 네임:쥬키퍼port --topic  testA(추가할 토픽명) --describe
        ![topic-list](./image/topic-describe.png)
                 
    4. console producer로 메시지 보내기  
     => ./kafka-topics --zookeeper 쥬키퍼 호스트 네임:쥬키퍼port --topic  testA(추가할 토픽명) --partition 3(파티션수) --replication-factor 3(복제수) --create
        ![topic-list](./image/topic-describe.png)             
                
    5. console consumer로 메시지 사용하기
    
 
 -    
 * 환경 설정 
   - 주키퍼는 카프가의 노드관리를 해주고 토픽의 offset정보등을 저장하기 위해 필요. 주키퍼가 죽으면 카프카도 죽는다. 
   주키퍼는 과반수 투표방식으로 결정하기 떄문에 홀수로 구성해야하고, 과반수 이상 살아있으면 정상 동작한다.
   
   - 카프카는 과반수 투표방식을 사용하지 않지만 , Replication Factor를 3으로 할 경우 균일하게 분배하기 위해서 노드 수는 최소 3으로 해야한다.
   (__consumer_offsets 토픽은 기본값이 RF3)     
   
   
 -
 * leader & fllower
   - rabbitmq : 복제본 2개시. 하나는 master 나머지는 mirrored
   - kafka : 복제본 2개시. 하나는 leader 나머지는 follower(leader와 동일한 데이터 내용을 유지하기 위해 짧은 주기로 leader로 부터 데이터를 가져옴)<br>
   
        ![topic-list](./image/ISR.png)  
        
        1. topic 별로 복제본의 갯수를 지정 가능.
        2. topic으로 통하는 모든 데이터의 read/write는 오직 leader에서 이뤄짐.
        3. leader가 있는 broker가 죽으면 . follower중에 리더가 된다.
        