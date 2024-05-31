document.addEventListener("DOMContentLoaded", () => {
  const preImg = document.querySelector("img.represent");
  const imageInput = document.querySelector("#files");
  const thumnailBox = document.querySelector("div.thumnail");

  //대표이미지를 클릭하면 input[type="file"]을 클릭한 것 처럼 해라.
  preImg.addEventListener("click", () => imageInput.click());

  const imgPreview = (file, target) => {
    const reader = new FileReader();
    reader.onloadend = (e) => (target.src = e.target.result);
    reader.readAsDataURL(file);
  };

  imageInput.addEventListener("change", (e) => {
    const files = e.target.files;
    const file = files[0];
    imgPreview(file, preImg);

    thumnailBox.innerHTML = "";
    for (let i = 0; i < files.length; i++) {
      const tempImage = document.createElement("img");
      imgPreview(files[i], tempImage);
      thumnailBox.appendChild(tempImage);
    }
  });

  thumnailBox.addEventListener("click", (e) => {
    const thumImage = e.target;
    preImg.src = thumImage.src;
  });
});
