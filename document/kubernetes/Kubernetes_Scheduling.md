# kubernetes Scheduling

 <yml 예시>
                            
        apiVersion: apps/v1
        kind: 위에 참고.
        metadata:
            name: uid과 함께 해당 오브젝트에 대한 고유 식별키값이 된다. 
            namespace: 논리적으로 포드들을 그룹화해서 관리할건데 그에 대한 네이밍을 정의한다.
            labels:
                키값 : 벨류값      포드를 라벨로 묶어서 관리.
            resourceVersion : 기본 데이터베이스에 저장된 해당 리소스의 버전을 나타내는 필드.
            selfLink: url 주소값
            uid : 쿠버네티스 오브젝트는 name, uid으로 식별된다.
       
        spec:
            podManagementPolicy: OrderedReady   # 기동 순서 조작. statefulset일경우에만 설정 가능. -> 1.OrderedReady(default) : pod를 생성하면 순차적으로 기동되고 순차적(역순)으로 삭제된다. 2. Parallel : 병렬로 동시에 모든 pod를 기동 및 삭제를 함.
            replicas: 1              # 포드의 갯수
            selector:
              matchLabels:
                app: no-kafka
            serviceName: kafka-sever-headless      # 서비스 이름.
            template:  포드의 template 설정.
                metadata:
                    labels:
                        키값 : 벨류값      * 포드를 라벨로 묶어서 관리.
                spec:
                     affinity:  
                           nodeAffinity:   해당 노드에만 포드 스케쥴링.
                                requiredDuringSchedulingIgnoredDuringExecution:  Intel CPU가 있는 노드에서 포드 만 실행.
                                     nodeSelectorTerms:    nodeSelectorTerms 이 nodeAffinity 밑에 있으면  nodeSelectorTerms 중 하나만 충족해도 됨
                                     - matchExpressions:    matchExpressions 가 nodeSelectorTerms 밑에 있으면 matchExpressions 아래 모든 조건이 충족되어야한다. 
                                       - key: app
                                         operator: In
                                         values:
                                         - no-kafka
                                preferredDuringSchedulingIgnoredDuringExecution:  포드가 동일한 노드에 스케쥴링 되길 바람. 안된다면 다른 노드에 배포.
                                     preference:
                                       matchExpressions:
                                       - key: app
                                         operator: In
                                         values:
                                         - no-kafka
                                
                           podAffinity:   하위에 labelSelector로 지정한 노드에만 동일한 시스템으로 스케줄 되어야함.
                                requiredDuringSchedulingIgnoredDuringExecution:  Intel CPU가 있는 노드에서 포드 만 실행.
                                     - labelSelector:  노드중에 아래 지정한 라벨에 해당되는 곳에만 포드를 스케쥴링 할 수 있음.
                                        matchExpressions:
                                          - key: app
                                            operator: In
                                            values:
                                            - no-kafka
                                      topologyKey:  포드가 배포어야 하는 범위를 결정.    ( topologyKey는 노드 X ,  포드에만 설정가능)
                                weight: 1            # 우선순위 설정. 바로 위에 조건문 중에서 몇번째로 수행시킬건지 (1~100까지 설정 가능)      
                                    
                           podAntiAffinity:     포드를 동일한 위치(노드)에 놓고 싶지 않을때 사용. 하위에 labelSelector로 지정한 노드에만 동일한 시스템으로 스케쥴 되면 안됨
                               preferredDuringSchedulingIgnoredDuringExecution:  포드가 동일하지 않은 노드에 스케쥴링 되길 바람. 안된다면 다른 노드에 배포.
                               - podAffinityTerm:  
                                   labelSelector:          
                                      matchExpressions:  
                                       - key: app
                                         operator: In
                                         values:
                                         - no-kafka
                                   topologyKey:  포드가 배포되지 말아야 하는 범위를 결정.    ( topologyKey는 노드 X ,  포드에만 설정가능)
                               
                          
                     nodeSelector: 특정 노드에만 pod를 배포할때 사용.
                   
                     containers:         # 포드에 실행될 도커 이미지 정보.
                         imagePullPolicy : 1. IfNotPresent  2. always     # 이미지가 이미 존재하면 계속 사용한다.  그렇기에 pod재시작을 하지 않고 있고. tag 사용시 좋음. 그게 아니라면 always로 변경하는게 좋음.  
 
 
