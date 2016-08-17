/**
 * Created by Michael on 17/08/2016.
 */
/**
 * Created by Michael on 15/08/2016.
 */
var pics = [
    "images/controller.png",
    "images/cherries.png",
    "images/cards.png",
    "images/bombs.png",
    "images/bomb.png",
    "images/board-game.png",
    "images/ball.png",
    "images/ammo.png"
];

var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; //January is 0!
var yyyy = today.getFullYear();

if(dd<10) {
    dd='0'+dd
}

if(mm<10) {
    mm='0'+mm
}

today = mm+'.'+dd+'.'+yyyy;
// document.write(today);


var ImageRandom = "";
var num;
var name
function myF() {
    num = Math.floor(Math.random() * pics.length);
    ImageRandom = pics[num];
    document.getElementById("pic").style.backgroundImage = 'url(' +ImageRandom+ ')';
    name=document.getElementById('name').value;
    document.getElementById("title").innerHTML = name+ "'s New UserPic!";
    console.log(name);

    var dateBy = document.createElement('p');
    dateBy.id = "para";
    dateBy.innerHTML =  "Generated Today - "+ today;
    document.getElementById('title').appendChild(dateBy);

}


