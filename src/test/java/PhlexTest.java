import org.example.Phlex;
import org.example.PhlexCase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhlexTest {

    private static String getTestHtml() {
        return "<html><head>\n" +
                "<title>Philippine Jurisprudence -  October 2022</title>\n" +
                "<meta name=\"author\" content=\"Philipp S. Bautista\">\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\n" +
                "<meta name=\"description\" content=\"The Lawphil Project\">\n" +
                "<meta name=\"keywords\" content=\"Lawphil, Arellano Law Foundation, law, constitution, court, jurisprudence, government, Philippines, statutes, congress, international law, lawyer, legal, bar, attorney\">\n" +
                "<!--  COPYRIGHT NOTICE      This oct2022.html is licensed under a Creative Commons Attribution-NonCommercial 4.0 by the ALF-->\n" +
                "<!-- \n" +
                "function click() {\n" +
                "if (event.button==2) {\n" +
                "alert(\"The Lawphil Project is licensed under a \\n Creative Commons \\n Attribution-NonCommercial 4.0 \\n by the Arellano Law Foundation\");\n" +
                "}\n" +
                "}document.onmousedown=click\n" +
                "// -->\n" +
                "</script>\n" +
                "<link rel=\"icon\" href=\"../../../imgs/alf.png\">\n" +
                "<link rel=\"stylesheet\" href=\"../../../styls/menu.css\" type=\"text/css\">\n" +
                "\t<p id=\"des\">We use cookies to ensure you get the best experience on Lawphil.net.<br>By continuing to browse our site, you are agreeing to our use of cookies.<br>Find out more <a id=\"link\" href=\"https://lawphil.net/privnote.html\" target=\"_blank\">here.</a></p>\n" +
                "<center>\t<button id=\"but\" class=\"cookie_box_close\" href=\"#\" title=\"You are Agreeing.\">OK</button> </center>\n" +
                "</div>\n" +
                "\n" +
                "<a name=\"top\"></a>\n" +
                "<center>\n" +
                "<table cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#ffffff\" border=\"0\" width=\"800\">\n" +
                "<tbody><tr>\n" +
                "<td rowspan=\"2\" height=\"84\" width=\"45%\"><img src=\"../../../imgs/bckgnds/lawphil.jpg\"></td>\n" +
                "<td height=\"30\" width=\"55%\" valign=\"middle\" align=\"center\">\n" +
                "<script src=\"../../../scrpts/dater.js\" language=\"Javascript\" type=\"text/javascript\"></script><font face=\"arial\" color=\"#00088\" size=\"2\">Today is Thursday, January 23, 2025 </font> <a href=\"https://lawphil.net\"><img src=\"https://lawphil.net/imgs/home.png\" title=\"home\" align=\"right\" hspace=\"4\"></a></td></tr>\n" +
                "<tr><td height=\"54\" width=\"55%\" valign=\"top\" align=\"center\" background=\"../../../imgs/bckgnds/009.jpg\">\n" +
                "</td></tr>\n" +
                "<tr align=\"center\" height=\"19\"><td colspan=\"2\" class=\"bar\"><script language=\"JavaScript1.2\" src=\"../../../scrpts/menu.js\"></script><style> .menuBar {overflow: hidden; max-width: 800px; background-color: #993399;} .menuBar a {float: left; font-size: 11px; color: white; text-align: center; padding: 5px 5px;} .level0 { float: left; overflow: hidden;} .level0 .top { font-size: 11px; font-weight: bold; border: none; outline: none; color: white; padding: 4px 4px; background-color: inherit; font-family: inherit; margin: 0;} .menuBar a:hover, .level0:hover .top { background-color: #4a1e8f; color: #8a8aff;} .level1 { display: none; position: absolute; background-color: #f9f9ff; min-width: 100px; box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2); z-index: 1;} .level1 a { float: none; color: black; padding: 5px 5px; text-decoration: none; display: block; text-align: left;} .level1 a:hover { background-color: #dddddd;} .level0:hover .level1 { display: block;} </style> <div class=\"menuBar\"> <div class=\"level0\">   \t<button style=\"margin-left: 6px;\" onclick=\"cons()\" class=\"top\">Constitution</button>   <div class=\"level1\"> \t<a href=\"/consti/cons1987.html\">1987 Constitution</a> \t<a href=\"/consti/cons1986.html\">1986 Constitution</a> \t<a href=\"/consti/cons1973.html\">1973 Constitution</a> \t<a href=\"/consti/cons1943.html\">1943 Constitution</a> \t<a href=\"/consti/cons1935.html\">1935 Constitution</a> \t<a href=\"/consti/consmalo.html\">Malolos Constitution</a>     </div> </div> <div class=\"level0\">     <button onclick=\"stats()\" class=\"top\">Statutes</button>    <div class=\"level1\"> \t<a href=\"/statutes/acts/acts.html\">Acts</a> \t<a href=\"/statutes/comacts/comacts.html\">Commonwealth Acts</a> \t<a href=\"/statutes/bataspam/bataspam.html\">Mga Batas Pambansa</a> \t<a href=\"/statutes/repacts/repacts.html\">Republic Acts</a>     </div> </div>  <div class=\"level0\">     <button onclick=\"exec()\" class=\"top\">Executive Issuances</button>    <div class=\"level1\"> \t<a href=\"/statutes/presdecs/legis_pd.html\">Presidential Decrees</a> \t<a href=\"/executive/execord/execord.html\">Executive Orders</a> \t<a href=\"/executive/ao/ao.html\">Administrative Orders</a> \t<a href=\"/executive/mo/mo.html\">Memorandum Orders</a> \t<a href=\"/executive/mc/mc.html\">Memorandum Circulars</a> \t<a href=\"/executive/proc/proc.html\">Proclamations</a> \t<a href=\"/executive/genor/genor.html\">General Orders</a> \t<a>Special Orders</a>     </div> </div> <div class=\"level0\">     <button onclick=\"juis()\" class=\"top\">Judicial Issuances</button>    <div class=\"level1\"> \t<a href=\"/courts/supreme/supreme.html\">Supreme Court</a> \t<a href=\"https://ca.judiciary.gov.ph\">Court of Appeals</a> \t<a href=\"https://cta.judiciary.gov.ph\">Court of Tax Appeals</a> \t<a href=\"/courts/sandigan/sandigan.html\">Sandiganbayan</a> \t<a>Regional Trial Court</a> \t<a>Metropolitan Trial Court</a> \t<a>Municipal Trial Court</a> \t<a>Municipal Circuit Trial Court</a> \t<a>Municipal Trial Court</a>     </div> </div> <div class=\"level0\">     <button onclick=\"other()\" class=\"top\">Other Issuances</button>    <div class=\"level1\"> \t<a href=\"/administ/mmaa/mmaa.html\">Muslim Mindanao Autonomy Act</a> \t<a href=\"/administ/comelec/comelec.html\">Commission on Election</a> \t<a href=\"/administ/csc/csc.html\">Civil Service Commission</a> \t<a>Commission on Audit</a>     </div> </div> <div class=\"level0\">     <button onclick=\"juri()\" class=\"top\">Jurisprudence</button>    <div class=\"level1\"> \t<a href=\"/judjuris/judjuris.html\">Supreme Court Decisions</a>     </div> </div> <div class=\"level0\">     <button onclick=\"ilr()\" class=\"top\">International Legal Resources</button>    <div class=\"level1\"> \t<a href=\"https://www.icj-cij.org\">International Court of Justice</a> \t<a href=\"https://www.icc-cpi.int/\">International Criminal Court</a> \t<a href=\"/international/int_cases/int_cases.html\">Collection of International Cases</a> \t<a href=\"/international/treaties/treaties.html\">Treatises Agreements &amp; Conventions</a> \t<a href=\"/international/un/un.html\">United Nations</a> \t<a href=\"/international/wto/wto.html\">World Trade Organization</a> \t<a href=\"https://www.wipo.int\">World Intellectual Property Organization</a> \t<a href=\"https://www.isa.org.jm\">Intellectual Seabed Authority</a>     </div> </div> <div class=\"level0\">     <button onclick=\"au()\" class=\"top\">AUSL Exclusive</button>    <div class=\"level1\"> \t<a href=\"/administ/administ.html\">Political Law</a> \t<a>Labor Law</a> \t<a>Civil Law</a> \t<a>Taxation Law</a> \t<a>Mercantile Law</a> \t<a>Criminal Law</a> \t<a>Remedial Law</a> \t<a>Ethics Law</a> \t<a href=\"/courts/bm/barQ/barQs.html\">Bar Examinations Archive</a> \t<a href=\"/tools/law_dict.html\">Legal Dictionary Links</a>     </div> </div> </div></td></tr>\n" +
                "<tr><td colspan=\"2\" align=\"center\"><br>\n" +
                "<h4>OCTOBER 2022 - PHILIPPINE JURISPRUDENCE</h4>\n" +
                "<input type=\"text\" id=\"filterInput\" onkeyup=\"filterTable()\" placeholder=\"Type keyword/s here.\">\n" +
                "<table border=\"0\" cellspacing=\"0\" cellpadding=\"5\" width=\"90%\" align=\"center\" id=\"s-menu\">\n" +
                "<tbody><tr bgcolor=\"#3366dc\" align=\"center\"><th width=\"35%\">CASE NUMBER</th><th width=\"65%\" colspan=\"2&quot;\">CASE TITLE</th></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_258187_2022.html\">G.R. No. 258187</a> <br>October 19, 2022\n" +
                "</td><td>\n" +
                "People of the Philippines <a class=\"vs\">vs.</a> Raymund Camarse y Gimotea\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_258187_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_249754_2022.html\">G.R. No. 249754</a> <br>October 19, 2022\n" +
                "</td><td>\n" +
                "The Heirs of Teodoro Ribac (Deceased), Represented By His Heirs and Issues: Augustina, Marll.Ano, Victor, Reynante,** Da Yla, and Rosalie, All Surnamed Ribac, <a class=\"vs\">vs.</a> Narcisa Rlbac-Putolan and Antonina Ribac-Blanco\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_249754_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_238859_2022.html\">G.R. No. 238859</a> <br>October 19, 2022\n" +
                "</td><td>\n" +
                "Elba J. Caballero <a class=\"vs\">vs.</a> Vikings Commissary and/or Jackson Go, and Hardworkers Manpower Services, Inc.,...\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_238859_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_223611_2022.html\">G.R. No. 223611</a> <br>October 19, 2022\n" +
                "</td><td>\n" +
                "Marcos Antonio Morales, Georgina D. Tribujenia, Cicero A. Cajurao, and Noli A. Dejan Vs....\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_223611_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_237369_2022.html\">G.R. No. 237369</a> <br>October 19, 2022\n" +
                "</td><td>\n" +
                "Land Bank of the Philippines <a class=\"vs\">vs.</a> Albrando R. Abellana\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_237369_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_255258_2022.html\">G.R. No. 255258</a> <br>October 19, 2022\n" +
                "</td><td>\n" +
                "Heirs of Arturo E. Bandoy and Heirs of Angelita E. Bandoy <a class=\"vs\">vs.</a> Alexander E. Bando\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_255258_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_197743_2022.html\">G.R. No. 197743</a> <br>October 18, 2022\n" +
                "</td><td>\n" +
                "Heirs of Jose Mariano and Helen S. Mariano, Represented By Danilo Davids. Mariano, Mary Therese Irene S. Mariano, Ma. Catalina Sophia S. Mariano, Jose Mario S. Mariano, Ma. Lenor S. Mariano, Macario S. Mariano and Heirs of Erlinda Mariano Villanueva, represented in This Act By Irene Lourdes M. Villanueva Through Her Attorney-In-Fact Editha S. Santuyo and Benjamin B. Santuyo <a class=\"vs\">vs.</a> City of Naga\n" +
                "<br><a class=\"vs\">Separate Opinion<br></a><a href=\"gr_197743_caguioa.html\">Justice Alfredo Benjamin S. Caguioa</a><a href=\"pdf/gr_197743_caguioa.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "<br><a class=\"vs\">Concurring and Dissenting Opinion<br></a><a href=\"gr_197743_gaerlan.html\">Justice Samuel H. Gaerlan</a><a href=\"pdf/gr_197743_gaerlan.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "<br><a class=\"vs\">Separate Opinion<br></a><a href=\"gr_197743_gesmundo.html\">Justice Alexander G. Gesmundo</a><a href=\"pdf/gr_197743_gesmundo.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "<br><a class=\"vs\">Concurring and Dissenting Opinion<br></a><a href=\"gr_197743_lazaro-javier.html\">Justice Amy C. Lazaro-Javier</a><a href=\"pdf/gr_197743_lazaro-javier.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "<br><a class=\"vs\">Separate Opinion<br></a><a href=\"gr_197743_leonen.html\">Justice Marvic M.V.F. Leonen</a><a href=\"pdf/gr_197743_leonen.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_197743_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_234766_2022.html\">G.R. No. 234766</a><br>October 18, 2022\n" +
                "</td><td>\n" +
                "Rosita P. Siniclang <a class=\"vs\">vs.</a> the Honorable Court of Appeals, the Honorable Ombudsman for Luzon and Ernesto A. Luciano, Jr./Rosita P. Siniclang <a class=\"vs\">vs.</a> Ernesto A. Luciano, Jr./Rosita P. Siniclang <a class=\"vs\">vs.</a> Office of the Ombudsman, and Ernesto A. Luciano, Jr./Rosita P. Siniclang <a class=\"vs\">vs.</a> Commission on Audit\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_234766_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_242644_2022.html\">G.R. No. 242644</a><br>October 18, 2022\n" +
                "</td><td>\n" +
                "Engineer Alex C. Paguio, in his capacity as General Manager of the Pagsanjan Water District, Angeline R. Aguilar, Administrative Division Manager, Edita B. Abarquez, Board of Director Secretary, Marifel B. Pabilonia, Board of Director Chairperson, Nina P. Velasco, BOD Vice Chairperson, Fred V. Capistrano, Board of Director Chairman, and Angelito T. Bombay, Board of Director Vice Chairman <a class=\"vs\">vs.</a> Commission on Audit, Nilda M. Blanco, Commission on Audit Regional Director, Region IV-A, Mario A. Corcega, Audit Team Leader, and Wilhelmina R. Cabuhat, Supervising Auditor, Audit Team 20, Group F-Laguna Province\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_242644_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_232168_2022.html\">G.R. No. 232168</a> <br>October 17, 2022\n" +
                "</td><td>\n" +
                "Civil Service Commission <a class=\"vs\">vs.</a> Jejomar Erwin S. Bina Y, Jr. and Gerardo Kangleon San Gabriel\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_232168_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_190057_2022.html\">G.R. No. 190057</a><br>October 17, 2022\n" +
                "</td><td>\n" +
                "Spouses Adolfo B. Velarde and Antonina T. Velarde, Spouses Romulo B. Velarde and Jean T. Velarde, Bella B. Velarde, Benedicto B. Velarde, Isabelle V. Diaz, and Carmelita B. Velarde, Petitioners, <a class=\"vs\">vs.</a> Heirs of Concepcion Candari, Respondents.\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_190057_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_222259_2022.html\">G.R. No. 222259</a> <br>October 17, 2022\n" +
                "</td><td>\n" +
                "Lowella Yap <a class=\"vs\">vs.</a> Almeda Yap, Hearty Yap-Dybongco and Diosdado Yap, Jr.\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_222259_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_255802_2022.html\">G.R. No. 255802</a> <br>October 12, 2022\n" +
                "</td><td>\n" +
                "One Shipping Corporation <a class=\"vs\">vs.</a> Heirs of the Late Ricardo R. Abarrientos\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_255802_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a class=\"nya\" xref=\"gr_211478_2022.html\">G.R. No. 211478</a> <br>October 12, 2022\n" +
                "</td><td>\n" +
                "Zenaida O. Duhay, et al. <a class=\"vs\">vs.</a> Hon. Office of the Ombudsman\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_211478_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_237815_2022.html\">G.R. No. 237815</a> <br>October 12, 2022\n" +
                "</td><td>\n" +
                "Orlando A. Fua, Jr. <a class=\"vs\">vs.</a> People of the Philippines\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_237815_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_235033_2022.html\">G.R. No. 235033</a> <br>October 12, 2022\n" +
                "</td><td>\n" +
                "Kristine Calubaquib-Diaz <a class=\"vs\">vs.</a> Dino Lopez Diaz\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_235033_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_257446_2022.html\">G.R. No. 257446</a> <br>October 12, 2022\n" +
                "</td><td>\n" +
                "Jhon Kenneth M. Porto, Chennie Ann Rose Elca, and Jomar Jonhedel B. Bruto (represented by Marife B. Bruto) <a class=\"vs\">vs.</a> Grant Institute of Trade &amp; Technology, Inc., and/or Its Board of Directors, namely: Dr. Ruel Reyes, Atty. Janet Joy A. Reyes, Lisha Alyanna A. Reyes, Jesse R. Reyes, and Nestor R. Miranda\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_257446_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_247868_2022.html\">G.R. No. 247868</a> <br>October 12, 2022\n" +
                "</td><td>\n" +
                "Land Bank of the Philippines <a class=\"vs\">vs.</a> Arturo L. Ramos, Josepine R. Co., Margarita R....\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_247868_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_232755_2022.html\">G.R. No. 232755</a> <br>October 12, 2022\n" +
                "</td><td>\n" +
                "Merlita Janeo Ramos <a class=\"vs\">vs.</a> Emelita Janeo Sol\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_232755_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_252715_2022.html\">G.R. No. 252715</a> <br>October 12, 2022\n" +
                "</td><td>\n" +
                "Joel G. Nolasco <a class=\"vs\">vs.</a> Purence Realty Corporation\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_252715_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_259728_2022.html\">G.R. No. 259728</a> <br>October 12, 2022\n" +
                "</td><td>\n" +
                "People of the Philippines <a class=\"vs\">vs.</a> Darwin Reyes y Cabornay\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_259728_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_232029-40_2022.html\">G.R. No. 232029-40/G.R. No. 234975-84</a> <br>October 12, 2022\n" +
                "</td><td>\n" +
                "Grace T. Chingkoe <a class=\"vs\">vs.</a> Sandiganbayan (First Division) and the People of the Philippines/Sandiganbayan (First...\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_232029-40_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"ac_13372_2022.html\">A.C. No. 13372</a> <br>October 12, 2022\n" +
                "</td><td>\n" +
                "Juanito V. Paras <a class=\"vs\">vs.</a> Atty. Jonathan J. De Paz\n" +
                "</td><td>\n" +
                "<a href=\"pdf/ac_13372_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_256611_2022.html\">G.R. No. 256611</a><br>October 12, 2022\n" +
                "</td><td>\n" +
                "XXX,  <a class=\"vs\">vs.</a> People of the Philippines\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_256611_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_254125_2022.html\">G.R. No. 254125</a><br>October 12, 2022\n" +
                "</td><td>\n" +
                "Rogelim A. Cabrales and Noe Cabrido Gozalo,  <a class=\"vs\">vs.</a> the Ombudsman, Nahum E. Dosdos, Pascual R. Pongase II, and Raul P. LLagas\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_254125_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_250830_2022.html\">G.R. No. 250830</a><br>October 12, 2022\n" +
                "</td><td>\n" +
                "Municipality of Province of Albay,  <a class=\"vs\">vs.</a> Antonio B. Betito\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_250830_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_238308_2022.html\">G.R. No. 238308</a> <br>October 12, 2022\n" +
                "</td><td>\n" +
                "Republic of the Philippines <a class=\"vs\">vs.</a> Teresita I. Salinas\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_238308_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_224945_2022.html\">G.R. No. 224945</a> <br>October 11, 2022\n" +
                "</td><td>\n" +
                "Girlie J. Lingad <a class=\"vs\">vs.</a> People of the Philippine\n" +
                "<br><a class=\"vs\">Separate Opinion<br></a><a href=\"gr_224945_lazaro-javier.html\">Justice Amy C. Lazaro-Javier</a><a href=\"pdf/gr_224945_lazaro-javier.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "<br><a class=\"vs\">Separate Opinion<br></a><a href=\"gr_224945_zalameda.html\">Justice Rodil V. Zalameda</a><a href=\"pdf/gr_224945_zalameda.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_224945_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_235310_2022.html\">G.R. No. 235310</a><br>October 11, 2022\n" +
                "</td><td>\n" +
                "Hon. Aniceto D. Bertiz III, as a Member of the House of Representatives and as a Taxpayer <a class=\"vs\">vs.</a> Hon. Salvador C. Medialdea, in his capacity as the Executive Secretary; Hon. Arthur P. Pugado, in his capacity as the Secretary of the Department of Transporatation; Hon. Benjamin E. Diokno, in his capacity as the Secretary of the Department of Budget and Management; Hon. Rosalia V. De Leon, in her capacity as the National Treasurer; Hon. Michael G. Aguinaldo, in his capacity as the Chairman of the Commission on Audit; Hon. Edgar C. Galvante, in his capacity as Assistant Secretary of the Land Transportation Office and Dermalog with NETTIX and CFP Joint Venture (JV)\n" +
                "<br><a class=\"vs\">Concurrence</a><br>\n" +
                "<a href=\"gr_235310_lazaro-javier.html\">Justice Amy C. Lazaro-Javier</a> <a href=\"pdf/gr_235310_lazaro-javier.pdf\"><img src=\"../../../imgs/p.png\">\n" +
                "</a></td><td>\n" +
                "<a href=\"pdf/gr_235310_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a class=\"nya\" xref=\"gr_190980_2022.html\">G.R. No. 190980</a> <br>October 10, 2022\n" +
                "</td><td>\n" +
                "Stradcom Corporation <a class=\"vs\">vs.</a> Mario Teodoro Failon Etong A.K.A. Ted Failon\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_190980_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_198083_2022.html\">G.R. No. 198083</a> <br>October 10, 2022\n" +
                "</td><td>\n" +
                "Bai Sandra Sinsuat A. Sema <a class=\"vs\">vs.</a> Republic of the Philippines\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_198083_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_199031_2022.html\">G.R. No. 199031</a> <br>October 10, 2022\n" +
                "</td><td>\n" +
                "Blemp Commercial Philippines, Inc <a class=\"vs\">vs.</a> the Hon. Sandiganba Yan First Division\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_199031_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_250852_2022.html\">G.R. No. 250852</a> <br>October 10, 2022\n" +
                "</td><td>\n" +
                "People of the Philippines <a class=\"vs\">vs.</a> &nbsp;John Francis Sualog\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_250852_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_248821_2022.html\">G.R. No. 248821</a> <br>October 10, 2022\n" +
                "</td><td>\n" +
                "Philippine National Bank <a class=\"vs\">vs.</a> Sps. Pedro Caguimbal and Vivian Caguimbal\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_248821_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_228350_2022.html\">G.R. No. 228350</a><br>October 10, 2022\n" +
                "</td><td>\n" +
                "Regidor R. Toleldo, Ronaldo Toledo, Joeffrey Toledo, and Gladdys Toledo <a class=\"vs\">vs.</a> Jerry R. Toledo and Jelly R. Toledo\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_228350_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_235863_2022.html\">G.R. No. 235863</a><br>October 10, 2022\n" +
                "</td><td>\n" +
                "Vanessa Laura Arcilla <a class=\"vs\">vs.</a> San Sebastian College-Recoletos, Manila446\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_235863_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_250542_2022.html\">G.R. No. 250542</a><br>October 10, 2022\n" +
                "</td><td>\n" +
                "Heirs of Pio Tejada and Soledad Tejada, Represented By Pio Domingo Tejada, Petitioners  <a class=\"vs\">vs.</a> Garry B. Hay, in Substitution of Myrna L. Hay, Represented By His Attorney-in-fact Gomercindo* Litong, Respondent\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_250542_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_200403_2022.html\">G.R. No. 200403</a> <br>October 10, 2022\n" +
                "</td><td>\n" +
                "Municipality of Biñan, Laguna, Rogelio V. Lee, Antonio P. Aguilar and Roberto Hernandez <a class=\"vs\">vs.</a> Holiday Hills Stock &amp; Breeding Farm Corporation and Domino Farms, Inc.\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_200403_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_227775_2022.html\">G.R. No. 227775</a> <br>October 10, 2022\n" +
                "</td><td>\n" +
                "Eleanor Reyno and Elsa De Vera <a class=\"vs\">vs.</a> George Baltazar and Joel Baltazar\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_227775_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_242722_2022.html\">G.R. No. 242722</a> <br>October 10, 2022\n" +
                "</td><td>\n" +
                "Carlos Cereza, Roger Estolonillo, Raymundo Lopez, Yolanda Pascual, Merly Ann Montes, and May Ann Villa <a class=\"vs\">vs.</a> Hon. Danilo V. Suarez, Presiding Judge, Regional Trial Court of Paranaque City, Branch 259, and People of the Philippines\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_242722_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_255264_2022.html\">G.R. No. 255264</a> <br>October 10, 2022\n" +
                "</td><td>\n" +
                "Manuel Ong <a class=\"vs\">vs.</a> Spouses Rowelito and Amelita Villorente\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_255264_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_205641_2022.html\">G.R. No. 205641</a> <br>October 5, 2022\n" +
                "</td><td>\n" +
                "Superior General of the Religious of the Virgin Mary (R.V.M.) <a class=\"vs\">vs.</a> Republic of the Philippines\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_205641_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_241067_2022.html\">G.R. No. 241067</a> <br>October 5, 2022\n" +
                "</td><td>\n" +
                "Raegar B. Ledesma <a class=\"vs\">vs.</a> C.F. Sharp Crew Management, Inc. and/or Prestige Cruise Services, LLC/Prestige Cruise Holdings, Inc. and Geronimo F. Caidic\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_241067_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_252230_2022.html\">G.R. No. 252230</a> <br>October 5, 2022\n" +
                "</td><td>\n" +
                "People of the Philippines <a class=\"vs\">vs.</a> XXX\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_252230_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_242837_2022.html\">G.R. No. 242837</a> <br>October 5, 2022\n" +
                "</td><td>\n" +
                "Eufrocina Rivera <a class=\"vs\">vs.</a> Rolando G. Velasco\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_242837_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"ac_13453_2022.html\">A.C. No. 13453</a> <br>October 4, 2022\n" +
                "</td><td>\n" +
                "Jackiya A. Lao <a class=\"vs\">vs.</a> Atty. Berteni C. Causing\n" +
                "</td><td>\n" +
                "<a href=\"pdf/ac_13453_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_248049_2022.html\">G.R. No. 248049</a><br>October 4, 2022\n" +
                "</td><td>\n" +
                "People of the Philippines <a class=\"vs\">vs.</a> Efren Agao y Añonuevo\n" +
                "<br><a class=\"vs\">Separate Concurring Opinion:</a><br><a href=\"gr_248049_singh.html\">Justice Filomena D. Singh</a> <a href=\"pdf/gr_248049_singh.pdf\"><img src=\"../../../imgs/p.png\">\n" +
                "<br></a><a class=\"vs\">Dissenting and Concurring Opinion:</a><br><a href=\"gr_248049_leonen.html\">Justice Marvic M.V.F. Leonen</a> <a href=\"pdf/gr_248049_leonen.pdf\"><img src=\"../../../imgs/p.png\">\n" +
                "<br></a><a class=\"vs\">Concurring Opinion:</a><br><a href=\"gr_248049_gesmundo.html\">Chief Justice Alexander G. Gesmundo</a> <a href=\"pdf/gr_248049_gesmundo.pdf\"><img src=\"../../../imgs/p.png\">\n" +
                "</a></td><td>\n" +
                "<a href=\"pdf/gr_248049_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"ac_13226_2022.html\">A.C. No. 13226</a> <br>October 4, 2022\n" +
                "</td><td>\n" +
                "Jocelyn G. Bartolome <a class=\"vs\">vs.</a> Atty. Remigio P. Rojas\n" +
                "</td><td>\n" +
                "<a href=\"pdf/ac_13226_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"ac_13475_2022.html\">A.C No. 13475</a> <br>October 4, 2022\n" +
                "</td><td>\n" +
                "Judy Gabawan Dela Cruz, Rodolf John G. Dela Cruz, and Rodolf James Dela Cruz <a class=\"vs\">vs.</a> Atty. Glen Eric Peralta\n" +
                "</td><td>\n" +
                "<a href=\"pdf/ac_13475_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr class=\"xy\"><td>\n" +
                "<a href=\"gr_260261_2022.html\">G.R. No. 260261</a> <br>October 3, 2022\n" +
                "</td><td>\n" +
                "Republic of the Philippines <a class=\"vs\">vs.</a> Robiegie Corporation\n" +
                "</td><td>\n" +
                "<a href=\"pdf/gr_260261_2022.pdf\"><img src=\"../../../imgs/p.png\"></a>\n" +
                "</td></tr>\n" +
                "<tr><td colspan=\"3\" class=\"id\">The Lawphil Project - Arellano Law Foundation, Inc.</td></tr>\n" +
                "<tr><td><a href=\"javascript:history.back(1)\"><img src=\"../../../images/back.gif\" border=\"0\"></a></td><td colspan=\"2\"><a \"href=\"#top\"><img src=\"../../../images/top.gif\" border=\"0\" align=\"right\"></a></td></tr></tbody></table>\n" +
                "</td></tr></tbody></table><img src=\"../../../imgs/bckgnds/010.gif\"><br><br></center>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<table cellspacing=\"0\" cellpadding=\"0\" style=\"width: 348px; display: none; top: 62px; position: absolute; left: 585px;\" role=\"presentation\" class=\"gstl_50 gssb_c\"><tbody><tr><td class=\"gssb_f\"></td><td class=\"gssb_e\" style=\"width: 100%;\"></td></tr></tbody></table></body></html>";
    }

    @Test
    public void test() {
        Document doc = Jsoup.parse(getTestHtml());
        doc.setBaseUri("https://lawphil.net/judjuris/juri2022/oct2022/oct2022.html");
        List<PhlexCase> cases = Phlex.getCases(doc);
        assertEquals(50, cases.size());
    }
}
