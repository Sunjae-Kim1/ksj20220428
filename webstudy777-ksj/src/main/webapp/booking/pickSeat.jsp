<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
        .seat {
            width: 50px;
            height: 50px;
        }
        
        .clicked {
            background-color: red;
            color: white;
        }
 </style>

<label for="person">예매 인원을 선택하세요:</label> 
<select name="persons" id="person"> 
<option value="">--Please choose an option--</option> 
<option value="1">1</option> 
<option value="2">2</option> 
<option value="3">3</option> 
</select>

<div class="seat-wrapper"></div>
<input type="hidden" id="seatArr" value="${seatArr}">
<button type="submit" onclick="return booking()" >예매하기</button>
<form id="booking" action="bookingController.do" method="post">
	<input type="hidden" name="seats1" value="">
	<input type="hidden" name="movieNo" value="${filmNO}">
	<input type="hidden" name="picktime" value="${picktime}">
</form>
<script>
    let test = [];
    let selectedSeats = new Array();
    let selectedSeatsMap = [];
    const seatWrapper = document.querySelector(".seat-wrapper");
    let clicked = "";
    let div = "";
    
    var seatArr = new Array();
    seatArr = $('#seatArr').val();
    
    for (var i = 0; i < 5; i++) {
        div = document.createElement("div");
        seatWrapper.append(div);
        for (var j = 0; j < 5; j++) {
            const input = document.createElement('input');
            input.type = "button";
            input.name = "seats"            
            input.classList = "seat";
            
            if (i == 0) {
                input.id = "A" + j;
            } else if (i == 1) {
                input.id = "B" + j;
            } else if (i == 2) {
                input.id = "C" + j;
            } else if (i == 3) {
                input.id = "D" + j;
            } else if (i == 4) {
                input.id = "E" + j;
            }
            //3중포문을 사용하지 않기위해 
            mapping(input, i, j);
            div.append(input);
            input.addEventListener('click', function(e) {
                console.log(e.target.value);
                //중복방지 함수
                selectedSeats = selectedSeats.filter((element, index) => selectedSeats.indexOf(element) != index);
				
                //click class가 존재할때(제거해주는 toggle)
                if (input.classList.contains("clicked")) {
                    input.classList.remove("clicked");
                    clicked = document.querySelectorAll(".clicked");
                    selectedSeats.splice(selectedSeats.indexOf(e.target.value), 1);
                    clicked.forEach((data) => {
                        selectedSeats.push(data.value);
                    });
                    //click class가 존재하지 않을때 (추가해주는 toggle)
                } else {
                    input.classList.add("clicked");
                    clicked = document.querySelectorAll(".clicked");
                    clicked.forEach((data) => {
                        selectedSeats.push(data.value);
                    })
                }
                console.log(selectedSeats);
           	 })//eventListener 함수 종료
        }
    }
    //<input type='button' disabled='disabled' value='비활성화2'/>
    for(var aa=0;aa<5;aa++){
    	for(var bb=0;bb<5;bb++){
            if (aa == 0) {
                var cc = "A" + bb;
            } else if (aa == 1) {
            	var cc  = "B" + bb;
            } else if (aa == 2) {
            	var cc  = "C" + bb;
            } else if (aa == 3) {
            	var cc  = "D" + bb;
            } else if (aa == 4) {
            	var cc  = "E" + bb;
            }//if문 종료
            if(seatArr.includes(cc)){
            	//alert(cc);
            	//$('input[id=cc]').attr('disabled', true);
            	document.getElementById(cc).setAttribute('disabled', true);
            }
    	}
    }
    
    function mapping(input, i, j) {
        if (i == 0) {
            input.value = "A" + j;
        } else if (i == 1) {
            input.value = "B" + j;
        } else if (i == 2) {
            input.value = "C" + j;
        } else if (i == 3) {
            input.value = "D" + j;
        } else if (i == 4) {
            input.value = "E" + j;
        }
    }
    function booking(){
       	$('input[name=seats1]').attr('value',selectedSeats);
 		var seatArray = new Array();
 		var seats = $('input[name=seats1]').val();
 		var personseat = $("#person").val();
 		seatArray = seats.split(',');
 		alert(seatArray.length);
 		alert(personseat);
 		if(seatArray.length!=personseat){
 			alert("인원수가 맞지 않습니다.");
 			return false;
 		}
        document.getElementById("booking").submit();
        var test1 = $('#seats1').val();
    }
    
    function checkOnlyOne(person1) {
      const checkboxes = document.getElementsByName("person");
      checkboxes.forEach((cb) => {cb.checked = false;})
      person1.checked = true;
    }
</script>
<%--
        var test1 = document.getElementByName("seats");
        alert("test1");
 --%>