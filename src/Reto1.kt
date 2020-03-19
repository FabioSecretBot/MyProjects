import model.*
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

fun main(args: Array<String>) {

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
            1 -> hacerReceta()
            2 -> verRecetas()
            3 -> break@escapar
            else -> println("Debe seleccionar una las opciones")
        }
    }

    println("Saliendo ...")
}

fun hacerReceta() {

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
            1 -> verAgua()
            2-> verLeche()
            3-> verCarne()
            4-> verVerdura()
            5-> verFruta()
            6-> verCereal()
            7-> verHuevos()
            8-> verAceite()
            9 -> break@escapar
            else -> println("Debe seleccionar una las opciones")
        }
    }
}

fun verRecetas() {

    escapar@while (true) {
        val mensaje_inicial = """
            
            :: Ver mis recetas ::
    
            1. Regresar
            
        """.trimIndent()

        println(mensaje_inicial)
        var options: Int = readLine()?.toInt() ?: 0
        if (options == 1) {
            break@escapar
        }
    }
}

fun verAgua() {

    val aguas: Array<Agua> = arrayOf(
        Agua(100, "Gaseosa"),
        Agua(200, "Agua Sola")
    )

    var mensaje: String = ""
    for ((index : Int, n ) in aguas.withIndex() ) {
        mensaje += "${index + 1}. ${n.toString()}\n"
    }
    mensaje += "${aguas.size + 1}. Regresar"

    escapar@while (true){
        val mensaje_inicial = """
            
:: Agua ::
    
Selecciona entre los ingredientes disponibles
$mensaje
            
        """.trimIndent()

        println(mensaje_inicial)
        var options: Int = readLine()?.toInt() ?: 0

        when (options) {
            1 -> aguas[0].toString()
            2-> aguas[1].toString()
            3 -> break@escapar
            else -> println("Debe seleccionar una las opciones")
        }
    }
}

fun verLeche() {

    val leches: Array<Leche> = arrayOf(
        Leche(100, "Leche de Avena"),
        Leche(200, "Leche Deslactosada")
    )

    var mensaje: String = ""
    for ((index : Int, n ) in leches.withIndex() ) {
        mensaje += "${index + 1}. ${n.toString()}\n"
    }
    mensaje += "${leches.size + 1}. Regresar"

    escapar@while (true){
        val mensaje_inicial = """
            
:: Leche ::
    
Selecciona entre los ingredientes disponibles
$mensaje
            
        """.trimIndent()

        println(mensaje_inicial)
        var options: Int = readLine()?.toInt() ?: 0

        when (options) {
            1 -> leches[0].toString()
            2-> leches[1].toString()
            3 -> break@escapar
            else -> println("Debe seleccionar una las opciones")
        }
    }
}

fun verCarne() {

    val carnes: Array<Carne> = arrayOf(
        Carne(100, "Carne de res"),
        Carne(200, "Carne de pollo")
    )

    var mensaje: String = ""
    for ((index : Int, n ) in carnes.withIndex() ) {
        mensaje += "${index + 1}. ${n.toString()}\n"
    }
    mensaje += "${carnes.size + 1}. Regresar"

    escapar@while (true){
        val mensaje_inicial = """
            
:: Carne ::
    
Selecciona entre los ingredientes disponibles
$mensaje
            
        """.trimIndent()

        println(mensaje_inicial)
        var options: Int = readLine()?.toInt() ?: 0

        when (options) {
            1 -> carnes[0].toString()
            2-> carnes[1].toString()
            3 -> break@escapar
            else -> println("Debe seleccionar una las opciones")
        }
    }
}

fun verVerdura() {

    val verduras: Array<Verduras> = arrayOf(
        Verduras(100, "Lechuga"),
        Verduras(200, "Espinaca")
    )

    var mensaje: String = ""
    for ((index : Int, n ) in verduras.withIndex() ) {
        mensaje += "${index + 1}. ${n.toString()}\n"
    }
    mensaje += "${verduras.size + 1}. Regresar"

    escapar@while (true){
        val mensaje_inicial = """
            
:: Verduras ::
    
Selecciona entre los ingredientes disponibles
$mensaje
            
        """.trimIndent()

        println(mensaje_inicial)
        var options: Int = readLine()?.toInt() ?: 0

        when (options) {
            1 -> verduras[0].toString()
            2-> verduras[1].toString()
            3 -> break@escapar
            else -> println("Debe seleccionar una las opciones")
        }
    }
}

fun verFruta() {

    val frutas: Array<Frutas> = arrayOf(
        Frutas(100, "Platano"),
        Frutas(200, "Mango")
    )

    var mensaje: String = ""
    for ((index : Int, n ) in frutas.withIndex() ) {
        mensaje += "${index + 1}. ${n.toString()}\n"
    }
    mensaje += "${frutas.size + 1}. Regresar"

    escapar@while (true){
        val mensaje_inicial = """
            
:: Frutas ::
    
Selecciona entre los ingredientes disponibles
$mensaje
            
        """.trimIndent()

        println(mensaje_inicial)
        var options: Int = readLine()?.toInt() ?: 0

        when (options) {
            1 -> frutas[0].toString()
            2-> frutas[1].toString()
            3 -> break@escapar
            else -> println("Debe seleccionar una las opciones")
        }
    }
}

fun verCereal() {

    val cereales: Array<Cereal> = arrayOf(
        Cereal(100, "Avena"),
        Cereal(200, "Trigo")
    )

    var mensaje: String = ""
    for ((index : Int, n ) in cereales.withIndex() ) {
        mensaje += "${index + 1}. ${n.toString()}\n"
    }
    mensaje += "${cereales.size + 1}. Regresar"

    escapar@while (true){
        val mensaje_inicial = """
            
:: Cereal ::
    
Selecciona entre los ingredientes disponibles
$mensaje
            
        """.trimIndent()

        println(mensaje_inicial)
        var options: Int = readLine()?.toInt() ?: 0

        when (options) {
            1 -> cereales[0].toString()
            2-> cereales[1].toString()
            3 -> break@escapar
            else -> println("Debe seleccionar una las opciones")
        }
    }
}

fun verHuevos() {

    val huevos: Array<Huevos> = arrayOf(
        Huevos(100, "Huevo de codorniz"),
        Huevos(200, "Huevo frito")
    )

    var mensaje: String = ""
    for ((index : Int, n ) in huevos.withIndex() ) {
        mensaje += "${index + 1}. ${n.toString()}\n"
    }
    mensaje += "${huevos.size + 1}. Regresar"

    escapar@while (true){
        val mensaje_inicial = """
            
:: Huevos ::
    
Selecciona entre los ingredientes disponibles
$mensaje
            
        """.trimIndent()

        println(mensaje_inicial)
        var options: Int = readLine()?.toInt() ?: 0

        when (options) {
            1 -> huevos[0].toString()
            2-> huevos[1].toString()
            3 -> break@escapar
            else -> println("Debe seleccionar una las opciones")
        }
    }
}

fun verAceite() {

    val aceites: Array<Aceites> = arrayOf(
        Aceites(100, "Aceite de Oliva"),
        Aceites(200, "Aceite para freir")
    )

    var mensaje: String = ""
    for ((index : Int, n ) in aceites.withIndex() ) {
        mensaje += "${index + 1}. ${n.toString()}\n"
    }
    mensaje += "${aceites.size + 1}. Regresar"

    escapar@while (true){
        val mensaje_inicial = """
            
:: Aceites ::
    
Selecciona entre los ingredientes disponibles
$mensaje
            
        """.trimIndent()

        println(mensaje_inicial)
        var options: Int = readLine()?.toInt() ?: 0

        when (options) {
            1 -> aceites[0].toString()
            2-> aceites[1].toString()
            3 -> break@escapar
            else -> println("Debe seleccionar una las opciones")
        }
    }
}