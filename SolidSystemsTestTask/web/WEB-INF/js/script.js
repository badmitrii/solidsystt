var add_button = document.getElementById("addbut");
var updatebut = document.getElementById("updatebut");
var modfrm = document.getElementById("modfrm");
var update = document.getElementById("update");
var create = document.getElementById("create");
var modifier = document.getElementById("modifier");
var add = document.getElementById("add");
var namemod = document.getElementById("namemod");
var name = document.getElementById("nameadd");
var cost = document.getElementById("cost");
var newnameadd = document.getElementById("newnameadd");

var remove = document.getElementsByClassName("button_left");
var sales = document.getElementsByClassName("button_right");

var saleinfo = document.getElementById("saleinfo");
var changeinfo = document.getElementById("changeinfo");
var id;


var prodArr = function getAllProducts()
{
    var arr = [];
    for (var i = 0; i < sales.length; i++)
    {
        arr.push(sales[i].name);
    }
    return arr;
}();

function checkProd(prod)
{
    for (var i in prodArr)
    {
        console.log(prodArr[i]);
        console.log(prod);
        if (prod === prodArr[i])
            return true;
    }
    return false;
}

for (var i = 0; i < remove.length; i++)
{
    remove[i].onclick = function()
    {
        xmlhttp = new XMLHttpRequest();
        xmlhttp.open('GET', '/SolidSystemsTestTask/products/remove.htm?id=' + this.name, true);
        var elem = this.parentNode.parentNode;
        elem.parentNode.removeChild(elem);
        xmlhttp.send();
    }
}

for (var i = 0; i < sales.length; i++)
{
    sales[i].onclick = function()
    {
        modfrm.style.display = "block";
        saleinfo.style.display = "block";
        changeinfo.style.display = "none";
        xmlhttp = new XMLHttpRequest();
        xmlhttp.open('GET', '/SolidSystemsTestTask/products/info?name=' + this.name, false);
        xmlhttp.send();
        var json = JSON.parse(xmlhttp.responseText);
        var str = "";
        for (var i in json)
        {
            var n = parseFloat(i) + 1;
            str = str + "Sale No" + n + "  Name: " + json[i].prodname + ", Count: " + json[i].count +
                    ", Sum: " + json[i].sum + ", Date: " + json[i].date + "<br/>" + "<br/>" + "<br/>";
        }

        saleinfo.innerHTML = str;
    }
}

add_button.onclick = function()
{
    saleinfo.style.display = "none";
    changeinfo.style.display = "block";
    create.style.display = "block";
    add.style.display = "block";
    modfrm.style.display = "block";
    update.style.display = "none";
    modifier.style.display = "none";
    newcost.style.display = "none";
}

updatebut.onclick = function()
{
    saleinfo.style.display = "none";
    changeinfo.style.display = "block";
    console.log(namemod.value);
    update.style.display = "block";
    modifier.style.display = "block";
    modfrm.style.display = "block";
    create.style.display = "none";
    add.style.display = "none";
}

create.onclick = function()
{
    console.log(checkProd(name.value));
    if (!/^[0-9]+$/.test(cost.value))
    {
        cost.style.border = "1px solid red";
    }
    else if (!/^(?=\s*\S).*$/.test(name.value))
    {
        name.style.border = "1px solid red";
    }
    else if (checkProd(name.value))
    {
        name.style.border = "1px solid red";
    }
    else
    {
        xmlhttp = new XMLHttpRequest();
        xmlhttp.open('GET', '/SolidSystemsTestTask/products/add.htm?name=' + name.value + '&cost=' + cost.value, true);
        xmlhttp.send();
        modfrm.style.display = "none";
    }
}

update.onclick = function()
{
    if (!/^[0-9]+$/.test(cost.value))
    {
        cost.style.border = "1px solid red";
    }
    else if (!/^(?=\s*\S).*$/.test(newnameadd.value))
    {
        newnameadd.style.border = "1px solid red";
    }
    else
    {
        xmlhttp = new XMLHttpRequest();
        xmlhttp.open('GET', '/SolidSystemsTestTask/products/change.htm?id=' + namemod.value + '&cost=' + cost.value + '&name=' + newnameadd.value, true);
        xmlhttp.send();
        modfrm.style.display = "none";
        cost.style.border = "1px solid #808080";
        namemod.style.border = "1px solid #808080";
    }
}