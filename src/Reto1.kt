import model.*
import java.util.*
import javax.swing.AbstractCellEditor
import kotlin.collections.ArrayList
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

//Inventario

//Agua
var aguas = listOf<Agua>(
    Agua(100, "Gaseosa"),
    Agua(200, "Agua Sola")
)
//Leche
var leches = listOf<Leche>(
    Leche(100, "Leche de Avena"),
    Leche(200, "Leche Deslactosada")
)
//Carne
var carnes = listOf<Carne>(
    Carne(100, "Carne de res"),
    Carne(200, "Carne de pollo")
)
//Frutas
var frutas = listOf<Frutas>(
    Frutas(100, "Platano"),
    Frutas(200, "Mango")
)
//Verduras
var verduras = listOf<Verduras>(
    Verduras(100, "Lechuga"),
    Verduras(200, "Espinaca")
)
//Cereal
var cereales = listOf<Cereal>(
    Cereal(100, "Avena"),
    Cereal(200, "Trigo")
)
//Huevos
var huevos = listOf<Huevos>(
    Huevos(100, "Huevo de codorniz"),
    Huevos(200, "Huevo frito")
)
//Aceites
var aceites = listOf<Aceites>(
    Aceites(100, "Aceite de Oliva"),
    Aceites(200, "Aceite para freir")
)

fun main(args: Array<String>) {

    var recetas = arrayListOf<Receta>()

    escapar@ while (true) {

        val menu = """
        
        :: Bienvenido a Recipe Maker ::

        Selecciona la opción deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
        
        """.trimIndent()

        println(menu)

        var options: Int = readLine()?.toInt() ?: 0

        when (options) {
            1 -> hacerReceta(recetas)
            2 -> verRecetas(recetas)
            3 -> break@escapar
            else -> println("Debe seleccionar una las opciones")
        }
    }

    println("Saliendo ...")
}

fun hacerReceta(recetas: ArrayList<Receta>) {

    var nuevaReceta = Receta()

    escapar@while (true){
        val mensaje_inicial = """
            
            :: Hacer una receta ::
    
            Selecciona por categoría el ingrediente que buscas
            1. Agua
            2. Leche
            3. Carne
            4. Verduras
            5. Frutas
            6. Cereal
            7. Huevos
            8. Aceites
            9. Regresar
            
        """.trimIndent()

        println(mensaje_inicial)
        var options: Int = readLine()?.toInt() ?: 0

        when (options) {
            1 -> verAgua(nuevaReceta)
            2-> verLeche(nuevaReceta)
            3-> verCarne(nuevaReceta)
            4-> verVerdura(nuevaReceta)
            5-> verFruta(nuevaReceta)
            6-> verCereal(nuevaReceta)
            7-> verHuevos(nuevaReceta)
            8-> verAceite(nuevaReceta)
            9 -> break@escapar
            else -> println("Debe seleccionar una las opciones")
        }
    }

    println("Desea guardar la receta creada? (Y/N)")

    var options: String = readLine()?.toString() ?: "N"

    if (options.equals("Y")) {
        println("Ingrese un nombre para la receta")
        var nombre: String = readLine()?.toString() ?: ""
        nuevaReceta.setName(nombre)
        recetas.add(nuevaReceta)
    }
}

fun verRecetas(recetas: ArrayList<Receta>) {

    var mensaje: String = ""
    for ((index : Int, n ) in recetas.withIndex() ) {
        mensaje += "${index + 1}. ${n.getName()}\n"
    }
    mensaje += "${recetas.size + 1}. Regresar"

    escapar@while (true) {
        val mensaje_inicial = """
            
:: Ver mis recetas ::
    
$mensaje
            
        """.trimIndent()

        println(mensaje_inicial)
        var options: Int = readLine()?.toInt() ?: 0
        var limit: Int = recetas.size

        when (options) {
            in 1 .. limit -> verReceta(recetas[options - 1].getComidas(), recetas[options - 1].getName())
            limit + 1 -> break@escapar
            else -> println("Debe seleccionar una de las opciones")
        }
    }
}

fun verReceta(list: List<Any>, nombre: String) {

    var mensaje: String = ""
    for ((index : Int, n ) in list.withIndex() ) {
        mensaje += "${index + 1}. ${n.toString()}\n"
    }
    mensaje += "${list.size + 1}. Regresar"

    val mensaje_inicial = """
            
:: $nombre ::
    
Ingredientes:
$mensaje
            
        """.trimIndent()

    escapar@while (true){

        println(mensaje_inicial)
        var options: Int = readLine()?.toInt() ?: 0

        if (options.equals(list.size + 1)) {
            break@escapar
        }

    }

}

fun hacerMensaje(list: List<Any>): String {

    var mensaje: String = ""
    for ((index : Int, n ) in list.withIndex() ) {
        mensaje += "${index + 1}. ${n.toString()}\n"
    }
    mensaje += "${list.size + 1}. Regresar"

    val mensaje_inicial = """
            
:: ${list[0].javaClass.simpleName} ::
    
Selecciona entre los ingredientes disponibles
$mensaje
            
        """.trimIndent()
    
    return mensaje_inicial
}

fun realizarAccion(list: List<Any>, receta: Receta) {
    escapar@while (true){

        println(hacerMensaje(list))
        var options: Int = readLine()?.toInt() ?: 0
        var limit: Int = list.size

        when (options) {
            in 1 .. limit -> agregarComida(list[options - 1], receta, options - 1)
            limit + 1 -> break@escapar
            else -> println("Debe seleccionar una de las opciones")
        }
    }
}

fun setAgua(receta: Receta, agua: Agua, cant: Int): Boolean {

    var procede: Boolean = false

    if (cant > agua.getCant()) {
        println("No hay $cant unidades/ml de ${agua.showNombre()}")
    } else {
        procede = true
        agua.setCant(agua.getCant() - cant)
        var nuevaAgua = Agua(cant, agua.showNombre())
        receta.getComidas().add(nuevaAgua)
        println(nuevaAgua.toString())
    }

    return procede
}

fun setLeche(receta: Receta, leche: Leche, cant: Int): Boolean {

    var procede: Boolean = false

    if (cant > leche.getCant()) {
        println("No hay $cant unidades/ml de ${leche.showNombre()}")
    } else {
        procede = true
        leche.setCant(leche.getCant() - cant)
        var nuevaLeche = Leche(cant, leche.showNombre())
        receta.getComidas().add(nuevaLeche)
        println(nuevaLeche.toString())
    }

    return procede
}

fun setCarne(receta: Receta, carne: Carne, cant: Int): Boolean {

    var procede: Boolean = false

    if (cant > carne.getCant()) {
        println("No hay $cant unidades/ml de ${carne.showNombre()}")
    } else {
        procede = true
        carne.setCant(carne.getCant() - cant)
        var nuevaCarne = Carne(cant, carne.showNombre())
        receta.getComidas().add(nuevaCarne)
        println(nuevaCarne.toString())
    }

    return procede
}

fun setVerdura(receta: Receta, verduras: Verduras, cant: Int): Boolean {

    var procede: Boolean = false

    if (cant > verduras.getCant()) {
        println("No hay $cant unidades/ml de ${verduras.showNombre()}")
    } else {
        procede = true
        verduras.setCant(verduras.getCant() - cant)
        var nuevaVerduras = Verduras(cant, verduras.showNombre())
        receta.getComidas().add(nuevaVerduras)
        println(nuevaVerduras.toString())
    }

    return procede
}

fun setFruta(receta: Receta, frutas: Frutas, cant: Int): Boolean {

    var procede: Boolean = false

    if (cant > frutas.getCant()) {
        println("No hay $cant unidades/ml de ${frutas.showNombre()}")
    } else {
        procede = true
        frutas.setCant(frutas.getCant() - cant)
        var nuevaFrutas = Frutas(cant, frutas.showNombre())
        receta.getComidas().add(nuevaFrutas)
        println(nuevaFrutas.toString())
    }

    return procede
}

fun setCereal(receta: Receta, cereal: Cereal, cant: Int): Boolean {

    var procede: Boolean = false

    if (cant > cereal.getCant()) {
        println("No hay $cant unidades/ml de ${cereal.showNombre()}")
    } else {
        procede = true
        cereal.setCant(cereal.getCant() - cant)
        var nuevaCereal = Cereal(cant, cereal.showNombre())
        receta.getComidas().add(nuevaCereal)
        println(nuevaCereal.toString())
    }

    return procede
}

fun setHuevos(receta: Receta, huevos: Huevos, cant: Int): Boolean {

    var procede: Boolean = false

    if (cant > huevos.getCant()) {
        println("No hay $cant unidades/ml de ${huevos.showNombre()}")
    } else {
        procede = true
        huevos.setCant(huevos.getCant() - cant)
        var nuevaHuevos = Huevos(cant, huevos.showNombre())
        receta.getComidas().add(nuevaHuevos)
        println(nuevaHuevos.toString())
    }

    return procede
}

fun setAceite(receta: Receta, aceites: Aceites, cant: Int): Boolean {

    var procede: Boolean = false

    if (cant > aceites.getCant()) {
        println("No hay $cant unidades/ml de ${aceites.showNombre()}")
    } else {
        procede = true
        aceites.setCant(aceites.getCant() - cant)
        var nuevaAceites = Aceites(cant, aceites.showNombre())
        receta.getComidas().add(nuevaAceites)
        println(nuevaAceites.toString())
    }

    return procede
}

fun agregarComida(comida: Any, receta: Receta, n: Int) {

    escapar@while (true) {
        println("Ingrese la cantidad a utilizar")
        var cantidad: Int = readLine()?.toInt() ?: 0
        val clase: String = comida.javaClass.simpleName

        when (clase) {
            "Agua" -> if(setAgua(receta, aguas[n], cantidad)) break@escapar
            "Leche" -> if(setLeche(receta, leches[n], cantidad)) break@escapar
            "Carne"-> if(setCarne(receta, carnes[n], cantidad)) break@escapar
            "Verduras"-> if(setVerdura(receta, verduras[n], cantidad)) break@escapar
            "Frutas"-> if(setFruta(receta, frutas[n], cantidad)) break@escapar
            "Cereal"-> if(setCereal(receta, cereales[n], cantidad)) break@escapar
            "Huevos"-> if(setHuevos(receta, huevos[n], cantidad)) break@escapar
            "Aceites"-> if(setAceite(receta, aceites[n], cantidad)) break@escapar
            else -> println("Comida desconocida")
        }

    }

}

fun verAgua(receta: Receta) {

    realizarAccion(aguas, receta)
}

fun verLeche(receta: Receta) {

    realizarAccion(leches, receta)
}

fun verCarne(receta: Receta) {

    realizarAccion(carnes, receta)
}

fun verVerdura(receta: Receta) {

    realizarAccion(verduras, receta)
}

fun verFruta(receta: Receta) {

    realizarAccion(frutas, receta)
}

fun verCereal(receta: Receta) {

    realizarAccion(cereales, receta)
}

fun verHuevos(receta: Receta) {

    realizarAccion(huevos, receta)
}

fun verAceite(receta: Receta) {

    realizarAccion(aceites, receta)
}