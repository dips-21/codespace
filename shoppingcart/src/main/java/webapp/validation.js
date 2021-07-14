//select all error Msg
// var allMsg = document.getElementsByClassName("errMsg")
var allMsg = document.querySelectorAll(".errMsg");
// console.log(allMsg); // []nodelist

allMsg.forEach(function(el){
	console.log(el);
	el.style.display = "none";
});

/*
	Fnctional programming
*/


// function email(){
	
// }
// function password(){
	
// }
// function cpassword(){
	
// }
// function cap(){
	
// }

function name(txtBox){
	//alert(txtbox.value);
	// console.log('name called');
	// console.log(txtBox);
	// console.log(txtBox.value);
	//reg_name = /^[a-zA-Z]([a-zA-Z ]+)?[a-zA-Z]$/;
	reg_name = /^[a-zA-Z][a-zA-Z]([a-zA-Z ]+)?$/;
	result = reg_name.test(txtBox.value);
	// console.log(result);
	return result; //true or false
}

/*
function mobile(txtBox){
	reg_mob = /^[1-9][0-9]{9}$/;
	return reg_mob.test(txtBox.value);
}
function email(txtBox){
	reg_email = /^([a-zA-Z0-9]([a-zA-Z0-9_\.]+)?[a-zA-Z0-9])@(([a-zA-Z0-9]([a-zA-Z0-9\-]+)?[a-zA-Z0-9])\.([a-zA-Z]{2,})(\.[a-zA-Z]{2,})?)$/
	return reg_email.test(txtBox.value);
}*/
function password(txtBox){
	//alert(txtbox.value);
	reg_pass= /^(?=.*[a-z])(?=.*[@#\$])(?=.*[0-9])(?=.*[A-Z]).{4,8}$/;
	//reg_pass = /^(?=.*[a-z])(?=.*[@#\$])(?=.*[0-9])(?=.*[A-Z]).{4,8}$/;
	return reg_pass.test(txtBox.value);
}
/*
var sum=0;
function captcha(){
	// int(20.90)
	// float(20)
	//string(20)==>'20'
	var no1 = Math.round( 10*Math.random() );
	console.log(no1); // 0 and 1
	var no2 = Math.round (10*Math.random());
	console.log(no2);
	var str = ` ${no1} + ${no2} `
	console.log(str);
	document.querySelector("#capValue").innerHTML = str;
	sum = no1+no2;
}
captcha();
*/

       // document.getElementById("btn").onclick="alert('hello');"
       function validate(){
       alert("in validate")
	// console.log('test')	
	var rec1 = document.getElementById("cid");
	alert(rec1.value);
	//console.log(rec1);
	var rec2 = document.getElementById("pwd");
	//console.log(rec2);
	alert(rec2.value);
	//var rec3 = document.getElementById("uEmail");
	//var rec4 = document.querySelector("#uPass");
	//var rec5 = document.querySelector("#uCpass");
	//var rec6 = document.querySelector("#uCap");
	
	// var ans1 = name(rec1);
	// console.log(ans1 , "===");
	var valid = false;
        alert(rec1.parentElement.nextElementSibling);
	rec1.parentElement.nextElementSibling.style.display=(name(rec1))?"none":"block";
	rec2.parentElement.nextElementSibling.style.display = (password(rec2))?"none":"block";
	alert(name(rec1))
	//alert(password(rec2))
        if ((name(rec1)) && (password(rec2))) 
		valid=true;
	else
		valid=false;
	// document.getElementById("errId").style.display = (email(rec3))?"none":"block";
	//rec3.nextElementSibling.nextElementSibling.style.display = (email(rec3))?"none":"block";
	//rec4.nextElementSibling.style.display = (password(rec4))?"none":"block";
	// password(rec5) && rec4.value==rec5.value
	//rec5.nextElementSibling.style.display = (password(rec5) && rec4.value==rec5.value)?"none":"block";
	//rec6.nextElementSibling.style.display = (rec6.value==sum)?"none":"block";
	alert(valid);
	return valid;
}


