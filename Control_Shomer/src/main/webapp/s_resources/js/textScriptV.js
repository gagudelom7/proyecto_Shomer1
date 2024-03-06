/**
 * 
 */

function success() {
	
	 if(document.getElementById("nameVisitante").value==="") { 
		 
           document.getElementById('button').disabled = true; 
           
       } else if(document.getElementById("apelVisitante").value===""){ 
    	   
    	   document.getElementById('button').disabled = true; 
    	   
       }else if(document.getElementById("numeroId").value===""){ 
    	   
    	   document.getElementById('button').disabled = true; 
    	   
       }else if(document.getElementById("movilVisitante").value===""){ 
    	   
    	   document.getElementById('button').disabled = true; 
    	   
       }else if(document.getElementById("emailVisitante").value===""){ 
    	   
    	   document.getElementById('button').disabled = true; 
    	   
       }else if(document.getElementById("fechaVisitante").value===""){ 
    	   
    	   document.getElementById('button').disabled = true; 
    	   
       }else if(document.getElementById("notas").value===""){ 
    	   
    	   document.getElementById('button').disabled = true; 
    	   
       }else{
    	   
    	   document.getElementById('button').disabled = false;
       }
   }


