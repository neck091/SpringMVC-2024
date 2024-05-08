document.addEventListener("DOMContentLoaded", function () {
  var nounList = document.getElementById("nounList");
  var modalWordsList = document.getElementById("modalWordsList");
  var currentUrl = window.location.href;

  var selectedNoun = ""; // 선택한 명사를 저장할 변수

  const textArea = document.querySelector("textarea");

  const btn = document.querySelector("button.delete");

  btn.addEventListener("click", () => {
    textArea.value = ""; // 텍스트 에어리어 내용 지우기
  });

  // 텍스트 에어리어 더블클릭 이벤트 핸들러
  document
    .getElementById("inputText")
    .addEventListener("dblclick", function (event) {
      var textarea = event.target;
      textarea.select(); // 텍스트 선택
      document.execCommand("copy", false, ""); // 복사 명령 실행

      alert("문장이 복사되었습니다.");
    });

  nounList.addEventListener("click", function (event) {
    if (event.target.tagName === "LI") {
      selectedNoun = event.target.textContent; // 선택한 명사 저장
      fetchData(selectedNoun); // 선택한 명사를 기반으로 데이터 가져오기
      openModal(); // 모달 창 열기
    }
  });

  modalWordsList.addEventListener("click", function (event) {
    if (
      event.target.tagName === "LI" &&
      event.target.textContent !== "관련어가 없습니다."
    ) {
      var replaceWord = event.target.textContent;
      replaceSelectedNoun(replaceWord); // 선택한 단어로 명사 대체
    }
    closeModal(); // 모달 창 닫기
  });

  function fetchData(noun) {
    var xhr = new XMLHttpRequest();
    xhr.open(
      "GET",
      `${rootPath}/words?word=` + encodeURIComponent(noun)
    );
    xhr.onload = function () {
      if (xhr.status === 200) {
        var data = JSON.parse(xhr.responseText);
        modalWordsList.innerHTML = ""; // 기존 목록 비우기
        if (data.length > 0) {
          data.forEach(function (word) {
            var li = document.createElement("li");
            li.textContent = word;
            modalWordsList.appendChild(li); // 새로운 항목 추가
          });
        } else {
          var li = document.createElement("li");
          li.textContent = "관련어가 없습니다.";
          modalWordsList.appendChild(li);
        }
      } else {
        console.error("Request failed. Status:", xhr.status);
      }
    };
    xhr.onerror = function () {
      console.error("Request failed. Network error");
    };
    xhr.send();
  }

  // 모달 창 열기
  function openModal() {
    document.getElementById("myModal").style.display = "block";
  }

  // 모달 창 닫기
  document
    .querySelector("#myModal .close")
    .addEventListener("click", function () {
      closeModal(); // 모달 창 닫기
    });

  // 모달 바깥 영역 클릭 시 모달 창 닫기
  window.addEventListener("click", function (event) {
    if (event.target === document.getElementById("myModal")) {
      closeModal(); // 모달 창 닫기
    }
  });

  // 모달 창 닫기
  function closeModal() {
    document.getElementById("myModal").style.display = "none";
  }

  // 폼 제출 함수
  function submitForm() {
    document.getElementById("myForm").submit();
  }

  // 선택한 명사를 클릭한 단어로 대체하는 함수
  function replaceSelectedNoun(replaceWord) {
    var textarea = document.getElementById("inputText");
    if (textarea) {
      var replacedText = textarea.value.replace(
        selectedNoun,
        replaceWord
      );
      textarea.value = replacedText;
      submitForm();
    } else {
      console.error("텍스트 에어리어를 찾을 수 없습니다.");
    }
  }

  // 맞춤법 검사 결과 클릭 시 텍스트 에어리어에 반영
  document
    .getElementById("displayText")
    .addEventListener("click", function () {
      if (inputText) {
        var resultText =
          document.getElementById("displayText").textContent;
        inputText.value = resultText;
      }
      submitForm();
    });

  function replaceNounsInTextarea() {
    var textarea = document.getElementById("inputText");
    var selectedNoun =
      document.getElementById("selectedNoun").textContent;
    var replaceWord =
      document.getElementById("replaceWord").textContent;

    if (textarea && selectedNoun && replaceWord) {
      var text = textarea.value;
      var nounIndices = []; // 선택된 명사의 위치를 저장할 배열

      // 텍스트 에어리어에서 선택된 명사가 나타나는 위치 찾기
      var index = text.indexOf(selectedNoun);
      while (index !== -1) {
        nounIndices.push(index);
        index = text.indexOf(selectedNoun, index + 1);
      }

      // 명사 리스트에서 선택된 명사의 위치와 일치하는 위치에 대체어 삽입
      for (var i = 0; i < nounIndices.length; i++) {
        var currentIndex = nounIndices[i];
        text =
          text.slice(0, currentIndex) +
          replaceWord +
          text.slice(currentIndex + selectedNoun.length);

        // 대체어를 삽입했으므로 나머지 위치들을 조정
        for (var j = i + 1; j < nounIndices.length; j++) {
          nounIndices[j] += replaceWord.length - selectedNoun.length;
        }
      }

      // 수정된 텍스트를 텍스트 에어리어에 할당
      textarea.value = text;
      submitForm();
    } else {
      console.error(
        "텍스트 에어리어나 선택된 명사, 대체어를 찾을 수 없습니다."
      );
    }
  }
});
