<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matěj
 */
interface ITeleso {
    /**
     * Vrací povrch objektu.
     * @return float
     */
    public function povrch(): float;
    
    /**
     * Vrací objem objektu.
     * @return float
     */
    public function objem(): float;
    
    /**
     * Vrací, zda-li jse objekt 3D či nikoli.
     * @return bool
     */
    public function is3D(): bool;
    
    /**
     * Vrací počet vrcholů.
     * @return int
     */
    public function pocetVrcholu(): int;
    
    /**
     * Vrátí string ve kterém jsou všechny funkce vypsané.
     * @return string
     */
    public function info(): string;
}
