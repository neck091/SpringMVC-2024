document.addEventListener("DOMContentLoaded", () => {
  const iolist_body = document.querySelector("table.iolist tbody");

  iolist_body?.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "TD") {
      const seq = target.closest("TR").dataset.seq;
      document.location.href = `${rootPath}/iolist/detail/${seq}`;
    }
  });
  const input_price = document.querySelector(
    "input[name='io_price']"
  );
  const input_quan = document.querySelector("input[name='io_quan']");
  const input_total = document.querySelector(
    "input[name='io_total']"
  );
  const total_calc = () => {
    if (input_total) {
      input_total.value =
        Number(input_price?.value) * Number(input_quan?.value);
    }
  };

  //합계 계산 후 보여주기
  total_calc();

  //  변경할 때 보여주기
  input_price?.addEventListener("keypress", total_calc);
  input_quan?.addEventListener("keypress", total_calc);
});
