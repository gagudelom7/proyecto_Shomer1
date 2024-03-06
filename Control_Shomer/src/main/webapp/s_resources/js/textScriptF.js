/**
 * 
 */

function success() {
	
	 if(document.getElementById("nameFuncionario").value==="") { 
		 
           document.getElementById('button').disabled = true; 
           
       } else if(document.getElementById("apelFuncionario").value===""){ 
    	   
    	   document.getElementById('button').disabled = true; 
    	   
       }else if(document.getElementById("telOficina").value===""){ 
    	   
    	   document.getElementById('button').disabled = true; 
    	   
       }else if(document.getElementById("emailFuncionario").value===""){ 
    	   
    	   document.getElementById('button').disabled = true; 
    	   
       }else{
    	   
    	   document.getElementById('button').disabled = false;
       }
   }


