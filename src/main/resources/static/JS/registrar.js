$(document).ready(function(){

});

async function registrarUsuarios(){
    let datos = {};
    datos.nombre = document.getElementById('nombre').value;
    datos.apellido = document.getElementById('apellido').value;
    datos.correo = document.getElementById('correo').value;
    datos.telefono = document.getElementById('telefono').value;
    datos.contrasena = document.getElementById('contrasena').value;
    datos.tipoUser = $('input[name="tipo"]:checked').val();

    const request = await fetch('api/usuarios',{
        method: 'POST',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
         body: JSON.stringify(datos);
    });
       |

    alert("Cuenta creada con exito");
    window.location.href = 'login.html'

}
