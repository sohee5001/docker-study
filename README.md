# Docker Compose

Docker란? <br>


Docker Compose : 하나의 yaml 형식의 설정파일에 여러개의 컨테이너를 정의하고 실행할 수 있다.
한번에 명령어로 컨테이너 여러개를 띄워서 애플리케이션에 올릴수 있다. 


1. Dockerfile : 애플리케이션에 필요한 환경을 정의.

2. Compose 사용하기  <br>
    - docker-compose.yml 파일에 애플리케이션에서 필요한 각 서비스들을 정의 <br>
    - 해당 yml파일을 up하면 정의된 각 서비스들은 독립된 환경에서 실행 됨.
 
3. Docker-compose.yml 파일 구조(설정) : image나 build 지시자가 반드시 있어야함.

    - image <br>  사용할 이미지의 태그나 ID 명시 . 로컬에 해당 이미지가 없으면 원격 저장소(Docker hub)에서 pull해서 가져옴.
    
    - build <br> Dockerfile이 있는 디렉토리 경로. compose가 해당 경로에 있는 Dockerfile을 빌드해서 사용함.
    
    - ports <br> 호스트포트:컨테이너포트의 형식으로 컨테이너에서 사용할 포트 지정.
    
    - container_name : 컨테이너에서 사용 할 이름 지정.
    
    - volumes <br> Data를 컨테이너가 아닌 호스트(저장할 위치,저장할 디렉토리)에 저장하는 방식.  <br>ex) 호스트 경로:컨테이너 경로
    
    - link <br> 컨테이너의 /etc/hosts에 내부 호스트 정보를 추가한다.
    
    - depends_on <br> 컨테이너가 시작되는 순서를 컨트롤함. 해당 서비스 이전에 수행해야할 서비스 설정.<br>
    
    - external_links <br> 컨테이너의 /etc/hosts에 외부 호스트정보를 추가한다. 
    
    - hostname <br> 호스트 네임을 지정. 
    
    - environment <br> 배열이나 사전형식으로 환경변수 설정. <br> 
       > 카프카 환경설정.
        - KAFKA_BROKER_ID : 카프카에는 하나의 브로커가 존재.
        - KAFKA_ZOOKEEPER_CONNECT : 연결시킬 zookeeper 
        - KAFKA_ADVERTISED_LISTENERS :  
        
    
    - extends <br> 다른 서비스를 현재 파일에 가져와 확장해서 사용. 
    
  
    


 
