function clock() {
    let date = new Date();
    let hours = date.getHours();
    let minutes = date.getMinutes();
    let seconds = date.getSeconds();
    if (10 > hours) hours = "0" + hours;
    if (10 > minutes) minutes = "0" + minutes;
    if (10 > seconds) seconds = "0" + seconds;
    document.getElementById("clock").innerHTML = hours + ":" + minutes + ":" + seconds;
    setTimeout("clock()", 6000);
}