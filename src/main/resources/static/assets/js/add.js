var btnElement = document.querySelector('button.add');
btnElement.addEventListener("click", addHabilidade);

function insertAfter(newElement, reference) {
    reference.parentNode.insertBefore(newElement, reference.nextSibling);
}


function addHabilidade() {
  var newSpan = document.createElement('span');
  newSpan.classList.add("badge");
  newSpan.classList.add("rounded-pill");
  newSpan.classList.add("bg-primary");
  newSpan.classList.add("mb-2");
  newSpan.style.paddingRight = '9.8px';
  newSpan.style.paddingLeft = '9.8px';
  newSpan.style.marginLeft = '5px';
  var input = document.querySelector('#habilidade');
  newSpan.textContent=input.value;
  const divNew = document.querySelector('#habilidades');
  insertAfter(newSpan, divNew);
  var textoHabilidades = document.querySelector('#listaHabilidades')
  document.querySelector('#listaHabilidades').value = textoHabilidades.value + input.value + ";";
  document.querySelector('#habilidade').value = ""
}