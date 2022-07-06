window.addEventListener('load', function () {

(function(){
  event.preventDefault();
  const url = '/pacientes';
  const settings = {
    method: 'GET'
}
  fetch(url,settings)
  .then(response => response.json())
  .then(data => {
     const dataOrdenada = data.sort(function(a, b){return a.id-b.id})
     for(paciente of dataOrdenada){
     console.log(paciente)

       let deleteButton = '<button' +
                                  ' id=' + '\"' + 'btn_delete_' + paciente.id + '\"' +
                                  ' type="button" onclick="deleteBy('+ paciente.id+')" class="btn btn-danger btn_delete">' +
                                  '&times' +
                                  '</button>';

      let get_More_Info_Btn = '<button' +
                                  ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                  ' type="button" onclick="findBy('+paciente.id+')" class="btn btn-info btn_id">' +
                                  paciente.id +
                                  '</button>';

      let tr_id = 'tr_' + paciente.id;
      let pacienteRow = '<tr id=\"' + tr_id + "\"" + '>' +
                '<td>' + get_More_Info_Btn + '</td>' +
                '<td>' + paciente.nombre.toUpperCase() + '</td>' +
                '<td>' + paciente.apellido.toUpperCase() + '</td>' +
                '<td>' + paciente.dni.toUpperCase() + '</td>' +
                '<td>' + paciente.domicilio.toUpperCase() + '</td>' +
                '<td>' + deleteButton + '</td>' +
                '</tr>';
      $('#tablaPaciente tbody').append(pacienteRow);
    };

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/listaPaciente.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})