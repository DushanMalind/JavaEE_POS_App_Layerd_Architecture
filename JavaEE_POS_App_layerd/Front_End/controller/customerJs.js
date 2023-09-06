/*
initiateUI();

function initiateUI() {
    clearAll();
    $("#customerContent").css("display", "block");

    setTheLastView();
}

function saveLastView(clickedID) {
    switch (clickedID) {
        case "customerContent":
            localStorage.setItem("view", "CUSTOMER");
            break;
        case "itemContent":
            localStorage.setItem("view", "ITEM");
            break;
        case "ordersContent":
            localStorage.setItem("view", "ORDERS");
            break;
        case "placeOrdersContent":
            localStorage.setItem("view", "PLACEORDERS");
            break;
    }
}

function setTheLastView() {
    let view = localStorage.getItem("view");
    switch (view) {
        case "CUSTOMER":
            setView($("#customerContent"));
            break;
        case "ITEM":
            setView($("#itemContent"));
            break;
        case "ORDERS":
            setView($("#ordersContent"));
            break;
        case "PLACEORDERS":
            setView($("#placeOrdersContent"));
            break;
        default:
            setView($("#customerContent"));
    }
}



function setView(viewOb) {
    clearAll();
    viewOb.css("display", "block");
    saveLastView(viewOb.get(0).id);
    console.log(viewOb.get(0).id);
}

$("#customers").click(function () {
    setView($("#customerContent"));
});

$("#items").click(function () {
    setView($("#itemContent"));
});

$("#orders").click(function () {
    setView($("#ordersContent"));
});

$("#placeOrders").click(function () {
    setView($("#placeOrdersContent"));
});


const BASE_URL = "http://localhost:8081/java_pos/";

getAllCustomer();

$("#btnDelete").click(function (){
  getAllCustomer();
  alert("ok");
});

function getAllCustomer(){
  $("#tblCustomer").empty();
  $.ajax({
    url:BASE_URL+"customer",
    method:"GET",
    headers:{
      Auth:"user=admin,pass=admin"
    },
    success:function (resp){
      let customers = resp.data;
      for(let i in customers){
        let cus = customers[i];
        let id = cus.id;
        let name = cus.name;
        let address = cus.address;
        let salary = cus.salary;
        let row = `<tr><td>${id}</td><td>${name}</td><td>${address}</td><td>${salary}</td></tr>`;
        $("#tblCustomer").append(row);
      }
    }
  });
}

$("#tblCustomer").on('click',function (event){
  let tr= $(event.target).closest("tr");

  let id = tr.find("td:eq(0)").text();
  let name = tr.find("td:eq(1)").text();
  let address = tr.find("td:eq(2)").text();
  let salary = tr.find("td:eq(3)").text();

  setFiledSet(id,name,address,salary);
  console.log(id,name,address,salary);
});

function setFiledSet(id,name,address,salary){
  $("#txtID").val(id);
  $("#txtName").val(name);
  $("#txtAddress").val(address);
  $("#txtSalary").val(salary);
}














*/
