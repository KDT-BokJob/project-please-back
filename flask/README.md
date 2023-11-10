# project-please

KDT-project-please

- Migrate from Django to Flask
- Running on Port 8000 (default 5000)
- Dynamic Routing: [`/hello/<name>`](/hello/mia)
- HEXACO features
  - getQuestions: GET [`/questions`](/questions)
  - getResult: POST [`/questions/jtc`](/questions/jtc)

# DoD (Definition of Done)
- ~~사용자 정보 가져오기~~
- ~~One-Hot-Encoding~~
- ~~연령 필터링(전처리)~~
- ~~min-max Normalization~~

### NEXT: 특정 사용자에 대한 유사도 계산

- 수준 이상의 유사도를 갖는 유저 선별
- 해당 유저들의 지원 내역을 질의
- 거기에 유사도를 붙여 우선도로 활용
- 우선도 내림차순으로 정렬
- 일정 개수만큼 잘라서 추천으로 보여주기