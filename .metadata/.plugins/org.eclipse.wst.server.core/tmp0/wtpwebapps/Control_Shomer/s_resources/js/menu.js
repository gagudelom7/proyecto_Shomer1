const burger = document.querySelector('.burger');
const menu = document.querySelector('.menu-navegacion');

console.log(menu);
console.log(burger);

/* Con esta funcion hacemos que cada vez que se le de click al menu le vas a poner o 
le vas a quitar la clase SPREAD */
burger.addEventListener('click', ()=>{
    
	menu.classList.toggle("spread");

})

/* para cerrar el menu */

window.addEventListener('click', e=>{
    if(menu.classList.contains('spread') && e.target != menu && e.target != burger ){
            
            menu.classList.toggle("spread");
    }
})