# FK 로 연결된 2개 이상의 테이블에 insert 하기 
- 두 테이블이 FK로 연결된 경우 1:n 의 관계의 table이 많다
- 1의 table에는 기본키가 존재하고, 이 기본키를 기준으로 n의 테이블에 다수의 데이터가 존재하는 구조
- 1의 테이블의 기본키가 생성된 후 N 테이블의 Fk 칼럼에 key 값이 추가되는 구조이다.

## 테이블에 insert 하는 순서
1. `1인 테이블 : master table` 에 데이터 insert 하기
-`master table` 의 `pk`는 미리 생성을 하거나, `AUTO_INCREMENT`로 만들어진다.
- `PK` 를 미리 생성하는 경우는 문제가 없으나 `AUTO_INCREMENT` 로 생성되는 키는 `MASTER table` 에 데이터가 insert 되기 전까지는 그 값을 알 수 없음
- `MyBatis` 에서는 `insert mapper`에 `selectKey` 라는 옵션을 제공하여 `master table`에 데이터가 `insert` 된 후 새로 생성된 `pk` 값을 코드에서 참조할 수 있도록 하고 있다.
- `java` 에서는 `Class Type` 의 객체를 매개변수로 method 에 전달한 경우 method에서 매개변수 객체의 일부 속성(요소, properties) 를 병경하는 경우 원본 객체의 속성 값이 변경되는 성질이 있다.
- 이 성질을 활용하여 `Mybatis` `selectKey` 에 의해 속성값을 변경, `Service` 등에서 그 값을 `getter` 할 수 있다.