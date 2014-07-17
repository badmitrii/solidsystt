var sale_add_button = document.getElementById("addbut");
var modfrm = document.getElementById("modfrm");
var create = document.getElementById("create");
var count = document.getElementById("count");
var date = document.getElementById("date");
var name = document.getElementById("name");

var info = document.getElementsByClassName("button_right");
var inf = document.getElementById("info");
var newsale = document.getElementById("newsale");

console.log(inf);

sale_add_button.onclick = function()
{
    modfrm.style.display = "block";
    inf.style.display= "none";
    newsale.style.display = "block";
}

create.onclick = function()
{
    console.log(/[0-9]{4}-[0-9]{2}-[0-9]{2}$/.test(date.value));
    if (!/^[0-9]+$/.test(count.value))
    {
        count.style.border = "1px solid red";
    }
    else if (!/^[0-9]{4}-[0-9]{2}-[0-9]{2}$/.test(date.value))
    {
        date.style.border = "1px solid red";
    }
    else
    {
        xmlhttp = new XMLHttpRequest();
        xmlhttp.open('GET', '/SolidSystemsTestTask/sales/add.htm?name=' + name.options[name.selectedIndex].text + '&count=' + count.value + '&date=' + date.value, true);
        xmlhttp.send();
        modfrm.style.display = "none";
    }
}

for (var i = 0; i < info.length; i++)
{
    info[i].onclick = function()
    {
        modfrm.style.display = "block";
        inf.style.display = "block";
        newsale.style.display = "none";
        xmlhttp = new XMLHttpRequest();
        xmlhttp.open('GET', '/SolidSystemsTestTask/sales/info?name=' + this.name, false);
        xmlhttp.send();
        var json = JSON.parse(xmlhttp.responseText);
        inf.innerHTML="Name:" + json.name + "<br\>" + "Cost:" + json.cost;
    }
}
