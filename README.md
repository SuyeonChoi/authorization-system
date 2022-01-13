# authorization-system

## 구현 기능
* [X] 사용자 DB 설계
* [X] 가입, 로그인 페이지
* [X] 인증 서버 (API)
* [X] RDBMS DB 사용 (MySQL, PostgreSQL)
* [X] Password Encryption
* [ ] 유저 관리 페이지 (Admin/BackOffice)
* [ ] E-Mail 인증
* [ ] 비밀번호 찾기
* [ ] 캐시

## DB 스키마
![auth_db](https://user-images.githubusercontent.com/28749734/149275831-13019713-2f6b-4dbe-8c65-6259af49c1dd.PNG)

## 결과 화면
### 회원가입
![signup](https://user-images.githubusercontent.com/28749734/149275656-6197979b-6e35-4967-b097-6b88f5bb1900.PNG)

### 로그인
![login](https://user-images.githubusercontent.com/28749734/149275643-67f5145a-03cd-4657-8e79-79b57b329d5f.PNG)

### 로그아웃
![logout](https://user-images.githubusercontent.com/28749734/149275641-aadab679-d9a1-4f60-8a9c-02e71dad0000.PNG)


## 🧾 기능 List
- 회원가입
  - 회원은 이메일, 비밀번호, 비밀번호 확인, 닉네임, 전화번호 정보를 입력한다.
  - **[예외]** 비밀번호와 비밀번호 확인 두 개의 정보가 일치하지 않는 경우 다시 입력받는다.
  - **[예외]** 이메일이 DB에 저장되어있는 경우 다시 입력받는다.
  - **[예외]** 전화번호가 DB에 저장되어있는 경우 다시 입력받는다.

- 로그인
  - 회원은 이메일, 비밀번호 정보를 입력한다.
  - **[예외]** 해당 정보가 DB의 정보와 일치하지 않는 경우 다시 입력받는다.

- 회원 정보 수정
  - 회원은 비밀번호 또는 닉네임을 변경할 수 있다.
 
- 회원 탈퇴
  - 회원은 본인임을 인증하고 탈퇴할 수 있다.

- 유저 관리
  - Admin 유저는 모든 유저의 이메일과 닉네임 정보를 확인할 수 있다.
  - Admin 유저는 다른 유저를 탈퇴시킬 수 있다. 
