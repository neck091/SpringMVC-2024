document.addEventListener("DOMContentLoaded", () => {
  const mainNav = document.querySelector("ui.nounList");
  const navItems = mainNav.querySelectorAll("li");

  mainNav?.addEventListener("click", (e) => {
    const target = e.target;

    if (target.tagName == "LI") {
      const className = target.classList[0];
      const url = NAV_INDEX[className].url;
      document.location.href = `${rootPath}${url}`;
      //nav 가 클릭됐을때 active 한 uI를 보여주기 위한 설정
      //그런데 nav를 클릭하면 화면이 refresh 되어버리기 때문에 의미가 없음
      // //active라는 class 제거
      // navItems.forEach((item) => {
      //   item.classList.remove("active");
      // });
      // //클릭된 항목에 active 클래스 추가
      // target.classList.add("active");
    }
  });
});

$(document).ready(function () {
  $("#nounList").on("mouseenter", "li", function () {
    var noun = $(this).text();
    $.ajax({
      url: "${rootPath}/words",
      type: "GET",
      data: {
        word: noun,
      },
      success: function (data) {
        console.log(data); // 받은 JSON 데이터 콘솔에 출력
        var $wordsList = $("#wordsList");
        $wordsList.empty(); // 기존 목록 비우기
        if (data.length > 0) {
          $.each(data, function (index, word) {
            $wordsList.append("<li>" + word + "</li>"); // 새로운 항목 추가
          });
        } else {
          $wordsList.append("<li>관련어가 없습니다.</li>");
        }
      },
      error: function (xhr, status, error) {
        console.log(error); // 오류 발생 시 콘솔에 출력
      },
    });
  });
});
