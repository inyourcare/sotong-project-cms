*이텔릭*  **두껍게** ~~취소~~ <u>밑줄</u>
<ol><li>순서</li></ol>
<ul><li>순서</li></ul>
<ul>순서</ul>
- 데쉬
* 별표
+ 더하기

[Google](http://temp.com)
[hoho] <http://dsds>
```html
html code
```
``code``

# 소통파이브 CMS 프로젝트

## 프로젝트 구조
### config
- Admin / Front 어노테이션, Bean 설정 , 시큐리티설정
### exception
- Exception 정의들과, handling  
### persistence
- JPA entities 와 repositories
### web
#### admin
- 어드민 에서 해야할 비즈니스 로직 

#### front
- 어디민이 아닌 유저들이 할 수 있는 로직

#### cmmn
- AbstractController , Response 등의 공통 객체 



## 해야할 일
interceptor , error 처리 , exception 로그 , datasource(jpa) , swagger(?) , security , httpFilter(공격방어)



## H2 Database
You can check the front view of the h2 at `localhost:8080/h2-console`

## Exception 설정
@ControllerAdvice 어노테이션을 기반으로 설정한다. exception 패키지 아래 객체 참조

## WebSecurityConfig
/admin 아래 모든 요청은 권한이 있어야 가능하다. application.yml 아래 security 쿼리가 저장되어있다.

## Controller 
config.anotation 아래 AdminController 와 FrontController 어노테이션 묶음을 설정 해 놓았다.

## BeanConfiguration
BeanConfig 에서 처리하자

## to do
- Admin / Front 어노테이션 컨트롤러에 CrossOrigin 설정
- admin.controller.DashboardController createTable 에 적용된 response 적용