/**
 * 
 */

function success() {
	
	 if(document.getElementById("cantMensajeria").value==="") { 
		 
           document.getElementById('button').disabled = true; 
           
       } else if(document.getElementById("fechaMensa").value===""){ 
    	   
    	   document.getElementById('button').disabled = true; 
    	   
       }else if(document.getElementById("remiteMensa").value===""){ 
    	   
    	   document.getElementById('button').disabled = true; 
    	   
       }else if(document.getElementById("notasMensa").value===""){ 
    	   
    	   document.getElementById('button').disabled = true; 
    	   
       }else{
    	   
    	   document.getElementById('button').disabled = false;
       }
   }


