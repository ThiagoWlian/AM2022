var btnElement = document.querySelector('button.add');
btnElement.addEventListener("click", addQuestao);

function addQuestao() {
  var inputQuestao = document.querySelector('#questao');
  var inputAlternativa1 = document.querySelector('#alternativa1');
  var inputAlternativa2 = document.querySelector('#alternativa2');
  var inputAlternativa3 = document.querySelector('#alternativa3');
  var inputAlternativa4 = document.querySelector('#alternativa4');


  var textoQuestoes = document.querySelector('#listaQuestoes')
  document.querySelector('#listaQuestoes').value = textoQuestoes.value + inputQuestao.value + "-" + inputAlternativa1.value + "-" + inputAlternativa2.value + "-" + inputAlternativa3.value + "-" + inputAlternativa4.value + ";";
  
  document.querySelector('#questao').value = ""
  document.querySelector('#alternativa1').value = ""
  document.querySelector('#alternativa2').value = ""
  document.querySelector('#alternativa3').value = ""
  document.querySelector('#alternativa4').value = ""


  console.log(document.querySelector('#listaQuestoes').value)
}