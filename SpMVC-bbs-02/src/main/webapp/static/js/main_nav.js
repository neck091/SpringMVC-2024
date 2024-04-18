//main nav 각 tag classname을 키로하는 객체 선언

const NAV_INDEX = {
  home: { url: "/" },
  notice: { url: "/bbs/notice" },
  bbs: { url: "/bbs/free" },
};

document.addEventListener("DOMContentLoaded", () => {
  const mainNav = document.querySelector("nav.main");
  const navItems = mainNav.querySelectorAll("li");

  mainNav.addEventListener("click", (e) => {
    const target = e.target;

    if (target.tagName == "LI") {
      //active라는 class 제거
      navItems.forEach((item) => {
        item.classList.remove("active");
      });
      //클릭된 항목에 active 클래스 추가
      target.classList.add("active");

      const className = target.classList[0];
      const url = NAV_INDEX[className].url;
      //   alert(url);
      document.location.href = url;
    }
  });
});
