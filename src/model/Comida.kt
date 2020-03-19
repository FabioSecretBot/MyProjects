package model

abstract  class Comida ( var cantidad: Int) {
    override fun toString(): String {
        return "| Cantidad: $cantidad"
    }
}