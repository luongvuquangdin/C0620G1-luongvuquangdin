function chuyenDoiTienTe() {
    let amount = parseInt(document.getElementById("Amount").value);
    let fromCurrency = document.getElementById("Fromcurrency").value;
    let tocurrency = document.getElementById("Tocurrency").value;
    if ((fromCurrency === "Vietnam") && (tocurrency === "USD")){
        document.getElementById("convert").innerHTML="Result:" + amount * 23000;
    } else if ((fromCurrency === "USD") && (tocurrency === "Vietnam")) {
        document.getElementById("convert").innerHTML ="Result:"+amount / 23000;
    } else {
        document.getElementById("convert").innerHTML ="Result:"+ amount;
    }

}