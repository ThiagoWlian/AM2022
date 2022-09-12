var btnElement = document.querySelector('button.add');
btnElement.addEventListener("click", addConteudo);

function addConteudo() {
  var inputConteudo = document.querySelector('#conteudoTrilha');
  var inputVideo = document.querySelector('#urlVideo');
  var inputDocumento = document.querySelector('#urlDocumento');


  var textoConteudo = document.querySelector('#listaConteudo')
  document.querySelector('#listaConteudo').value = textoConteudo.value + inputConteudo.value + "-" + inputVideo.value + "-" + inputDocumento.value + ";";
  
  document.querySelector('#conteudoTrilha').value = ""
  document.querySelector('#urlVideo').value = ""
  document.querySelector('#urlDocumento').value = ""


  console.log(document.querySelector('#listaConteudo').value)
}