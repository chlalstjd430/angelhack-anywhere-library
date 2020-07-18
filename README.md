# anglehack-anywhere-library
2020 엔젤핵 해커톤, anywhere library 서버입니다

[swagger](https://angelhack-anywhere-library.herokuapp.com/swagger-ui.html)

## 📂 프로젝트 구조
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
