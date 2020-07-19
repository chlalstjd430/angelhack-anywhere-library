# anglehack-anywhere-library
2020 엔젤핵 해커톤, anywhere library 서버입니다.

## 📄 API 문서
- [swagger](https://angelhack-anywhere-library.herokuapp.com/swagger-ui.html)
- 기능명세
  - 로그인/회원가입(JWT)
    - 로그인
    - 회원가입
  - 도서관
    - 도서관 생성
    - 도서관 조회
    - 도서관 상세 정보 조회
    - 도서관 대학교 랭킹
  - 도서관 좌석
    - 좌석 선택
    - 좌석 시간 업데이트
    - 좌석 떠나기

## 📂 프로젝트 구조(멀티 모듈)
- anywhere-library-application
  - api 모듈
- anywhere-library-domain
  - Domain, Repository, Service 레이어가 정의 되는 모델
- anywhere-library-core
  - 모든 모듈에서 사용되는 공통 모듈

## 💻 기술 스택
- java8, spring boot2.3, jpa, mysql, travis ci, heroku

## ⚒ CI/CD
- travis,heroku를 이용한 CI/CD 적용
  1. 브랜치에서 작업 후 push
  2. travis ci를 이용하여 빌드테스트
  3. 빌드 성공시 merge 가능
  4. merge시 heroku에서 다시 빌드 테스트
  5. 빌드 성공시 heroku 서버에 자동 배포
  
## 😽 git branch 전략
- [git-flow](https://woowabros.github.io/experience/2017/10/30/baemin-mobile-git-branch-strategy.html)
- master
- develop
- feature/{issue-number}

## ⚙ 환경 변수(intelij 기준)
<img width="690" alt="스크린샷 2020-07-19 오전 10 45 28" src="https://user-images.githubusercontent.com/50758600/87865186-0e05ae80-c9ad-11ea-9552-61f85e054f07.png">

CLEARDB_DATABASE_URL=jdbc:mysql://{사용자아이디}:{사용자비밀번호}@{DB주소}:3306/{database이름}
- 예시 : jdbc:mysql://root:1234@localhost:3306/angelhack

JWT_EXPIRATION={JWT의 만료기간}
- 예시 : 6000000

JWT_SECRET={JWT에 사용되는 SECRET KEY }
- 예시 : abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz123456789

