# Docker

Docker란? <br>
* 도커는 컨테이너(격리된 공간에서 프로세스가 동작하는 기술) 기반의 오픈소스 가상화 플랫폼 <br>
* 다양한 프로그램, 실행환경을 컨테이너로 추상화하고 동일한 인터페이스를 제공하여 프로그램의 배포 및 관리를 단순하게 해준다. 
* 백엔드 프로그램, 데이터베이스 서버, 메시지 큐등 어떤 프로그램도 컨테이너로 추상화할 수 있고 조립PC, AWS, Azure, Google cloud등 어디에서든 실행할 수 있다.

 * console 명령어  
    1. docker 목록 확인 <br>
     
         docker ps <옵션>
      
            * -a : 모든 컨테이너 출력.
            * -q : 컨테이너 ID만 출력.  
            * -l 가장 최근 컨테이너 정보 출력.
       
    2. docker 컨테이너 생성 및 실행 <br>
    
         docker run -i -t -v /var/run/docker.sock:/var/run/docker.sock  -p 9001:9000  --name portainer  이미지이름
         
                     * -i : 컨테이너와 상호적으로 주고받겠다라는 의미
                     * -t : tty(터미널과 비슷한 환경)를 사용하겠다는 의미.
                     * --volume, -v : 호스트 OS의 디렉토리와 컨테이너 내부 디렉토리의 공유. ex) 호스트 OS의 디렉토리:컨테이너 내부 디렉토리  
                     * -p : 외부에서 접근하려할때 필요한 필수 조건. 컨테이너 포트를 호스트 포트로 연결해주는것. 
                            ex) 호스트 port:컨테이너 port  : 컨테이너에도 일반 머신과 동일하게 포트 0번부터 65535번까지의 포트를 가지고 있음.
                                                             -p 9001:9000이면 외부에서 호스트의 9001번 포트로 접속하면 9001번 포트는 9000포트와 연결되어 있기에 컨테이너의 9000포트와 연결된다.
                     * -expose : -p는 포트 개방후 호스트 포트와 연결해주지만 -expose는 포트만 개방해주기에 읽기만 가능.
                     * --name : 해당 컨테이너의 이름 지정.
                     * -c : --cpu-share라고 쓰이는 옵션. cpu 스케쥴링에서 컨테이너가 얼마나 많은 부분을 차지할지 정함. default 1024
                     * -m : 메모리 제한.
                       
    3.  docker 컨테이너의 shell 접속 <br>
          
         docker exec -i -t <컨테이너ID or 컨테이너name> bash           
     
    4. docker 컨테이너 중지 및 제거 <br>  

         - 실행중인 컨테이너 중지 : docker stop <컨테이너ID or 컨테이너name> , docker kill <컨테이너ID or 컨테이너name> 
         
         - 컨테이너 제거 : docker rm -f <컨테이너ID or 컨테이너name> 
                          
                  
     > 참고 자료 <br> 
      - [container 포트와 host 포트의 개념](https://blog.naver.com/alice_k106/220278762795) <br>