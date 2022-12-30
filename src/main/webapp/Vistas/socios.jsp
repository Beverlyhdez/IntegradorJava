<%-- 
    Document   : socios
    Created on : 29 dic. 2022, 22:45:04
    Author     : Beverly
--%>

<%@page import="Modelo.SociosDAO"%>
<%@page import="Modelo.Socios"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Integrador Java - Socios</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/2cbbc87d30.js" crossorigin="anonymous"></script>    
    </head>
    <body>
        <h1 class="text-center">Listado de Socios del Gym</h1>
        
        <div class="container">
            <div class="row">
                <a class="btn btn-primary col-2 mb-4">Agregar Socio</a>
            </div>
        </div>
        <br>
        <div class="container">
            <div class="row">
                <table class="table table-primary col-2 lg-6">
                    <thead>
                        <th>id</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Dirección</th>
                        <th>Localidad</th>
                        <th>Fecha Nac.</th>  
                        <th>Email</th>
                        <th>Teléfono</th>
                        <th>Modificar</th>
                        <th>Eliminar</th>
                    </thead>
                    <%
                    List<Socios> resultado=null;
                    SociosDAO s1=new SociosDAO();
                    resultado=s1.listarSocios();
                    
                    for(int x=0;x<resultado.size();x++)
                    {
                    String ruta="SociosController?accion=modificar&id="+resultado.get(x).getIdSocio();
                    String rutaE="SociosController?accion=eliminar&id="+resultado.get(x).getIdSocio();
                    %>
                    
                    
                    <tr class="table-light col-2 lg-6">
                        <td><%=resultado.get(x).getIdSocio()%></td>
                        <td><%=resultado.get(x).getNombre()%></td> 
                        <td><%=resultado.get(x).getApellido()%></td> 
                        <td><%=resultado.get(x).getDireccion()%></td> 
                        <td><%=resultado.get(x).getLocalidad()%></td>
                        <td><%=resultado.get(x).getFnac()%></td> 
                        <td><%=resultado.get(x).getEmail()%></td>
                        <td><%=resultado.get(x).getTelefono()%></td> 
                        <td class="text-center"><a href=<%=ruta%>> <i class="fa-solid fa-arrow-right-arrow-left"></i> </a></td>
			<td class="text-center"><a href=<%=rutaE%>><i class="fa-solid fa-arrow-down"></i> </a></td> 
                    </tr>
                    <%
                        }
                    %>
                </table>            
            </div>
        </div>        
    </body>
</html>
