const nav = document.querySelector("nav");

window.addEventListener("scroll", function () {
  const offset = window.pageYOffset;

  if (offset > 90) nav.classList.add("scroll");
  else nav.classList.remove("scroll");
});
