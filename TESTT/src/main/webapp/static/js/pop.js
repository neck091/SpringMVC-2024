document.addEventListener("DOMContentLoaded", () => {
  function showSimilarWords(event, noun) {
    event.preventDefault(); // 링크 클릭 이벤트를 취소

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
      if (xhr.readyState === XMLHttpRequest.DONE) {
        if (xhr.status === 200) {
          var similarWords = JSON.parse(xhr.responseText);
          var popup = document.getElementById("similarWordsPopup");
          if (popup) {
            // 팝업 창이 존재하는 경우에만 실행
            popup.innerHTML = "유사어: " + similarWords.join(", ");
            popup.style.display = "block";
          }
        } else {
          alert("서버 오류");
        }
      }
    };
    xhr.open("GET", "${rootPath}/similarWords?word=" + noun);
    xhr.send();
  }

  // 유사어 팝업 창을 닫는 함수
  document.addEventListener("click", function (event) {
    var popup = document.getElementById("similarWordsPopup");
    if (popup && !popup.contains(event.target)) {
      popup.style.display = "none";
    }
  });
});
