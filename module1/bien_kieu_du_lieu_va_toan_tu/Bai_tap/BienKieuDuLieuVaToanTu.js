
function SumandMedium() {
    let physical=parseInt(document.getElementById("physical").value);
    let chemistry=parseInt(document.getElementById("Chemistry").value);
    let biological=parseInt(document.getElementById("biological").value);
    let sum=physical+chemistry+biological;
    let medium=sum/3;
    document.getElementById("Sum").value=sum;
    document.getElementById("Medium").value=medium;
}
/* Bai 2
function move() {
    let doC = parseInt(document.getElementById("OC").value);
    let doF = ((9 * doC) / 5) + 32;
    document.getElementById("movea").value = doF;
}*/
/* Bài 3 và bài 4
function chuViVaDienTich() {
    let radius=parseInt(document.getElementById("Radius").value);
    const pi=3.14;
    let perimeter=2*radius*pi;
    let acreage=radius*radius*pi;
    document.getElementById("Perimeter").value = perimeter;
    document.getElementById("Acreage").value = acreage;
}
 */
