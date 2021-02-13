Spring test code
===================================

테스트 [코드](src/test/java/com/jh/springtestcode/examples) 정리.

### 목록

- [JUnit4 기본](#junit4)
- [JUnit5 기본](#junit5)
- [AssertJ](#assertj)
- [MVC Test](#mvc-test)

**진행중.**

<br>
<br>

# JUnit4
### Annotation
- @Test <br>
  해당 어노테이션이 붙은 메서드를 테스트.
  - @Test(timeout= ~ms) <br>
  	~ms(밀리세컨드) 시간 안에 실행이 되면 성공, 아니면 실패.
  - @Test(expected= ~Exception.class) <br>
  	~Exception이 발생하면 성공, 아니면 실패.

- @Before / @After <br>****
  각 테스트마다 테스트 전 / 후에 실행되어야 하는 코드 삽입.

- @BeforeClass / @AfterClass <br>
  전체 테스트마다 테스트 전 / 후에 실행되어야 하는 코드 삽입.

- @Ignore <br>
  해당 테스트케이스를 무시할 때 사용.


### Mathod
- assertEquals(Object expected, Object actual) / assertNotEquals(Object expected, Object actual) <br>
  두 객체 expected와 actual의 값이 (같으면 / 다르면) 테스트 성공.

- assertTrue(boolean condition) / assertFalse(boolean condition) <br>
  condition의 값이 (true / false) 이면 테스트 성공.

- assertNull(Object object) / assertNotNull(Object object) <br>
  object가 (null / not null) 이면 테스트 성공.

- assertSame(Object expected, Object actual) / assertNotSame(Object expected, Object actual) <br>
  expected와 actual이 (같은 객체 / 다른 객체) 이면 테스트 성공.

- assertArrayEquals(type[] expecteds, type[] actuals) <br>
  expecteds와 actuals가 같은 같은 값을 가진 배열이면 테스트 성공.


<br>
<hr>
<br>

# JUnit5
### Annotation
- @Test <br>
  해당 어노테이션이 붙은 메서드를 테스트. (JUnit4의 @Test와 차이점은 다른 속성을 선언하지 못함.)

- @ParameterizedTest <br>
  매개변수가 있는 테스트를 지정. <br>
  매개변수를 지정할 땐 다음과 같은 어노테이션들을 사용할 수 있음. <br>

  - @ValueSource <br>
	단일 값 배열을 전달. <br>
	값의 종류는 short, byte, int, ... boolean, java.lang.String, java.lang.Class 등이 있음.

  - @NullSource <br>
	단일 null 값을 전달. <br>
	기본 타입은 null 값을 허용할 수 없음.

  - @EmptySource <br>
	단일 빈 값을 인수에 전달.

  - @NullAndEmptySource <br>
	@NullSource와 @EmptySource의 기능을 제공.

  - @EnumSource <br>
	ㅇ

  - @MethodSource <br>
	ㅇ

  - @CsvSource <br>
	ㅇ

  - @CsvFileSource <br>
	ㅇ

  - @ArgumentsSource <br>
	ㅇ

- @RepeatedTest <br>
  반복 테스트를 하기위해 사용.
  매개변수로 반복 값이 들어감.

- @TestFactory <br>
  동적 테스트를 하기위해 사용.
  (부가설명 필요..)


- @TestTemplate <br>
  ㅇ

- @TestMethodOrder <br>
- @TestInstance <br>
- @DisplayName <br>
- @DisplayNameGeneration <br>
- @BeforeEach / @AfterEach <br>
  각 테스트마다 테스트 전 / 후에 실행되어야 하는 코드 삽입. <br>
  현재 class 안에 있는 @Test, @RepeatedTest, @ParameterizedTest, @TestFactory 가 붙은 메서드가 전 / 후에 @BeforeEach / @AfterEach 가 붙은 메서드가 실행됨.

- @BeforeAll / @AfterAll <br>
  전체 테스트마다 테스트 전 / 후에 실행되어야 하는 코드 삽입. <br>
  @BeforeEach / @AfterEach랑 비슷.

- @Nested <br>
- @Tag <br>
- @Disable <br>
  해당 테스트 클래스 또는 테스트 메서드를 사용하지 않음.

- @Timeout <br>
- @ExtendWith <br>
- @RegisterExtension <br>
- @TempDir <br>

참고 : <https://junit.org/junit5/docs/snapshot/user-guide/index.html#writing-tests-annotations> 

### Mathod
- ...

<br>
<hr>
<br>

# AssertJ
- Method

<br>
<hr>
<br>

# Testing
### Annotation
- @RunWith(~.class) <br>
  테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행.

- @SpringBootTest <br>
  *통합 테스트*를 하기위한 스프링 부트 테스트 어노테이션. <br>
  테스트에 필요한 거의 모든 의존성을 제공.
  모든 Bean을 제공하기 때문에 애플리케이션의 규모가크면 테스트가 느려짐.
  
  - @SpringBootTest(webEnvironment = ~) <br>
	웹 테스트 환경 구성. <br>

	- @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) <br>
	  ..

	- @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) <br>
	  스프링 내장 서버를 랜덤 포트로 배정.

	- @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) <br>
	  ..

	- @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE) <br>
	  기본적인 ApplicationContext를 불러옴.



- @WebMvcTest <br>
  MVC *단위 테스트*를 하기위한 스프링 부트 테스트 어노테이션. <br>
  웹에서 테스트하기 힘든 *컨트롤러를 테스트하기 적합*. <br>
  WebApplication 관련 Bean빈들만 관리하므로 @SpringBootTest에 비해 가벼운 테스팅이 가능.
  Service를 사용하려면 가짜로 만들수 있음. (@MockMvc) <br>
  @Controller, @ControllerAdvice 등을 사용 가능. <br>

  - @WebMvcTest(controllers = ~.class) , @WebMvcTest(value = ~.class) <br>
	컨트롤러를 명시한다. <br>
  - @WebMvcTest(...) <br>
	진행중.. <br>
  ...

  참고 : <https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/web/servlet/WebMvcTest.html> 

- @DataJpaTest
  JPA 관련 설정만 로드.

- @RestClientTest <br>
  REST 관련 테스트를 하기 위한 어노테이션.

- @JsonTest <br>
  JSON 테스트를 하기 위한 어노테이션.

...

### MockMvc Method
**MockMvc**란? 웹 API를 테스트하기 위한 클래스로서 Spring MVC 동작을 테스트할 수 있음.

- Request
  - perform(RequestBuilder requestBuilder) <br>
  	요청을 수행하고 추가 작업을 할 수 있는 결과를 반환. 

    - get(URI uri) <br>
	  URI 주소로 HTTP GET 요청

    - post(URI uri) <br>
	  URI 주소로 HTTP POST 요청

    - put(URI uri) <br>
	  URI 주소로 HTTP PUT 요청

    - delete(URI uri) <br>
	  URI 주소로 HTTP DELETE 요청


      - param(String name, String value) / params(MultiValueMap<String, String> params) <br>
		파라미터로 키(name)와 값(value)을 전달합니다.

      - contentType() <br>
		- MockHttpServletRequestBuilder.contentType(MediaType contentType) <br>
		  요청의 헤더에 Content-Type을 설정.

		- ContentResultMatchers.contentType(MediaType contentType) <br>
		  응답의 type을 contentType으로 ?

	  - content() <br>
		- MockHttpServletRequestBuilder.content(String content) <br>
		  request body를 설정.

		- MockMvcResultMatchers.content() <br>
		  response body에 접근.

      - header() <br>

- Response
  - andExpect(ResultMatcher matcher) <br>
	검증을 실행.


	- status() <br>
	  HTTP 상태 코드를 검증.

	  - isOk() : 200
	  - isCreated() : 201
	  - isBadRequest() : 400
	  - isNotFound() : 404
	  - isMethodNotAllowed() : 405
	  - isInternalServerError() : 500
	  - is1xxInformational()
	  - is2xxSuccessful()
	  - is3xxRedirection()
	  - is4xxClientError()
	  - is5xxServerError()
	  - is(int status) : 예상 응답 상태 코드(status) 삽입. 
		
		...

	- header() <br>
	  응답 헤더 상태를 검증.

	- content() <br>
	  requestBody를 설정.

	- contentType() <br>
	  요청의 Content-Type 헤더를 설정.


	- cookie() <br>
	- view() <br>
	- redirect() <br>
	- model() <br>
	

  - andDo(ResultHandler handler) <br>
	요청에 대한 처리.

	- print() <br>
	  실행 결과를 임의의 출력 대상에 출력. 출력 대상을 지정하지 않으면 기본적으로 표준 출력(System.out)이 대상.
	- log() <br>
	  실행 결과를 디버깅 레벨에서 로그로 출력.
  

  - andReturn() <br>
	테스트한 결과 객체를 받을 때 사용.


- HTTP GET 예제 <br>
  ~~~ java
	mvc.perform()
	...
  ~~~
  
- HTTP POST 예제 <br>
  
- HTTP PUT 예제 <br>
  
- HTTP DELETE 예제 <br>
  

<br>
<hr>
<br>