package model

import java.util.ArrayList

class Receta {

    private var nombre = ""
    private var comidas = arrayListOf<Any>()

    fun setName(nombre: String) {
        this.nombre = nombre
    }

    fun getName(): String {
        return this.nombre
    }

    fun addComida(comida: Any) {
        comidas.add(comida)
    }

    fun getComidas(): ArrayList<Any> {
        return this.comidas
    }

}