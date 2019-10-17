<?php
include 'ITeleso.php';

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of Kvadr
 *
 * @author Matěj
 */
class Kvadr implements ITeleso {

    /**
     * Nadeklarujeme si privítní proměnné $a, $b, $c.
     * @var type 
     */
    private $a, $b, $c;

    /**
     * 
     * @param type $a
     * @param type $b
     * @param type $c
     */
    function __construct($a = 0, $b = 0, $c = 0) {
        $this->a = $a;
        $this->b = $b;
        $this->c = $c;
    }

    /**
     * Seter nastaví hodnotu privítní proměnné $a.
     * @param type $a
     */
    public function setA($a) {
        $this->a = $a;
    }

    /**
     * Seter nastaví hodnotu privítní proměnné $b.
     * @param type $b
     */
    public function setB($b) {
        $this->b = $b;
    }

    /**
     * Seter nastaví hodnotu privítní proměnné $c.
     * @param type $c
     */
    public function setC($c) {
        $this->c = $c;
    }
    

    /**
     * Vrací povrch objektu.
     * @return float
     */
    public function povrch(): float {
        return 2 * ($this->a * $this->b) + 2 * ($this->a * $this->c) + 2 * ($this->b * $this->c);
    }

    /**
     * Vrací objem objektu.
     * @return float
     */
    public function objem(): float {
        return $this->a * $this->b * $this->c;
    }

    /**
     * Vrací, zda-li jse objekt 3D či nikoli.
     * @return bool
     */
    public function is3D(): bool {
        if ($this->a != 0 && $this->b != 0 && $this->c != 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Vrací string, kde je slovně napsáno, zda-li jse objekt 3D či nikoli.
     * @return string
     */
    public function getIs3D(): string{
        if($this->is3D()){
            return "ano";
        }else{
            return "ne";
        }
    }

    /**
     * Vrací počet vrcholů.
     * @return int
     */
    public function pocetVrcholu(): int {
        $dimension = 0;
        if ($this->a != 0) {
            $dimension++;
        }
        if ($this->b != 0) {
            $dimension++;
        }
        if ($this->c != 0) {
            $dimension++;
        }
        if ($dimension != 0) {
            return pow(2, $dimension);
        } else {
            return 0;
        }
    }

    /**
     * Vrací, co je objekt zač.
     * @return string
     */
    public function coJsem(): string {
        $dimension = 0;
        if ($this->a != 0) {
            $dimension++;
        }
        if ($this->b != 0) {
            $dimension++;
        }
        if ($this->c != 0) {
            $dimension++;
        }
        switch ($dimension) {
            case 0: return "Nejsem objekt";
            case 1: return "Jsem úsečka";
            case 2: return "jsem obdelník";
            case 3: return "Jsem kvádr";
        }
    }

    /**
     * Vrátí string ve kterém jsou všechny funkce vypsané.
     * @return string
     */
    public function info(): string {
        return $this->coJsem() . ":" .
                "<br>Kolik mám vrcholů? " . $this->pocetVrcholu() .
                "<br>Jsem 3D objekt? " . $this->getIs3D() .
                "<br>Můj objem je " . $this->objem() . "m<sup>3</sup>" .
                "<br>Můj povrch je " . $this->povrch() . "m<sup>2</sup>";
    }

}
