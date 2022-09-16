var numeroPartie = 0;

document
.querySelector('.nouvellePartie')
.addEventListener('click', () => {
    const date = new Date().toLocaleDateString('fr-FR');
    const heure = new Date().toLocaleTimeString('fr-FR');
    // Fabriquer la ligne du tableau
    const tableRow = document.createElement('tr');

    // Modifier le contenu de la ligne du tableau
    numeroPartie++;
    const nom=` test ${numeroPartie}`
    tableRow.innerHTML = `<td><button class="boutonVersPartie"> <a href="JeuInteractif.html">Partie ${numeroPartie}</a></button></td>`;
    tableRow.innerHTML += `<td>${ nom }</td>`;
    tableRow.innerHTML += `<td>${date}</td>`;
    tableRow.innerHTML += `<td>${heure}</td>`;

    // Ajouter la ligne au tbody du tableau
    document.querySelector('table.partiesEnCours > tbody').append(tableRow);
    document.querySelector('td.compteur').innerHTML =numeroPartie;

});


