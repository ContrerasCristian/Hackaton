$(document).ready(function(){

});

async function registrarEmprendimientos(){
    let datos = {};
    datos.nombre = document.getElementById('nombreEmprendimiento').value;
    datos.tiempo = document.getElementById('tiempo').value;
    datos.descripcion = document.getElementById('descripcion').value;
    datos.correo = document.getElementById('correo').value;
    datos.telefono = document.getElementById('telefono').value;

    const request = await fetch('api/registrar',{
            method: 'POST',
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
             body: JSON.stringify(datos)
        });

    alert("Emprendimiento creado con exito");
     window.location.href = 'emprendimientos.html'
   //

}