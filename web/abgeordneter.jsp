<%-- 
    Document   : abgeordneter
    Created on : 16.06.2014, 00:37:15
    Author     : Jeff
--%>

<%@page import="database.Bundesland"%>
<%@page import="database.Partei"%>
<%@page import="database.Abgeordneter"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.TypedQuery"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./resources/css/MainStyle.css">
        <link href="./resources/styles/kendo.common.min.css" rel="stylesheet" />
        <link href="./resources/styles/kendo.default.min.css" rel="stylesheet" />
        <link href="styles/kendo.dataviz.min.css" rel="stylesheet" />
        <link href="styles/kendo.dataviz.default.min.css" rel="stylesheet" />
        <script src="./resources/js/jquery.min.js"></script>
        <script src="./resources/js/kendo.web.min.js"></script>
        <script src="./resources/js/kendo.all.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <header>H.E.A.D.E.R.</header>
        <h1>Abgeordneter</h1>
        
        <% EntityManagerFactory emf = Persistence.createEntityManagerFactory("BundestagAppPU"); %>
        <% EntityManager em = emf.createEntityManager(); %>
        <% TypedQuery<Abgeordneter> query = em.createNamedQuery("Abgeordneter.findAll", Abgeordneter.class); %>
	<% List<Abgeordneter> politiker = query.getResultList(); %>
        <% TypedQuery<Bundesland> bquery = em.createNamedQuery("Bundesland.findAll", Bundesland.class); %>
        <% List<Bundesland> bundeslaender = bquery.getResultList(); %>
        <% TypedQuery<Partei> pquery = em.createNamedQuery("Partei.findAll", Partei.class); %>
        <% List<Partei> parteien = pquery.getResultList(); %>
        
        
        
        <div id="politiker">
            <table id="grid">
                <colgroup>
                    <col />
                    <col />
                    <col />
                    <col />
                    <col />
                    <col />
                </colgroup>
                <thead>
                    <tr>
                        <th data-field="bild">Bild</th>
                        <th data-field="name">Name</th>
                        <th data-field="bundesland">Bundesland</th>
                        <th data-field="partei">Partei</th>
                        <th data-field=""></th>
                    </tr>
                </thead>
                <tbody>
                    <% int i = 0; %>
                    <% for(Abgeordneter p : politiker) { %>

                        <tr>
                            <td><img src=<%= p.getBild() %> style="width:70px"; /></td> 
                            <td> <%= p.getVorname() + " " + p.getNachname() %> </td>
                            <td> <%= p.getGeschlecht()%> </td>
                            <td> <%= p.getKonfession()%> </td>
                            <td> <%= p.getFamilienstand()%> </td>
                            <td> <%= p.getKinder()%> </td>
                            <td> <%= p.getWahlkreis() %> </td>
                            <% Bundesland b = new Bundesland();
                            b.setIdbundesland(p.getBundeslandID().getIdbundesland()); %>
                            <td> <%= bundeslaender.get(bundeslaender.indexOf(b)).getName() %> </td>
                            <% Partei par = new Partei();
                            par.setIdpartei(p.getParteiID().getIdpartei()); %>
                            <td> <%= parteien.get(parteien.indexOf(par)).getName() %> </td>
                            <td> <%= p.getFraktion()%> </td>
                            <td> <%= p.getGeburtsdatum()%> </td>
                            <td> <%= p.getAktuellerberuf()%> </td>
                            <td> <%= p.getBerufe()%> </td>
                            <td> <%= p.getAddbundestag()%> </td>
                            <td> <%= p.getAddwahlkreis()%> </td>
                            <td> <%= p.getEmail()%> </td>
                            <td> <%= p.getWebsite() %> </td>
                            <td></td>
                        </tr>
                    <% } %>
                    
                </tbody>
            </table>
            <div id="details"></div>
            <script>
                var wnd, detailsTemplate;
                
                $(document).ready(function() {
                    $("#grid").kendoGrid({
                        pageable: true,
                        selectable: "mutliple",
                        columns: [
                            { field: "bild", title: "Bild", sortable:false, width:70, height: 75 },
                            { field: "name", title:"Name" },
                            { field: "geschlecht", title:"Geschlecht", hidden:true },
                            { field: "konfession", title:"Konfession", hidden:true },
                            { field: "familienstand", title:"Familienstand", hidden:true },
                            { field: "kinder", title:"Kinder", hidden:true },
                            { field: "wahlkreis", title:"Wahlkreis", hidden:true },
                            { field: "bundesland", title:"Bundesland" },
                            { field: "partei", title:"Partei" },
                            { field: "fraktion", title:"Fraktion", hidden:true },
                            { field: "geburtsdatum", title:"Geburtsdatum", hidden:true },
                            { field: "aktuellerberuf", title:"Aktueller Beruf", hidden:true },
                            { field: "berufe", title:"Berufe", hidden:true },
                            { field: "addbundestag", title:"Adresse Bundestag", hidden:true },
                            { field: "addwahlkreis", title:"Adresse Wahlkreis", hidden:true },
                            { field: "email", title:"E-Mail", hidden:true },
                            { field: "website", title:"Website", hidden:true },
                            { command: { text: "Details", click: showDetails }, title: "&nbsp;", sortable:false }],
                        dataSource: {
                            pageSize: 10
                        },
                        pageSizes: true,
                        refresh: true,
                        serverPaging: true,
                        sortable: true,
                        scrollable: false,
                        editable: "popup"
                    }).data("kendoGrid");
                    wnd = $("#details")
                        .kendoWindow({
                            title: "Detailansicht",
                            modal: true,
                            visible: false,
                            resizable: false,
                            width: 600
                        }).data("kendoWindow");

                    detailsTemplate = kendo.template($("#template").html());
                });
                function showDetails(e) {
                    e.preventDefault();

                    var dataItem = this.dataItem($(e.currentTarget).closest("tr"));
                    wnd.content(detailsTemplate(dataItem));
                    wnd.center().open();
                }
            </script>
            
            <script type="text/x-kendo-template" id="template">
                <div id="details-container">
                    
                    #= bild #
                    
                    
                    <h2>#= name #</h2>
                    <h3>#= partei #</h3>
                    <em></em>
                    <ul>
                        <li>Wahlkreis: #= wahlkreis #</li>            
                        <li>Bundesland: #= bundesland #</li>
                        <li>Ausbildung: #= aktuellerberuf #</li>
                        
                    </ul>
                    
                </div>
            </script>
        </div>
        
        <footer>F.O.O.T.E.R.</footer>
    </body>
</html>
