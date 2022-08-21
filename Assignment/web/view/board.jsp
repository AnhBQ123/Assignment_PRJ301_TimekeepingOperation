<%-- 
    Document   : board
    Created on : Aug 15, 2022, 10:43:53 AM
    Author     : QUANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
        <link rel="stylesheet" href="/Assignment/styles/boardstyle.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <table class="board">
            <thead>
            <th style="background-color: #acd48c;">
                #
            </th>
            <th style="background-color: #acd48c;" >
               Name
            </th>
            <th style="background-color: #acd48c;">
                Division
            </th>
            <th style="background-color: #acd48c;">
                Available leave
            </th>
            
<!--                <div>
                    <div style="border-bottom: 1px solid black;">Days in month</div>
                    
                  </div>-->
<tr>
   <%for(int i = 1;i<32;i++){%>
                        <td ><%=i%></td >
                    <%}%> 
</tr>
                    
                   
                
               
            
            <th>
                Working days
            </th>
            <th>
                Working Sunday
            </th>
            <th>
                Working Holiday
            </th>
            <th>
                Business travel
            </th>
            <th>
                Admitted leave
            </th>
            <th>
                Compensatory leave
            </th>
            <th>
                Regime
            </th>
            <th>
                Sum of days
            </th>
            <th>
                Leave left
            </th>
            <th>
                Multiple by
            </th>
            <th>
                Working holidays
            </th>
            <th>
                Working days off
            </th>
            <th>
                OverTime normal days(18h-22h)
            </th>
            <th>
                OverTime normal days(22h-18h)
            </th>
            <th>
                Sum of days
            </th>
        </thead>
        <tbody>
        
            <% for(int x = 0;x<10;x++){%>
                <tr>
                    <% for(int y = 0;y<50;y++){%>
                        <%if(y==0){%>
                            <td class="<%="col"+y%>" id ="<%=y+"and"+x%>"  ><%=x+1%></td>
                        <%}%>
                        <%if(y>2){%>
                            <td class="<%="col"+y%>" id ="<%=y+"and"+x%>" onclick="editMode(event)" onkeypress="save(event)" >&nbsp </td>
                        <%}if(y<=2 && y!=0){%>
                            <td class="<%="col"+y%>" id ="<%=y+"and"+x%>"  >&nbsp </td>
                        <%}%>
                    <%}%>
                </tr>
            <%}%>
        </tbody>
        
            
        </table>
    </body>
    <script type="text/javascript">
        var temp;
        function editMode(event){
            console.log(event);
            var x = event.path[0];
            temp = x.value;
            console.log(temp);  
            x.innerHTML = '';
            var newinput = document.createElement('input');
            newinput.type = 'number';
            newinput.min = '0';
            newinput.max = '4';
            newinput.id = x.id;
            console.log(newinput);                      
            x.appendChild(newinput);
        }
        function save(event){
            console.log(event);
            if(event.key ==='Enter' && event.code === 'Enter'){
                
                event.path[1].value = event.path[0].value;
                
                var child = event.path[0];
                var parent = event.path[1];
                console.log(event.path[0].value);
                if(event.path[0].value === '0'){
                    parent.style.backgroundColor = '#ff6c6c';
                }
                parent.removeChild(child);
                console.log(parent.value);
                parent.innerHTML = parent.value;
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
            
    </script>
</html>
