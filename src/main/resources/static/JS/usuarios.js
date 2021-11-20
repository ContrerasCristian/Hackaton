$(document).ready(function(){
    cargarUsuarios();
    $("#usuarios").DataTable();
    actualizarName();
});

function actualizarName(){
    document.getElementById('nameUser').outerHTML = localStorage.email;
}
async function cargarUsuarios(){
    const request = await fetch('api/usuarios',{
        method: 'GET',
        headers:{
            "Accept" : "application/json",
                    "Content-Type" : "application/json",
                    "Authorization":  localStorage.token
        },
      //  body: JSON.stringify({a:1, b: 'Textual-content'})
    })
    const usuarios = await request.json();
    console.log(usuarios);

    let listado = '';
    for(let index of usuarios){
    let botonEliminar= '<a href="#" onclick="eliminarUsuario(' + index.id + ')" "class="buton">Eliminar</a>';
    let usuarioHTML = '<tr><td>'+ index.id + '</td><td>'+ index.nombre + ' ' + index.apellido +
    '</td><td>'+ index.correo +'</td><td>'+ index.telefono +'</td><td>'
    + index.tipoUser +'</td><td>' + botonEliminar + '</td</tr>'
    listado += usuarioHTML
    }

    document.querySelector('#usuarios tbody').outerHTML = listado;
}

async function eliminarUsuario(id){
if(!confirm('¿Desea eliminar el usuario?')){
    return;
}
    const request = await fetch('api/usuarios/' + id,{
    method: "DELETE",
    headers: {
        "Accept" : "application/json",
        "Content-Type" : "application/json",
        "Authorization":  localStorage.token
    }
    });
 location.reload();
}