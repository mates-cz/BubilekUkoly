<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <link href="newCascadeStyleSheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <p>Lorem Ipsum</p>
        <a href="<?php $_SERVER['PHP_SELF']; ?>">načíst znovu</a>
        <div>
            <?php
            $podst = explode("<br>", getArrFromCSV(".\slovni_zasoba\podst.csv"));
            $prid = explode("<br>", getArrFromCSV(".\slovni_zasoba\prid.csv"));

            for ($i = 0; $i < rand(300, 900); $i++) {

                $rndmPodst = rand(0, sizeof($podst) - 2);
                $arrPodst = explode(";", $podst[$rndmPodst]);

                $rndmPrid = rand(0, sizeof($prid) - 2);
                $arrPrid = explode(";", $prid[$rndmPrid]);

                if ($arrPrid[1] === "mladý") {
                    switch ($arrPodst[3]) {
                        case "m": $retPrid = substr($arrPrid[0], 0, strlen($arrPrid[0]) - 2) . "ý";
                            break;
                        case "z": $retPrid = substr($arrPrid[0], 0, strlen($arrPrid[0]) - 2) . "á";
                            break;
                        case "s": $retPrid = substr($arrPrid[0], 0, strlen($arrPrid[0]) - 2) . "é";
                            break;
                    }
                } else {
                    $retPrid = $arrPrid[0];
                }

                echo ucfirst($retPrid . " " . $arrPodst[0] . ". ");
            }

            function getArrFromCSV($csfFileAdress) {
                $return = null;
                if (($handle = fopen($csfFileAdress, "r")) !== FALSE) {
                    while (($data = fgetcsv($handle, 100, ",")) !== FALSE) {
                        for ($c = 0; $c < count($data); $c++) {
                            $return .= $data[$c] . "<br>";
                        }
                    }
                    return $return;
                }
            }
            ?>
        </div>
    </body>
</html>
