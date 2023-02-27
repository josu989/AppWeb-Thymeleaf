//consumir la api
$(document).ready(function() {
	cargarDataTable();
});


var dataTable;
function cargarDataTable() {
	dataTable = $('#tablaInstructores').DataTable({
		"ajax": {
			"type": "GET",
			"datatype": "json",
			"url": "/instructores/api/listadoInstructores"
		},
		"columns": [
			{ "data": "id", "width": "5%" },
			{ 
				"data": "id", 
				"width": "20%",
				"render": function(data, type, row, meta){
					return row.nombre + ' ' + row.apPaterno + ' ' +  row.apMaterno
				}
			},
			{ "data": "telefono", "width": "10%" },
			{ "data": "codigoInstructor", "width": "15%" },
			{ "data": "horas", "width": "15%" },
			{
				"data": "urlFoto",
				"width": "30%",
				"render": function(data) {
					return `<div class="text-center"><img src="/uploads/${data}" width="50%"/>
					</div>`
				}
			},
			{
				"data": "id",
				"width": "30%",
				"render": function(data) {
					return `<div class="text-center"><a class="btn btn-primary" href="/instructores/edit/${data}">Editar</a>&nbsp; <a class="btn btn-danger text=white" style="cursor:pointer;" onclick="Delete('/instructores/api/delete/${data}')">Eliminar</a></div>`
				},

			}
		],
		language: {
			"decimal": "",
			"emptyTable": "No hay información",
			"info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
			"infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
			"infoFiltered": "(Filtrado de _MAX_ total entradas)",
			"infoPostFix": "",
			"thousands": ",",
			"lengthMenu": "Mostrar _MENU_ Entradas",
			"loadingRecords": "Cargando...",
			"processing": "Procesando...",
			"search": "Buscar:",
			"zeroRecords": "Sin resultados encontrados",
			"paginate": {
				"first": "Primero",
				"last": "Ultimo",
				"next": "Siguiente",
				"previous": "Anterior"
			}
		}
	});
}


function Delete(url) {
	swal({
		title: "Esta seguro de borrar?",
		text: "Este contenido no se puede recuperar!",
		type: "warning",
		showCancelButton: true,
		confirmButtonColor: "#DD6B55",
		confirmButtonText: "Si, borrar!",
		closeOnconfirm: true
	}, function() {
		$.ajax({
			type: 'DELETE',
			url: url,
			success: function(response) {
				if (response.success == "true") {
					toastr.success(response.message);
					dataTable.ajax.reload();
				}
				else {
					toastr.error(data.message);
				}
			}
		});
	});
}


