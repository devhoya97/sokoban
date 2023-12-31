# sokoban
1단계 : 소코반 게임을 진행하기 위한 맵 정보를 객체로 저장 및 출력하기
2단계 : 1단계 스테이지 2의 지도를 읽고 사용자 입력을 받아서 캐릭터를 움직이게 하는 프로그램을 작성하기
***
## 구현할 기능 목록
- 입력 명령
```
w: 위쪽
a: 왼쪽
s: 아래쪽
d: 오른쪽
q: 프로그램 종료
입력으로 대문자와 소문자 모두 입력받을 수 있도록 처리한다.
```

- 요구사항
  - 처음 시작하면 스테이지 2의 지도를 출력한다.
  - 간단한 프롬프트 (예: SOKOBAN> )를 표시해 준다.
  - 하나 이상의 문자를 입력받은 경우 순서대로 처리해서 단계별 상태를 출력한다.
  - 이동 중 벽이나 공등 다른 물체에 부딪히면 (경고!) 해당 명령을 수행할 수 없습니다! 라는 메시지를 출력하고 플레이어를 움직이지 않는다.
  - 지원하지 않는 명령을 입력했을 경우 (경고) 지원하지 않는 명령입니다! 라는 메시지를 출력하고, 다시 사용자의 입력을 받는다.

- 동작 예시
```
Stage 2

  #######
###  O  ###
#    o    #
# Oo P oO #
###  o  ###
 #   O  # 
 ########

SOKOBAN> ddzw (엔터)

  #######
###  O  ###
#    o    #
# Oo  PoO #
###  o  ###
 #   O  # 
 ########

D: 오른쪽으로 이동합니다.

  #######
###  O  ###
#    o    #
# Oo  PoO #
###  o  ###
 #   O  # 
 ########

D: (경고!) 해당 명령을 수행할 수 없습니다!

  #######
###  O  ###
#    o    #
# Oo  PoO #
###  o  ###
 #   O  # 
 ########

Z: (경고!) 해당 명령을 수행할 수 없습니다!

  #######
###  O  ###
#    o    #
# Oo  PoO #
###  o  ###
 #   O  # 
 ########

W: 위로 이동합니다.

  #######
###  O  ###
#    oP   #
# Oo   oO #
###  o  ###
 #   O  # 
 ########

SOKOBAN> q
Bye~
```
***
## 2단계 코딩 요구사항

- 너무 크지 않은 함수 단위로 구현하고 중복된 코드를 줄이도록 노력한다.
- 전역변수의 사용을 자제한다.
- 객체, 리스트, 배열 등을 적절히 활용한다.
- 1단계와 같이 README.md 파일을 작성한다.
- 구현 완료 커밋에 v2 태그를 생성하고 GitHub에 push 한다.
***
## 풀이과정 및 코드설명(1단계와 중복되지 않는 로직에 대해서만 설명을 추가했습니다.)
- InputView : 사용자의 콘솔 입력을 받는 클래스입니다.
- Direction : 플레이어의 이동방향을 관리하는 enum입니다.
  - match 메서드 : 받은 symbol과 일치하는 방향을 반환하는 메서드입니다.
    - 단, 준비된 방향이 아니라면 null을 반환합니다.
- GameMap
  - move 메서드 : 받은 symbol과 일치하는 방향으로 플레이어를 이동시킬 수 있는 메서드를 호출합니다.
    - 이동에 성공했는지 여부를 boolean 타입으로 반환합니다.
  - move* 메서드 : 특정 방향으로 플레이어를 이동시킵니다.
    - 이동은 gameMap의 요소 값을 서로 변경하는 메서드를 호출함으로써 수행됩니다.
    - 이동에 성공했다면 true를 반환합니다.
    - 이동하려는 방향에 장애물이 있다면, 이동 없이 false를 반환합니다.
  - changePosition 메서드 : 플레이어의 위치와 이동하려는 위치 값을 바탕으로 gameMap 상에서 값을 교환합니다.
- Application 
  - main 메서드 : 게임의 전체 흐름을 관장합니다.
    - Stage2에 대해 게임을 수행합니다.
    - 콘솔 입력으로 받은 String을 char로 분해하여 순차적으로 로직을 수행합니다.
    - symbol 값이 알파벳이 아니라면 경고메시지를 출력한 후 재입력받습니다.
    - symbol 값을 대분자로 변환하여 모든 로직을 수행합니다.
    - symbol 값이 'Q'라면 프로그램을 종료합니다.
    - symbol 값이 준비된 Direction 중 하나라면 이동을 수행하고 이동 결과를 출력합니다.
- OutputView : 프로그램에 필요한 각종 출력을 수행합니다.
  - printGameStart 메서드 : 게임 시작시 Stage 정보와 준비된 gameMap을 출력합니다.
  - printResult 메서드 : 어느 방향으로 이동을 시도했는지, 이동에 성공했는지, 이동 결과는 어떠한지 출력합니다.
    - 시도된 명령이 준비된 방향이 아닌 경우와, 준비된 방향이 맞지만 장애물 때문에 이동하지 못한 경우의 경고메시지는 다릅니다.
  - printGameOver 메서드 : 게임 종료시 필요한 문구를 출력합니다.
  - printNotSupportedInput 메서드 : 지원하지 않는 명령이 들어왔을 때 알리기 위한 문구를 출력합니다.
    - OutputView, Application에서 각각 위 메시지를 필요로 하므로 중복을 피하기 위해 메서드화 하였습니다.
## 실행 결과
```
Stage 2

  #######
###  O  ###
#    o    #
# Oo P oO #
###  o  ###
 #   O  #
 ########

SOKOBAN> ddzw

  #######
###  O  ###
#    o    #
# Oo  PoO #
###  o  ###
 #   O  #
 ########

D: 오른쪽으로 이동합니다.

  #######
###  O  ###
#    o    #
# Oo  PoO #
###  o  ###
 #   O  #
 ########

D: (경고!) 해당 명령을 수행할 수 없습니다!

  #######
###  O  ###
#    o    #
# Oo  PoO #
###  o  ###
 #   O  #
 ########

Z: (경고) 지원하지 않는 명령입니다!

  #######
###  O  ###
#    oP   #
# Oo   oO #
###  o  ###
 #   O  #
 ########

W: 위쪽으로 이동합니다.

SOKOBAN> SAa1

  #######
###  O  ###
#    o    #
# Oo  PoO #
###  o  ###
 #   O  #
 ########

S: 아래쪽으로 이동합니다.

  #######
###  O  ###
#    o    #
# Oo P oO #
###  o  ###
 #   O  #
 ########

A: 왼쪽으로 이동합니다.

  #######
###  O  ###
#    o    #
# OoP  oO #
###  o  ###
 #   O  #
 ########

A: 왼쪽으로 이동합니다.

1: (경고) 지원하지 않는 명령입니다!

SOKOBAN> ZDQA

  #######
###  O  ###
#    o    #
# OoP  oO #
###  o  ###
 #   O  #
 ########

Z: (경고) 지원하지 않는 명령입니다!

  #######
###  O  ###
#    o    #
# Oo P oO #
###  o  ###
 #   O  #
 ########

D: 오른쪽으로 이동합니다.

Bye~
```