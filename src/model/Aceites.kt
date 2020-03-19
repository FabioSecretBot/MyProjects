package model

class Aceites (cantidad: Int, var nombre: String) :
    Comida(cantidad), ICrudActions {

    private var tipo = this.javaClass.name

    override fun showTipo(){
        println(this.tipo)
    }

    override fun showNombre() {
        println(this.nombre)
    }

    override fun setCant(cant: Int) {
        this.cantidad = cant
    }

    override fun getCant(): Int {
        return this.cantidad
    }

    override fun toString(): String {
        return "$nombre " + super.toString()  + ".ml"
    }

}