window.addEventListener('load', function () {

(function(){
  event.preventDefault();
  const url = '/odontologos';
  const settings = {
    method: 'GET'
}
  fetch(url,settings)
  .then(response => response.json())
  .then(data => {
     const dataOrdenada = data.sort(function(a, b){return a.id-b.id})
     for(odontologo of dataOrdenada){
       let deleteButton = '<button' +
                                  ' id=' + '\"' + 'btn_delete_' + odontologo.id + '\"' +
                                  ' type="button" onclick="deleteBy('+odontologo.id+')" class="btn btn-danger btn_delete">' +
                                  '&times' +
                                  '</button>';

      let get_More_Info_Btn = '<button' +
                                  ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                  ' type="button" onclick="findBy('+odontologo.id+')" class="btn btn-info btn_id">' +
                                  odontologo.id +
                                  '</button>';

      let tr_id = 'tr_' + odontologo.id;
      let odontologoRow = '<tr id=\"' + tr_id + "\"" + '>' +
                '<td>' + get_More_Info_Btn + '</td>' +
                '<td>' + odontologo.nombre.toUpperCase() + '</td>' +
                '<td>' + odontologo.apellido.toUpperCase() + '</td>' +
                '<td>' + odontologo.matricula.toUpperCase() + '</td>' +
                '<td>' + deleteButton + '</td>' +
                '</tr>';
      $('#tablaOdontologo tbody').append(odontologoRow);
    };

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/listaOdontologo.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})