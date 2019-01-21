function formValidation()
{
var uname = document.registration.name;
var passid = document.registration.password;
var uemail = document.registration.email;
var uregDate = document.registration.regDate;
var udepoditAmt = document.registration.depoditAmt;


if(ValidateEmail(uemail))
{
	if(passid_validation(passid,7,12))
	{
		if(allLetter(uname))
		{
			if(allnumeric(udepositAmt))
			{
							
			}
		}
	}
}
return fasle;
}



function ValidateEmail(uemail )
{
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(uemail.value.match(mailformat))
{
return true;
}
else
{
alert("You have entered an invalid email address!");
return false;
}
}

function passid_validation(passid,mx,my)
{
//Minimum 8 characters at least 1 Alphabet, 1 Number and 1 Special Character	
//var passw=  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]$/;	
//console.log(passid);
var passid_len = passid.value.length;
if (passid_len == 0 || passid_len >= my || passid_len < mx)
{
alert("Password should not be empty / length be between "+mx+" to "+my);
passid.focus();
return false;
}
return true;
}

function allnumeric(udepositAmt)
{ 
var numbers = /^[0-9]+$/;
if(uzip.value.match(numbers))
{
	if(depositAmt==1500)
	{
		return true;
	}
	else
		{
			alert('Minimum Amount 1500');
			return false;
		}
}
else
{
alert('Amount must have numeric characters only');
udepositAmt.focus();
return false;
}
}