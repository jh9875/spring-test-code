Spring test code
===================================

테스트 코드 정리.

진행중.

<br>
<br>

## JUnit4
- Annotation
  - @Test
	- 해당 어노테이션이 붙은 메서드를 테스트.
  - @Test(timeout= ~ms)
    - ~ms(밀리세컨드) 시간 안에 실행이 되면 성공, 아니면 실패.
  - @Test(expected= ..Exception.class)
    -  ..Exception이 발생하면 성공, 아니면 실패.
  - @Before / @After
    - 각 테스트마다 테스트 전 / 후에 실행되어야 하는 코드 삽입.
  - @BeforeClass / @AfterClass
    - 전체 테스트마다 테스트 전 / 후에 실행되어야 하는 코드 삽입.
  - @Ignore
    - 해당 테스트케이스를 무시할 때 사용.
- Mathod
  - void assertEquals(Object expected, Object actual) / assertNotEquals(Object expected, Object actual)
    - 두 객체 expected와 actual의 값이 (같으면 / 다르면) 테스트 성공.
  - void assertTrue(boolean condition) / assertFalse(boolean condition)
    - condition의 값이 (true / false) 이면 테스트 성공.
  - void assertNull(Object object) / assertNotNull(Object object)
    - object가 (null / not null) 이면 테스트 성공.
  - void assertSame(Object expected, Object actual) / assertNotSame(Object expected, Object actual)
    - expected와 actual이 (같은 객체 / 다른 객체) 이면 테스트 성공.
  - void assertArrayEquals(type[] expecteds, type[] actuals)
    - expecteds와 actuals가 같은 같은 값을 가진 배열이면 테스트 성공.

## AssertJ
- Method

## MockMvc


## JUnit5

미정.