function fverificaSenha() {
	var p1 = document.getElementById("p1");
	var p2 = document.getElementById("p2");
	var sp1 = document.getElementById("sp1");
	var sp2 = document.getElementById("sp2");

	if (p1.value === null || p1.value==="") {
		sp1.style.color = "red";
		alert("Senha não pode ser vazia");
	} else if (p1.value === null || p1.value==="") {
		alert("Senha não pode ser vazia"); 
	}
}