$(document).ready(function(){
    cargarEmprendimientos();
    $("#usuarios").DataTable();
});

async function cargarEmprendimientos(){
    const request = await fetch('api/emprendimientos',{
        method: 'GET',
        headers:{
            "Accept" : "application/json",
                    "Content-Type" : "application/json",
                    "Authorization":  localStorage.token
        },
      //  body: JSON.stringify({a:1, b: 'Textual-content'})
    })
    const emprendimientos = await request.json();
    console.log(emprendimientos)
    let listado = '';
    for(let index of emprendimientos){
    let botonEliminar= '<a href="#" onclick="eliminarUsuario(' + index.id + ')" "class="buton">Eliminar</a>';
    let usuarioHTML = '<tr><td>'+ index.id + '</td><td>'+ index.nombre +
    '</td><td>'+ index.tiempo +'</td><td>'+ index.descripcion +'</td><td>'
    + index.correo + '</td><td>' + index.telefono + '</td</tr>'
    listado += usuarioHTML
    }

    document.querySelector('#usuarios tbody').outerHTML = listado;
}