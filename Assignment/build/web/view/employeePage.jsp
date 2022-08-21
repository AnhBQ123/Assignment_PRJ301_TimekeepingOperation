<%-- 
    Document   : employeePage.jsp
    Created on : Aug 17, 2022, 10:29:21 AM
    Author     : QUANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="/Assignment/styles/employeestyle.css"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <div class="left">
            <a id="option" name="checkin" href="#"  onclick="display(event)">Checkin</a><br/>
            <a id="option" name="checkout" href="#" onclick="display(event)">Checkout</a><br/>
            <a id="option" name="absence" href="#" onclick="display(event)">Ask for absence</a><br/>
            <a id="option" name="overtime" href="#" onclick="display(event)">Register for overtime</a> <br/>          
        </div>
        <div class="right">
            <span>Hello Bui Quang Anh</span>
            <input id="now" value=""/> 
            <div id="checkin" hidden="true" > 
                <form action="checkin" method="post">
                    <input id="checkinDate" type="datetime" hidden="true"> 
                    <input type="submit"  value="Checkin">
                </form>
                
            </div>
            <div id="checkout" hidden="true" >
                <form action="checkout" method="post">
                    <input id="checkoutDate" type="datetime" hidden="true">
                    <input type="submit" value="Checkout">
                </form>         
            </div>
            <div id="absence" hidden="true">
                  <input id="now" value=""/>  
            </div>

        </div>
        
    </body>
    <script type="text/javascript">
        const weekday = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
        var dateNow = setInterval(DateNow,1000); 
       
        if(new Date().getHours() < 17){
            document.getElementsByName('checkin')[0].hidden = false;
        }   
        else
        {   
            document.getElementsByName('checkin')[0].hidden = true;
        }
        if(new Date().getHours() >= 17 ){           
            document.getElementsByName('checkout')[0].hidden = false;
        }
        else
        {   
            document.getElementsByName('checkout')[0].hidden = true;
        }
        function display(event){
            var option = document.getElementById("option");
            console.log(option.name);
            if(event.srcElement.innerHTML === 'Checkin'){               
                document.getElementById("checkin").hidden = false;  
                document.getElementById('checkout').hidden=true;
                document.getElementById('absence').hidden=true;
                document.getElementById('overtime').hidden=true;
                document.getElementById("checkinDate").value = new Date();
            }
            if(event.srcElement.innerHTML === 'Checkout'){
                document.getElementById("checkin").hidden = true;  
                document.getElementById('checkout').hidden=false;
                document.getElementById('absence').hidden=true;
                document.getElementById('overtime').hidden=true;
                document.getElementById("checkoutDate").value = new Date();
            }
            if(event.srcElement.innerHTML === 'Ask for absence'){
                document.getElementById("checkin").hidden = true;  
                document.getElementById('checkout').hidden=true;
                document.getElementById('absence').hidden=false;
                document.getElementById('overtime').hidden=true;
            }
            
        }
        function DateNow(){
            var now = document.getElementById('now');
            now.value = new Date().toLocaleString() + ', ' + weekday[new Date().getDay()];;
        }
    </script>
</html>
    