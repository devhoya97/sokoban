# sokoban
소코반 게임을 진행하기 위한 맵 정보를 객체로 저장 및 출력하는 프로젝트

***
## 구현할 기능 목록
```
Stage 1
#####
#OoP#
#####
=====
Stage 2
  #######
###  O  ###
#    o    #
# Oo P oO #
###  o  ###
 #   O  # 
 ########
```
1. 위 내용을 문자열로 넘겨서 처리하는 함수를 작성한다.
2. 위 값을 읽고 저장할 수 있는 적당한 객체(혹은 클래스)를 생성하고 문자열로부터 읽은 값을 변환해서 저장한다.

   | 기호 | 의미           | 저장값  |
   |----|--------------|------|
   | 없음 | 빈 공간         | 0    |
   | O  | 구멍(Hall)     | 1    |
   | o  | 공(Ball)      | 2    |
   | P  | 플레이어(Player) | 3    |
   | #  | 벽(Wall)      | 4    |
   | =  | 스테이지 구분자     | 값 없음 |

3. 다음과 같은 형태로 각 스테이지 정보를 출력한다.
- 플레이어 위치는 배열 [0][0]을 기준으로 행과 열을 출력한다.
- 스테이지 구분값은 출력하지 않는다.

```
Stage 1

#####
#OoP#
#####

가로크기: 5
세로크기: 3
구멍의 수: 1
공의 수: 1
플레이어 위치: 2행 4열

Stage 2

  #######
###  O  ###
#    o    #
# Oo P oO #
###  o  ###
 #   O  # 
 ########

가로크기: 11
세로크기: 7
구멍의 수: 4
공의 수: 4
플레이어 위치 4행 6열
```
***
## 풀이과정 및 코드설명
1. MapElement : 맵을 구성하는 요쇼의 symbol과 mappingValue를 저장하는 enum입니다.
- matWithSymbol 메서드
  - 매개변수로 주어진 symbol 값이 어떤 MapElement의 symbol인지 알려줍니다.
  - 단, MapElement에 저장되지 않은 symbol이 주어질 경우 예외를 발생시킵니다.
  - 처음 게임 맵이 주어졌을 때 이를 mappingValue로 변환하기 위한 과정에서 사용됩니다.
- matWithMappingValue 메서드
   - 매개변수로 주어진 mappingValue 값이 어떤 MapElement의 symbol인지 알려줍니다.
   - 단, MapElement에 저장되지 않은 symbol이 주어질 경우 예외를 발생시킵니다.
   - 게임이 진행되면서 변경되는 게임 맵의 정보를 출력형식에 맞게 출력하기 위한 과정에서 사용됩니다. 

2. GameMap : 특정 Stage에 대한 게임 맵의 정보를 관리하는 객체입니다.
- List<List<Integer>> gameMap 멤버변수 : 요구사항에 맞는 저장값을 활용하여 변환된 게임 맵 정보입니다.
- translateToGameMap 메서드 : 한 줄 씩 변환된 맵을 합쳐 변환된 게임 맵을 완성시킵니다.
- translateToGameMapRow 메서드 
  - 한 줄 씩 게임 맵을 변환합니다.
  - MapElement enum을 활용해 처음 입력받은 symbol값으로 mapping value를 구하는 방식으로 변환합니다.
- getHorizontalSize 메서드 : 맵의 가로 크기를 계산합니다.
- getVerticalSize 메서드 : 맵의 세로 크기를 계산합니다.
- getHallCount 메서드 : 맵에 나타난 구멍의 수를 계산합니다.
- getBallCount 메서드 : 맵에 나타난 공의 수를 계산합니다.
- getPlayerPosition 메서드 : 플레이어의 위치를 계산합니다.

3. Application
- main 메서드 : 프로그램의 전체 흐름을 관장합니다.
- getGameMaps 메서드
  - 주어진 Stage 정보와 맵에 대한 String 정보를 Stage별로 나눕니다.
  - Stage별로 나눠진 정보에 대해 Stage 정보와 맵에 대한 정보로 나눕니다.
  - 나눠진 정보를 활용해 GameMap의 생성자에 필요한 매개변수를 전달해줍니다.
- printAll 메서드 : 생성된 GameMap 객체들로부터 필요한 출력 정보를 한 번에 출력합니다.
- printGameMap 메서드
  - GameMap 객체를 활용해 맵의 형태를 출력합니다.
  - GameMap 객체는 0~4의 정보로 맵을 저장하고 있으므로, 이를 출력 symbol에 맞게 변환합니다.
  - StringBuilder를 활용해 맵 정보를 한 줄씩 모은 뒤, 한꺼번에 출력합니다.
- printGameMapSummary 메서드 : 하나의 GameMap이 갖는 가로크기, 세로크기, 구멍의 수, 공의 수, 플레이어 위치를 출력합니다.

## 실행 결과
```
Stage 1

#####
#OoP#
#####

가로크기: 5
세로크기: 3
구멍의 수: 1
공의 수: 1
플레이어 위치: 2행 4열

Stage 2

  #######
###  O  ###
#    o    #
# Oo P oO #
###  o  ###
 #   O  #
 ########

가로크기: 11
세로크기: 7
구멍의 수: 4
공의 수: 4
플레이어 위치: 4행 6열


```