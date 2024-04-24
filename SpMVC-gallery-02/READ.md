# Spring 파일 업로드 프로젝트
- gallery-01에서는 이미지를 base64로 변환하여 DB table에 저장했다
- 이러한 방식은 오래전에 파일의 크기가 크지 않을 때는 괜찮은 방법이었다 
- 요즘은 카메라 성능이 좋아져 이미지 크기가 큰 경우가 많음
- 이미지 파일은 파일 자체를 서버에 업로드 하여 서버의 폴더에 저장, db table 에는 파일에 대한 정보만 저장하는 형태로 구현
- 이미지 파일(또는 기타 파일)을 업로드하는 여러가지 도구를 활용해야 한다.

## 도구 설치
- fileUplad를 위한 dependency 설 정
```xml
<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.5</version>
</dependency>

```
- `commons-fileupload` 를 dependency에 설정한 후 `Maven dependencis`를 확인하여 `commons-io` 항목이 없으면 아래 항목을 추가로 설치해줘야 한다.
```xml
<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.16.1</version>
</dependency>
```