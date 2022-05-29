## 화면설계

![image](https://user-images.githubusercontent.com/23456264/158011724-0def314c-0df0-4869-9f52-5a012a1425f4.png)
![image](https://user-images.githubusercontent.com/23456264/158011746-1b34746d-de33-4fcb-a31c-ebcc32ad0594.png)
![image](https://user-images.githubusercontent.com/23456264/158011759-1c224ac8-49f2-4b83-8910-40933fff0092.png)
![image](https://user-images.githubusercontent.com/23456264/158011766-f8e553dd-2e7b-42ea-9f9a-86b7481c89a1.png)

## 프로젝트 목표

## 프로젝트 주요 관심사

## 브랜치 관리 전략
### 선정조건
- 운영환경과 개발환경을 구분하는 브랜치 역할이 존재해야 한다
- merge과정에서 팀원간 충분한 리뷰와 피드백 과정이 필요하다

### Keam Flow 전략
- Keam Flow는 gitlab에서 착안하여, 이슈트래킹을 연동해 전략을 단순화하고자 한다.
- merge request를 활용해 승인이 되는 이슈만 머지하도록 하는것이 핵심이다
- 해당 프로젝트에서는 불필요한 절차를 줄이고, 팀원간에 안정성있는 소스관리를 위한 전략이다.

#### 브랜치 구성

- master
	- 운영환경의 버전과 일치한다.
- develop
	- master 브랜치로부터 생성되어
	- 각 feature에서 병합된 기능에 대해서 검증하기 위한 브랜치다.
- feature
	- 모든 기능구현은 feature에서 진행된다.
	- develop 브랜치로부터 분리되어나와 develop으로 머지되며 기능구현이 완료되면, merge request를 통하여 팀원간 협의가 완료되면 master로 머지한다.


#### 향후목표
- develop 브랜치에 merge 및 push까지 완료된 시점에 CI/CD를 자동화하여 테스트와 빌드를 거친 후 master에 배포

## 사용 기술 및 환경

## 프로젝트 DB ERD
![image](https://user-images.githubusercontent.com/23456264/164025116-840dde85-294b-46ae-a114-80312e882da6.png)

# 서버구조
