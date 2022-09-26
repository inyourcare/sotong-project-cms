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

## 해야할 일
interceptor , error 처리 , exception 로그 , datasource(jpa) , swagger(?) , security , httpFilter(공격방어)

## H2 Database
You can check the front view of the h2 at `localhost:8080/h2-console`

## Datasource 편집
기본적으로 application.yml 파일을 기초한다. 다중 데이터소스에 관한 내용은 DatasourceProvider 클래스를 참고

## Exception 설정
@ControllerAdvice 어노테이션을 기반으로 설정한다. exception 패키지 아래 객체 참조