<%-- 
    Document   : board
    Created on : Aug 15, 2022, 10:43:53 AM
    Author     : QUANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.*" %>
<%@ page import="model.Account" %>
<%@ page import="model.TimeSheet" %>
<%@ page import="model.Absence" %>
<%@ page import="model.LeaveDays" %>
<%@ page import="model.OverTime" %>
<%@ page import="model.Syntax" %>
<%@ page import="helper.*" %>
<!DOCTYPE html>
<html>
        <link rel="stylesheet" href="/Assignment/styles/boardstyle.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <% 
            Calendar cal = Calendar.getInstance();
            int dayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
        %>  
        <% ArrayList<Account>accounts = (ArrayList<Account>)request.getAttribute("listAccount");
            TimeHelper th = new TimeHelper();
            int count=0;
            
           
            int numberOfDays = (int)request.getAttribute("days");
        %> 
        filter by month:<select id="listMonth" name="listMonth" onchange="GetSelectMonth(event)" >
        <%for(int x=1;x<13;x++){%>
        <%if(x == month+1){%>
            <option value="<%=x%>" ><%=x%></option>
                
            <%continue;}%> 
            <option value="<%=x%>"><%=x%></option>
        <%}%>       
    </select>
    year:<select id="listYear" name="listYear" onchange="GetSelectYear(event)">
        <%for(int x=2010;x<2023;x++){%>
            <%if(x == year){%>
            <option value="<%=x%>" selected=""><%=x%></option>
                
            <%continue;}%> 
            <option value="<%=x%>"><%=x%></option>
        <%}%> 
    </select>
        <table class="board">
            <tr>
                <th ></th>
                <th ></th>
                <th></th>
                <th></th>
                <th style="background-color:#acd48c " colspan="<%=numberOfDays%>">Days of month</th>
            </tr>
            <tr>
            <th class="emptyTH" style="background-color: #acd48c; border-top: 0;">
                #
            </th>
            <th class="emptyTH" style="background-color: #acd48c; border-top: 0;" >
               Name
            </th>
            <th class="emptyTH" style="background-color: #acd48c; border-top: 0;">
                Division
            </th>
            <th class="emptyTH" style="background-color: #acd48c; border-top: 0;">
                Available leave
            </th>
            
<!--                <div>
                    <div style="border-bottom: 1px solid black;">Days in month</div>
                    
                  </div>-->
   <%for(int i = 1;i<numberOfDays+1;i++){%>
                        <th style="background-color:#acd48c " ><%=i%></th >
                    <%}%> 

                    
                   
                
               
            
            <th style="background-color: #385494;Color:white;">
                Working days
            </th>
            <th style="background-color: #385494;Color:white;">
                Working Sunday
            </th>
            <th style="background-color: #385494;Color:white;">
                Working Holiday
            </th>
            <th style="background-color: #385494;Color:white;">
                Business travel
            </th>
            <th style="background-color: #385494;Color:white;">
                Admitted leave
            </th>
            <th style="background-color: #385494;Color:white;">
                Compensatory leave
            </th>
            <th style="background-color: #385494;Color:white;">
                Regime
            </th>
            <th style="background-color: #385494;Color:white;">
                Sum of days
            </th>
            <th style="background-color: #385494;Color:white;">
                Leave left
            </th>
            <th style="background-color: #385494;Color:white;">
                Multiple by
            </th>
            <th style="background-color: #ffcc9c">
                Working holidays
            </th >
            <th style="background-color: #ffcc9c">
                Working days off
            </th>
            <th style="background-color: #ffcc9c">
                OverTime normal days(18h-22h)
            </th>
            <th style="background-color: #ffcc9c">
                OverTime normal days(22h-18h)
            </th>
            <th style="background-color: #ffcc9c">
                Sum of days
            </th>
        </tr>
               
        <%for(Account account : accounts){%>
            <% double dayswork = 0;%>
            <% count = 0;%>
            <tr>
                <td><%=accounts.indexOf(account)+1%></td> 
                <td><%=account.getName()%></td>
                <td><%=account.getDivision()%></td>
                <td>12</td>
                <%for(TimeSheet ts : account.getTimesheets()){%>
            
                    <%if(th.getDayOfWeekSQL(ts.getDate()) == 6){%>
                   
                        <%if(account.specialFunction(ts) == 0){%>
                                <td>0</td>
                        <%}%>
                        <%if(account.specialFunction(ts) == 1){%>
                                <td>1</td>
                                <%dayswork +=1;%>
                        <%}%>
                        <%if(account.specialFunction(ts) == 2){%>
                                <td>P/2</td>
                                <%dayswork +=0.5;%>
                        <%}%>
                        <%if(account.specialFunction(ts) == 3){%>
                                <td>P</td>
                        <%}%>
                   
                        
                        <td>&nbsp</td>
                        <td>&nbsp</td>
                    <%continue;}%>
                    
                    
                        <%if(account.specialFunction(ts) == 0){%>
                                <td>0</td>
                        <%}%>
                        <%if(account.specialFunction(ts) == 1){%>
                                <td>1</td>
                                <%dayswork +=1;%>
                        <%}%>
                        <%if(account.specialFunction(ts) == 2){%>
                                <td>P/2</td>
                                 <%dayswork +=0.5;%>
                        <%}%>
                        <%if(account.specialFunction(ts) == 3){%>
                                <td>P</td>
                        <%}%>
                      
                    <%}%>  
                    <td><%=dayswork%></td> 
                    <% LeaveDays ld = account.getLeavedays(); %>
                    
                    <%if(ld != null ){%>
                    <td>0.0</td>
                    <td>0.0</td>
                    <td>0.0</td>
                    <td>0.0</td>
                    <td>0.0</td>
                    <td>0.0</td>
                    <td>0.0</td>
                    <td>0.0</td>
                    <td><%=dayswork%></td>   
                    <%}else{%>
                                                 
                     <%}%> 
                     <% OverTime ot = account.getOvertime(); %>
                     
                     <%if(ot != null){%>
                    <td>0.0</td>
                    <td>0.0</td>
                    <td>0.0</td>
                    <td>0.0</td>
                    <td>0.0</td>
                        
                    <%}else{%>
                       
                         
                     <%}%> 
                
            </tr>
         <%}%>  
         
        </table>
         <table>
             <%ArrayList<Syntax>syntaxes = (ArrayList<Syntax>)request.getAttribute("listSyntax");%>
             <th>Syntax</th>
             <th>Meaning</th>
             <%for(Syntax s: syntaxes){%>
             <tr>
                 <td><%=s.getSyntax()%></td>
                <td><%=s.getName()%></td>
             </tr>
                
             <%}%>
             
         </table>
             
    </body>
    <script type="text/javascript">
//        var temp;
//        function GetSelectMonth(event){
//            console.log(event);
//            var month = document.getElementById('listMonth').value;
//            window.location("")
//            console.log(month);
//        }
//        function GetSelectYear(event){
//            console.log(event);
//            var year = document.getElementById('listYear').value;
//            window.location("")
//            console.log(year);
//
//        }
//        function editMode(event){
//            console.log(event);
//            var x = event.path[0];
//            temp = x.value;
//            console.log(temp);  
//            x.innerHTML = '';
//            var newinput = document.createElement('input');
//            newinput.type = 'number';
//            newinput.min = '0';
//            newinput.max = '4';
//            newinput.id = x.id;
//            console.log(newinput);                      
//            x.appendChild(newinput);
//        }
//        function save(event){
//            console.log(event);
//            if(event.key ==='Enter' && event.code === 'Enter'){
//                
//                event.path[1].value = event.path[0].value;
//                
//                var child = event.path[0];
//                var parent = event.path[1];
//                console.log(event.path[0].value);
//                if(event.path[0].value === '0'){
//                    parent.style.backgroundColor = '#ff6c6c';
//                }
//                parent.removeChild(child);
//                console.log(parent.value);
//                parent.innerHTML = parent.value;
//            }
//            
//        }
            var listtd = document.getElementsByTagName("td");
            console.log(listtd);
            for(let x = 0;x < listtd.length;x++ ){
                if(listtd[x].innerText.toString().trim() === ''){
                    listtd[x].style.backgroundColor = 'gray';
                }
                if(listtd[x].innerText.toString().trim() === '0'){
                    listtd[x].style.backgroundColor = 'pink';
                }
                if(listtd[x].innerText.toString().trim() === 'P' || listtd[x].innerText.toString().trim() === 'P/2' ){
                    listtd[x].style.backgroundColor = 'yellow';
                }
            }
            var x = 0;           
            while(x<4){
                var y = 0;
                var str = 'col'+x;
                var column = document.getElementsByClassName(str);
                console.log(column);
                while(y<10) 
                {
                    column[y].style.backgroundColor = '#acd48c';
                    y++;
                }
                x +=1;
            }
            function GetSelectMonth(event){
                var month = document.getElementById("listMonth").value;
                var year = document.getElementById("listYear").value;
                window.location.href = "http://localhost:9999/Assignment/board?month="+month+"&&year="+year
            }
    </script>
</html>
