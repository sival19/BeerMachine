function changeSpeed(e) {
    var b = document.getElementById("productType").value = e.target.value
    console.log(b);
    if(b === "0.0") {
        document.getElementById("machineSpeed").setAttribute('max', "600");
        document.getElementById("machineSpeed").setAttribute('value', "486");
    }
    else if(b === "1.0"){
        document.getElementById("machineSpeed").setAttribute('max', "300");
        document.getElementById("machineSpeed").setAttribute('value', "82");
    }
    else if(b === "2.0"){
        document.getElementById("machineSpeed").setAttribute('max', "150");
        document.getElementById("machineSpeed").setAttribute('value', "100");

    }
    else if(b === "3.0"){
        document.getElementById("machineSpeed").setAttribute('max', "200");
        document.getElementById("machineSpeed").setAttribute('value', "184");

    }
    else if(b === "4.0"){
        document.getElementById("machineSpeed").setAttribute('max', "100");
        document.getElementById("machineSpeed").setAttribute('value', "81");

    }
    else if(b === "5.0"){
        document.getElementById("machineSpeed").setAttribute('max', "125");
        document.getElementById("machineSpeed").setAttribute('value', "23");

    }
}
