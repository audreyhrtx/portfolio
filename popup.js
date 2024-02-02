function renderProjet(img, title, content, download, popup) {
  let tmp = ` <div class="container">
                <img src=".${img}" alt="projet">
                <div class="overlay">
                    <h2>${title}</h2>
                    <p class="text"> ${content} </p>`;
  if (download) {
    tmp += `<p class="download">  <a href=${download.href} download=${download.name}>  Telecharger </a>  </p>`;
  }
  tmp += `<button class="popupBtn">+</button>
                    <div class="popup">
                        <h3> Compétences Technique  </h3>
                        <p>${popup.contentT}</p>
                        <h3> Qualités </h3>
                        <p>${popup.contentQ}</p>
                        <button class="closeBtn">Fermer</button>
                    </div>
                </div>
            </div>
            `;

  document.querySelector(".allP").innerHTML += tmp;
}

renderProjet(
  "./img/olivier.jpg",
  "Fullstack S4",
  `Pour ce stage erasmus, j'ai à partir de données excel crée une base de données mongodb ainsi qu'un site web permettant de voir, de modifier et d'ajouter un olivier à cette base de données. </br> De plus, j'ai effectué un classement à partir de plusieurs critères comportant chacun un poids plus ou moins faible selon l'importance de celui-ci.`,
  null,
  {
    contentT:
      "- Maitriser JavaScript </br> - Interagir avec une API avec Express.io </br> - Créer et interroger une base de données MongoDB avec JavaScript",
    contentQ:
      "- travail en équipe (trello, git) </br> - organisation </br> - autonomie ",
  }
);

renderProjet(
  "./img/agario.png",
  "Agar.io S4",
  `Pour ce dernier projet de S4, nous avons dû par binôme, re créer le jeu agar.io en TypeScript, cela a été l'occasion de découvrir toutes les possibilités du langage et de voir la différence entre JavaScript et java que nous avons appris depuis près de 2 ans`,
  {
    href: "https://github.com/audreyhrtx/classification.git",
    name: "null",
  },
  {
    contentT:
      "- Maitriser Javascript et Typescript </br> - Créer et gérer un serveur Node.js </br> - Faire des test avec Jest",
    contentQ:
      "- travail en équipe (trello, git) </br> - patience </br> - rigueur ",
  }
);

renderProjet(
  "./img/pizzeria.png",
  "API REST S4",
  `Le but de ce projet était de réaliser l'API REST d'une pizzeria avec les méthodes du CRUD nécessaire au bon fonctionnement de la pizzeria ainsi qu'une authentification de type Bearer pour les méthodes autres que GET.`,
  { href: "https://github.com/audreyhrtx/classification.git", name: "null" },
  {
    contentT:
      "- Maitriser Java </br> - Créer et interagir avec une base de données (PostgreSQL) - Maitriser les jetons d'authentification </br> - ",
    contentQ: "- travail en équipe (git) </br> ",
  }
);

renderProjet(
  "./img/radiateur.jpg",
  "Methode Agile S3",
  `Au cours de ce projet de 4 jours, j'ai découvert et de mis en pratique la méthode agile. Notre mission consistait à développer un jeu sans interface graphique, en travaillant par groupe de 7 personnes avec des compétences variées et sans nous connaître auparavant. Nous avons ainsi créé Tovicon, un jeu inspiré de Pokémon.`,
  { href: "https://github.com/audreyhrtx/tovicon.git", name: "null" },
  {
    contentT:
      "- Maitriser Java </br> - Maitriser le fonctionnement de travail agile ",
    contentQ: "- travail en équipe (git/agile) </br>- Créativité </br> ",
  }
);

renderProjet(
  "./img/stat.png",
  "Base de données S2",
  `Notre objectif était de créer une base de données fonctionnelle afin de réaliser différentes analyses statistiques sur des données parcoursup au format Excel. Nous avons ainsi répondu à des questions telles que "les filles n'aiment pas les études scientifiques ?",en nous appuyant exclusivement sur des données quantitatives. Bien qu'indispensable pour répondre à ce genre de question il n'y avait aucune étude sociologique.`,
  { href: "./data/bddrapport.pdf", name: "statistique" },
  {
    contentT:
      "- Maitriser SQL </br> - Creer une base de données avec des données provenant d'un CSV - Interoger une base de données ",
    contentQ: "- Synthetiser - </br>  Analyser - Documenter ",
  }
);

const popupBtns = document.querySelectorAll(".popupBtn");
const popups = document.querySelectorAll(".popup");
const closeBtns = document.querySelectorAll(".closeBtn");

popupBtns.forEach((popupBtn, index) => {
  popupBtn.addEventListener("click", () => {
    popups[index].style.display = "block";
  });

  closeBtns[index].addEventListener("click", () => {
    popups[index].style.display = "none";
  });
});

// fermer quand on clique n'importe ou ailleur

popups.forEach((popup, index) => {
  window.onclick = function (event) {
    if (event.target == popup) {
      popup[index].style.display = "none";
    }
  };
});
