
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
    val menu = """
        
        :: Hacer una receta ::

        1. Regresar
        
    """.trimIndent()

    println(menu)
    var options: Int = readLine()?.toInt() ?: 0
}

fun verRecetas() {

    val menu = """
        
        :: Ver mis recetas ::

        1. Regresar
        
    """.trimIndent()

    println(menu)
    var options: Int = readLine()?.toInt() ?: 0
}

