Spring test code
===================================

테스트 [코드](src/test/java/com/jg/springtestcode/examples) 정리.

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

- @Before / @After <br>
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

# AssertJ
- Method

<br>
<hr>
<br>

# MVC Test
### Annotation
- @RunWith(~.class) <br>
  테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행.

- @SpringBootTest <br>
  *통합 테스트*를 하기위한 스프링 부트 테스트 어노테이션. <br>
  테스트에 필요한 거의 모든 의존성을 제공.
  
  - @SpringBootTest(webEnvironment = ) <br>
	웹 테스트 환경 구성. <br>
	- 진행중 ..


- @WebMvcTest <br>
  *단위 테스트*를 하기위한 스프링 부트 테스트 어노테이션. <br>
  웹에서 테스트하기 힘든 *컨트롤러를 테스트하기 적합*. <br>
  @Controller, @ControllerAdvice 등을 사용 가능. <br>

  - @WebMvcTest(controllers = ~.class) , @WebMvcTest(value = ~.class) <br>
	컨트롤러를 명시한다. <br>
  - @WebMvcTest(...) <br>
	진행중.. <br>
  ...

  참고 : <https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/web/servlet/WebMvcTest.html> 

- @DataJpaTest
  
- @RestClientTest
  
- @JsonTest

...

### MockMvc
**MockMvc**란? 웹 API를 테스트하기 위한 클래스로서 Spring MVC 동작을 테스트할 수 있음.

- HTTP GET 예제 <br>
  
- HTTP POST 예제 <br>
  
- HTTP PUT 예제 <br>
  
- HTTP DELETE 예제 <br>
  

<br>
<hr>
<br>