<%-- 
    Document   : modifierCandidature
    Created on : 10 avr. 2018, 09:59:51
    Author     : Kiiaroto
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Une Candidature</h1>
        <div>
            <table>
                <tr>
                    <td>
                        <span id="id" hidden="true"><c:out value="${numeroCandidature}" /></span>
                        <c:out value="${candidature.getPersonne().getNom()}" /> <c:out value="${candidature.getPersonne().getPrenom()}" /> <br>
                        <c:out value="${candidature.getPersonne().getAdresse()}" /> <br>
                        <c:out value="${candidature.getPersonne().getCodePostal()}" />  <c:out value="${candidature.getPersonne().getVille()}" /> <br>
                        <c:out value="${candidature.getPersonne().getMail()}" />  <br>
                        <c:out value="${candidature.getPersonne().getTel()}" /> 
                    </td>
                    <td>
                        ID Formation: <c:out value="${candidature.getSessionFormation().getIdFormation()}" /> <br>
                        ID Session: <c:out value="${candidature.getSessionFormation().getIdSession()}" /> <br>
                        Date debut: <c:out value="${candidature.getSessionFormation().getDateDebutToString()}" /> <br>
                        Date fin: <c:out value="${candidature.getSessionFormation().getDateFinToString()}" /> <br>
                        Est ouverte: <c:out value="${candidature.getSessionFormation().getEstOuverte()}" /> <br>
                    </td>
                    <td>
                        <select id="etat">
                            <c:forEach begin="1" end="${etatCandidature.getValues().size()}" varStatus="loop">
                                <option value="${loop.index}" <c:if test="${candidature.getEtatCandidature() == loop.index}"> selected="selected" </c:if>>${etatCandidature.getValues().get(loop.index)}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <button id="buttonAjax">Sauvegarder</button>
        </div>
        <script type="text/javascript" src="jquery.min.js"></script>
        <script type="text/javascript" src="modifierCandidature.js"></script>
    </body>
</html>
