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
     for(odontologo of data){

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
      let studentRow = '<tr id=\"' + tr_id + "\"" + '>' +
                '<td>' + get_More_Info_Btn + '</td>' +
                '<td class=\"td_first_name\">' + odontologo.name.toUpperCase() + '</td>' +
                '<td class=\"td_last_name\">' + odontologo.lastname.toUpperCase() + '</td>' +
                '<td>' + deleteButton + '</td>' +
                '</tr>';
      $('#studentTable tbody').append(studentRow);
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