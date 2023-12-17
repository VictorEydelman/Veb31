var r="";

document.addEventListener("DOMContentLoaded",function (){
    document.getElementById("php").reset()
    if (typeof subtrue === 'undefined') {
        subtrue=false;
    }
    document.getElementById("imgt").innerHTML +=
        "<h4 class='prov' id='rnot' style='color:red' >Не введён R</h4>";
    document.getElementById("rnot").style.visibility="hidden"
    document.getElementById("php:add").disabled=true
})
window.setInterval(function () {
    if(r==="r1") {
        Rcheck()
        document.getElementById("php:r1").style.background = "red"
    }
    if(r==="r2") {
        Rcheck()
        document.getElementById("php:r2").style.background = "red"
    }
    if(r==="r3") {
        Rcheck()
        document.getElementById("php:r3").style.background = "red"
    }
    if(r==="r4") {
        Rcheck()
        document.getElementById("php:r4").style.background = "red"
    }
    if(r==="r5") {
        Rcheck()
        document.getElementById("php:r5").style.background = "red"
    }
    document.getElementById("php:Y").addEventListener("input",Ycheck)
    if(document.getElementById("Yprov1")!= null || document.getElementById("Yprov2")!= null
        || document.getElementById("Yprov3")!= null
        || r===""){
        document.getElementById("php:add").disabled=true
    } else {
        document.getElementById("php:add").disabled=false
    }
    document.getElementById("svg").onclick=function (e){
        alert("qwertyu");
        let svg=document.getElementById("svg").getBoundingClientRect();
        let x=(e.clientX-svg.x)
        let y = (e.clientY - svg.y)
        if(r!==""){
            rad=Radius()
            x=(x-140)/80*rad
            y=(140-y)/80*rad
            x=x.toFixed(2)
            y=y.toFixed(16)
            let time = Intl.DateTimeFormat().resolvedOptions().timeZone;
            document.getElementById("php:Y").value=y

            document.getElementById("php:x_input").value=x
            document.getElementById("php:add").click()

            //ajax(x,y,r,time)
        } else {
            alert("3")
            document.getElementById("rnot").style.visibility="visible"
        }
    }
})
function Radius(){
    if(r==="r1") {
        return 1
    }
    if(r==="r2") {
        return 2
    }
    if(r==="r3") {
        return 3
    }
    if(r==="r4") {
        return 4
    }
    if(r==="r5") {
        return 5
    }
}

    function Rcheck1(){
        Rcheck();
        r="r1";
        document.getElementById("php:r").value=1
    }
    function Rcheck2(){
        Rcheck();
        r="r2"
        document.getElementById("php:r").value=2
    }
    function Rcheck3(){
        Rcheck();
        r="r3"
        document.getElementById("php:r").value=3
    }
    function Rcheck4(){
        Rcheck();
        r="r4"
        document.getElementById("php:r").value=4
    }
    function Rcheck5(){
        Rcheck();
        r="r5"
        document.getElementById("php:r").value=5
    }
function Rcheck() {
    if (typeof rprov === 'undefined') {
        rprov = 0
        r=""
        m=document.getElementById("php:r2").style.background
    }
    rad=Radius();

    document.getElementById("-r").innerHTML = -rad;
    document.getElementById("2-r").innerHTML = -rad;
    document.getElementById("r").innerHTML = rad;
    document.getElementById("2r").innerHTML = rad;
    document.getElementById("-r/2").innerHTML = -rad/2;
    document.getElementById("2-r/2").innerHTML = -rad/2;
    document.getElementById("r/2").innerHTML = rad/2;
    document.getElementById("2r/2").innerHTML = rad/2;
    document.getElementById("php:r1").style.background=m
    document.getElementById("php:r2").style.background=m
    document.getElementById("php:r3").style.background=m
    document.getElementById("php:r4").style.background=m
    document.getElementById("php:r5").style.background=m
}

function Ycheck() {
    if (typeof yprov === 'undefined') {
        yprov = 0
    }
    let y = document.getElementById("php:Y").value;
    if (y.includes('0x')) {
        y = y.replace('0x', '');
        document.getElementById("php:Y").value = y;
    }
    if (y.includes('0X')) {
        y = y.replace('0X', '');
        document.getElementById("php:Y").value = y;
    }

    if (y === "") {
        //document.getElementById("submit").disabled = true;
        if (yprov > 0) {
            yprov = delete_element(yprov);}
        yprov = 1;
        f = false;
        document.getElementById("yblock").innerHTML +=
            "<h4 class='prov' id='Yprov1' >Не введён Y</h4>";

    }else if (isNaN(y) && y !== "-" && !y.includes(",")) {
        //document.getElementById("submit").disabled = true;
        if (yprov > 0) {
            yprov = delete_element(yprov);
        }
        yprov = 2;
        f = false;
        document.getElementById("yblock").innerHTML +=
            "<h4 class='prov' id='Yprov2'>Ошибка при вводе Y</h4>";
    } else if(y.includes(",")) {
        if (!y.includes(".")) {
            y = y.replace(',', '.');
        } else{
            y = y.replace(',', '');
        }
        document.getElementById("php:Y").value = y;
    } else if (y < -5 || y > 3) {
        //document.getElementById("submit").disabled = true;
        if (yprov > 0) {
            yprov = delete_element(yprov);
        }
        yprov = 3;
        f = false;
        document.getElementById("yblock").innerHTML +=
            "<h4 class='prov' id='Yprov3' >Y вышел за приделы от -5 до 3</h4>";
    } else if(y==="-"){
        //document.getElementById("submit").disabled = true;
        if (yprov > 0) {
            yprov = delete_element(yprov);
        }
    } else {
        //document.getElementById("php:ysvg").value=document.getElementById("php:Y").value
        //document.getElementById("submit").disabled = false;
        yprov=delete_element(yprov)
    }
}
function delete_element(prov) {
    if (prov === 1) {
        document.getElementById("Yprov1").remove();
    }
    if (prov === 2) {
        document.getElementById("Yprov2").remove();
    }
    if (prov === 3) {
        document.getElementById("Yprov3").remove();
    }
    return  0;
}



function Xcheck() {
    if (typeof xprov === 'undefined') {
        xprov = 0
    }

    //alert(document.getElementById("php:x").value)
    //document.getElementById("php:xsvg").value=document.getElementById("php:x").value
    //alert(document.getElementById("php:xsvg").value)
}

function f(){
    alert("q")
}