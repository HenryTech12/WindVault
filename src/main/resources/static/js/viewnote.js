let diaryPopup = document.getElementById('diary');

let btns = document.getElementById('buttons');
let inputField = document.querySelectorAll('.dash');
let i = 0;
let txtarea = document.getElementById('txtarea');
let showControl = document.querySelector('.vertline');
function showBtn() {
console.log('logged');
   if(i%2 == 0) {
     btns.style.display = "grid";
     txtarea.classList.add('disableTxtArea');
     i++;
   }
   else {
     btns.style.display = "none";
     txtarea.classList.remove('disableTxtArea');
     i++;
   }
}

let pinAsDiary = document.getElementById('pinAsDiary');
pinAsDiary.addEventListener('click', (event) => {
    console.log('open popup');
    event.preventDefault();

    diaryPopup.style.display = "flex";
})

function closeDiary() {
  console.log('closed');
  diaryPopup.style.display = "none";
}

let gohome = document.getElementById('gohome');
gohome.addEventListener('click', () => {
    for(let j = 0; j < inputField.length; j++) {
      inputField[i].removeAttribute('required');
    }
    txtarea.removeAttribute('required');
});