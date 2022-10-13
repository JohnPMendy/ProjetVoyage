//ouvre la selection de la partie à charger
document
.querySelector('input.Charger')
.addEventListener('click', () => {
    document
    .querySelector('.popup-overlay-chargement')
    .classList.add('open');

    document
    .querySelector('.popup-container-chargement')
    .classList.add('open');
});

//chargment de la partie selectionné avec ouvertue d'une popup de chargement reussi
const listeBoutons = document.querySelectorAll('button.ligneChargement');
listeBoutons.forEach(bouton=>{
    bouton.addEventListener('click',()=>{

        document
        .querySelector('.popup-container-chargement')
        .classList.remove('open');
    
        document
        .querySelector('.popup-charge-confirme')
        .classList.add('open');
    
    });
});


// Fermeture de la popup et retour à la partie
document
.querySelector('button.close-popup-chargement')
.addEventListener('click', () => {
    document
    .querySelector('.popup-overlay-chargement')
    .classList.remove('open');

    document
    .querySelector('.popup-container-chargement')
    .classList.remove('open');
});

//Fermeture de la validation de chagement et retour à la partie
document
.querySelector('button.close-charge-confirme')
.addEventListener('click', () => {
    document
    .querySelector('.popup-overlay-chargement')
    .classList.remove('open');

    document
    .querySelector('.popup-charge-confirme')
    .classList.remove('open');
});