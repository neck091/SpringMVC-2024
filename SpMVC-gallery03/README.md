# SpringMVC Java Config
- SpringMVC Legacy Project 는 전통적으로 `*.xml` 를 사용하여 서버의 여러가지 세팅을 수행했다.
- `Spring Framework 3.x` 이후에선 `Annotation`이 도입되고 이때부터 `*.xml` 을 사용하지 않는 코드가 만들어지기 시작
- 하지만 `SpringMVC` 프로젝트에서는 `JavaConfig` 방식이 거의 사용되지 않았다.
- 이후에 `Spring Boot` 프로젝트가 시작되면서, `JavaConfig` 에 대한 관심이 새롭게 생겨나고, 일부 프로젝트에서 `JavaConfig` 방식의 SpringMVC, Legacy 프로젝트가 작성되었다.
- 현업 실무에선 거의 사용하지 않지만 `JavaConfig` 프로젝트를 만들어 봄으로 `*.xml` 방식의 `Bean Config Context` 등의 설정이 어케 작동하는지 이해할 수 있다.
- `Spring Boot` 프로젝트를 업그레이드 하는데 혼란을 최소화 할 수 있다