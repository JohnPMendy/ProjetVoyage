document
.querySelector('input.Charger')
.addEventListener('click', () => {
    document
    .querySelector('.popup-overlay')
    // .style.display = 'block';
    .classList.add('open');

    document
    .querySelector('.popup-container')
    .classList.add('open');
});

const listeBoutons = document.querySelectorAll('button.ligneChargement');
listeBoutons.forEach(bouton=>{
    bouton.addEventListener('click',()=>{

        document
        .querySelector('.popup-container')
        .classList.remove('open');
    
        document
        .querySelector('.popup-container-chargement')
        .classList.add('open');
    
    });
});


// Fermeture de la popup
document
.querySelector('button.close-popup')
.addEventListener('click', () => {
    document
    .querySelector('.popup-overlay')
    .classList.remove('open');

    document
    .querySelector('.popup-container')
    .classList.remove('open');
});

document
.querySelector('button.close-chargmement')
.addEventListener('click', () => {
    document
    .querySelector('.popup-overlay')
    .classList.remove('open');

    document
    .querySelector('.popup-container-chargement')
    .classList.remove('open');
});