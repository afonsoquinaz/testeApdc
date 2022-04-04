
    	
    //	xmlhttp = new XMLHttpRequest();
    	

   //  xmlhttp = new XMLHttpRequest();



   function addItem() {
    alert("hire the security team");
    var newItem = document.createElement("div");
    newItem.innerHTML = document.getElementById("box").value;
    document.getElementById("list").appendChild(newIem);

    } 
    

    function addSimpleRegister(){
        xmlhttp = new XMLHttpRequest();
        alert("simple register");
        var textUserSimpleRegister = document.getElementById("simpleUserRegister").value;
        var textPassSimpleRegister = document.getElementById("simplePassRegister").value;
        
        //http://afonsoq.appspot.com/rest/register/v1
        xmlhttp.open('POST', 'https://afonsoq.appspot.com/rest/register/v1',true);
        xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        
        var myObj = {
            username: "random007",
            password: "password2"
        };
        var myJSON = JSON.stringify(myObj);
        xmlhttp.send(myJSON);
        alert("simple register FINISHEDD");
    }

    function remove() {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", 'https://afonsoq.appspot.com/rest/delete/v2', true);
    
        //const username = document.getElementById('username')
    
        xhr.setRequestHeader('Content-Type', '/application/json; charset=utrf-8');
    
        xhr.onreadystatechange = function(){
            if(this.readyState === XMLHttpRequest.DONE && this.status === 200){
                //Request finished. Do processing here
            }
        }
        xhr.send(JSON.stringify('{"username": RANDOM7}'))
    }
    
        function remove1() {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", 'https://afonsoq.appspot.com/rest/delete/v2', true);
    
        //const username = document.getElementById('username')
    
        xhr.setRequestHeader('Content-Type', '/application/json; charset=utrf-8');
    
        xhr.onreadystatechange = function(){
            if(this.readyState === XMLHttpRequest.DONE && this.status === 200){
                //Request finished. Do processing here
            }
        }
        xhr.send(JSON.stringify('{username: "RANDOM7"}'))
    }
    
            
   

    function addSimpleRegister2(){
        xmlhttp = new XMLHttpRequest();

        var textUserSimpleRegister = document.getElementById("simpleUserRegister").value;
        var textPassSimpleRegister = document.getElementById("simplePassRegister").value;
        var myObj = { "username": textUserSimpleRegister, "password": textPassSimpleRegister };
      
        var myJSON = JSON.stringify(myObj);
        xmlhttp.open('POST', 'https://afonsoq.appspot.com/rest/register/v1',true);
        xmlhttp.setRequestHeader("Content-Type", "application/json");


        if(xmlhttp){
            xmlhttp.onreadystatechange = function() {
                if(xmlhttp.readyState == 4){

                        alert(myObj.username);
                        
                        
                    
                }else {
                    if(xmlhttp.status == 401)
                        alert("401: unauthorized" + xmlhttp.responseText);
                }
            }
            
        }

        xmlhttp.send(myJSON);
    }





    function addSimpleRegister1(){
        const xhr = new XMLHttpRequest();
        xhr.open('GET', 'https://reqres.in/api/users');

    xhr.onload = () => {
        const data = JSON.parse(xhr.response);
       console.log(data);
    };

        xhr.send();
    }

    function addSimpleRegister1(){

        const xhr = new XMLHttpRequest();
        xhr.open('GET', 'https://reqres.in/api/users');

        xhr.setRequestHeader('Content_Type' , 'application/json');

        xhr.onload = () => {
         const data = JSON.parse(xhr.response);
         console.log(data);
        };

        xhr.send();
    }






    function getUsers(){
        xmlhttp = new XMLHttpRequest();
        if(xmlhttp){
            xmlhttp.onreadystatechange = function() {
                if(xmlhttp.readyState == 4){
                    var myObj = JSON.parse(xmlhttp.responseText);
                    alert(xmlhttp.responseText);
                    var i;
                    for(i=0; i< myObj.length; i++){
                        alert(myObj[i].nome);
                    }

                }else {
                    if(xmlhttp.status == 401)
                        alert("401: unauthorized" + xmlhttp.responseText);
                }
            }
            xmlhttp.open("POST", "http://afonsoq.appspot.com/rest/list/User2");
            xmlhttp.send(null);
        }
    }
    
//	xmlhttp.open("GET" , "https://afonsoq.appspot.com/", true);
//	xmlhttp.send(null);
    


const getBtn = document.getElementById('get-btn');
const postBtn = document.getElementById('post-btn');

const sendHttpRequest = (method, url, data) => {
const promise = new Promise((resolve, reject) => {
const xhr = new XMLHttpRequest();
xhr.open(method, url);

xhr.responseType = 'json';

if (data) {
  xhr.setRequestHeader('Content-Type', 'application/json');
}

xhr.onload = () => {
  if (xhr.status >= 400) {
    reject(xhr.response);
  } else {
    resolve(xhr.response);
  }
};

xhr.onerror = () => {
  reject('Something went wrong!');
};

xhr.send(JSON.stringify(data));
});
return promise;
};

const getData = () => {
sendHttpRequest('GET', 'https://reqres.in/api/users').then(responseData => {
console.log(responseData);
});
};

const sendData = () => {
sendHttpRequest('POST', 'https://afonsoq.appspot.com/rest/register/v1', {
email: "eve.holt@reqres.in",
password: "pistol"
})
.then(responseData => {
  console.log(responseData);
})
.catch(err => {
  console.log(err);
});

};











function postRegister() {
var xhr = new XMLHttpRequest();
xhr.open("POST", 'https://afonsoq.appspot.com/rest/register/v1', true);
const textUserSimpleRegister = document.getElementById("simpleUserRegister");
const textPassSimpleRegister = document.getElementById("simplePassRegister");
//Send the proper header information along with the request
xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');

xhr.onreadystatechange = function() { // Call a function when the state changes.
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        // Request finished. Do processing here.
    }
}
xhr.send(JSON.stringify({"username": textUserSimpleRegister.value, "password": textPassSimpleRegister.value}));
alert("Register sucessfull")
}

function postFullRegister() {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", 'https://afonsoq.appspot.com/rest/register/v9', true);

    const usernameRegister = document.getElementById("usernameRegister");
    const passwordRegister = document.getElementById("passwordRegister");
    const confirmationRegister = document.getElementById("confirmationRegister");
    const emailRegister = document.getElementById("emailRegister");
    const nameRegister = document.getElementById("nameRegister");
    const isPublicRegister = document.getElementById("isPublicRegister");
    const tFixoRegister = document.getElementById("tFixoRegister");
    const tMovelRegister = document.getElementById("tMovelRegister");
    const nifRegister = document.getElementById("nifRegister");
    //const nifRegister = document.getElementById("nifRegister");
   
    //const textPassSimpleRegister = document.getElementById("simplePassRegister");

    


    //Send the proper header information along with the request
    xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
    
    xhr.onreadystatechange = function() { // Call a function when the state changes.
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            // Request finished. Do processing here.
        }
    }
    xhr.send(JSON.stringify({"username": usernameRegister.value,
    "password": passwordRegister.value,
    "confirmation": confirmationRegister.value,
    "email": emailRegister.value,
    "name": nameRegister.value,
    "isPublic": isPublicRegister.value,
    "tFixo": tFixoRegister.value,
    "tMovel": tMovelRegister.value,
    "nif": nifRegister.value }));

    alert("Register sucessfull")
    }


    function postFullRegisterV11() {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", 'https://afonsoq.appspot.com/rest/register/v11', true);
    
        const usernameRegister = document.getElementById("usernameRegister");
        const passwordRegister = document.getElementById("passwordRegister");
        const confirmationRegister = document.getElementById("confirmationRegister");
        const emailRegister = document.getElementById("emailRegister");
        const nameRegister = document.getElementById("nameRegister");
        const isPublicRegister = document.getElementById("isPublicRegister");
        const tFixoRegister = document.getElementById("tFixoRegister");
        const tMovelRegister = document.getElementById("tMovelRegister");
        const nifRegister = document.getElementById("nifRegister");
        const role = document.getElementById("role");
       
        //const textPassSimpleRegister = document.getElementById("simplePassRegister");
 
    
    
        //Send the proper header information along with the request
        xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
        
        xhr.onreadystatechange = function() { // Call a function when the state changes.
            if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                // Request finished. Do processing here.
            }
        }
        xhr.send(JSON.stringify({"username": usernameRegister.value,
        "password": passwordRegister.value,
        "confirmation": confirmationRegister.value,
        "email": emailRegister.value,
        "name": nameRegister.value,
        "isPublic": isPublicRegister.value,
        "tFixo": tFixoRegister.value,
        "tMovel": tMovelRegister.value,
        "nif": nifRegister.value,
        "role": role.value }));
    
        alert("Register sucessfull")
        }



    function getUser(username ,password){
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", 'https://afonsoq.appspot.com/rest/login/user', true);

        if(xmlhttp){
            xmlhttp.onreadystatechange = function() {
                if(xmlhttp.readyState == 4){
                    
                      //  const textLoggedUser = document.getElementById("textLoggedUser");
                      //  textLoggedUser.textContent = xmlhttp.responseText ;
                      //  textLoggedUser.value = xmlhttp.responseText ;
                    

                }else {
                    if(xmlhttp.status == 401)
                        alert("401: unauthorized" + xmlhttp.responseText);
                }
            }
            xmlhttp.open("POST", "http://afonsoq.appspot.com/rest/list/User");
            xmlhttp.send(JSON.stringify({"username": username,
            "password": password }));
        }
    }

    function removeV1() {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", 'https://afonsoq.appspot.com/rest/delete/v1', true);
        const removeUserText = document.getElementById("removeUserText");
        xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
      
        //const username = document.getElementById('username')
    
        xhr.setRequestHeader('Content-Type', '/application/json; charset=utrf-8');

            xhr.onreadystatechange = function() { // Call a function when the state changes.
            if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                alert("User REgistered")
               
            }
        }
        xhr.send(JSON.stringify({"username": removeUserText.value}));
     
    }


    function doSimpleLogin(){
        

        const loginSimpleButton = document.getElementById("loginSimpleButton");
        
       
        if(loginSimpleButton.value == "LOGIN"){

            var xhr = new XMLHttpRequest();
            xhr.open("POST", 'https://afonsoq.appspot.com/rest/login/v10', true);
            const textUserSimpleLogin = document.getElementById("usernameSimpleLogin");
            const textPassSimpleLogin = document.getElementById("passwordSimpleLogin");
            //Send the proper header information along with the request
            xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
            
            xhr.onreadystatechange = function() { // Call a function when the state changes.
                if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                    alert("You are logged")
                    const loginSimpleButton = document.getElementById("loginSimpleButton");
                    //loginSimpleButton.textContent = "LOG OUT" ;
                    loginSimpleButton.value = "LOGOUT"
                    //loginSimpleButton.onclick = "doSimpleLogOut();"
                    getUser(textUserSimpleLogin.value , textPassSimpleLogin.value);
    
                    const textLoggedUser = document.getElementById("textLoggedUser");
                    textLoggedUser.innerHTML = "YOU ARE LOGGED";
    
                    const removeUserButton = document.getElementById("removeUserButton");
                    removeUserButton.disabled = false
      
                    const updatePasswordButton = document.getElementById("updatePasswordButton");
                    updatePasswordButton.disabled = false

                    const updateEmailButton = document.getElementById("updateEmailButton");
                    updateEmailButton.disabled = false

                    const updatePhoneButton = document.getElementById("updatePhoneButton");
                    updatePhoneButton.disabled = false

                    const updateRoleButton = document.getElementById("updateRoleButton");
                    updateRoleButton.disabled = false
      
                }
            }
            xhr.send(JSON.stringify({"username": textUserSimpleLogin.value, "password": textPassSimpleLogin.value}));
  


        }else if(loginSimpleButton.value == "LOGOUT"){
            alert("You are logged out")
            const loginSimpleButton = document.getElementById("loginSimpleButton");
            //loginSimpleButton.textContent = "LOG IN" ;
            loginSimpleButton.value = "LOGIN"
            //loginSimpleButton.onclick = "doSimpleLogin();"

            const textLoggedUser = document.getElementById("textLoggedUser");

            textLoggedUser.innerHTML = "YOU ARE NOT LOGGED";
            
            const removeUserButton = document.getElementById("removeUserButton");
            removeUserButton.disabled = true

            const updatePasswordButton = document.getElementById("updatePasswordButton");
            updatePasswordButton.disabled = true

            const updateEmailButton = document.getElementById("updateEmailButton");
            updateEmailButton.disabled = true

            const updatePhoneButton = document.getElementById("updatePhoneButton");
            updatePhoneButton.disabled = true

            const updateRoleButton = document.getElementById("updateRoleButton");
            updateRoleButton.disabled = true

        
            
        }
        
    }

    function changeP(){
        
        const tryText = document.getElementById("tryText");
        tryText.innerHTML = "DEU?" ;
    }

    function updatePassword(){
        var xhr = new XMLHttpRequest();
        xhr.open("POST", 'https://afonsoq.appspot.com/rest/update/pass', true);

        const updatePassUser = document.getElementById("updatePassUser");
        const updatePassPass = document.getElementById("updatePassPass");
        const updatePassPass2 = document.getElementById("updatePassPass2");

        xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
      
        //const username = document.getElementById('username')
    
            xhr.onreadystatechange = function() { // Call a function when the state changes.
            if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                alert("PASS ALTERED")
               
            }
        }
        xhr.send(JSON.stringify({"username": updatePassUser.value, "password": updatePassPass.value, "confirmation": updatePassPass2.value}));
    }

    function updateEmail(){
        var xhr = new XMLHttpRequest();
        xhr.open("POST", 'https://afonsoq.appspot.com/rest/update/email', true);

        const updateEmail = document.getElementById("updateEmail");
        const username = document.getElementById("usernameSimpleLogin");
        //const updatePassPass2 = document.getElementById("updatePassPass2");

        xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
      
        //const username = document.getElementById('username')
    
            xhr.onreadystatechange = function() { // Call a function when the state changes.
            if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                alert("EMAIL ALTERED")
               
            }
        }
        xhr.send(JSON.stringify({"username": username.value, "email": updateEmail.value}));
    }

    function updatePhone(){
        var xhr = new XMLHttpRequest();
        xhr.open("POST", 'https://afonsoq.appspot.com/rest/update/phone', true);

        const updatePhone = document.getElementById("updatePhone");
        const username = document.getElementById("usernameSimpleLogin");
        //const updatePassPass2 = document.getElementById("updatePassPass2");

        xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
      
        //const username = document.getElementById('username')
    
            xhr.onreadystatechange = function() { // Call a function when the state changes.
            if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                alert("PHONE ALTERED")
               
            }
        }
        xhr.send(JSON.stringify({"username": username.value, "email": updatePhone.value , "password": username.value, "tMovel": updatePhone.value}));
    }

    function updateRole(){
        var xhr = new XMLHttpRequest();
        xhr.open("POST", 'https://afonsoq.appspot.com/rest/update/role', true);

        const newRole = document.getElementById("updateROLE");
        const username1 = document.getElementById("usernameSimpleLogin");
        const username2 = document.getElementById("updateROLEUser");
        //const updatePassPass2 = document.getElementById("updatePassPass2");

        xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
      
        //const username = document.getElementById('username')
    
            xhr.onreadystatechange = function() { // Call a function when the state changes.
            if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                alert("ROLE ALTERED")
               
            }
        }
        xhr.send(JSON.stringify({"username1": username1.value, "username2": username2.value , "newRole": newRole.value}));
    }

    function doSimpleLogOut(){      
                alert("You are logged out")
                const loginSimpleButton = document.getElementById("loginSimpleButton");
                loginSimpleButton.textContent = "LOG IN" ;
                loginSimpleButton.value = "LOGIN"
                loginSimpleButton.onclick = "doSimpleLogin();"

                const textLoggedUser = document.getElementById("textLoggedUser");

                textLoggedUser.innerHTML = "YOU ARE NOT LOGGED";
                
                const removeUserButton = document.getElementById("removeUserButton");
                removeUserButton.disabled = false
         
    }