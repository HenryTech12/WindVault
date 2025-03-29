console.log('hey');
let diaryPopup = document.getElementById('diary');

function closeDiary() {
  console.log('closed');
  diaryPopup.style.display = "none";
}


let holder = document.querySelectorAll('.holder');
let popupBtn = document.getElementById('button');
let checkForPopup = document.querySelectorAll('.check');
holder.forEach((holderBtn) => {
    holderBtn.addEventListener('click', (event) => {
        let url =  `access-diary?id=${holderBtn.value}`;
        console.log("URL: ", url);
        let i = holderBtn.value;

        console.log(checkForPopup);

        console.log(checkForPopup[i].innerText, checkForPopup[i].value);
        if(checkForPopup[i].innerText) {
             event.preventDefault();

             console.log(holderBtn.value);

             popupBtn.setAttribute('formaction',url);
             diaryPopup.style.display = "flex";
        }
        else {
            diaryPopup.style.display = "none";
        }
    });
 });

let pinError = document.getElementById('pinError');
if(pinError.innerText) {
    window
    .alert('you entered an incorrect diary pin');
}
